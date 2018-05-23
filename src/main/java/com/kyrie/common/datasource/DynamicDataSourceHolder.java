package com.kyrie.common.datasource;

import org.apache.commons.lang.StringUtils;

public class DynamicDataSourceHolder{
	/** 写库对应的数据源key */
	public static final String WRITE = "write";
	/** 读库对应的数据源key */
	public static final String READ = "read";
	/** 使用ThreadLocal记录当前线程的数据源key */
	private static final ThreadLocal<String> holder = new ThreadLocal<String>();

	/**
	 * 设置数据源的key
	 * @param key 数据源的key值
	 */
	public static void putDataSourceKey(String key) {
		holder.set(key);
	}
	/**
	 * 获取数据源key
	 * @return 获取的key
	 */
	public static String getDataSourceKey() {
		return holder.get();
	}

	/**
	 * 清除
	 */
	public static void remove(){holder.remove();};
}