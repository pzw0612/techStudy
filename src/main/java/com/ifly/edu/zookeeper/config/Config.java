package com.ifly.edu.zookeeper.config;

public interface Config {
	byte[] getConfig(String path) throws Exception;
}
