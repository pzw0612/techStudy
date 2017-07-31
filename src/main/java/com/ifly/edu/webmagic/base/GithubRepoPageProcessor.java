package com.ifly.edu.webmagic.base;

import us.codecraft.webmagic.Page;
import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.Spider;
import us.codecraft.webmagic.pipeline.JsonFilePipeline;
import us.codecraft.webmagic.processor.PageProcessor;

/**
 *
 * @author pangzhw
 * @date 2015年4月1日
 */

public class GithubRepoPageProcessor implements PageProcessor {
	// 部分一：抓取网站的相关配置，包括编码、抓取间隔、重试次数等
	private Site site = Site.me().setRetryTimes(3).setSleepTime(1000);

	// process是定制爬虫逻辑的核心接口，在这里编写抽取逻辑
	public void process(Page page) {
		// 部分三：从页面发现后续的url地址来抓取
		page.addTargetRequests(page.getHtml().links()
				.regex("(https://github\\.com/\\w+/\\w+)").all());

		// 部分二：定义如何抽取页面信息，并保存下来
		page.putField("author",
				page.getUrl().regex("https://github\\.com/(\\w+)/.*")
						.toString());
		page.putField(
				"name",
				page.getHtml()
						.xpath("//h1[@class='entry-title public']/strong/a/text()")
						.toString());
		if (page.getResultItems().get("name") == null) {
			// skip this page
			page.setSkip(true);
		}
		page.putField("readme",
				page.getHtml().xpath("//div[@id='readme']/tidyText()"));
	}

	public Site getSite() {
		return site;
	}

	public static void main(String[] args) {
		Spider.create(new GithubRepoPageProcessor())
				.addUrl("https://github.com/code4craft")
				.addPipeline(new JsonFilePipeline("E:\\webmagic\\"))
				.thread(5)
				.run();
	}
}
