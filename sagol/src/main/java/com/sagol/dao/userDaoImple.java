package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.searchVO;
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
		
		if (uservo.getOrderby_key() != null && uservo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(uservo.getOrderby_key());
			if (uservo.getOrderby_rule() != null && uservo.getOrderby_rule() != "") {
				sql.append(" ").append(uservo.getOrderby_rule());
			}
		} else {
			sql.append("\n").append("order by mdfy_dt");
		}

		
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

	@Override
	public List<searchVO> search(searchVO searchvo) {
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_user");
		sql.append("\n").append("where 1=1");
    	if (searchvo.getUid() != null && searchvo.getUid() != "") {
    		sql.append("\n").append("and uid = :uid");
    	}
    	if (searchvo.getNickname() !=null && searchvo.getNickname() != "") {
    		if ("like".equals(searchvo.getType())) {    			
        		sql.append("\n").append("and nickname like '%").append(searchvo.getNickname()).append("%'");
			}else {
	    		sql.append("\n").append("and nickname = :nickname");
			}
		}
    	if (searchvo.getKakao_email() !=null && searchvo.getKakao_email() != "") {
    		if ("like".equals(searchvo.getType())) {    			
        		sql.append("\n").append("and kakao_email like '%").append(searchvo.getKakao_email()).append("%'");
			}else {
	    		sql.append("\n").append("and kakao_email = :kakao_email");    		
			}
		}
    	if (searchvo.getComp_email() !=null && searchvo.getComp_email() != "") {
    		if ("like".equals(searchvo.getType())) {    			
        		sql.append("\n").append("and comp_email like '%").append(searchvo.getComp_email()).append("%'");
			}else {
	    		sql.append("\n").append("and comp_email = :comp_email");    		
			}
		}
    	if (searchvo.getComp_cd() !=null && searchvo.getComp_cd() != "") {
    		sql.append("\n").append("and comp_cd = :comp_cd");    		
		}
    	if (searchvo.getDft_cc_id() !=null && searchvo.getDft_cc_id() != "") {
    		sql.append("\n").append("and dft_cc_id = :dft_cc_id");    		
		}
    	if (searchvo.getJoin_club_num() != null && searchvo.getJoin_club_num() != "") {
    		sql.append("\n").append("and join_club_num = :join_club_num");    		
		}
    	if (searchvo.getGender() !=null && searchvo.getGender() != "") {
    		sql.append("\n").append("and gender = :gender");		
		}
    	if (searchvo.getHit() !=null && searchvo.getHit() != "") {
    		sql.append("\n").append("and hit = :hit");    		
		}
    	if (searchvo.getComp_year() !=null && searchvo.getComp_year() != "") {
    		sql.append("\n").append("and comp_year = :comp_year");    	
		}
    	if (searchvo.getReport_num() !=null && searchvo.getReport_num() != "") {
    		sql.append("\n").append("and report_num = :report_num");
		}
    	if (searchvo.getAct_yn() !=null && searchvo.getAct_yn() != "") {
    		sql.append("\n").append("and act_yn = :act_yn");
		}
    	if (searchvo.getAuth_yn() !=null && searchvo.getAuth_yn() != "") {
    		sql.append("\n").append("and auth_yn = :auth_yn");
		}
    	if (searchvo.getAuth_cd() !=null && searchvo.getAuth_cd() != "") {
    		sql.append("\n").append("and auth_cd = :auth_cd");
		}
    	if (searchvo.getAdmin_yn() !=null && searchvo.getAdmin_yn() != "") {
    		sql.append("\n").append("and admin_yn = :admin_yn");
		}
    	
    	if (searchvo.getOrderby_key() != null && searchvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(searchvo.getOrderby_key());
			if (searchvo.getOrderby_rule() != null && searchvo.getOrderby_rule() != "") {
				sql.append(" ").append(searchvo.getOrderby_rule());
			}
		} else {
			sql.append("\n").append("order by mdfy_dt");
		}


		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchvo);

		RowMapper<searchVO> mapper = new BeanPropertyRowMapper<searchVO>(searchVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}


}
