package com.kyrie.service.impl;

import com.kyrie.service.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private JdbcTemplate jdbcTemplate;

	@Override
	public void findUserById(String id) {
		List<Map<String, Object>> list = jdbcTemplate.queryForList("select * from tb_user");
		System.out.println("########################: " + list.size());
	}

	@Override
	public void save() {
		jdbcTemplate.execute("insert into tb_user(id,name,age)values('9999','xiaochang','18')");
		System.out.println("########################我插入了一条语句########################");
	}
}
