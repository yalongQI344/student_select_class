package javaConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableAspectJAutoProxy
@EnableWebMvc//开启mvc配置
@ComponentScan(basePackages={"Action"})//扫描配置包
//mvc静态资源
public class mvcConfig extends WebMvcConfigurerAdapter{
	//配置视图
	@Bean("viewResolver")
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver inResolver =  new InternalResourceViewResolver();
		inResolver.setPrefix("/");
		inResolver.setSuffix(".jsp");
		return inResolver;
	}
	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		// TODO Auto-generated method stub
		configurer.enable();//处理静态资源
	}
}
