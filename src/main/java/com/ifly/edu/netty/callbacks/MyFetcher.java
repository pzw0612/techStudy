package com.ifly.edu.netty.callbacks;

/**
 *
 * @author pangzhw
 * @date 2015年7月8日
 */
public class MyFetcher implements Fetcher {
	final Data data;  
	public MyFetcher(Data data){
		this.data = data; 
	}
	@Override
	public void fetchData(FetcherCallback callback){
		try{
			callback.onData(data);
		}catch(Exception e){
			callback.onError(e);
		}
	}
}
