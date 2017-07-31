package com.ifly.edu.webmagic.base;

import java.util.Date;
import java.util.List;

import us.codecraft.webmagic.Site;
import us.codecraft.webmagic.model.ConsolePageModelPipeline;
import us.codecraft.webmagic.model.OOSpider;
import us.codecraft.webmagic.model.annotation.ExtractBy;
import us.codecraft.webmagic.model.annotation.Formatter;
import us.codecraft.webmagic.model.annotation.TargetUrl;

/**
 *
 * @author pangzhw
 * @date 2015年3月29日
 */
@TargetUrl("http://my.oschina.net/flashsword/blog/\\d+")
public class OschinaBlog {

    @ExtractBy("//title")
    private String title;

    @ExtractBy(value = "div.BlogContent",type = ExtractBy.Type.Css)
    private String content;

    @ExtractBy(value = "//div[@class='BlogTags']/a/text()", multi = true)
    private List<String> tags;

    @Formatter("yyyy-MM-dd HH:mm")
    @ExtractBy("//div[@class='BlogStat']/regex('\\d+-\\d+-\\d+\\s+\\d+:\\d+')")
    private Date date; 

    public static void main(String[] args) {
        OOSpider.create(
            Site.me().addStartUrl("http://my.oschina.net/flashsword/blog"),
            new ConsolePageModelPipeline(), OschinaBlog.class).run();
    }
}
