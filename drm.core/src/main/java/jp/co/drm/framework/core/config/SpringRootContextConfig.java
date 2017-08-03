package jp.co.drm.framework.core.config;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import jp.co.drm.beans.factory.config.LinkedPropertiesFactoryBean;

@Configuration
public class SpringRootContextConfig {

	@Value("${spring.datasource.url}")
	private String dbUrl;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.driverClassName}")
	private String driverClassName;

	@Value("${cpp.messages.basenames}")
	private String basenames;

	@Value("${cpp.items.basenames}")
	private String itemBasenames;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	ResourceLoader resourceLoader;

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		String[] names = basenames.split(",");
		messageSource.setBasenames(names);
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean(destroyMethod = "close")
	public DataSource dataSource() {
		// DBCP2のデータソースを使う
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl(dbUrl);
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setInitialSize(3);// 初期化時接続数
		dataSource.setMaxTotal(10);// 最大接続プールの数连接池数量
		dataSource.setMinIdle(3);// 最小接続プールの数
		dataSource.setTimeBetweenEvictionRunsMillis(60000);// 接続取得の待ち時間（単位：ミり秒）
		dataSource.setValidationQuery("SELECT 1 FROM DUAL");// テスト用SQL
		dataSource.setTestOnBorrow(true);
		dataSource.setTestWhileIdle(true);
		return dataSource;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager transactionManager = new DataSourceTransactionManager();
		transactionManager.setDataSource(dataSource());

		return transactionManager;
	}

	/*
	 * @Bean public SimpleAsyncTaskExecutor taskExecutor(){
	 * SimpleAsyncTaskExecutor task = new SimpleAsyncTaskExecutor();
	 * //task.setConcurrencyLimit(100); return task; }
	 */

	@Bean
	public LocalValidatorFactoryBean validator() {
		LocalValidatorFactoryBean localValidatorFactoryBean = new LocalValidatorFactoryBean();
		localValidatorFactoryBean.setValidationMessageSource(messageSource);
		return localValidatorFactoryBean;
	}

	@Bean
	public Properties itemProperties() throws IOException {
		LinkedPropertiesFactoryBean factory = new LinkedPropertiesFactoryBean();
		factory.setFileEncoding("utf8");
		String[] names = itemBasenames.split(",");
		List<Resource> lstResouce = Stream.of(names)
				.map(p -> resourceLoader.getResource(p))
				.collect(Collectors.toList());
		factory.setLocations(lstResouce.toArray(new Resource[lstResouce.size()]));
		factory.afterPropertiesSet();

		Properties properties = factory.getObject();
		return properties;
	}

}
