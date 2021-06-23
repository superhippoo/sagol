package com.sagol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.userVO;

@Repository
public class loginDaoImple implements loginDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;



	@Override
	public userVO login(userVO uservo) {

		String q = "select * from sg_user where kakao_email = ?";
		Object[] args = { uservo.getKakao_email() };
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<userVO>(userVO.class));
		} catch (Exception e) {
			return uservo;
		}

	}


}
