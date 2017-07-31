package com.ifly.edu.jfree.chart;

import java.io.File;
import java.io.IOException;

import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CombinedDomainXYPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.xy.XYDataItem;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;


/**
 *
 * @author pangzhw
 * @date 2015年5月6日
 */
public class CombinedDomainXYPlotTest2 {

	
	
    /**
     * Creates a sample dataset.
     *
     * @return Series 2.
     */
    private XYDataset createDataset2() {

        XYSeries series2 = new XYSeries("Series 3");

        series2.add(10.0, 16853.2);
        series2.add(20.0, 19642.3);
        series2.add(30.0, 18253.5);
        series2.add(40.0, 15352.3);
        series2.add(50.0, 13532.0);
        series2.add(100.0, 12635.3);
        series2.add(110.0, 13998.2);
        series2.add(120.0, 11943.2);
        series2.add(130.0, 16943.9);
        series2.add(140.0, 17843.2);
        series2.add(150.0, 16495.3);
        series2.add(160.0, 17943.6);
        series2.add(170.0, 18500.7);
        series2.add(180.0, 19595.9);
        
        series2.add(new XYDataItem(160.0, null));
        series2.add(new XYDataItem(170.0, null));
        series2.add(new XYDataItem(180.0, null));
        series2.add(new XYDataItem(190.0, null));

        return new XYSeriesCollection(series2);

    }
	
    

    /**
     * Creates a sample dataset.
     *
     * @return Series 1.
     */
    private XYDataset createDataset1() {

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
        return collection;

    }
    /**
     * Creates a sample plot.
     *
     * @return A sample plot.
     */
    private CombinedDomainXYPlot createPlot() {
        // create subplot 1...
        XYDataset data1 = createDataset1();
        XYItemRenderer renderer1 = new StandardXYItemRenderer();
        NumberAxis rangeAxis1 = new NumberAxis("Range 1");
        XYPlot subplot1 = new XYPlot(data1, null, rangeAxis1, renderer1);
        subplot1.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);

//        XYTextAnnotation annotation = new XYTextAnnotation("Hello!", 50.0,
//                10000.0);
//        annotation.setFont(new Font("SansSerif", Font.PLAIN, 9));
//        annotation.setRotationAngle(Math.PI / 4.0);
//        subplot1.addAnnotation(annotation);

        // create subplot 2...
        XYDataset data2 = createDataset2();
        XYItemRenderer renderer2 = new StandardXYItemRenderer();
        NumberAxis rangeAxis2 = new NumberAxis("Range 2");
        rangeAxis2.setAutoRangeIncludesZero(false);
        XYPlot subplot2 = new XYPlot(data2, null, rangeAxis2, renderer2);
        subplot2.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);

        // parent plot...
        CombinedDomainXYPlot plot = new CombinedDomainXYPlot(
                new NumberAxis("Domain"));
        plot.setGap(10.0);

        // add the subplots...
        plot.add(subplot1, 1);
        plot.add(subplot2, 1);
        plot.setOrientation(PlotOrientation.VERTICAL);
        return plot;
    }
    
    
	public  JFreeChart createTimeseriesChart() {
        CombinedDomainXYPlot plot = createPlot();
        JFreeChart chart = new JFreeChart(plot);
        return chart;
	}
	
	public static void main(String[] args) throws IOException {
		
		CombinedDomainXYPlotTest2 test = new CombinedDomainXYPlotTest2();
		String uploadUrl ="/home/wwwroot/jstockchart/images";
		String imageDir = uploadUrl;
		File images = new File(imageDir);
		if (!images.exists()) {
			images.mkdirs();
		}
		String imageFile = imageDir + "/stock_"+60000+".png";
		
		System.out.println("开始写入图片。。。。");
		
		JFreeChart jfreechart= test.createTimeseriesChart();
		
		ChartUtilities.saveChartAsJPEG(new File(imageFile),1.0f, jfreechart, 600, 320);
	}
}
