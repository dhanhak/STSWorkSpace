package kh.spring.config;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringProvider implements ApplicationContextAware{

	private static ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		SpringProvider.ctx = applicationContext;
	}
	
	public static ApplicationContext getApplicationContext() {
		return ctx;
	}
	
}
