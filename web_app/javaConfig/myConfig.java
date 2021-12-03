package javaConfig;

import java.beans.PropertyVetoException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration//配置文件
@EnableAspectJAutoProxy//开启切面代理
@ComponentScan(basePackages={"Dao","Service"},
excludeFilters={
		@Filter(type=FilterType.ANNOTATION,value=EnableWebMvc.class)
})//扫描配置包
@PropertySource(value={"classpath:database.properties"})//导入db资源文件
public class myConfig {
	@Autowired
	private Environment env;
	//配置一个jdbc连接池，本次使用Spring自带，不具备池特征
//	@Bean("driverManagerDataSource")
//	public DriverManagerDataSource driverManagerDataSource(){
//		DriverManagerDataSource db = new DriverManagerDataSource();
//		db.setUrl(env.getProperty("url"));
//		db.setUsername(env.getProperty("username"));
//		db.setPassword(env.getProperty("password"));
//		db.setDriverClassName(env.getProperty("driverClass"));
//		return db;
//	}
	//配置C3P0
	@Bean("c3p0")
	public ComboPooledDataSource comboPooledDataSource(){
		ComboPooledDataSource c = new ComboPooledDataSource();
		try {
			c.setDriverClass(env.getProperty("driverClass"));
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		c.setJdbcUrl(env.getProperty("url"));
		c.setUser(env.getProperty("user"));
		c.setPassword(env.getProperty("password"));
		return c;
	}
	//配置jdbc模板
	@Bean("jdbcTemplate")
	public org.springframework.jdbc.core.JdbcTemplate JdbcTemplate(ComboPooledDataSource dataSource){
		org.springframework.jdbc.core.JdbcTemplate jdbcTemplate = new org.springframework.jdbc.core.JdbcTemplate(dataSource);
		return jdbcTemplate;
	}
}
