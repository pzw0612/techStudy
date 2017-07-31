package com.ifly.edu.jfree.chart;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.IntervalMarker;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.Layer;

/**
 *
 * @author pangzhw
 * @date 2015年5月7日
 */
public class XYPlotTest {

	  private XYDataset createDataset1(){
		String result = "";  
        try  
        {  
            URL uAddr = new URL(" http://222.73.229.180:8080/v1/sh1/line/600000");  
            URLConnection conn = uAddr.openConnection();  
            conn.setDoInput(true);  
            conn.setDoOutput(false);  
            conn.setConnectTimeout(2000);  
            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));  
            String inputLine;  
            while ((inputLine = in.readLine()) != null) result = inputLine;   
        }  
        catch(Exception e)  
        {  
            e.printStackTrace();  
        }  
//		System.out.println(result);
		
		JSONArray array = JSONArray.fromObject("["+result+"]");
	    JSONObject o=(JSONObject) array.get(0);
	    

	    
	    JSONArray a2 = JSONArray.fromObject(o.get("line").toString());
		
	    XYSeries series1 = new XYSeries("Series 1");
	    String time = o.getString("date") + " 09:30";
	    Date od = parse2(time);
	    int nowCount = a2.size();
	    
	    for (int i=0;i<nowCount;i++) {
//	    	System.out.println("我是第几个啊"+i);
	    	int p = i;
	    	if(i>120) {
	    		p = i+89;
	    	}
	    	String[] str = a2.get(i).toString().replace("[", "").replace("]", "").trim().split(",");
	    	Double avg = Double.valueOf(str[0]);
	    	Double volume = Double.valueOf(str[2]);
	    	Date d = addMinute(od,p);
//	    	series1.add(new TimeseriesItem(d, avg, volume));
	    }
	    
	    XYSeriesCollection collection = new XYSeriesCollection();
        collection.addSeries(series1);
	    return collection;
	}
	  
		public static Date parse2(String dateStr) {
			return parse(dateStr, "yyyyMMdd HH:mm");
		}
		
		
		private static String shortPattern = "yyyy-MM-dd";
		private static SimpleDateFormat shortDateFormat = new SimpleDateFormat(
				shortPattern);
		public static Date parse(String dateStr, String pattern) {
			Date date = null;
			SimpleDateFormat format = null;
			if (pattern == null || ("").equals(pattern)) {
				format = shortDateFormat;
			} else {
				format = new SimpleDateFormat(pattern, Locale.US);
			}
			try {
				synchronized (format) {
					// SimpleDateFormat is not thread safe
					date = format.parse(dateStr);
				}
			} catch (ParseException e) {
				
			}
			return date;
		}
		/**
		 * 分钟
		 * @param date 日期
		 * @param amount 计量数
		 * @return 处理后的日期
		 */
		public static Date addMinute(Date date, int amount){
			
			if(date == null){
				return null;
			}
			
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			cal.add(Calendar.MINUTE, amount);
			return cal.getTime();
		}
	public static void main(String[] args) throws IOException {
		
		


	        // create dataset 1...
	        XYSeries series1 = new XYSeries("Series 1");
	        series1.add(10.0, 12353.3);
	        series1.add(20.0, 13734.4);
	        series1.add(30.0, 14525.3);
	        series1.add(40.0, 13984.3);
	        series1.add(50.0, 12999.4);
	        series1.add(60.0, 14274.3);
	        series1.add(70.0, 15943.5);
	        series1.add(80.0, 14845.3);
	        series1.add(90.0, 14645.4);
	        series1.add(100.0, 16234.6);
	        series1.add(110.0, 17232.3);
	        series1.add(120.0, 14232.2);
	        series1.add(130.0, 13102.2);
	        series1.add(140.0, 14230.2);
	        series1.add(150.0, 11235.2);
	        series1.add(150.0, 11235.2);
	        series1.add(150.0, 11235.2);
	        series1.add(new XYDataItem(160.0, null));
	        series1.add(new XYDataItem(170.0, null));
	        series1.add(new XYDataItem(180.0, null));
	        series1.add(new XYDataItem(190.0, null));

	        XYSeries series2 = new XYSeries("Series 2");
	        series2.add(10.0, 15000.3);
	        series2.add(20.0, 11000.4);
	        series2.add(30.0, 17000.3);
	        series2.add(40.0, 15000.3);
	        series2.add(50.0, 14000.4);
	        series2.add(60.0, 12000.3);
	        series2.add(70.0, 11000.5);
	        series2.add(80.0, 12000.3);
	        series2.add(90.0, 13000.4);
	        series2.add(100.0, 12000.6);
	        series2.add(110.0, 13000.3);
	        series2.add(120.0, 17000.2);
	        series2.add(130.0, 18000.2);
	        series2.add(140.0, 16000.2);
	        series2.add(150.0, 17000.2);
	        series2.add(new XYDataItem(160.0, null));
	        series2.add(new XYDataItem(170.0, null));
	        series2.add(new XYDataItem(180.0, null));
	        series2.add(new XYDataItem(190.0, null));

	        XYSeriesCollection collection = new XYSeriesCollection();
	        collection.addSeries(series1);
	        collection.addSeries(series2);
	  

        
        JFreeChart chart = ChartFactory.createXYLineChart("Test Chart",
                "Domain Axis", "Range Axis", collection);
        XYPlot plot = (XYPlot) chart.getPlot();
        plot.addDomainMarker(new ValueMarker(1.0), Layer.FOREGROUND);
        plot.addDomainMarker(new IntervalMarker(2.0, 3.0), Layer.BACKGROUND);
        plot.addRangeMarker(new ValueMarker(4.0), Layer.FOREGROUND);
        plot.addRangeMarker(new IntervalMarker(5.0, 6.0), Layer.BACKGROUND);
        


        
		String uploadUrl ="/home/wwwroot/jstockchart/images";
		String imageDir = uploadUrl;
		File images = new File(imageDir);
		if (!images.exists()) {
			images.mkdirs();
		}
		String imageFile = imageDir + "/stock_"+99999+".png";
		
		System.out.println("开始写入图片。。。。");
		
		
		ChartUtilities.saveChartAsJPEG(new File(imageFile),1.0f, chart, 600, 320);
	
		
 
	}
}
