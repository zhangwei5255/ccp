package jp.co.drm.cpp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "jp.co.drm") // デフォルト：当パッケージ package jp.co.drm.cpp;
@MapperScan("jp.co.drm.ccp.**.integration.mybatis.dao")
public class Application {

/*	@Autowired
	TblUserDao userDao;*/

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext cac = SpringApplication.run(Application.class, args);
		Application app = cac.getBean(Application.class);
		app.hello();
	}

	public void hello() {
		System.out.println("hello2()");
	}





}
