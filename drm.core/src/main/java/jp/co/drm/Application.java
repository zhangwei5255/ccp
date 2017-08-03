package jp.co.drm;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

//@SpringBootApplication(scanBasePackages = "jp.co.drm") // デフォルト：当パッケージjp.co.drm
public class Application {

	public static void main(String[] args) throws Exception {
		ConfigurableApplicationContext cac = SpringApplication.run(Application.class, args);
		Application app = cac.getBean(Application.class);
		app.hello();
	}

	public void hello() {
		System.out.println("hello()");
	}

}
