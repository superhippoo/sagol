package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.ccVO;

@Repository
public class ccDaoImple implements ccDao {

//	@Autowired
//	private JdbcTemplate jdbdtemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 

	@Override
	public List<ccVO> selectCcList(ccVO ccvo) {

//		String q = "select * from sg_cc";
//		return jdbdtemplate.query(q, new BeanPropertyRowMapper<ccVO>(ccVO.class));
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_cc");

		
		RowMapper<ccVO> mapper = new BeanPropertyRowMapper<ccVO>(ccVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), mapper);

	}
	
	@Override
	public List<ccVO> selectCcListByCompCd(ccVO ccvo) {

//		String q = "select * from sg_cc " 
//					+ "where comp_cd = ?" ;
//		Object[] args = { ccvo.getComp_cd()};
//		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<ccVO>(ccVO.class));
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_cc ");
		sql.append("\n").append("where comp_cd = :comp_cd");
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(ccvo);

		RowMapper<ccVO> mapper = new BeanPropertyRowMapper<ccVO>(ccVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}

	@Override
	public ccVO selectCc(ccVO ccvo) {
//		String q = "select * from sg_cc where cc_id = ?";
//		Object[] args = { ccvo.getCc_id()};
//		try {
//			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<ccVO>(ccVO.class));
//		} catch (Exception e) {
//			return null;
//		}
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_cc");
		sql.append("\n").append("where cc_id = :cc_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(ccvo);
		RowMapper<ccVO> mapper = new BeanPropertyRowMapper<ccVO>(ccVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertCc(ccVO ccvo) {
//		String q = "  INSERT INTO sg_cc VALUES(?,?,?,?,?,?,?,?)";
//		Object[] args = { ccvo.getCc_id(), ccvo.getCc_nm(), ccvo.getComp_cd(), ccvo.getCc_stat(), ccvo.getUid(),
//				ccvo.getCc_user_num(), ccvo.getReg_dt(), ccvo.getMdfy_dt() };
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("INSERT INTO sg_cc ");
		sql.append("\n").append("(cc_id,cc_nm,comp_cd,cc_stat,uid,cc_user_num,reg_dt,mdfy_dt");
		sql.append("\n").append(") ");
		sql.append("\n").append("VALUES (:cc_id,:cc_nm,:comp_cd,:cc_stat,:uid,:cc_user_num,:reg_dt,:mdfy_dt");
		sql.append("\n").append(")");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(ccvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int updateCc(ccVO ccvo) {
//		String q = "update sg_cc set " 
//				+ "cc_nm = ? , " 
//				+ "comp_cd = ? , " 
//				+ "cc_stat = ? , " 
//				+ "uid = ? , " 
//				+ "cc_user_num = ? , " 
//			    + "mdfy_dt = ?"
//			+ "where cc_id = ?";
//		Object[] args = { ccvo.getCc_nm(), ccvo.getComp_cd(), ccvo.getCc_stat(), ccvo.getUid(), ccvo.getCc_user_num(),
//				ccvo.getMdfy_dt(), ccvo.getCc_id() };
//	return jdbdtemplate.update(q, args);
	StringBuffer sql = new StringBuffer();

	sql.append("\n").append("update sg_cc set ");
	sql.append("\n").append("cc_nm = :cc_nm , ");
	sql.append("\n").append("cc_stat = :cc_stat , ");
	sql.append("\n").append("uid = :uid , ");
	sql.append("\n").append("cc_user_num = :cc_user_num , ");
	sql.append("\n").append("mdfy_dt = :mdfy_dt");
	sql.append("\n").append("where cc_id = :cc_id");
	
	BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(ccvo);
	
	return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	
	}

	@Override
	public int deleteCc(ccVO ccvo) {
//		String q = "update sg_cc set " 
//	              + "cc_stat = ? ," 
//				  + "mdfy_dt = ? "
//	              + "where cc_id = ?";
//		Object[] args = { ccvo.getCc_stat(),ccvo.getMdfy_dt(),ccvo.getCc_id()};
//		return jdbdtemplate.update(q, args);
		
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_cc set ");
		sql.append("\n").append("cc_stat = :cc_stat , ");
		sql.append("\n").append("mdfy_dt = :mdfy_dt");
		sql.append("\n").append("where cc_id = :cc_id");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(ccvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int isExistByCcId(ccVO ccvo) {
//		String q = "select count(*) from sg_cc where cc_id = ?";
//		Object[] args = { ccvo.getCc_id() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, Integer.class);
//		} catch (Exception e) {
//			return 0;
//		}
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_cc");
		sql.append("\n").append("where cc_id = :cc_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(ccvo);

		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}


}
