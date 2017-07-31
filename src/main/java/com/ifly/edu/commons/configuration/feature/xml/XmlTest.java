package com.ifly.edu.commons.configuration.feature.xml;

import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.apache.commons.configuration.reloading.FileChangedReloadingStrategy;
import org.apache.commons.configuration.reloading.ReloadingStrategy;
import org.apache.commons.configuration.tree.xpath.XPathExpressionEngine;

/**
 * 参考地址：http://my.oschina.net/jack230230/blog/57171
 * @author pangzhw
 * @date 2015年5月3日
 */
public class XmlTest {

	public static void main(String[] args) throws ConfigurationException {
		reloadingStrategyHandle();
	}
	
	
	/**
	 * 处理唯一一个节点情况
	 * @throws ConfigurationException
	 */
	public static void oneNodeHandle() throws ConfigurationException{
		XMLConfiguration config =new XMLConfiguration("configuration/const1.xml");
		// 127.0.0.1
		String url= config.getString("databases.database.url"); 
		System.out.println("url="+url);
		
		// 1521
		String port =config.getString("databases.database.port");
		System.out.println("port="+port);
	}
	
	public static void mutilNodeHandle() throws ConfigurationException{
		XMLConfiguration config =new XMLConfiguration("configuration/const.xml");
		
		List<Object> list=config.getList("databases.database.url");
		System.out.println("list="+list);
		
		// 127.0.0.1
		String url= config.getString("databases.database.url"); 
		System.out.println("url="+url);
		
		// 1521
		String port =config.getString("databases.database.port");
		System.out.println("port="+port);
	}
	
	/**
	 * XPath表达式
	 * @throws ConfigurationException
	 */
	public static void xPathHandle() throws ConfigurationException{
		XMLConfiguration config =new XMLConfiguration("configuration/const.xml");
		config.setExpressionEngine(new XPathExpressionEngine());
		  
		// 127.0.0.1
		String url= config.getString("databases/database[name = 'dev']/url");       
		System.out.println("url="+url);
		
		// 192.23.44.100
		url =config.getString("databases/database[name = 'production']/url");
		System.out.println("url="+url);
	}
	
	/**
	 * 自动重新加载
	 * @throws ConfigurationException
	 */
	public static void reloadingStrategyHandle() throws ConfigurationException{
		XMLConfiguration config =new XMLConfiguration("configuration/const.xml");
		config.setExpressionEngine(new XPathExpressionEngine());
		ReloadingStrategy strategy =new FileChangedReloadingStrategy();
		((FileChangedReloadingStrategy) strategy).setRefreshDelay(5000);
		config.setReloadingStrategy(strategy);
		// 127.0.0.1
		String url= config.getString("databases/database[name = 'dev']/url");       
		System.out.println("url="+url);
		
		// 192.23.44.100
		url =config.getString("databases/database[name = 'production']/url");
		System.out.println("url="+url);
	}
}
