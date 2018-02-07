package jp.co.drm.ccp.web.presentation.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orangesignal.csv.Csv;
import com.orangesignal.csv.CsvConfig;
import com.orangesignal.csv.filters.CsvExpressions;
import com.orangesignal.csv.handlers.StringArrayListHandler;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.co.drm.ccp.web.presentation.domain.KeyVal;

@RestController
@RequestMapping(value = "/tools/EC5347")
// public class LoginRestController extends BaseController{
public class EC5347Controller extends BaseController {

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	private HttpServletRequest request;

	final String PHP_HOME = "classpath:/php/";
	final String PHP_IN = PHP_HOME + "gwos_in.php";
	final String PHP_IN_ENV = PHP_HOME + "gwos_in_env.php";
	final String API_HOME = "classpath:/api/";
	final String API_IN  = API_HOME + "gwos_in.properties";

	@RequestMapping(value = "/getPhpData", method = { RequestMethod.GET, RequestMethod.POST })
	public List<KeyVal> getPhpData() throws Exception {

//		List<String[]> lstDomain = getCsvDatas(CSV_NAME);
//		List<KeyVal> lstKeyVal = lstDomain.stream().map(arr -> arr2Bean(arr[0])).collect(Collectors.toList());
//		logger.info("対象の件数：" + lstKeyVal.size());
//
//		// KEYの昇順でソートする
//		lstKeyVal = lstKeyVal.stream().sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
//				.collect(Collectors.toList());

		List<String> lstDes =  getDatas(PHP_IN, PHP_IN_ENV);
		List<KeyVal> lstKeyVal = convertPhp(lstDes);

		// KEYの昇順でソートする
		lstKeyVal = lstKeyVal.stream().sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
				.collect(Collectors.toList());

		return lstKeyVal;

	}

	@RequestMapping(value = "/chkOverPhp", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String> chkOverPhp() throws IOException{
		List<String> lstDes =  getDatas(PHP_IN, PHP_IN_ENV);
		List<KeyVal> lstKeyVal = convertPhp(lstDes);

		List<String> lst = chkOver(lstKeyVal);

		return lst;

	}

	@RequestMapping(value = "/getJavaData", method = { RequestMethod.GET, RequestMethod.POST })
	public List<KeyVal> getJavaData() throws Exception {

//		List<String[]> lstDomain = getCsvDatas(CSV_NAME);
//		List<KeyVal> lstKeyVal = lstDomain.stream().map(arr -> arr2Bean(arr[0])).collect(Collectors.toList());
//		logger.info("対象の件数：" + lstKeyVal.size());
//
//		// KEYの昇順でソートする
//		lstKeyVal = lstKeyVal.stream().sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
//				.collect(Collectors.toList());

		List<String> lstDes =  getDatas(API_IN);
		List<KeyVal> lstKeyVal = convertJava(lstDes);

		// KEYの昇順でソートする
		lstKeyVal = lstKeyVal.stream().sorted((o1, o2) -> o1.getKey().compareTo(o2.getKey()))
				.collect(Collectors.toList());

		return lstKeyVal;
	}


	@RequestMapping(value = "/chkOverJava", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String> chkOverJava() throws IOException{
		List<String> lstDes =  getDatas(API_IN);
		List<KeyVal> lstKeyVal = convertJava(lstDes);

		List<String> lst = chkOver(lstKeyVal);

		return lst;

	}


	private List<String> chkOver(List<KeyVal> lstKeyVal) {
		List<String> lstOver = new ArrayList<String>();

		for (KeyVal keyVal : lstKeyVal) {
			String key = keyVal.getKey();
			List<KeyVal> lstChk = lstKeyVal.stream()
					.filter(p -> key.equals(p.getKey()) && !lstOver.contains(key))
					.collect(Collectors.toList());

			if (lstChk.size() > 1) {

				lstOver.add(key);
				//logger.info(key + arr[0]);
			}
		}

		return lstOver;
	}

	private List<String> getDatas(String... fileNames) throws IOException {
		Resource resource;
		Path path;
		List<String> lstTmp;
		List<String> lstRet = new ArrayList<String>();

		for(String fileName : fileNames) {
			 resource = resourceLoader.getResource(fileName);
			 path = Paths.get(resource.getURI());
			 lstTmp = Files.readAllLines(path);

			 lstRet.addAll(lstTmp);
		}

		return lstRet;

	}

	private List<KeyVal> convertJava(List<String> lstInput){
		List<KeyVal> lstRet;
		String regex = "^.*=.*$";
		String regexGroup = "^(.*)=(.*)$";

		lstRet = lstInput.stream()
				.map(p -> p.trim())
				.filter(p -> Pattern.matches(regex,p ))
				.map(p -> string2KeyVal(regexGroup,p ))
				.collect(Collectors.toList());

		return lstRet;
	}

	private List<KeyVal> convertPhp(List<String> lstInput){
		List<KeyVal> lstRet;
		String regex = "^\".*\"\\s*=>\\s*\".*\"\\s*,?$";
		String regexGroup = "^\"(.*)\"\\s*=>\\s*\"(.*)\"\\s*,?$";

		lstRet = lstInput.stream()
				.map(p -> p.trim())
				.filter(p -> Pattern.matches(regex,p ))
				.map(p -> string2KeyVal(regexGroup,p ))
				.collect(Collectors.toList());

		return lstRet;
	}


	private KeyVal string2KeyVal(String regexGroup, String input) {
		KeyVal keyVal = null;

        //判定するパターンを生成
        Pattern ptn = Pattern.compile(regexGroup);
        Matcher m = ptn.matcher(input);
        if (m.find()){
        	keyVal = new KeyVal();
        	keyVal.setKey(m.group(1));
        	keyVal.setVal(m.group(2));
        }

		return keyVal;
	}

	private KeyVal arr2Bean(String str) {
		KeyVal keyVal = new KeyVal();
		String[] arr = str.split("=>");
		if (arr.length != 2) {
			return null;
		}
		String key;
		String val;
		key = arr[0].trim();
		key = StringUtils.strip(key, "\"").trim();
		keyVal.setKey(key);

		val = arr[1].trim();
		val = StringUtils.strip(val, "\"").trim();
		keyVal.setVal(val);

		return keyVal;
	}


	private List<String[]> getCsvDatas(String csvName) throws IOException {
	    Resource resource = resourceLoader.getResource(csvName);

	    File file = resource.getFile();


	    CsvConfig cfg = new CsvConfig(',', '"', '\\');
		cfg.setNullString("NULL"); // null 値扱いする文字列を指定します。
		cfg.setIgnoreLeadingWhitespaces(true); // 項目値前のホワイトスペースを除去します。
		cfg.setIgnoreTrailingWhitespaces(true); // 項目値後のホワイトスペースを除去します。
		cfg.setIgnoreEmptyLines(true); // 空行を無視するようにします。

		cfg.setIgnoreLinePatterns(Pattern.compile("^#.*$"));   // 使っても効果がないようだ
		//cfg.setUtf8bomPolicy(true);                          // UTF-8 エンコーディングでの出力時に BOM (Byte Order Mark) を付与します。
		cfg.setVariableColumns(false); // デフォルトでは有効となっている可変項目数を無効化して項目数チェックを行うようにしま


		StringArrayListHandler handler = new StringArrayListHandler()
        .filter(CsvExpressions.regex(0, "^.*=>.*$"));

		// CsvManager 統合アクセスインターフェースでの使用例
		List<String[]> lstXls = Csv.load(file, cfg, handler);

		return lstXls;
	}

}
