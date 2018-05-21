package com.ifly.edu.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.math.BigDecimal;

public class CrawPrice {


    public static void main(String[] args) {
        String tag = "data-format-value";
        String baseUrl = "https://coinmarketcap.com/currencies/";
        String currencys = "BTC:bitcoin;ETH:ethereum;ETP:metaverse;BCY:bitcrystals";

        String currencyArr[] = currencys.split(";");
        StringBuilder sb = null;
        QuoteModel quote = null;

        int seq = 1000;

        for (String currency : currencyArr) {
            String[] currArr = currency.split(":");
            sb = new StringBuilder(baseUrl);

            try {
                quote = new QuoteModel();
                String currCode = currArr[0];
                String coinmarketcapUrl = sb.append(currArr[1]).append("/historical-data/?start=20170901&end=20180506").toString();
                Document doc = Jsoup.connect(coinmarketcapUrl).timeout(180000).get();
                Elements rowEles = doc.select("div.table-responsive>table>tbody>tr.text-right");


                for(Element rowEle: rowEles){
                    Elements links= rowEle.children();
                    if (links.size() == 0 || links.size() < 7) {
                        continue;
                    }
                    Element e = links.get(0);
                    String date = e.html();
                    System.out.println("date = [" + date + "]");

                    e = links.get(1);
                    String value = e.attr(tag);
                    System.out.println("open = [" + value + "]");
                    quote.setOpen(new BigDecimal(value));

                    e = links.get(2);
                    value = e.attr(tag);
                    System.out.println("higin = [" + value + "]");
                    quote.setHigh(new BigDecimal(value));

                    e = links.get(3);
                    value = e.attr(tag);
                    System.out.println("low = [" + value + "]");
                    quote.setLow(new BigDecimal(value));

                    e = links.get(4);
                    value = e.attr(tag);
                    System.out.println("close = [" + value + "]");
                    quote.setClose(new BigDecimal(value));

                    e = links.get(5);
                    value = e.attr(tag);
                    System.out.println("volume = [" + value + "]");
                    quote.setVolume(new BigDecimal(value));

                    e = links.get(6);
                    value = e.attr(tag);
                    System.out.println("marketCap = [" + value + "]");
                    quote.setMarketCap(new BigDecimal(value));

                    quote.setHappenDate(date);
                    quote.setCurrency(currCode);
                    quote.setId(new Long(seq));

                    System.out.println("-------------------");
                }

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    }
}
