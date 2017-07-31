package com.ifly.edu.netty.callbacks;

/**
 *
 * @author pangzhw
 * @date 2015年7月8日
 */
public interface Fetcher {
	void fetchData(FetcherCallback callback);
}
