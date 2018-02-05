package jp.co.drm.ccp.web.presentation.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gh.mygreen.xlsmapper.XlsMapper;
import com.gh.mygreen.xlsmapper.XlsMapperException;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.co.drm.ccp.web.presentation.domain.UserSheet;

@RestController
@RequestMapping(value = "/tools/xsl")
public class XslMapperControl extends BaseController {

	@Autowired
	ResourceLoader resourceLoader;

	final String XLS_NAME = "classpath:/xls/sample.xlsx";


	@RequestMapping(value = "/load", method = { RequestMethod.GET, RequestMethod.POST })
	public UserSheet load() throws FileNotFoundException, XlsMapperException, IOException {
		Resource resource = resourceLoader.getResource(XLS_NAME);

		// Load sheet with mapping to POJO.
		XlsMapper xlsMapper = new XlsMapper();
		UserSheet sheet = xlsMapper.load(
				resource.getInputStream(), // excel sheet.
		    UserSheet.class                     // POJO class.
		    );
		return sheet;
	}

}
