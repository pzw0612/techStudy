package com.ifly.edu.tika.example2;

/**
 *
 * @author pangzhw
 * @date 2015年4月17日
 */
import java.io.File;
import java.util.HashSet;
import java.util.Set;

import org.apache.tika.Tika;
import org.apache.tika.config.TikaConfig;


public class DealMimeTypes {

    private static Tika tika = null;

    private static Set supportFileTypes = new HashSet();

    static {
        TikaConfig config = TikaConfig.getDefaultConfig();
        tika = new Tika(config);
        // 支持的文件类型
        for (FileTypes fileTypes : FileTypes.values()) {
            supportFileTypes.add(fileTypes.value);
        }
    }

   
    public static boolean supportFileType(File file) {
        return supportFileTypes.contains(tika.detect(file.getPath()));
    }

   
    public static boolean supportFileType(String filetPath) {
        return supportFileTypes.contains(tika.detect(filetPath));
    }

   
    public static String detect(File file) {
        return tika.detect(file.getPath());
    }

   
    public static String detect(String filetPath) {
        return tika.detect(filetPath);
    }

   
    public static FileTypes getFileTypes(File file) {
        String value = tika.detect(file.getPath());
        for (FileTypes fileTypes : FileTypes.values()) {
            if (value.equals(fileTypes.value)) {
                return fileTypes;
            }
        }
        return null;
    }

   
    public static FileTypes getFileTypes(String filetPath) {
        String value = tika.detect(filetPath);
        for (FileTypes fileTypes : FileTypes.values()) {
            if (value.equals(fileTypes.value)) {
                return fileTypes;
            }
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        File f = new File("E:\\sivdc\\equity\\enc\\201504\\");
        for (File tf : f.listFiles()) {
            if (tf.exists() && tf.isFile() && supportFileType(tf)) {
                System.out.print(tf.getName() + "::");
                System.out.println(DealMimeTypes.detect(tf));
//                System.out.println(DealMimeTypes.detect(tf));
            }
        }

    }
}
