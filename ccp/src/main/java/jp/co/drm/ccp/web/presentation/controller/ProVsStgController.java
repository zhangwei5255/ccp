package jp.co.drm.ccp.web.presentation.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.co.drm.beans.factory.config.LinkedPropertiesFactoryBean;
import jp.co.drm.ccp.web.presentation.domain.DiffDomain;
import jp.co.drm.ccp.web.presentation.domain.LoginDomain;

@RestController
@RequestMapping(value = "/tools/proVsStg")
// public class LoginRestController extends BaseController{
public class ProVsStgController extends BaseController {

	private final Logger logger = LogManager.getLogger(this.getClass());

	final String STG0_HOME = "file:///C:/work/zw/SVN/branches/release_2017_WOS_MENTE_1121/gwos-conf/stg0.misumi-ec.com/";
	final String STG1_HOME = "file:///C:/work/zw/SVN/branches/release_2017_WOS_MENTE_1121/gwos-conf/stg1.misumi-ec.com/";
	final String PRO0_HOME = "file:///C:/work/zw/SVN/branches/release_2017_WOS_MENTE_1121/gwos-conf/prd0.misumi-ec.com/";
	final String PRO1_HOME = "file:///C:/work/zw/SVN/branches/release_2017_WOS_MENTE_1121/gwos-conf/prd1.misumi-ec.com/";

	final String[] stgNames = {
			STG0_HOME + "CHN/user/gwos_cn.properties",
			STG0_HOME + "GRM/user/gwos_de.properties",
			STG0_HOME + "IND/user/gwos_in.properties",
			STG0_HOME + "JKT/user/gwos_id.properties",
			STG0_HOME + "KOR/user/gwos_kr.properties",
			STG0_HOME + "MYS/user/gwos_my.properties",
			STG0_HOME + "SGP/user/gwos_sg.properties",
			STG0_HOME + "THA/user/gwos_th.properties",
			STG0_HOME + "TIW/user/gwos_tw.properties",
			STG0_HOME + "USA/user/gwos_us.properties",
			STG0_HOME + "VNM/user/gwos_vn.properties",
			STG1_HOME + "MJP/user/gwos_jp.properties"
	};

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
	private HttpServletRequest request;

	@Autowired
	ResourceLoader resourceLoader;

	@RequestMapping(value = "/cmp", method = { RequestMethod.GET, RequestMethod.POST })
	public void cmp(@RequestBody LoginDomain domain) {

	}

	@RequestMapping(value = "/ReadProperties", method = { RequestMethod.GET, RequestMethod.POST })
	public Set<String> ReadProperties() throws Exception {
		if (proNames.length != stgNames.length) {
			logger.info("propertiesの件数が不一致ですので、ご確認ください。");
			new Exception("propertiesの件数が不一致ですので、ご確認ください。");
		}

		Map<String, DiffDomain> map = new HashMap<String, DiffDomain>();

		for (int i = 0; i < proNames.length; i++) {
			String proName = proNames[i];
			String stgName = stgNames[i];
			Properties ProProperties = getPropertiesByName(proName);
			Properties StgProperties = getPropertiesByName(stgName);

			Map<String, DiffDomain> tmpMap = getDiff(StgProperties, ProProperties);

			for(String key : tmpMap.keySet()) {
				if(map.containsKey(key) == false) {
					map.put(key, tmpMap.get(key));
				}
			}

		}

		logger.info("DIFF総件数:" + map.keySet().size());
		return map.keySet();

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
				logger.info(msg);
			}
		}

		logger.info("-----------------------------------------------------------------------------------");

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
