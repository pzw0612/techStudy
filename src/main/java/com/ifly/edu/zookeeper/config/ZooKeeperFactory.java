package com.ifly.edu.zookeeper.config;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
 
public class ZooKeeperFactory {
 
    public static final String CONNECT_STRING = "192.168.111.157:2181,192.168.111.155:2181,192.168.111.156:2181";
     
    public static final int MAX_RETRIES = 3;
 
    public static final int BASE_SLEEP_TIMEMS = 3000;
 
    public static final String NAME_SPACE = "cfg";
 
    public static CuratorFramework get() {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(BASE_SLEEP_TIMEMS, MAX_RETRIES);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(CONNECT_STRING)
                .retryPolicy(retryPolicy)
                .namespace(NAME_SPACE)
                .build();
        client.start();
        return client;
    }
}
