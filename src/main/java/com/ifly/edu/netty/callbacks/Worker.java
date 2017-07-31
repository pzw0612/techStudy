package com.ifly.edu.netty.callbacks;

/**
 *
 * @author pangzhw
 * @date 2015年7月8日
 */
public class Worker {
	public void doWork() {
		Fetcher fetcher = new MyFetcher(new Data(1, 0));
		fetcher.fetchData(new FetcherCallback() {
			@Override
			public void onError(Throwable cause) {
				System.out.println("An error accour: " + cause.getMessage());
			}

			@Override
			public void onData(Data data) {
				System.out.println("Datareceived:" + data);
			}
		});
	}

	public static void main(String[] args) {
		Worker w = new Worker();
		w.doWork();
	}

}
