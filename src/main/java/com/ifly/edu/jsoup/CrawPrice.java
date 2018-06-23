package com.ifly.edu.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CrawPrice {


    public static void main(String[] args) {
        String tag = "data-format-value";
        String baseUrl = "https://coinmarketcap.com/currencies/";
        String currencys = "BTC:bitcoin;ETH:ethereum;ETP:metaverse;BCY:bitcrystals";

        String currencyArr[] = currencys.split(";");
        StringBuilder sb = null;
        QuoteModel quote = null;
        int seq = 1000;
        boolean isStart =true;
        FileWriter fileWriter =null;
        try {
            File file = new File("hft_report_quote.sql");
            if(file.exists()){
                file.delete();
            }
            fileWriter = new FileWriter(file);
        } catch (IOException e) {
           e.printStackTrace();
        }
        if(fileWriter==null) return;
        try {

            BufferedWriter bw = new BufferedWriter(fileWriter);
            bw.write("insert into hft_report_quote(id,currency,happendate,open,high,low,close,volume,marketcap) values");

            StringBuilder stringBuilder = null;
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
                        bw.newLine();
                        seq++;
                        quote.setId(new Long(seq));
                        quote.setCurrency(currCode);

                        if(isStart){
                            stringBuilder= new StringBuilder("('").append(seq).append("','").append(currCode).append("',");
                            isStart=false;
                        }else{
                            stringBuilder= new StringBuilder(",('").append(seq).append("','").append(currCode).append("',");
                        }
                        Elements links= rowEle.children();
                        if (links.size() == 0 || links.size() < 7) {
                            continue;
                        }
                        Element e = links.get(0);
                        String date = dateParese(e.html());
                        quote.setHappenDate(date);
                        System.out.println("date = [" + date + "]");

                        stringBuilder=stringBuilder.append("'").append(date).append("',");

                        e = links.get(1);
                        String value = e.attr(tag);
                        System.out.println("open = [" + value + "]");
                        quote.setOpen(new BigDecimal(value));
                        stringBuilder=stringBuilder.append("'").append(value).append("',");

                        e = links.get(2);
                        value = e.attr(tag);
                        System.out.println("higin = [" + value + "]");
                        quote.setHigh(new BigDecimal(value));
                        stringBuilder=stringBuilder.append("'").append(value).append("',");

                        e = links.get(3);
                        value = e.attr(tag);
                        System.out.println("low = [" + value + "]");
                        quote.setLow(new BigDecimal(value));
                        stringBuilder=stringBuilder.append("'").append(value).append("',");

                        e = links.get(4);
                        value = e.attr(tag);
                        System.out.println("close = [" + value + "]");
                        quote.setClose(new BigDecimal(value));
                        stringBuilder=stringBuilder.append("'").append(value).append("',");

                        e = links.get(5);
                        value = e.attr(tag);
                        System.out.println("volume = [" + value + "]");
                        quote.setVolume(new BigDecimal(value));
                        stringBuilder=stringBuilder.append("'").append(value).append("',");

                        e = links.get(6);
                        value = e.attr(tag);
                        System.out.println("marketCap = [" + value + "]");
                        quote.setMarketCap(new BigDecimal(value));
                        stringBuilder=stringBuilder.append("'").append(value).append("')");
                        bw.write(stringBuilder.toString());

                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            bw.write(";");
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileWriter!=null){
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static  String dateParese(String dateStr){
        SimpleDateFormat sdf = new SimpleDateFormat("MMM d, yyyy",Locale.ENGLISH);
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Date d2 = null;
        try {
            d2 = sdf.parse(dateStr);
            return sdf2.format(d2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
