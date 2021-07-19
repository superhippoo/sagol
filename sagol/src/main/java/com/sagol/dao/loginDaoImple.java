package com.sagol.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.userVO;

@Repository
public class loginDaoImple implements loginDao {

//	@Autowired
//	private JdbcTemplate jdbdtemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 

	@Override
	public userVO login(userVO uservo) {

//		String q = "select * from sg_user where kakao_email = ?";
//		Object[] args = { uservo.getKakao_email() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<userVO>(userVO.class));
//		} catch (Exception e) {
//			return null;
//		}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_user");
		sql.append("\n").append("where kakao_email = :kakao_email");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		RowMapper<userVO> mapper = new BeanPropertyRowMapper<userVO>(userVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}


}
