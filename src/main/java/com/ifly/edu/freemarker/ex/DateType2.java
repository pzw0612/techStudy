package com.ifly.edu.freemarker.ex;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.ifly.edu.freemarker.FreemarkConfig;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年3月1日
 */
public class DateType2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception
	{
		
		// Create your Configuration instance, and specify if up to what FreeMarker
		// version (here 2.3.21) do you want to apply the fixes that are not 100%
		// backward-compatible. See the Configuration JavaDoc for details.
		Configuration cfg = FreemarkConfig.getInstance().getConfiguration();
		
		  // 2. Proccess template(s)
	    //
	    // You will do this for several times in typical applications.
	    
	    // 2.1. Prepare the template input:
	    
		// Create the root hash
//		Map<String,Object> root = DataHolder.getData3();
		Map<String,Object> root = new HashMap<String,Object>();
		root.put("user", "pangzhw");
		root.put("indexOf", new IndexOfMethod());
	    // 2.2. Get the template

	    Template template = cfg.getTemplate("/datatype/method.ftl");
	      
	    // 2.3. Generate the output

	    // Write output to the console
	    Writer consoleWriter = new OutputStreamWriter(System.out);
	    template.process(root, consoleWriter);


	 }

	

}
