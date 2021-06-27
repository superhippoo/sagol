package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.userVO;

@Repository
public class userDaoImple implements userDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<userVO> selectUserList(userVO uservo) {

		String q = "select * from sg_user";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<userVO>(userVO.class));

	}

	@Override
	public userVO selectUser(userVO uservo) {

		String q = "select * from sg_user where uid = ?";
		Object[] args = { uservo.getUid() };
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<userVO>(userVO.class));
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public int insertUser(userVO uservo) {

		String q = "  INSERT INTO sg_user VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] args = { uservo.getUid(), uservo.getNikname(), uservo.getKakao_email(), uservo.getComp_email(),
				uservo.getComp_cd(), uservo.getDft_cc_id(), uservo.getJoin_club_num(), uservo.getGender(),
				uservo.getHit(), uservo.getComp_year(), uservo.getReport_num(), uservo.getAct_yn(), uservo.getAuth_yn(),
				uservo.getAuth_cd(),uservo.getAdmin_yn(),uservo.getReg_dt(), uservo.getMdfy_dt() };
		return jdbdtemplate.update(q, args);

	}

	@Override
	public int updateUser(userVO uservo) {
		String q = "update sg_user set " 
					+ "nikname = ? , " 
				    + "kakao_email = ? , " 
					+ "comp_email = ? , " 
				    + "comp_cd = ? , "
				    + "dft_cc_id = ? , " 
				    + "gender = ? ," 
				    + "hit = ? ," 
				    + "comp_year = ? ," 
				    + "act_yn = ? ," 
				    + "auth_yn = ? ," 
				    + "auth_cd = ? ," 
				    + "admin_yn = ? ," 
				    + "mdfy_dt = ?"
				+ "where uid = ?";
		Object[] args = { uservo.getNikname(), uservo.getKakao_email(), uservo.getComp_email(), uservo.getComp_cd(),
				uservo.getDft_cc_id(), uservo.getGender(), uservo.getHit(), uservo.getComp_year(), uservo.getAct_yn(),
				uservo.getAuth_yn(),uservo.getAuth_cd(),uservo.getAdmin_yn(),uservo.getMdfy_dt(), uservo.getUid() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int deleteUser(userVO uservo) {
		String q = "update sg_user set " 
	              + "act_yn = ? ," 
				  + "mdfy_dt = ? "
	              + "where uid = ?";
		Object[] args = { uservo.getAct_yn(),uservo.getMdfy_dt(),uservo.getUid() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int saveauthcd(userVO uservo) {
		String q = "update sg_user set " 
					+ "auth_cd = ? " 
					+ "where uid = ?";
		Object[] args = { uservo.getAuth_cd(), uservo.getUid() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int auth(userVO uservo) {
		String q = "update sg_user set " 
				+ "auth_yn = ? " 
				+ "where uid = ?";
		Object[] args = { uservo.getAuth_yn(), uservo.getUid() };
		return jdbdtemplate.update(q, args);
	}

}
