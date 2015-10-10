package com.ea.core.http;

import com.ea.core.AbstractBaseTest;
import com.ea.core.http.impl.HttpClientServiceImpl;

public class HttpTest extends AbstractBaseTest{

	public static void main(String[] args) {
		HttpTest testCase = new HttpTest();
		testCase.loadAppContextXmlCfg(null);
		
		testCase.testHttpRequest();
	}
	
	public void testHttpRequest(){
		HttpClientServiceImpl service = (HttpClientServiceImpl)this.appllicationContext.getBean("httpClientServiceImpl");
		String httpUrl = "https://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel=15730054860";
		ResponseVo vo = (ResponseVo)service.httpClientGet(httpUrl, ResponseVo.class);
		System.out.println("response result is : 归属地="+vo.getProvince()+", tel="+vo.getTelString());
	}
	
}
