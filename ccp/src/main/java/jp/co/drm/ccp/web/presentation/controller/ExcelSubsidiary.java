package jp.co.drm.ccp.web.presentation.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.util.StringUtils;

import com.orangesignal.csv.Csv;
import com.orangesignal.csv.CsvConfig;
import com.orangesignal.csv.handlers.CsvEntityListHandler;
import com.orangesignal.csv.manager.CsvManagerFactory;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.co.drm.beans.factory.config.LinkedPropertiesFactoryBean;
import jp.co.drm.ccp.web.presentation.domain.SubsidiaryDomain;

@RestController
@RequestMapping(value = "/tools/ExcelSubsidiary")
// public class LoginRestController extends BaseController{
public class ExcelSubsidiary extends BaseController {

	private final Logger logger = LogManager.getLogger(this.getClass());

	final String PRO0_HOME = "file:///C:/work/zw/SVN/branches/release_2018_WOS_0118_EC7.0/gwos-conf/prd0.misumi-ec.com/";
	final String PRO1_HOME = "file:///C:/work/zw/SVN/branches/release_2018_WOS_0118_EC7.0/gwos-conf/prd1.misumi-ec.com/";

	final String[] proNames = {
			PRO0_HOME + "CHN/user/gwos_cn.properties",
			PRO0_HOME + "GRM/user/gwos_de.properties",
			PRO0_HOME + "IND/user/gwos_in.properties",
			PRO0_HOME + "JKT/user/gwos_id.properties",
			PRO0_HOME + "KOR/user/gwos_kr.properties",
			PRO0_HOME + "MYS/user/gwos_my.properties",
			PRO0_HOME + "SGP/user/gwos_sg.properties",
			PRO0_HOME + "THA/user/gwos_th.properties",
			PRO0_HOME + "TIW/user/gwos_tw.properties",
			PRO0_HOME + "USA/user/gwos_us.properties",
			PRO0_HOME + "VNM/user/gwos_vn.properties",
			PRO1_HOME + "MJP/user/gwos_jp.properties"
	};

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	private HttpServletRequest request;

//	final String CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/Subsidiary.csv";
//
//	final String CSV_NAME_RET = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/SubsidiaryRet.csv";


//	ClassLoader cl = Thread.currentThread().getContextClassLoader();
//	URL url = cl.getResource("/csv/Subsidiary.csv");
//	InputStream stream  = url.openConnection().getInputStream();

	// HOME_DIR
	// resourceLoader.getResource("a.csv") HOME_DIR = default: **/webapp
	// resourceLoader.getResource("classpath:/a.csv") HOME_DIR = build to dir
	// resourceLoader.getResource("classpath* : a.csv") libのファイルも読み込める

	final String CSV_NAME = "classpath:/csv/Subsidiary.csv";

	final String CSV_NAME_RET = "classpath:/csv/SubsidiaryRet.csv";

	@RequestMapping(value = "/checkVal", method = { RequestMethod.GET, RequestMethod.POST })
	public List<SubsidiaryDomain> checkVal() throws Exception {

		List<SubsidiaryDomain> lstDomain = getCsvDatas(CSV_NAME);

		for (String proName : proNames) {

			Properties proProperties = getProperties(proName);
			for (Object key : proProperties.keySet()) {
				String siteCode = getSiteCode(proName);
				lstDomain = lstDomain.stream()
						.map(d -> updateDomain(d, siteCode, key + "", proProperties.getProperty(key + "")))
						.collect(Collectors.toList());

			}

		}

		saveCsv(lstDomain, CSV_NAME_RET);

		return lstDomain;

	}

	private SubsidiaryDomain updateDomain(SubsidiaryDomain domain, String siteCode , String proKey, String proVal) {
		// PropertyUtils.getProperty(bean, name) 戻り値：Object
		// BeanUtils.getProperty(bean, name) 戻り値：String
		SubsidiaryDomain retDomain = null;


		try {
			String key = domain.getKey();
			String val = BeanUtils.getProperty(domain, siteCode);

			// KEYは同じだけど、値は合わせていない場合、
			if (StringUtils.equals(key, proKey) == true && StringUtils.equals(val, proVal) == false) {
				BeanUtils.setProperty(domain, siteCode, proVal);
			}

			retDomain = domain;
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		return retDomain;
	}

	private String getSiteCode(String proName) {
		String siteCode = proName.replace(".properties", "");
		siteCode = siteCode.substring(siteCode.length() - 2, siteCode.length());
		siteCode = siteCode.toUpperCase();

		return siteCode;
	}

	private void saveCsv(List<SubsidiaryDomain> lstDomain, String csvName) throws IOException {
	    Resource resource = resourceLoader.getResource(csvName);

	    File file = resource.getFile();

		CsvConfig cfg = new CsvConfig(',');
		cfg.setNullString("NULL"); // null 値扱いする文字列を指定します。
		cfg.setIgnoreLeadingWhitespaces(true); // 項目値前のホワイトスペースを除去します。
		cfg.setIgnoreTrailingWhitespaces(true); // 項目値後のホワイトスペースを除去します。
		cfg.setIgnoreEmptyLines(true); // 空行を無視するようにします。
		cfg.setIgnoreLinePatterns(Pattern.compile("^#.*$")); // コメント#
		//cfg.setUtf8bomPolicy(true);                          // UTF-8 エンコーディングでの出力時に BOM (Byte Order Mark) を付与します。
		cfg.setVariableColumns(false); // デフォルトでは有効となっている可変項目数を無効化して項目数チェックを行うようにしま


		// 出力
		Csv.save(lstDomain, file, cfg, new CsvEntityListHandler<SubsidiaryDomain>(SubsidiaryDomain.class));
	}
	private List<SubsidiaryDomain> getCsvDatas(String csvName) throws IOException {
	    Resource resource = resourceLoader.getResource(csvName);

	    File file = resource.getFile();

		CsvConfig cfg = new CsvConfig(',');
		cfg.setNullString("NULL"); // null 値扱いする文字列を指定します。
		cfg.setIgnoreLeadingWhitespaces(true); // 項目値前のホワイトスペースを除去します。
		cfg.setIgnoreTrailingWhitespaces(true); // 項目値後のホワイトスペースを除去します。
		cfg.setIgnoreEmptyLines(true); // 空行を無視するようにします。
		cfg.setIgnoreLinePatterns(Pattern.compile("^#.*$")); // コメント#
		//cfg.setUtf8bomPolicy(true);                          // UTF-8 エンコーディングでの出力時に BOM (Byte Order Mark) を付与します。
		cfg.setVariableColumns(false); // デフォルトでは有効となっている可変項目数を無効化して項目数チェックを行うようにしま

		// CsvManager 統合アクセスインターフェースでの使用例
		List<SubsidiaryDomain> domains = CsvManagerFactory.newCsvManager().config(cfg).load(SubsidiaryDomain.class)
				.from(file);
		return domains;
	}

	private List<String[]> chkOver(List<String[]> lstXls) {
		List<String[]> lstOver = new ArrayList<String[]>();

		for (String[] arr : lstXls) {
			String key = arr[1];
			List<String[]> lstChk = lstXls.stream()
					.filter(p -> key.equals(p[1]))
					.collect(Collectors.toList());
			if (lstChk.size() > 1) {
				lstOver.add(arr);
				//logger.info(key + arr[0]);
			}
		}

		return lstOver;
	}

	private Properties getProperties(String fileName) throws Exception {
		LinkedPropertiesFactoryBean factory = new LinkedPropertiesFactoryBean();
		//factory.setFileEncoding("utf8");
		factory.setFileEncoding("UTF-8");
		factory.setLocations(resourceLoader.getResource(fileName));
		factory.afterPropertiesSet();

		return factory.getObject();
	}

	private Properties getProperties(String[] names) throws Exception {
		LinkedPropertiesFactoryBean factory = new LinkedPropertiesFactoryBean();
		factory.setFileEncoding("UTF-8");

		List<Resource> lstResouce = Stream.of(names)
				.map(p -> resourceLoader.getResource(p))
				.collect(Collectors.toList());
		factory.setLocations(lstResouce.toArray(new Resource[lstResouce.size()]));
		factory.afterPropertiesSet();

		return factory.getObject();

	}

}
