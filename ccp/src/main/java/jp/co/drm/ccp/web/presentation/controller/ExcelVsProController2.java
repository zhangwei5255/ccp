package jp.co.drm.ccp.web.presentation.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;

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
import com.orangesignal.csv.handlers.StringArrayListHandler;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.co.drm.beans.factory.config.LinkedPropertiesFactoryBean;
import jp.co.drm.ccp.web.presentation.domain.DiffDomain;

@RestController
@RequestMapping(value = "/tools/ExcelVsAllPro")
// public class LoginRestController extends BaseController{
public class ExcelVsProController2 extends BaseController {

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

	// HOME_DIR
	// resourceLoader.getResource("a.csv") HOME_DIR = default: **/webapp
	// resourceLoader.getResource("classpath:/a.csv") HOME_DIR = build to dir
	// resourceLoader.getResource("classpath* : a.csv") libのファイルも読み込める
	// final String CSV_NAME = "C:/Users/user/git/ccp/ccp/src/main/resources/csv/excel.csv";
	final String CSV_NAME = "classpath:/csv/excel.csv";


	@RequestMapping(value = "/cmp", method = { RequestMethod.GET, RequestMethod.POST })
	public List<String> cmp() throws Exception {

		List<String[]> lstXls = getCsvDatas(CSV_NAME);

		Properties pros = getAllPro(proNames);


		List<String[]> lstOver = chkOver(lstXls);
		if(lstOver.size() > 0) {
			logger.info("エクセル重複キー件数：" + lstOver.size() / 2);
			for(String[] data : lstOver) {
				logger.info(data[0] + " " + data[1]);
			}
		}

		if(lstXls.size() != pros.keySet().size()) {
			logger.info("csv行数：" + lstXls.size() + " prosキー件数：" + pros.keySet().size());
		}



		List<String> lstTmp = new ArrayList<String>();
		for(String[] arr : lstXls ) {
			String key = arr[1];
			if(pros.containsKey(key) == false) {
				lstTmp.add(key);
			}
		}
		if(lstTmp.size() > 0) {
			logger.info("key:エクセル有り、pro無し");
			lstTmp.stream().forEach(p -> logger.info(p));
		}

		lstTmp = new ArrayList<String>();
		for(Object key : pros.keySet()) {

			Stream<String[]> stream= lstXls.stream().filter(p ->  key.toString().equals(p[1]));
			List<String[]> ret = stream.collect(Collectors.toList());
			if(ret.size() == 0) {
				lstTmp.add(key + "");
			}

		}

		if(lstTmp.size() > 0) {
			logger.info("key:pro有り、エクセル無し 件数：" + lstTmp.size());
			lstTmp.stream().forEach(p -> logger.info(p));
		}

//		Map<String, String> mapXlsEnv = getXlsEnvPro(lstXls);
//		logger.info("エクセルに環境の件数：" + mapXlsEnv.keySet().size());

//		List<String> lstXlsNon = new ArrayList<String>();
//		for(String key : mapProsEnv.keySet()) {
//			if(mapXlsEnv.containsKey(key) == false) {
//				lstXlsNon.add(key);
//			}
//		}
//
//		logger.info("DIFF総件数:" + lstXlsNon.size());

		return lstTmp;


	}




	private List<String[]> getCsvDatas(String csvName) throws IOException{

	    Resource resource = resourceLoader.getResource(csvName);

	    File file = resource.getFile();

		List<String[]> lstXls = Csv.load(file, new CsvConfig(), new StringArrayListHandler());
		return lstXls;
	}

	private List<String[]> chkOver(List<String[]> lstXls){
		List<String[]> lstOver = new ArrayList<String[]>();

		for(String[] arr : lstXls ) {
			String key = arr[1];
			List<String[]> lstChk = lstXls.stream()
				.filter(p -> key.equals(p[1]))
				.collect(Collectors.toList());
			if(lstChk.size() > 1) {
				lstOver.add(arr);
				//logger.info(key + arr[0]);
			}
		}

		return lstOver;
	}

	private Map<String, String> getXlsEnvPro(List<String[]> lstXls) {

		// p[1]重複時、toMAP：システムエラーが起こる
/*		Map<String, String> map = lstXls.stream()
		.filter(p -> "環境".equals(p[0].trim()))
		.collect(Collectors.toMap(p -> p[1], p -> p[0]));*/

//		// 　１．Collectors.groupingBy    重複値はリストに格納する
//		Map<Object, List<String[]>> map = lstXls.stream()
//				.filter(p -> "環境".equals(p[0].trim()))
//				.collect(Collectors.groupingBy(p -> p[1]));

		//第 3引数で同一キーの値が複数あった場合にどちらを選択するかを指定します。
		// 重複値が削除される
		Map<String, String> map = lstXls.stream()
				.filter(p -> "環境".equals(p[0].trim()))
				.collect(Collectors.toMap(p -> p[1], p -> p[0], (d1, d2) -> d1));

		return map;

	}

	private Properties getAllPro(String[] names) throws Exception {
		LinkedPropertiesFactoryBean factory = new LinkedPropertiesFactoryBean();
		factory.setFileEncoding("UTF-8");

		List<Resource> lstResouce = Stream.of(names)
				.map(p -> resourceLoader.getResource(p))
				.collect(Collectors.toList());
		factory.setLocations(lstResouce.toArray(new Resource[lstResouce.size()]));
		factory.afterPropertiesSet();

		return factory.getObject();

	}



	private Map<String, DiffDomain> getDiff(Properties stg, Properties pro) {
		Map<String, DiffDomain> map = new HashMap<String, DiffDomain>();

		if (stg.keySet().size() != pro.keySet().size()) {
			new Exception("キーの件数が合わせていませんので、ご確認ください。");
		}

		for (Object key : stg.keySet()) {
			if (pro.containsKey(key) == false) {
				new Exception("キーが違いますので、ご確認ください。");
			}
		}

		for (Object key : pro.keySet()) {
			if (stg.containsKey(key) == false) {
				new Exception("キーが違いますので、ご確認ください。");
			}
		}

		for (Object key : stg.keySet()) {
			if (stg.getProperty(key + "").equals(pro.getProperty(key + "")) == false) {
				DiffDomain domain = new DiffDomain();
				domain.setVal1(stg.getProperty(key + ""));
				domain.setVal2(pro.getProperty(key + ""));
				map.put(key + "", domain);
				String msg = String.format("Diff: key = %s , stg = %s, pro = %s", key, domain.getVal1(), domain.getVal2());
				//logger.info(msg);
			}
		}

		//logger.info("-----------------------------------------------------------------------------------");

		return map;

	}

	private Properties getPropertiesByName(String fileName) throws Exception {
		LinkedPropertiesFactoryBean factory = new LinkedPropertiesFactoryBean();
		//factory.setFileEncoding("utf8");
		factory.setFileEncoding("UTF-8");
		factory.setLocations(resourceLoader.getResource(fileName));
		factory.afterPropertiesSet();

		return factory.getObject();
	}


}
