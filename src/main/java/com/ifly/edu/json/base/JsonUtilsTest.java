package com.ifly.edu.json.base;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.ifly.edu.json.common.JsonUtils;
    
/**   
 * JsonUtils测试类   
 * (C) 2009-9-11, jzj   
 */    
public class JsonUtilsTest  {     
    
	public static void main(String[] args) {
		testgetJsonStr1();
	}
    /**   
     * 从json串转换成实体对象，且实体中Date属性能正确转换   
     *  void   
     */    
    public static void  testGetDtoFromJsonObjStr1() {     
        String json = "{'name':'get','dateAttr':'2009-11-12'}";     
        Person ps = (Person) JsonUtils.getDtoFromJsonObjStr(json, Person.class);     
        //print: get     
        System.out.println(ps.getName());     
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");     
        //print: 2009-11-12     
        System.out.println(sdf.format(ps.getDateAttr()));     
    }     
    
    /**   
     * 从json串转换成实体对象，并且实体集合属性存有另外实体Bean   
     *  void   
     */    
    public static void testGetDtoFromJsonObjStr3() {     
        String json = "{'data':[{'name':'get'},{'name':'set'}]}";     
        Map classMap = new HashMap();     
        classMap.put("data", Person.class);   
        MyBean myBean = (MyBean) JsonUtils.getDtoFromJsonObjStr(json, MyBean.class,classMap);     
        
//        //print: class comm.test.Person name =get            
//        System.out.println(myBean.getData().get(0).getClass() + " name ="    
//                + ((Person) myBean.getData().get(0)).getName());     
//        //print: class comm.test.Person name =set     
//        System.out.println(myBean.getData().get(1).getClass() + " name ="    
//                + ((Person) myBean.getData().get(1)).getName());     
    }     
    
    /**   
     * 把一个json数组串转换成普通数组   
     *  void   
     */    
    public  static void testGetArrFromJsonArrStr() {     
        String json = "['get',1,true,null]";     
        Object[] objArr = JsonUtils.getArrFromJsonArrStr(json);     
        for (int i = 0; i < objArr.length; i++) {     
            System.out.println(objArr[i].getClass() + " " + objArr[i]);     
        }     
        /*  print:   
            class java.lang.String get   
            class java.lang.Integer 1   
            class java.lang.Boolean true   
            class net.sf.json.JSONNull null   
         */    
    }     
    
    /**   
     * 把一个json数组串转换成实体数组   
     *  void   
     */    
    public  static void testGetDtoArrFromJsonArrStr1() {     
        String json = "[{'name':'get'},{'name':'set'}]";     
        Object[] objArr = JsonUtils.getDtoArrFromJsonArrStr(json, Person.class);     
        for (int i = 0; i < objArr.length; i++) {     
            System.out.println(objArr[i].getClass() + " name = "    
                    + ((Person) objArr[i]).getName());     
        }     
        /*  print:   
            class comm.test.Person name = get   
            class comm.test.Person name = set   
         */    
    }     
    
    /**   
     * 把一个json数组串转换成实体数组，且数组元素的属性含有另外实例Bean   
     *  void   
     */    
    public  static void testGetDtoArrFromJsonArrStr2() {     
        String json = "[{'data':[{'name':'get'}]},{'data':[{'name':'set'}]}]";     
        Map classMap = new HashMap();     
        classMap.put("data", Person.class);     
        Object[] objArr = JsonUtils.getDtoArrFromJsonArrStr(json, MyBean.class, classMap);     
        for (int i = 0; i < objArr.length; i++) {     
            System.out.println(((MyBean) objArr[i]).getData().get(0).getClass()     
                    + " name = "    
                    + ((Person) ((MyBean) objArr[i]).getData().get(0)).getName());     
        }     
        /*  print:   
            class comm.test.Person name = get   
            class comm.test.Person name = set   
         */    
    }     
    
    /**   
     * 把一个json数组串转换成存放普通类型元素的集合   
     *  void   
     */    
    public  static void testGetListFromJsonArrStr1() {     
        String json = "['get',1,true,null]";     
        List list = JsonUtils.getListFromJsonArrStr(json);     
        for (int i = 0; i < list.size(); i++) {     
            System.out.println(list.get(i).getClass() + " " + list.get(i));     
        }     
        /*  print:   
            class java.lang.String get   
            class java.lang.Integer 1   
            class java.lang.Boolean true   
            class net.sf.json.JSONNull null   
         */    
    }     
    
    /**   
     * 把一个json数组串转换成集合，且集合里存放的为实例Bean   
     *  void   
     */    
    public  static void testGetListFromJsonArrStr2() {     
        String json = "[{'name':'get'},{'name':'set'}]";     
        List list = JsonUtils.getListFromJsonArrStr(json, Person.class);     
        for (int i = 0; i < list.size(); i++) {     
            System.out.println(list.get(i).getClass() + " name = "    
                    + ((Person) list.get(i)).getName());     
        }     
        /*  print:   
            class comm.test.Person name = get   
            class comm.test.Person name = set   
         */    
    }     
    
    /**   
     * 把一个json数组串转换成集合，且集合里的对象的属性含有另外实例Bean   
     *  void   
     */    
    public  static void testGetListFromJsonArrStr3() {     
        String json = "[{'data':[{'name':'get'}]},{'data':[{'name':'set'}]}]";     
        Map classMap = new HashMap();     
        classMap.put("data", Person.class);     
        List list = JsonUtils.getListFromJsonArrStr(json, MyBean.class, classMap);     
        for (int i = 0; i < list.size(); i++) {     
            System.out.println(((MyBean) list.get(i)).getData().get(0).getClass()     
                    + " name = "    
                    + ((Person) ((MyBean) list.get(i)).getData().get(0)).getName());     
        }     
        /*  print:   
            class comm.test.Person name = get   
            class comm.test.Person name = set   
         */    
    }     
    
    /**   
     * 把json对象串转换成map对象   
     *  void   
     */    
    public  static void testGetMapFromJsonObjStr() {     
        String json = "{'name':'get','int':1,'double':1.1,'null':null}";     
        Map map = JsonUtils.getMapFromJsonObjStr(json);     
        for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {     
            System.out.println(map.get(iter.next()).getClass());     
        }     
        /*  print:   
            class java.lang.Double   
            class net.sf.json.JSONNull   
            class java.lang.Integer   
            class java.lang.String   
         */    
    }     
    
    /**   
     * 把json对象串转换成map对象，且map对象里存放的为其他实体Bean   
     *  void   
     */    
    public  static void testGetMapFromJsonObjStr2() {     
        String json = "{'data1':{'name':'get'},'data2':{'name':'set'}}";     
        Map map = JsonUtils.getMapFromJsonObjStr(json, Person.class);     
        for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {     
            String key = (String) iter.next();     
            System.out.println(map.get(key).getClass() + " name="    
                    + ((Person) map.get(key)).getName());     
        }     
        /*  print:   
            class comm.test.Person name=set   
            class comm.test.Person name=get   
         */    
    }     
    
    /**   
     * 把json对象串转换成map对象，且map对象里   
     * 存放的其他实体Bean还含有另外实体Bean   
     *  void   
     */    
    public  static void testGetMapFromJsonObjStr3() {     
        String json = "{'mybean':{'data':[{'name':'get'}]}}";     
        Map classMap = new HashMap();     
        classMap.put("data", Person.class);     
        Map map = JsonUtils.getMapFromJsonObjStr(json, MyBean.class, classMap);     
        for (Iterator iter = map.keySet().iterator(); iter.hasNext();) {     
            String key = (String) iter.next();     
            Object o = ((MyBean) map.get(key)).getData().get(0);     
            System.out.println(o.getClass() + " name=" + ((Person) o).getName());     
        }     
        /*  print:   
            class comm.test.Person name=get   
         */    
    }     
    
    /**   
     * 实体Bean转json串   
     *  void   
     */    
    public  static void testgetJsonStr1() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        MyBean myBean = new MyBean();     
        List list = new ArrayList();     
        list.add(ps);     
    
        myBean.setData(list);     
        //print: {"data":[{"dateAttr":"2009-09-12 07:24:54","name":"get"}]}     
        System.out.println(JsonUtils.getJsonStr(myBean));     
    }     
    
    /**   
     * map转json串   
     *  void   
     */    
    public  static void testgetJsonStr2() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        Map map = new LinkedHashMap();     
        map.put("person1", ps);     
    
        //print: {"person1":{"dateAttr":"2009-09-12 07:24:27","name":"get"}}     
        System.out.println(JsonUtils.getJsonStr(map));     
    }     
    
    /**   
     * 数组转json串   
     *  void   
     */    
    public  static void testgetJsonStr3() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        Person[] personArr = new Person[1];     
        personArr[0] = ps;     
        //print: [{"dateAttr":"2009-09-12 07:23:54","name":"get"}]     
        System.out.println(JsonUtils.getJsonStr(personArr));     
    }     
    
    /**   
     * list转json串   
     *  void   
     */    
    public  static void testgetJsonStr4() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        List list = new ArrayList();     
        list.add(ps);     
    
        //print: [{"dateAttr":"2009-09-12 07:22:49","name":"get"}]     
        System.out.println(JsonUtils.getJsonStr(list));     
    }     
    
    /**   
     * set转json串   
     *  void   
     */    
    public  static void testgetJsonStr5() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        Set set = new LinkedHashSet();     
        set.add(ps);     
    
        //print: [{"dateAttr":"2009-09-12 07:22:16","name":"get"}]     
        System.out.println(JsonUtils.getJsonStr(set));     
    }     
    
    /**   
     * json对象串转XML   
     *  void   
     */    
    public  static void testGetXMLFromObj1() {     
        ///System.out.println(JsonUtils.getXMLFromObj("{/"name/":/"json/",/"bool/":true,/"int/":1}"));     
        /*  print:   
            <?xml version="1.0" encoding="UTF-8"?>   
            <o>   
                <bool type="boolean">true</bool>   
                <int type="number">1</int>   
                <name type="string">json</name>   
            </o>   
         */    
    }     
    
    /**   
     * json数组串转XML   
     *  void   
     */    
    public  static void testGetXMLFromObj2() {     
        System.out.println(JsonUtils.getXMLFromObj("[1,2,3]"));     
        /*  print:   
            <?xml version="1.0" encoding="UTF-8"?>   
            <a>   
                <e type="number">1</e>   
                <e type="number">2</e>   
                <e type="number">3</e>   
            </a>   
         */    
    }     
    
    /**   
     * java数组转XML   
     *  void   
     */    
    public  static void testGetXMLFromObj3() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        Person[] personArr = new Person[2];     
        personArr[0] = ps;     
    
        System.out.println(JsonUtils.getXMLFromObj(personArr));     
        /*  print:   
            <?xml version="1.0" encoding="UTF-8"?>   
            <a>   
                <e class="object">   
                    <dateAttr type="string">2009-09-12 06:58:55</dateAttr>   
                    <name type="string">get</name>   
                </e>   
            </a>   
         */    
    }     
    
    /**   
     * list转XML   
     *  void   
     */    
    public  static void testGetXMLFromObj4() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        List list = new ArrayList();     
        list.add(ps);     
    
        System.out.println(JsonUtils.getXMLFromObj(list));     
        /*  print:   
            <?xml version="1.0" encoding="UTF-8"?>   
            <a>   
                <e class="object">   
                    <dateAttr type="string">2009-09-12 07:02:31</dateAttr>   
                    <name type="string">get</name>   
                </e>   
            </a>   
         */    
    }     
    
    /**   
     * set转XML   
     * void   
     */    
    public  static void testGetXMLFromObj5() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        Set set = new LinkedHashSet();     
        set.add(ps);     
    
        System.out.println(JsonUtils.getXMLFromObj(set));     
        /*  print:   
            <?xml version="1.0" encoding="UTF-8"?>   
            <a>   
                <e class="object">   
                    <dateAttr type="string">2009-09-12 07:04:38</dateAttr>   
                    <name type="string">get</name>   
                </e>   
            </a>   
         */    
    }     
    
    /**   
     * map转XML   
     *  void   
     */    
    public  static void testGetXMLFromObj6() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        Map map = new HashMap();     
        map.put("person1", ps);     
    
        System.out.println(JsonUtils.getXMLFromObj(map));     
        /*  print:   
            <?xml version="1.0" encoding="UTF-8"?>   
            <o>   
                <person1 class="object">   
                    <dateAttr type="string">2009-09-12 07:08:35</dateAttr>   
                    <name type="string">get</name>   
                </person1>   
            </o>   
         */    
    }     
    
    /**   
     * 实体Bean转XML   
     *  void   
     */    
    public  static void testGetXMLFromObj7() {     
        Person ps = new Person();     
        ps.setDateAttr(new Date());     
        ps.setName("get");     
        System.out.println(JsonUtils.getXMLFromObj(ps));     
        /*  print:   
            <?xml version="1.0" encoding="UTF-8"?>   
            <o>   
                <dateAttr type="string">2009-09-12 07:13:02</dateAttr>   
                <name type="string">get</name>   
            </o>   
         */    
    }     
    
    /**   
     * 从XML对象串转json串   
     *  void   
     */    
    public  static void testGetJsonStrFromXML1() {     
        String xml = "<o><dateAttr type='string'>2009-09-12 07:13:02</dateAttr>"    
                + "<name type='string'>get</name></o>";     
        //print: {"dateAttr":"2009-09-12 07:13:02","name":"get"}     
        System.out.println(JsonUtils.getJsonStrFromXML(xml));     
    }     
    
    /**   
     * 从XML数组串转json串   
     *  void   
     */    
    public  static void testGetJsonStrFromXML2() {     
        String xml = "<a class='array'><e class='object'><dateAttr type='string'>2009-09-12 07:04:38</dateAttr>"    
                + "<name type='string'>get</name></e></a>";     
        //print: [{"dateAttr":"2009-09-12 07:04:38","name":"get"}]     
        System.out.println(JsonUtils.getJsonStrFromXML(xml));     
    }     
}  
