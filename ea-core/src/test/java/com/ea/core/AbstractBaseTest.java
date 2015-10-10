package com.ea.core;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AbstractBaseTest {
	
	protected ClassPathXmlApplicationContext appllicationContext;
	
	protected void loadAppContextXmlCfg(String[] xmls) {
		if(xmls == null){
			String[] tmp = {"applicationContext-beans-test.xml"};
			xmls = tmp;
		}
		appllicationContext = new ClassPathXmlApplicationContext(xmls);
	}
}
