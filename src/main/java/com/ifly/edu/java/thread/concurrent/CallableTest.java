package com.ifly.edu.java.thread.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 *
 *
 *  Callable接口的功能类似于Runnable接口。他们都是规定线程的执行任务。两者的不同有：
	(1)Callable规定的方法是call(),Runnable规定的方法是run().
	(2)Callable的任务执行后可返回值，而Runnable的任务是不能返回值得。
	(3)call方法可以抛出异常，run方法不可以
	(4)运行Callable任务可以拿到一个Future对象，表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，
	并检索计算的结果。通过Future对象可以了解任务执行
	情况，可取消任务的执行，还可获取执行结果
 * @author pangzhw
 * @date 2015年3月14日
 */
public class CallableTest {
	public static void main(String[] args) throws Exception {
		ExecutorService singlePool = Executors.newSingleThreadExecutor();
		Future<String> future = singlePool.submit(new Callable<String>() {
			public String call() throws Exception {
				Thread.sleep(40000);
				return "pangzhw";
			};
		});
		System.out.println("等待.....");
		System.out.println(future.isCancelled());
		System.out.println("结果：" + future.get());
	}
}
