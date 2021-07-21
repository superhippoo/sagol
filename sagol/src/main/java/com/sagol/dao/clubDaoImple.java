package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.clubVO;
import com.sagol.dto.searchVO;

@Repository
public class clubDaoImple implements clubDao {

//	@Autowired
//	private JdbcTemplate jdbdtemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 

	@Override
	public List<clubVO> selectClubList(clubVO clubvo) {

//		String q = "select * from sg_club " 
//				    + "where club_type = ?" ;
//	    Object[] args = {clubvo.getClub_type()};
//	    return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<clubVO>(clubVO.class));
	    
	    StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_club ");
		sql.append("\n").append("where club_type = :club_type ");
		if (clubvo.getOrderby_key() != null && clubvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(clubvo.getOrderby_key());	
			if (clubvo.getOrderby_rule() != null && clubvo.getOrderby_rule() != "") {
				sql.append(" ").append(clubvo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);

		RowMapper<clubVO> mapper = new BeanPropertyRowMapper<clubVO>(clubVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);

	}
	
	@Override
	public List<clubVO> selectClubListByCcId(clubVO clubvo) {

//		String q = "select * from sg_club " 
//					+ "where cc_id = ? and club_type = ?" ;
//		Object[] args = { clubvo.getCc_id(),clubvo.getClub_type()};
//		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<clubVO>(clubVO.class));
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_club ");
		sql.append("\n").append("where cc_id = :cc_id");
		sql.append("\n").append("and club_type = :club_type");
		if (clubvo.getOrderby_key() != null && clubvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(clubvo.getOrderby_key());	
			if (clubvo.getOrderby_rule() != null && clubvo.getOrderby_rule() != "") {
				sql.append(" ").append(clubvo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);

		RowMapper<clubVO> mapper = new BeanPropertyRowMapper<clubVO>(clubVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);

	}

	@Override
	public clubVO selectClub(clubVO clubvo) {
//		String q = "select * from sg_club where club_id = ? and club_type = ?";
//		Object[] args = { clubvo.getClub_id(),clubvo.getClub_type()};
//		try {
//			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<clubVO>(clubVO.class));
//		} catch (Exception e) {
//			return null;
//		}
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_club");
		sql.append("\n").append("where club_id = :club_id");
		sql.append("\n").append("and club_type = :club_type");
		

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);
		RowMapper<clubVO> mapper = new BeanPropertyRowMapper<clubVO>(clubVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertClub(clubVO clubvo) {
//		String q = "  INSERT INTO sg_club VALUES(?,?,?,?,?,?,?,?,?,?)";
//		Object[] args = { clubvo.getClub_id(), clubvo.getClub_nm(), clubvo.getClub_mem_num(), clubvo.getGender(),
//				clubvo.getHit(), clubvo.getComp_year(), clubvo.getCc_id(),clubvo.getClub_type(), clubvo.getReg_dt(), clubvo.getMdfy_dt() };
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("INSERT INTO sg_club ");
		sql.append("\n").append("(club_id,club_nm,club_mem_num,gender,hit,comp_year,cc_id,club_type,reg_dt,mdfy_dt");
		sql.append("\n").append(") ");
		sql.append("\n").append("VALUES (:club_id,:club_nm,:club_mem_num,:gender,:hit,:comp_year,:cc_id,:club_type,:reg_dt,:mdfy_dt");
		sql.append("\n").append(")");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	
	}

	@Override
	public int updateClub(clubVO clubvo) {
//		String q = "update sg_club set " 
//				+ "club_nm = ? , " 
//				+ "club_mem_num = ? , " 
//				+ "gender = ? , " 
//				+ "hit = ? , " 
//				+ "comp_year = ? , " 
//				+ "cc_id = ? , " 
//			    + "mdfy_dt = ?"
//			+ "where club_id = ?";
//		Object[] args = { clubvo.getClub_nm(), clubvo.getClub_mem_num(), clubvo.getGender(), clubvo.getHit(),
//				clubvo.getComp_year(), clubvo.getCc_id(), clubvo.getMdfy_dt(), clubvo.getClub_id() };
//		return jdbdtemplate.update(q, args);
//		
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_club set ");
		sql.append("\n").append("club_nm = :club_nm , ");
		sql.append("\n").append("club_mem_num = :club_mem_num , ");
		sql.append("\n").append("gender = :gender , ");
		sql.append("\n").append("hit = :hit , ");
		sql.append("\n").append("comp_year = :comp_year, ");
		sql.append("\n").append("cc_id = :cc_id, ");
		sql.append("\n").append("mdfy_dt = :mdfy_dt");
		sql.append("\n").append("where club_id = :club_id");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
	}

	@Override
	public int deleteClub(clubVO clubvo) {
//		String q = "delete from sg_club where club_id = ?" ;
//		Object[] args = {clubvo.getClub_id()};
//		return jdbdtemplate.update(q,args);
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("delete from sg_club ");
		sql.append("\n").append("where club_id = :club_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int isExistByClubId(clubVO clubvo) {
//		String q = "select count(*) from sg_club where club_id = ?";
//		Object[] args = { clubvo.getClub_id() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, Integer.class);
//		} catch (Exception e) {
//			return 0;
//		}
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_club");
		sql.append("\n").append("where club_id = :club_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);

		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, Integer.class);
		} catch (Exception e) {
			return 0;
		}
	}

	@Override
	public int addClubMemNum(clubVO clubvo) {
//		String q = "update sg_club set " 
//				+ "club_mem_num = club_mem_num + 1  " 				
//				+ "where club_id = ?";
//		Object[] args = { clubvo.getClub_id() };
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_club set ");
		sql.append("\n").append("club_mem_num = club_mem_num+1  ");
		sql.append("\n").append("where club_id = :club_id");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
	}

	@Override
	public int minusClubMemNum(clubVO clubvo) {
//		String q = "update sg_club set " 
//				+ "club_mem_num = club_mem_num - 1  " 				
//				+ "where club_id = ?";
//		Object[] args = { clubvo.getClub_id() };
//		return jdbdtemplate.update(q, args);
		
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_club set ");
		sql.append("\n").append("club_mem_num = club_mem_num-1  ");
		sql.append("\n").append("where club_id = :club_id");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public List<searchVO> search(searchVO searchvo) {
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_club");
		sql.append("\n").append("where 1=1");

		if (searchvo.getClub_id() != null && searchvo.getClub_id() != "") {
			sql.append("\n").append("and club_id = :club_id");			
		}
		if (searchvo.getClub_nm() != null && searchvo.getClub_nm() != "") {
			if ("like".equals(searchvo.getType())) {
				sql.append("\n").append("and club_nm like '%").append(searchvo.getClub_nm()).append("%'");
			} else {
				sql.append("\n").append("and club_nm = :club_nm");
			}
		}
		if (searchvo.getClub_mem_num() != null && searchvo.getClub_mem_num() != "") {
			sql.append("\n").append("and club_mem_num = :club_mem_num");	
		}
		if (searchvo.getGender() != null && searchvo.getGender() != "") {
			sql.append("\n").append("and gender = :gender");
		}
		if (searchvo.getHit() != null && searchvo.getHit() != "") {
			sql.append("\n").append("and hit = :hit");
		}
		if (searchvo.getComp_year() != null && searchvo.getComp_year() != "") {
			sql.append("\n").append("and comp_year = :comp_year");
		}
		if (searchvo.getCc_id() != null && searchvo.getCc_id() != "") {
			sql.append("\n").append("and cc_id = :cc_id");
		}
		if (searchvo.getClub_type() != null && searchvo.getClub_type() != "") {
			sql.append("\n").append("and club_type = :club_type");
		}
		if (searchvo.getOrderby_key() != null && searchvo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(searchvo.getOrderby_key());	
			if (searchvo.getOrderby_rule() != null && searchvo.getOrderby_rule() != "") {
				sql.append(" ").append(searchvo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchvo);

		RowMapper<searchVO> mapper = new BeanPropertyRowMapper<searchVO>(searchVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), paramSource, mapper);
	}


}
