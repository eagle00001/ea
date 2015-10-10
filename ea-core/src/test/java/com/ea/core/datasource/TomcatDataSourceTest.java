package com.ea.core.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import com.ea.core.AbstractBaseTest;
import com.ea.core.utils.ApplicationContextHelper;
import com.ea.core.utils.LogUtils;



public class TomcatDataSourceTest extends AbstractBaseTest{
	
	public void init(){
		String[] xmls = {"applicationContext-beans-test.xml"};
		super.loadAppContextXmlCfg(xmls);
	}
	
	public static void main(String[] args){
		TomcatDataSourceTest testCase = new TomcatDataSourceTest();
		testCase.init();
		
		testOracleDataSource();
		testMysqlDataSource();
	}

	private static void testOracleDataSource() {
		DataSourceProxy dsProxy = (DataSourceProxy)ApplicationContextHelper.getBeanObject("dataSource_oracle");
		try {
			Connection connection = dsProxy.getConnection();
			if(connection!=null)
				LogUtils.info(TomcatDataSourceTest.class, "create oracle db connection success!!!");
			else
				LogUtils.info(TomcatDataSourceTest.class, "create oracle db connection fail!!!");
		} catch (SQLException e) {
			LogUtils.error(TomcatDataSourceTest.class, "create oracle db connection fail!!!",e);
		}
	}
	
	private static void testMysqlDataSource() {
		DataSourceProxy dsProxy = (DataSourceProxy)ApplicationContextHelper.getBeanObject("dataSource_mysql");
		try {
			Connection connection = dsProxy.getConnection();
			if(connection!=null)
				LogUtils.info(TomcatDataSourceTest.class, "create mysql db connection success!!!");
			else
				LogUtils.info(TomcatDataSourceTest.class, "create mysql db connection fail!!!");
		} catch (SQLException e) {
			LogUtils.error(TomcatDataSourceTest.class, "create mysql db connection fail!!!",e);
		}
	}
	
	
}
