package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.userVO;

@Repository
public class userDaoImple implements userDao {

//	@Autowired
//	private JdbcTemplate jdbdtemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 

	@Override
	public List<userVO> selectUserList(userVO uservo) {
//
//		String q = "select * from sg_user";
//		return jdbdtemplate.query(q, new BeanPropertyRowMapper<userVO>(userVO.class));
//		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_user");

		
		RowMapper<userVO> mapper = new BeanPropertyRowMapper<userVO>(userVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), mapper);

	}

	@Override
	public userVO selectUser(userVO uservo) {

//		String q = "select * from sg_user where uid = ?";
//		Object[] args = { uservo.getUid() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<userVO>(userVO.class));
//		} catch (Exception e) {
//			return null;
//		}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_user");
		sql.append("\n").append("where uid = :uid");
		
//		Map<String, Object> param = new HashMap<String, Object>();
//		param.put("uid",uservo.getUid());
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		RowMapper<userVO> mapper = new BeanPropertyRowMapper<userVO>(userVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertUser(userVO uservo) {

//		String q = "  INSERT INTO sg_user VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
//		Object[] args = { uservo.getUid(), uservo.getNickname(), uservo.getKakao_email(), uservo.getComp_email(),
//				uservo.getComp_cd(), uservo.getDft_cc_id(), uservo.getJoin_club_num(), uservo.getGender(),
//				uservo.getHit(), uservo.getComp_year(), uservo.getReport_num(), uservo.getAct_yn(), uservo.getAuth_yn(),
//				uservo.getAuth_cd(),uservo.getAdmin_yn(),uservo.getReg_dt(), uservo.getMdfy_dt() };
//		return jdbdtemplate.update(q, args);
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("INSERT INTO sg_user ");
		sql.append("\n").append("(uid,nickname,kakao_email,comp_email,comp_cd,dft_cc_id,join_club_num,gender,hit,comp_year,");
		sql.append("\n").append("report_num,act_yn,auth_yn,auth_cd,admin_yn,reg_dt,mdfy_dt) ");
		sql.append("\n").append("VALUES (:uid,:nickname,:kakao_email,:comp_email,:comp_cd,:dft_cc_id,:join_club_num,:gender,:hit,:comp_year,");
		sql.append("\n").append(":report_num,:act_yn,:auth_yn,:auth_cd,:admin_yn,:reg_dt,:mdfy_dt)");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);

	}

	@Override
	public int updateUser(userVO uservo) {
		
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_user set ");
		sql.append("\n").append("nickname = :nickname , ");
		sql.append("\n").append("kakao_email = :kakao_email , ");
		sql.append("\n").append("comp_email = :comp_email , ");
		sql.append("\n").append("comp_cd = :comp_cd , ");
		sql.append("\n").append("dft_cc_id = :dft_cc_id , ");
		sql.append("\n").append("gender = :gender ,");
		sql.append("\n").append("hit = :hit ,");
		sql.append("\n").append("comp_year = :comp_year ,");
		sql.append("\n").append("act_yn = :act_yn ,");
		sql.append("\n").append("auth_yn = :auth_yn ,");
		sql.append("\n").append("auth_cd = :auth_cd ,");
		sql.append("\n").append("admin_yn = :admin_yn ,");
		sql.append("\n").append("mdfy_dt = :mdfy_dt");
		sql.append("\n").append("where uid = :uid");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int deleteUser(userVO uservo) {

		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_user set ");
		sql.append("\n").append("act_yn = :act_yn, ");
		sql.append("\n").append("mdfy_dt = :mdfy_dt ");
		sql.append("\n").append("where uid = :uid");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int saveauthcd(userVO uservo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_user set ");
		sql.append("\n").append("auth_cd = :auth_cd ");
		sql.append("\n").append("where uid = :uid");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int auth(userVO uservo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_user set ");
		sql.append("\n").append("auth_yn = :auth_yn ");
		sql.append("\n").append("where uid = :uid");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int isExistByKakaoEmail(userVO uservo) {
//		String q = "select count(*) from sg_user where kakao_email = ?";
//		Object[] args = { uservo.getKakao_email() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, Integer.class);
//		} catch (Exception e) {
//			return 0;
//		}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_user");
		sql.append("\n").append("where kakao_email = :kakao_email");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}
	
	@Override
	public int isExistByUid(userVO uservo) {
//		String q = "select count(*) from sg_user where uid = ?";
//		Object[] args = { uservo.getUid() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, Integer.class);
//		} catch (Exception e) {
//			return 0;
//		}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_user");
		sql.append("\n").append("where uid = :uid");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(uservo);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}


}
