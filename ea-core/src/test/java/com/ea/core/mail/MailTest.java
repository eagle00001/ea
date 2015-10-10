package com.ea.core.mail;

import com.ea.core.AbstractBaseTest;

public class MailTest extends AbstractBaseTest{

	public static void main(String[] args) {
		MailTest testCase = new MailTest();
		testCase.loadAppContextXmlCfg(null);
		
		testCase.testEmail();
	}
	
	public void testEmail(){
		MailBoxBuilder mailBoxBuilder = (MailBoxBuilder)this.appllicationContext.getBean("mailBoxBuilder");
		MailBoxMsg mailMsg = new MailBoxMsg();
		mailMsg.setFromMailAddress("daiqiang@iot.chinamobile.com");
		mailMsg.setSubject("This is a test mail.");
		mailMsg.setBody("Tesfdfdfdfdt mail");
		String[] toMailAddressArr = {"284956732@qq.com"};
		mailMsg.setToMailAddressArr(toMailAddressArr);
		
		mailBoxBuilder.sendMail(mailMsg);
	}

}
