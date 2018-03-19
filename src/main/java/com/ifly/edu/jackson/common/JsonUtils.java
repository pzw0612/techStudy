package com.ifly.edu.jackson.common;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 一些json与对象转换的工具集合类
 * 
 * 
 */
public class JsonUtils {

    private static Logger logger = LoggerFactory.getLogger(JsonUtils.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    private JsonUtils(){}
    public static ObjectMapper getInstance() {  
            return objectMapper;  
    }  

    /**
     * 使用Jackson 数据绑定 将对象转换为 json字符串
     * 
     * 还可以 直接使用 JsonUtils.getInstance().writeValueAsString(Object obj)方式 
     * @param obj
     * @return
     */
    public static String toJsonString(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (JsonGenerationException e) {
            logger.error("转换为json字符串失败" + e.toString());
        } catch (JsonMappingException e) {
            logger.error("转换为json字符串失败" + e.toString());
        } catch (IOException e) {
            logger.error("转换为json字符串失败" + e.toString());
        }
        return null;
    }

    /**
     * json字符串转化为 JavaBean
     * 
     * 还可以直接JsonUtils.getInstance().readValue(String content,Class valueType)用这种方式
     * @param <T>
     * @param content
     * @param valueType
     * @return
     */
    public static <T> T toJavaBean(String content, Class<T> valueType) {
        try {
            return objectMapper.readValue(content, valueType);
        } catch (JsonParseException e) {
            logger.error("json字符串转化为 javabean失败" + e.toString());
        } catch (JsonMappingException e) {
            logger.error("json字符串转化为 javabean失败" + e.toString());
        } catch (IOException e) {
            logger.error("json字符串转化为 javabean失败" + e.toString());
        }
        return null;
    }

    /**
     * json字符串转化为list
     * 
     * 还可以 直接使用  JsonUtils.getInstance().readValue(String content, new TypeReference<List<T>>(){})方式
     * @param <T>
     * @param content
     * @param valueType
     * @return
     * @throws IOException 
     */
    public static <T> List<T> toJavaBeanList(String content, TypeReference<List<T>>  typeReference) throws IOException {
        try {
            return objectMapper.readValue(content, typeReference);
        } catch (JsonParseException e) {
            logger.error("json字符串转化为 list失败,原因:" + e.toString());
            throw new RuntimeException("json字符串转化为 list失败");
        } catch (JsonMappingException e) {
            logger.error("json字符串转化为 list失败,原因" + e.toString());
            throw new JsonMappingException("json字符串转化为 list失败");
        } catch (IOException e) {
            logger.error("json字符串转化为 list失败,原因" + e.toString());
            throw new IOException("json字符串转化为 list失败");
        }
    }


    public static void main(String[] args)  throws  Exception{
        String json = "{\"name\":\"lijz\",\"id\":10}";
        JsonNode node = objectMapper.readTree(json);
        String name = node.get("name").asText();
        int id = node.get("id").asInt();
        System.out.println(name +":"+ id);
    }

}
