package com.ifly.edu.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;

/**
 * @ClassName: FileUtilsTest
 * @Description: TODO
 * @author pangzhw
 * @date 2015年1月8日
 */
public class FileUtilsTest {

	public static void main(String[] args) throws Exception {
		
		readLine();
		
		
	}
	
	static void moveFileToDirectory() throws IOException{
		String srcFile ="C:\\Users\\zhiwang\\Desktop\\项目\\统计\\文件目录.txt";
		String destDir ="C:\\Users\\zhiwang\\Desktop\\项目\\统计\\doc\\处理逻辑\\";
		
		FileUtils.moveFileToDirectory(new File(srcFile), new File(destDir), true);
	}
	
	static void copy() throws IOException{
		String srcFile ="C:\\Users\\zhiwang\\Desktop\\项目\\统计\\CopyOfEquityParseService.java";
		String destDir ="C:\\Users\\zhiwang\\Desktop\\项目\\统计\\doc\\aa\\11CopyOfEquityParseServicess.java";
		
		FileUtils.copyFile(new File(srcFile), new File(destDir));
	}
	static void readLine() throws IOException{
		String srcFile ="E:\\work\\irecom\\sse\\doc\\网投\\06-sseinfonet_voting_system\\网络投票统计系统（SIVS）\\05. 测试文档\\01. 测试数据\\R006获取现场投票文件\\sse2vote_20141030_600201.txt";
		
		
		List<String> list =FileUtils.readLines(new File(srcFile), "utf-8");
		
		for(String str:list){
			System.out.println(str);
			System.out.println("-------------------------------");
		}
	}
}
