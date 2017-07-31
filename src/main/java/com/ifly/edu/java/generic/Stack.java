package com.ifly.edu.java.generic;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * 第26条：优先考虑泛型
 * @Description: TODO
 * @author pangzhw
 * @date 2015年2月14日
 */
public class Stack<E> {
	 private Object[] elements;
	 private int size=0;
	 private static final int DEFAULT_INITIAL_CAPACITY =16;
	public Stack(){
		 elements =   new Object[DEFAULT_INITIAL_CAPACITY];
//		 elements =  (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	 }
	 public void push(E e){
		 ensureCapacity();
		 elements[size++]=e;
		 Integer aa;
	 }

	private void ensureCapacity() {
		if(elements.length==size){
			elements = Arrays.copyOf(elements, 2*size+1);
			System.out.println(elements.length);
		}
	}
	public E pop(){
		 if(size==0){
			  throw new EmptyStackException();
		 }
		 @SuppressWarnings("unchecked")E result = (E)elements[--size];
		 elements[size]=null;
		 return result;
	 }
	 public boolean isEmpty(){
		 return size==0;
	 }
	public static void main(String[] args) {
		Stack<String> stack = new Stack<String>();
		stack.push("abc1");
		stack.push("abc2");
		stack.push("abc3");
		stack.push("abc4");
		
		while(!stack.isEmpty()){
			System.out.println(stack.pop());
		}
		
     }
}
