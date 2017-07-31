package com.ifly.edu.freemarker.ex;

import java.util.List;

import freemarker.template.SimpleNumber;
import freemarker.template.TemplateMethodModel;
import freemarker.template.TemplateModel;
import freemarker.template.TemplateModelException;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年3月1日
 */
public class IndexOfMethod implements TemplateMethodModel {
	@SuppressWarnings("rawtypes")public TemplateModel exec(List args) throws TemplateModelException {
			if (args.size() != 2) {
			  throw new TemplateModelException("Wrong arguments");
			}
			
		   return new SimpleNumber(((String) args.get(1)).indexOf((String) args.get(0)));
      }
}
