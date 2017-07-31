package com.ifly.edu.tika.example2;

/**
 *
 * @author pangzhw
 * @date 2015年4月17日
 */
public enum FileTypes {
	   
    TEXT_PLAIN("text/plain"),
   
    MS_EXCEL("application/vnd.ms-excel"),
   
    MS_EXCEL2007("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet"),
    
    DBF("application/octet-stream");

    public String value;

    FileTypes(String value) {
        this.value = value;
    }

}
