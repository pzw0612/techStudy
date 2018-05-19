package com.ifly.edu.nutch;


//import crawlercommons.fetcher.BaseFetchException;
//import crawlercommons.fetcher.FetchedResult;
//import crawlercommons.fetcher.http.SimpleHttpFetcher;
//import crawlercommons.fetcher.http.UserAgent;
//import org.apache.nutch.parse.Parser;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.xml.sax.InputSource;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @Description: todo
 * @author: pangzhiwang
 * @create: 2018/5/8
 **/
public class GetFetchResult {

    public static void main(String[] args) {
//        try {
//            UserAgent userAgent = new UserAgent("coinmarketcap", "pzw_0612@163.com", "https://coinmarketcap.com/");
//            SimpleHttpFetcher simpleHttpFetcher = new SimpleHttpFetcher(userAgent);
//            FetchedResult f = simpleHttpFetcher.fetch("https://coinmarketcap.com/zh/currencies/bitcoin/");
//
//            byte[] result = f.getContent();
//            String s = new String(result);

//
//            //这里是对链接进行处理
//            s = s.replaceAll("</?a[^>]*>", "");
//            //这里是对样式进行处理
//            //s = s.replaceAll("<(\\w+)[^>]*>", "<$1>");
//            System.out.println(s);
//        } catch (BaseFetchException e) {
//            e.printStackTrace();
//        }


        try {
            Document doc = Jsoup.connect("https://coinmarketcap.com/zh/currencies/bitcoin/historical-data/").get();
            Elements links = doc.select("div.table-responsive>table>tbody>tr.text-right:eq(0)>td:eq(4)");
            if(links.size()==0){

            }else{
                Element e= links.get(0);
                String usd= e.attr("data-format-value");
                //String usd= e.html();
                System.out.println("usd = [" + usd + "]");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
