package com.ifly.edu.ant.zip;

import java.io.File;

import org.apache.tools.ant.Project;
import org.apache.tools.ant.taskdefs.Expand;
import org.apache.tools.ant.taskdefs.Zip;
import org.apache.tools.ant.types.FileSet;

public class ZipUtil {
	 
    private static final Project DEFAULT_PROJECT = new Project();
     
    public static void unZip(File orgin, File dest) {
         
        Expand expand = new Expand();
        expand.setProject(DEFAULT_PROJECT);
        expand.setSrc(orgin);
        expand.setDest(dest);
        expand.execute();
         
    }
     
    public static void zip(File orgin, File dest) {
         
        Zip zip = new Zip();
        zip.setProject(DEFAULT_PROJECT);
        zip.setDestFile(dest);
        zip.setEncoding("utf-8");
         
        FileSet fs = new FileSet();
        fs.setProject(DEFAULT_PROJECT);
        fs.setDir(orgin);
//      fs.setIncludes("**/*.java");
//      fs.setExcludes("**/*.xml");
         
        zip.addFileset(fs);
        zip.execute();
         
    }
     
    /**
     * @param args
     */
    public static void main(String[] args) {
        File orgin = new File("E:\\庞志旺.zip");
        File dest = new File("E:\\weblogs\\sivdc\\20150121");
        unZip(orgin, dest);
        System.out.println("----------un zip -----------");
         
        File zip = new File("E:\\庞志旺.zip");
        System.out.println("----------zip starting-----------");
        zip(dest, zip);
        System.out.println("----------zip success-----------");
    }
 
}
