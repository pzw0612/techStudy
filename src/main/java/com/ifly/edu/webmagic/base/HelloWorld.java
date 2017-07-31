package com.ifly.edu.webmagic.base;

import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.processor.SimplePageProcessor;


/**
 *
 * @author pangzhw
 * @date 2015年3月29日
 */
public class HelloWorld {
//	public static void main(String[] args) throws JMException,
//    OOSpider<>.create(Site.me(), new JsonFilePageModelPipeline("/data/webmagic/"), OschinaBlog.class)
//    .addUrl("http://my.oschina.net/flashsword/blog").run();
//}
//	public static void main(String[] args) throws JMException,
//	NullPointerException,
//	IOException {
//		Spider oschinaSpider = Spider.create(new OschinaBlogPageProcessor())
//				.addUrl("http://my.oschina.net/flashsword/blog").thread(2);
//		Spider githubSpider = Spider.create(new GithubRepoPageProcessor())
//				.addUrl("https://github.com/code4craft");
//		SpiderMonitor spiderMonitor =  SpiderMonitor.instance();
//		spiderMonitor.register(oschinaSpider, githubSpider);
////		spiderMonitor.jmxStart();
//	}
//	 public static void main(String[] args) {
//		 
//		 Spider.create(new GithubRepoPageProcessor())
//		 //从"https://github.com/code4craft"开始抓
//		 .addUrl("https://github.com/code4craft")
//		 .addPipeline(new JsonFilePipeline("/webmagic/"))
//		 //开启5个线程抓取
//		 .thread(5)
//		 //启动爬虫
//		 .run();
//	 }
	  public static void main(String[] args) {
		  Spider.create(new SimplePageProcessor("http://my.oschina.net/",
				  "http://my.oschina.net/*/blog/*")).thread(1).run();
	  }
}
