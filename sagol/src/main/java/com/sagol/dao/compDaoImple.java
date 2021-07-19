package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.compVO;

@Repository
public class compDaoImple implements compDao {

//	@Autowired
//	private JdbcTemplate jdbdtemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 

	@Override
	public List<compVO> selectCompList(compVO compvo) {

//		String q = "select * from sg_comp";
//		return jdbdtemplate.query(q, new BeanPropertyRowMapper<compVO>(compVO.class));
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_comp");

		
		RowMapper<compVO> mapper = new BeanPropertyRowMapper<compVO>(compVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), mapper);

	}

	@Override
	public compVO selectComp(compVO compvo) {
//		String q = "select * from sg_comp where comp_cd = ?";
//		Object[] args = { compvo.getComp_cd() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<compVO>(compVO.class));
//		} catch (Exception e) {
//			return null;
//		}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_comp");
		sql.append("\n").append("where comp_cd = :comp_cd");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(compvo);

		RowMapper<compVO> mapper = new BeanPropertyRowMapper<compVO>(compVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertComp(compVO compvo) {
//		String q = "  INSERT INTO sg_comp VALUES(?,?,?,?,?,?,?)";
//		Object[] args = { compvo.getComp_cd(), compvo.getComp_nm(),compvo.getComp_domain(), compvo.getComp_stat(), 
//				compvo.getComp_user_num(),compvo.getReg_dt(), compvo.getMdfy_dt() };
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("INSERT INTO sg_comp ");
		sql.append("\n").append("(comp_cd,comp_nm,comp_domain,comp_stat,comp_user_num,reg_dt,mdfy_dt");
		sql.append("\n").append(") ");
		sql.append("\n").append("VALUES (:comp_cd,:comp_nm,:comp_domain,:comp_stat,:comp_user_num,:reg_dt,:mdfy_dt");
		sql.append("\n").append(")");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(compvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
	}

	@Override
	public int updateComp(compVO compvo) {
//		String q = "update sg_comp set " 
//				+ "comp_nm = ? , "
//				+ "comp_domain = ? , " 
//				+ "comp_stat = ? , " 
//				+ "comp_user_num = ? , " 
//			    + "mdfy_dt = ?"
//			+ "where comp_cd = ?";
//	Object[] args = { compvo.getComp_nm(),compvo.getComp_domain(),compvo.getComp_stat(),compvo.getComp_user_num(),
//			compvo.getMdfy_dt(),compvo.getComp_cd()};
//	return jdbdtemplate.update(q, args);
	
	StringBuffer sql = new StringBuffer();

	sql.append("\n").append("update sg_comp set ");
	sql.append("\n").append("comp_nm = :comp_nm , ");
	sql.append("\n").append("comp_domain = :comp_domain , ");
	sql.append("\n").append("comp_stat = :comp_stat , ");
	sql.append("\n").append("comp_user_num = :comp_user_num , ");
	sql.append("\n").append("mdfy_dt = :mdfy_dt");
	sql.append("\n").append("where comp_cd = :comp_cd");
	
	BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(compvo);
	
	return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int deleteComp(compVO compvo) {
//		String q = "update sg_comp set " 
//	              + "comp_stat = ? ," 
//				  + "mdfy_dt = ? "
//	              + "where comp_cd = ?";
//		Object[] args = { compvo.getComp_stat(),compvo.getMdfy_dt(),compvo.getComp_cd() };
//		return jdbdtemplate.update(q, args);
		
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_comp set ");
		sql.append("\n").append("comp_stat = :comp_stat , ");
		sql.append("\n").append("mdfy_dt = :mdfy_dt");
		sql.append("\n").append("where comp_cd = :comp_cd");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(compvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int isExistByCompCd(compVO compvo) {
//		String q = "select count(*) from sg_comp where comp_cd = ?";
//		Object[] args = { compvo.getComp_cd() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, Integer.class);
//		} catch (Exception e) {
//			return 0;
//		}
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_comp");
		sql.append("\n").append("where comp_cd = :comp_cd");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(compvo);

		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}


}
