package com.ifly.edu.commons.configuration.feature;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;

/**
 *
 * @author pangzhw
 * @date 2015年5月2日
 */
public class TonfigurationTest {

	public static void main(String[] args) {
		String file = "configuration/AppConfig.xml";
		try {
			XMLConfiguration config = new XMLConfiguration(file);
			System.out.println("成功加载:" + file);
			String btime = config.getString("应用程序配置参数.考勤时间.上班时间");
			double basicm = config.getDouble("应用程序配置参数.个人所得税起征额");

			System.out.println("上班时间：" + btime);
			System.out.println("个人所得税起征额:" + basicm + "元");
		} catch (ConfigurationException e) {
			e.printStackTrace();
		}
	}

}
