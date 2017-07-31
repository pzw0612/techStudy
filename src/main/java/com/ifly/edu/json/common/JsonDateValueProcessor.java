package com.ifly.edu.json.common;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import net.sf.json.JsonConfig;
import net.sf.json.processors.JsonValueProcessor;
/**
 *
 * @author pangzhw
 * @date 2015年5月19日
 */

public class JsonDateValueProcessor implements JsonValueProcessor {

   
	private String format = "yyyy-MM-dd HH:mm:ss"; 

   
    public JsonDateValueProcessor() {
        super();
    }

   
    public JsonDateValueProcessor(String format) {
        super();
        this.format = format;
    }

   
    public Object processArrayValue(Object value, JsonConfig jsonConfig) {
        return process(value);
    }

   
    public Object processObjectValue(String key, Object value,
            JsonConfig jsonConfig) {
        return process(value);
    }

   
    private Object process(Object value) {
        try {
            if (value instanceof Date) {
                SimpleDateFormat sdf = new SimpleDateFormat(format,Locale.UK);
                return sdf.format((Date) value);
            }
            return value == null ? "" : value.toString();
        } catch (Exception e) {
            return "";
        }

    }

   
    public String getDatePattern() {
        return format;
    }

   
    public void setDatePattern(String pDatePattern) {
    	format = pDatePattern;
    }

}

