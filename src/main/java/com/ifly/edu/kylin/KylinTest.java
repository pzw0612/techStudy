package com.ifly.edu.kylin;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;

/**
 * @Description: todo
 * @author: pangzhiwang
 * @create: 2018/4/28
 **/
public class KylinTest {

//    private static String encoding;
//    private static final String baseURL="http://52.53.238.57:7070/kylin/api";
//
//    public static String login(String user,String passwd){
//        String method = "POST";
//        String para = "/user/authentication";
//        byte[] key = (user+":"+passwd).getBytes();
//        encoding = Base64.encodeBase64String(key);
//        return  excute(para,method,null);
//    }
//
//    public static String httpPost(String url,String arg){
//        InputStream is;
//        BufferedReader br;
//        StringBuilder sBuilder = null;
//        try {
//            HttpClient httpClient = new DefaultHttpClient();
//
//            HttpPut httpPost = new HttpPut(url);
//            //方式一：将参数添加到请求体当中
//            StringEntity sentity =new StringEntity(arg,"utf-8");
//            sentity.setContentType("application/json");
//            httpPost.setEntity(sentity);//默认是采用ISO-8859-1 对于中文需要使用utf-8编码
//
//            httpPost.addHeader("Authorization","Basic " + encoding);
//            httpPost.addHeader("Content-Type","application/json;charset=UTF-8");
//            HttpResponse httpResponse = httpClient.execute(httpPost);
//            //连接成功
//            if(200 == httpResponse.getStatusLine().getStatusCode()) {
//                HttpEntity httpEntity = httpResponse.getEntity();
//                is = httpEntity.getContent();
//                br = new BufferedReader(new InputStreamReader(is));
//                String tempStr;
//                sBuilder = new StringBuilder();
//                while ((tempStr = br.readLine()) != null) {
//                    sBuilder.append(tempStr);
//                }
//                br.close();
//                is.close();
//            }
//
//            System.out.println("httpResponse = " + httpResponse);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return sBuilder==null? "":sBuilder.toString();
//    }
//
//
//
//    private  static String excute(String para,String method,String body){
//
//        StringBuilder out = new StringBuilder();
//        try {
//            URL url = new URL(baseURL+para);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod(method);
//            connection.setDoOutput(true);
//            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
//            connection.setRequestProperty("Content-Type","application/json");
//            if(body !=null){
//                byte[] outputInBytes = body.getBytes("UTF-8");
//                OutputStream os = connection.getOutputStream();
//                os.write(outputInBytes);
//                os.close();
//            }
//            InputStream content = (InputStream)connection.getInputStream();
//            BufferedReader in  = new BufferedReader (new InputStreamReader (content));
//            String line;
//            while ((line = in.readLine()) != null) {
//                out.append(line);
//            }
//            in.close();
//            connection.disconnect();
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        return out.toString();
//    }
//    public static void main(String[] args) {
//
//        String KYLIN_CUBE_BUILD_FORMAT="{\"startTime\": '%d',\"endTime\": '%d',\"buildType\": \"BUILD\"}";
//
//        Date startDate=DateUtil.parseStrToDate("20180428080000",DateUtil.DATE_TIME_FORMAT_YYYYMMDDHHMISS);
//        Date stopDate= DateUtil.parseStrToDate("20180428090000",DateUtil.DATE_TIME_FORMAT_YYYYMMDDHHMISS);
//
//
//
//        System.out.println("startDate=" + startDate.toString());
//        System.out.println("stopDate=" + stopDate.getTime());
//
//        long currentSegmentStartTime=startDate.getTime();
//        long currentSegmentStopTime=stopDate.getTime();
//        //String baseUrl="http://52.53.238.57:7070/kylin/api";
//        String baseUrl="http://127.0.0.1:7070/kylin/api";
//        String body =String.format(KYLIN_CUBE_BUILD_FORMAT, currentSegmentStartTime,currentSegmentStopTime);
//
//        //login("ADMIN","KYLIN");
//
//        String para = "/cubes/"+"hft_order_view_5_cube_clone"+"/build";
//
//        String url = baseUrl+para;
//
//        httpPost(url,body);
//
//    } private static String encoding;
//    private static final String baseURL="http://52.53.238.57:7070/kylin/api";
//
//    public static String login(String user,String passwd){
//        String method = "POST";
//        String para = "/user/authentication";
//        byte[] key = (user+":"+passwd).getBytes();
//        encoding = Base64.encodeBase64String(key);
//        return  excute(para,method,null);
//    }
//
//    public static String httpPost(String url,String arg){
//        InputStream is;
//        BufferedReader br;
//        StringBuilder sBuilder = null;
//        try {
//            HttpClient httpClient = new DefaultHttpClient();
//
//            HttpPut httpPost = new HttpPut(url);
//            //方式一：将参数添加到请求体当中
//            StringEntity sentity =new StringEntity(arg,"utf-8");
//            sentity.setContentType("application/json");
//            httpPost.setEntity(sentity);//默认是采用ISO-8859-1 对于中文需要使用utf-8编码
//
//            httpPost.addHeader("Authorization","Basic " + encoding);
//            httpPost.addHeader("Content-Type","application/json;charset=UTF-8");
//            HttpResponse httpResponse = httpClient.execute(httpPost);
//            //连接成功
//            if(200 == httpResponse.getStatusLine().getStatusCode()) {
//                HttpEntity httpEntity = httpResponse.getEntity();
//                is = httpEntity.getContent();
//                br = new BufferedReader(new InputStreamReader(is));
//                String tempStr;
//                sBuilder = new StringBuilder();
//                while ((tempStr = br.readLine()) != null) {
//                    sBuilder.append(tempStr);
//                }
//                br.close();
//                is.close();
//            }
//
//            System.out.println("httpResponse = " + httpResponse);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return sBuilder==null? "":sBuilder.toString();
//    }
//
//
//
//    private  static String excute(String para,String method,String body){
//
//        StringBuilder out = new StringBuilder();
//        try {
//            URL url = new URL(baseURL+para);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setRequestMethod(method);
//            connection.setDoOutput(true);
//            connection.setRequestProperty  ("Authorization", "Basic " + encoding);
//            connection.setRequestProperty("Content-Type","application/json");
//            if(body !=null){
//                byte[] outputInBytes = body.getBytes("UTF-8");
//                OutputStream os = connection.getOutputStream();
//                os.write(outputInBytes);
//                os.close();
//            }
//            InputStream content = (InputStream)connection.getInputStream();
//            BufferedReader in  = new BufferedReader (new InputStreamReader (content));
//            String line;
//            while ((line = in.readLine()) != null) {
//                out.append(line);
//            }
//            in.close();
//            connection.disconnect();
//
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        return out.toString();
//    }
//    public static void main(String[] args) {
//
//        String KYLIN_CUBE_BUILD_FORMAT="{\"startTime\": '%d',\"endTime\": '%d',\"buildType\": \"BUILD\"}";
//
//        Date startDate=DateUtil.parseStrToDate("20180428080000",DateUtil.DATE_TIME_FORMAT_YYYYMMDDHHMISS);
//        Date stopDate= DateUtil.parseStrToDate("20180428090000",DateUtil.DATE_TIME_FORMAT_YYYYMMDDHHMISS);
//
//
//
//        System.out.println("startDate=" + startDate.toString());
//        System.out.println("stopDate=" + stopDate.getTime());
//
//        long currentSegmentStartTime=startDate.getTime();
//        long currentSegmentStopTime=stopDate.getTime();
//        //String baseUrl="http://52.53.238.57:7070/kylin/api";
//        String baseUrl="http://127.0.0.1:7070/kylin/api";
//        String body =String.format(KYLIN_CUBE_BUILD_FORMAT, currentSegmentStartTime,currentSegmentStopTime);
//
//        //login("ADMIN","KYLIN");
//
//        String para = "/cubes/"+"hft_order_view_5_cube_clone"+"/build";
//
//        String url = baseUrl+para;
//
//        httpPost(url,body);
//
//    }
}