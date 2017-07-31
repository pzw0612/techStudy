package com.ifly.edu.freemarker;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.ifly.edu.freemarker.model.Animal;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年2月28日
 */
public class DataHolder {

	public static Map<String,Object> getData1(){
		Map<String,Object> root = new HashMap<String,Object>();
		// Put string ``user'' into the root
		root.put("user", "Big Joe");
		// Create the hash for ``latestProduct''
		Map<String,Object> latest = new HashMap<String,Object>();
		// and put it into the root
		root.put("latestProduct", latest);
		// put ``url'' and ``name'' into latest
		latest.put("url", "products/greenmouse.html");
		latest.put("name", "green mouse");  
		return root;
	}
	
	public static Map<String,Object> getData2(){
		Map<String,Object> root = new HashMap<String,Object>();
		Map<String,Object> animals = new HashMap<String,Object>();
		Map<String,Object> whatnot = new HashMap<String,Object>();
		root.put("animals", animals);
		root.put("whatnot", whatnot);
		root.put("test", "It is a test");
		whatnot.put("because", "don't know");
		
		animals.put("mouse", new Animal("small",50));
		animals.put("elephant", new Animal("large",5000));
		animals.put("python", new Animal("medium",49990));
		
		return root;
	}
	
	public static Map<String,Object> getData3(){
		
		Map<String,Object> root = new HashMap<String,Object>();
		Map<String,Object> fruits = new HashMap<String,Object>();

		List<Animal> amlList = new ArrayList<Animal>();
		List<String> fruitsList = new ArrayList<String>();
		
		root.put("animals", amlList);
		root.put("whatnot", fruits);
		fruits.put("fruits", fruitsList);
		amlList.add(new Animal("small",50,"mouse"));
		amlList.add(new Animal("large",5000,"elephant"));
		amlList.add(new Animal("medium",4999,"python"));
		
		fruitsList.add("orange");
		fruitsList.add("banana");
		
		return root;
	}
	
	public static Map<String,Object> getData4(){
		
		Map<String,Object> root = new HashMap<String,Object>();
		Map<String,Object> cargo = new HashMap<String,Object>();
		
		List<Integer> lotteryNumbers = new ArrayList<Integer>();
		root.put("user", "Big Joe");
		root.put("today", new Date());
		root.put("todayHoliday", false);
		root.put("lotteryNumbers", lotteryNumbers);
		
		lotteryNumbers.add(20);
		lotteryNumbers.add(14);
		lotteryNumbers.add(42);
		lotteryNumbers.add(8);
		lotteryNumbers.add(15);
		
		cargo.put("name", "coal");
		cargo.put("weight", 40);
		
		return root;
	}
	
}
