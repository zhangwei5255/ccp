package jp.co.drm.ccp.web.presentation.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.orangesignal.csv.Csv;
import com.orangesignal.csv.CsvConfig;
import com.orangesignal.csv.handlers.StringArrayListHandler;

import jp.co.drm.base.presentation.controller.BaseController;

@RestController
@RequestMapping(value = "/tools/i2p")
// public class LoginRestController extends BaseController{
public class Ini2PhpController extends BaseController {

	private final Logger logger = LogManager.getLogger(this.getClass());

	@Autowired
	ResourceLoader resourceLoader;

	@Autowired
	private HttpServletRequest request;

	//final String CSV_NAME = "classpath:csv/excel.csv";
	//final String CSV_NAME = "file:///C:/Users/user/git/ccp/ccp/src/main/resources/csv/excel.csv";
	final String INI_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/ini.csv";
	final String PHP_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/php.csv";
	final String CONST_FMT = "\"%s\" => \"%s\"";

	@RequestMapping(value = "/cvt", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String[]> converter() throws Exception {

		List<String[]> lstInis = getCsvDatas(INI_CSV_NAME);

		logger.info("INI総件数：" + lstInis.size());

		List<String> lstIni = lstInis.stream().filter(p -> StringUtils.isBlank(p[0]) == false)
				.map(p -> p[0].trim())
				.collect(Collectors.toList());

		logger.info("INI非空行件数：" + lstIni.size());

		List<String[]> lstPhp =lstIni.stream().map(p -> i2p(p)).collect(Collectors.toList());

		logger.info("PHP非空行件数：" + lstPhp.size());


		saveCsvDatas(PHP_CSV_NAME,lstPhp);

		return lstPhp;

	}

	private String[] i2p(String line) {
		String[] retArr = new String[2];


		if(line.startsWith(";")) {
			retArr[0] = line.replace(";", "//");
			return retArr;
		}

		String[] arr = line.split("=");
		if(arr.length != 2) {
			new Exception("エラー：" + line);

		}

		retArr[0] = String.format(CONST_FMT, arr[0].trim() , arr[1].trim());
		retArr[1] = "";   // 最後に「,」が出力されるため

		return retArr;
	}

	private List<String[]> getCsvDatas(String csvName) throws IOException {
		CsvConfig cfg = new CsvConfig();
		File file = new File(csvName);
		List<String[]> lstXls = Csv.load(file, cfg, new StringArrayListHandler());
		return lstXls;
	}

	private void saveCsvDatas(String csvName, List<String[]> datas) throws IOException {
		File file = new File(csvName);
		CsvConfig cfg = new CsvConfig();
		// 出力
		Csv.save(datas, file, cfg, new StringArrayListHandler());
	}
}
