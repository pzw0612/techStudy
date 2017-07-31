package com.ifly.edu.java.base.init;

/**
 *
 * @author pangzhw
 * @date 2015年3月29日
 */
public class InitTest {
	public static void main(String[] args) {
		/**
		 * 一：先不考虑继承。一个类中初始化的顺序规则是： （1）静态变量>普通变量>构造器。 （2）变量定义的顺序决定初始化的顺序。
		 * （3）静态变量和静态块是一样的，变量和非静态块是一样的。 即可以把静态块看作是静态变量，把非静态块看作是 变量
		 * 
		 */
//		D.main(args);
//		
//		System.out.println("---------------------------------");
		
		/**
		 * 二：如果有继承的话。那么初始化的顺序规则是： 
		      （1）父类的初始化>子类的初始化 
		      （2）静态变量>普通变量>构造器。 
		      （3）变量定义的顺序决定初始化的顺序。 
		      （4）静态变量和静态块是一样的，变量和非静态块是一样的。
		                即可以把静态块看作是静态变量，把非静态块看作是  变量。 
		 * 
		 */
		System.out.println("aaaaa-------------");
		B.main(args);
		System.out.println("bbbb-------------");

	}
}

class C {
	public C(String s) {
		System.out.println(s + "------cccccccccccccc");
	}
}

class D {

	/** D的构造器 **/
	public D() {
		System.out.println("D的构造器");
	}

	/** D静态代码块 **/
	static {
		System.out.println("执行静态代码块");
	}

	/** D变量 **/

	private C c1 = new C("变量--（1）");
	private C c2 = new C("变量--（2）");

	/** D非静态代码块 **/
	{
		System.out.println("执行非静态代码块");
	}

	/** D的静态变量 **/

	private static C c3 = new C("静态变量--（3）");
	private static C c4 = new C("静态变量--（4）");

	public static void main(String[] args) {
		new D();
	}
}


class A {

	/*** 构造器 ***/
	public A() {
		System.out.println("父类--构造器");
	}

	/***** 静态变量 ****/
	public static C c3 = new C("父类静态变量1");
	/***** 静态初始化块 ****/
	static {
		System.out.println("父类--静态初始化块");
	}
	public static C c4 = new C("父类静态变量2");

	/***** 变量 ****/
	public C c1 = new C("父类--变量1");
	/***** 始化块 ****/
	{
		System.out.println("父类--初始化块");
	}
	public C c2 = new C("父类--变量2");

}

 class B extends A {
	/*** 构造器 ***/
	public B() {
		System.out.println("子类--构造器");
	}

	/***** 静态变量 ****/
	public static C c1 = new C("子类静态变量1");
	/***** 静态初始化块 ****/
	static {
		System.out.println("子类--静态初始化块");
	}
	public static C c2 = new C("子类静态变量2");

	/***** 变量 ****/
	public C c3 = new C("子类--变量1");
	/***** 始化块 ****/
	{
		System.out.println("子类--初始化块");
	}
	public C c4 = new C("子类--变量2");

	public static void main(String[] args) {
		new B();
	}

}
