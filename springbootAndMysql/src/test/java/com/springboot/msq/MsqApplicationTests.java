package com.springboot.msq;

import com.springboot.msq.entity.user;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MsqApplicationTests {

	@Test
	public void contextLoads() {
	}
	/**
	 * myqal集成springboot测试
	 */
	@Resource
	private JdbcTemplate jdbcTemplate;
	@Test
	public  void mysqlTest(){
		String sql="select id, name,PASSWORD from user";
		List<user> useList=(List<user>) jdbcTemplate.query
				(sql, new RowMapper<user>() {
					@Override
					public user mapRow(ResultSet rs, int rowNum) throws SQLException {
						user us = new user();
						us.setId(rs.getString("id"));
						us.setName(rs.getString("name"));
						us.setPassword(rs.getString("password"));
						return us;
					}
				});
		System.out.println("查询成功");
		for(user user:useList)
			System.out.println("id:"+ user.getId()+";name:"+user.getName());
	}




}
