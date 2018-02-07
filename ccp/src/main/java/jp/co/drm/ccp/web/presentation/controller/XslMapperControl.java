package jp.co.drm.ccp.web.presentation.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gh.mygreen.xlsmapper.XlsMapper;
import com.gh.mygreen.xlsmapper.XlsMapperException;

import jp.co.drm.base.presentation.controller.BaseController;
import jp.co.drm.ccp.web.presentation.domain.Gender;
import jp.co.drm.ccp.web.presentation.domain.UserRecord;
import jp.co.drm.ccp.web.presentation.domain.UserSheet;

@RestController
@RequestMapping(value = "/tools/xsl")
public class XslMapperControl extends BaseController {

	@Autowired
	ResourceLoader resourceLoader;

	final String XLS_NAME = "classpath:/xls/sample.xlsx";
	final String XLS_TEMPLATE = "classpath:/xls/sample_template.xlsx";
	final String XLS_OUTPUT = "classpath:/xls/out.xlsx";


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

	@RequestMapping(value = "/save", method = { RequestMethod.GET, RequestMethod.POST })
	public UserSheet save() throws FileNotFoundException, XlsMapperException, IOException {

		// Create sheet data.
		UserSheet sheet = new UserSheet();
		sheet.setCreateDate(new Date());

		List<UserRecord> users = new ArrayList<>();

		// Create record data.
		UserRecord record1 = new UserRecord();
		record1.setNo(1);
		record1.setClassName("A");
		record1.setName("Ichiro");
		record1.setGender(Gender.male);
		users.add(record1);

		UserRecord record2 = new UserRecord();
		record2.setNo(2);
		record2.setClassName("B");
		record2.setName("ni");
		record2.setGender(Gender.female);
		users.add(record2);

		sheet.setUsers(users);

		Resource resTmp = resourceLoader.getResource(XLS_TEMPLATE);

		String classPath = resourceLoader.getResource("classpath:/").getFile().getPath();



		// Save the Excel sheet.
		XlsMapper xlsMapper = new XlsMapper();
		xlsMapper.save(
				resTmp.getInputStream(), // for template excel file.
		    new FileOutputStream(XLS_OUTPUT.replace("classpath:", classPath)),     // for output excel file.
			//	 new FileOutputStream("C:/Users/user/git/ccp/ccp/bin/xls/out.xlsx"),     // for output excel file.
		    sheet                                // for created sheet data.
		    );



		return sheet;
	}



}
