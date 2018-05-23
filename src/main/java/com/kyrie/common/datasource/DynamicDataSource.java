package com.kyrie.common.datasource;

import org.apache.commons.lang.StringUtils;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.sql.SQLFeatureNotSupportedException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class DynamicDataSource extends AbstractRoutingDataSource {
	public static Map<String, List<String>> METHODTYPE = new HashMap<String, List<String>>();

	@Override
	protected Object determineCurrentLookupKey() {
		return DynamicDataSourceHolder.getDataSourceKey();
	}

	// 设置方法名前缀对应的数据源
	public void setMethodType(Map<String, String> map) {
		for (String key : map.keySet()) {
			List<String> v = new ArrayList<String>();
			String[] types = map.get(key).split(",");
			for (String type : types) {
				if (StringUtils.isNotBlank(type)) {
					v.add(type);
				}
			}
			METHODTYPE.put(key, v);
		}
	}

	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		return null;
	}
}