package jp.co.drm.ccp.web.presentation.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
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
	final String HOME_PATH =  "C:/Users/user/git/ccp/ccp/src/main/resources/csv/";
	final String INI_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/ini.csv";
	final String PHP_ALL_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/phpAll.csv";
	final String PHP_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/php.csv";
	final String PHP_ENV_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/phpEnv.csv";
	final String XLS_ENV_CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/excelEnv.csv";

	final String CONST_FMT = "\"%s\" => \"%s\"";

	@RequestMapping(value = "/cvt", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String[]> converter() throws Exception {

		List<String[]> lstXlsEnv = getCsvDatas(XLS_ENV_CSV_NAME);

		Map<String, String> mapEnv = lstXlsEnv.stream()
				.collect(Collectors.toMap(p -> p[0], p -> p[0], (d1, d2) -> d1));

		logger.info("エクセルに環境の件数：" + mapEnv.keySet().size());


		List<String[]> lstInis = getCsvDatas(INI_CSV_NAME);

		logger.info("INI総件数：" + lstInis.size());

		List<String> lstIni = lstInis.stream().filter(p -> StringUtils.isBlank(p[0]) == false)
				.map(p -> p[0].trim())
				.collect(Collectors.toList());

		logger.info("INI非空行件数：" + lstIni.size());

		List<String> lstPro = lstIni.stream().filter(p -> p.startsWith(";") == false).map(p -> getPro(p))
				.collect(Collectors.toList());

		logger.info("lstPro件数：" + lstPro.size());



		List<String> dataOver = chkOver(lstPro);
		//dataOver.forEach(p -> logger.info(p));
		saveCsv(HOME_PATH + "dataOver.csv", dataOver);
		logger.info("INI　ＫＥＹ重複データ：" + dataOver.size());


		List<String> dataDis = distinct(lstPro);
		//dataDis.forEach(p -> logger.info(p));
		saveCsv(HOME_PATH + "dataDis.csv", dataDis);
		logger.info("INIＫＥＹ重複なしデータ：" + dataDis.size());


		List<String[]> lstPhp = lstIni.stream().map(p -> i2p(p)).collect(Collectors.toList());

		logger.info("PHP非空行件数：" + lstPhp.size());


		saveAllCsvDatas(PHP_ALL_CSV_NAME, lstPhp);


		saveCsvDatas(PHP_CSV_NAME, PHP_ENV_CSV_NAME, lstPhp, mapEnv);


		return lstPhp;

	}




	private String getPro(String line) {


		if (line.endsWith("=")) {
			return line.substring(0, line.length() - 1);
		}

		String[] arr = line.split("=");
		if (arr.length != 2) {
			new Exception("エラー：" + line);
		}

		return StringUtils.trim(arr[0]);
	}


	private String[] i2p(String line) {
		String[] retArr = new String[2];

		//logger.info(line);
		if (line.startsWith(";")) {
			retArr[0] = line.replace(";", "//");
			return retArr;
		}

		if (line.endsWith("=")) {
			retArr[0] = line.substring(0, line.length() - 1);
			retArr[1] = ""; // 最後に「,」が出力されるため
			return retArr;
		}

		String[] arr = line.split("=");
		if (arr.length != 2) {
			new Exception("エラー：" + line);

		}

		String para1 = StringUtils.trim(arr[0]);
		String para2 = StringUtils.trim(arr[1]);
		para2 = para2 == null ? "" : para2.trim();
		retArr[0] = String.format(CONST_FMT,para1 ,para2 );
		retArr[1] = ""; // 最後に「,」が出力されるため

		return retArr;
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

	private List<String[]> getCsvDatas(String csvName) throws IOException {
		CsvConfig cfg = new CsvConfig();
		File file = new File(csvName);
		List<String[]> lstXls = Csv.load(file, cfg, new StringArrayListHandler());
		return lstXls;
	}

	private void saveCsv(String csvName, List<String> lst) throws IOException {

		List<String[]> datas = lst.stream().map(p -> {
			String[] arr = new String[2];
			arr[0] = p;
			return arr;
		}).collect(Collectors.toList());

		File file = new File(csvName);
		CsvConfig cfg = new CsvConfig();
		// 出力
		Csv.save(datas, file, cfg, new StringArrayListHandler());
	}


	private void saveCsvDatas(String csvName, String csvEnv, List<String[]> datas, Map<String, String> mapEnv) throws IOException {
		List<String[]> dataLogic = new ArrayList<String[]>();
		List<String[]> dataEnv = new ArrayList<String[]>();
		List<String[]> dataTmp = new ArrayList<String[]>();

		for(int i = 0; i < datas.size(); i++) {
			dataTmp.add(datas.get(i));
			String key  = datas.get(i)[0];
			if(key.startsWith("//")) {
				continue;
			}

			if(mapEnv.containsKey(key)) {//環境の場合、
				dataEnv.addAll(dataTmp);
			}else { //業務の場合
				dataLogic.addAll(dataTmp);
			}

			dataTmp = new ArrayList<String[]>();

		}

		CsvConfig cfg = new CsvConfig();


		File file = new File(csvName);
		// 出力
		Csv.save(dataLogic, file, cfg, new StringArrayListHandler());

		file = new File(csvEnv);
		// 出力
		Csv.save(dataEnv, file, cfg, new StringArrayListHandler());
	}




	private List<String[]>  getRecord(List<String[]> datas, int i) {
		List<String[]> ret = new ArrayList<String[]>();
		for(int j = i - 1 ; j <= 0; j-- ) {
			String keyEnv  = datas.get(j)[0];
			if(keyEnv.startsWith("//") == false) {
				ret = datas.subList(j + 1, i + 1);
				break;
			}
		}

		return ret;

	}


	private void saveAllCsvDatas(String csvName, List<String[]> datas) throws IOException {
		File file = new File(csvName);
		CsvConfig cfg = new CsvConfig();
		// 出力
		Csv.save(datas, file, cfg, new StringArrayListHandler());
	}
}
