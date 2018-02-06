package jp.co.drm.ccp.web.presentation.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
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
	final String HOME_PATH =  "C:/Users/user/git/ccp/ccp/src/main/resources/csv/";
	final String INI_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/ini.csv";
	final String PHP_ALL_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/phpAll.csv";
	final String PHP_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/php.csv";
	final String PHP_ENV_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/phpEnv.csv";
	final String XLS_ENV_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/excelEnv.csv";

	final String CONST_FMT = "\"%s\" => \"%s\"";

	private List<String[]> getCsvDatas(String csvName) throws IOException {
		CsvConfig cfg = new CsvConfig();
		File file = new File(csvName);
		List<String[]> lstXls = Csv.load(file, cfg, new StringArrayListHandler());
		return lstXls;
	}


	private List<String> chkOver(List<String> datas) {
		Map<String, Long> map = datas.stream().collect(
				Collectors.groupingBy(
						Function.identity(), Collectors.counting()));

		List<String> ret = map.keySet().stream()
				.filter(p -> map.get(p) >= 2).collect(Collectors.toList());

		return ret;

	}

	private List<String> distinct(List<String> datas) {
		List<String> ret = datas.stream().distinct().collect(Collectors.toList());
		return ret;

	}




}
