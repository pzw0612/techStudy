package com.ifly.edu.ant.zip;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;
  
public class ZipCompressorByAnt {  
  
    private File zipFile;  
  
    public ZipCompressorByAnt(String pathName) {  
        zipFile = new File(pathName);  
    }  
      
    public void compress(String srcPathName) {  
        File srcdir = new File(srcPathName);  
        if (!srcdir.exists())  
            throw new RuntimeException(srcPathName + "不存在！");  
          
        Project prj = new Project();  
        Zip zip = new Zip();  
        zip.setProject(prj);  
        zip.setDestFile(zipFile);  
        
        FileSet fileSet = new FileSet();  
        fileSet.setProject(prj);  
        fileSet.setDir(srcdir);  
        zip.addFileset(fileSet);  
          
        zip.execute();  
    } 

    public static void main(String[] args) {  
//    	ZipCompressorByAnt zc = new  ZipCompressorByAnt("E:\\szhzip.zip");  
//        zc.compress("E:\\test");  
          
        ZipCompressorByAnt zca = new ZipCompressorByAnt("E:\\庞志旺.zip");  
        zca.compress("E:\\weblogs\\sivdc\\20150121");  
    }  
}
