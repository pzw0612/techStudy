package com.ifly.edu.netty.callbacks;

/**
 *
 * @author pangzhw
 * @date 2015年7月8日
 */
public interface FetcherCallback {
	void onData(Data data) throws Exception; 
	void onError(Throwable cause); 
}
