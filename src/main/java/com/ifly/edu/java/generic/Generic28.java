package com.ifly.edu.java.generic;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @Description: TODO
 * @author pangzhw
 * @date 2015年2月14日
 */
public class Generic28 {

	public static void main(String[] args) {
		
		Set<String> guys = new HashSet<String>(Arrays.asList("Tom","Dick","Harry"));
		Set<String> stooges = new HashSet<String>(Arrays.asList("Larry","Moe","Curly"));
		
		Set<String> aflcio = union(guys,stooges);
		System.out.println(aflcio);
	}
	
	public static <E> Set<E> union(Set<E> s1, Set<E> s2){
		Set<E> result = new HashSet<E>(s1);
		result.addAll(s2);
		return result;
	}
	
}
