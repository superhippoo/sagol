package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.clubmemVO;
import com.sagol.dto.searchVO;

@Repository
public class clubmemDaoImple implements clubmemDao {

//	@Autowired
//	private JdbcTemplate jdbdtemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 


	@Override
	public List<clubmemVO> selectClubmemList(clubmemVO clubmemvo) {

//		String q = "select * from sg_clubmem";
//		return jdbdtemplate.query(q, new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class));
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("a.*,b.nickname,b.gender,b.hit,b.comp_year ");
		sql.append("\n").append("from sg_clubmem a, sg_user b ");
		sql.append("\n").append("where a.uid = b.uid ");


		RowMapper<clubmemVO> mapper = new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), mapper);


	}
	
	@Override
	public List<clubmemVO> selectClubmemListByClubId(clubmemVO clubmemvo) {

//		String q = "select * from sg_clubmem " 
//					+ "where club_id = ?" ;
//		Object[] args = { clubmemvo.getClub_id()};
//		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class));
	    StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("a.*,b.nickname,b.gender,b.hit,b.comp_year ");
		sql.append("\n").append("from sg_clubmem a, sg_user b ");
		sql.append("\n").append("where a.uid = b.uid ");
		sql.append("\n").append("and a.club_id = :club_id");
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubmemvo);

		RowMapper<clubmemVO> mapper = new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);

	}

	@Override
	public clubmemVO selectClubmem(clubmemVO clubmemvo) {
//		String q = "select * from sg_clubmem where club_id = ? and uid = ?" ;
//		Object[] args = { clubmemvo.getClub_id(),clubmemvo.getUid()};
//		try {
//			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class));
//		} catch (Exception e) {
//			return null;
//		}
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_clubmem");
		sql.append("\n").append("where club_id = :club_id");
		sql.append("\n").append("and uid = :uid");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubmemvo);
		RowMapper<clubmemVO> mapper = new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertClubmem(clubmemVO clubmemvo) {
//		String q = "  INSERT INTO sg_clubmem VALUES(?,?,?,?)";
//		Object[] args = {clubmemvo.getUid(),clubmemvo.getClub_id(),clubmemvo.getOwner_yn(),clubmemvo.getReg_dt()};
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("INSERT INTO sg_clubmem ");
		sql.append("\n").append("(uid,club_id,owner_yn,reg_dt");
		sql.append("\n").append(") ");
		sql.append("\n").append("VALUES (:uid,:club_id,:owner_yn,:reg_dt");
		sql.append("\n").append(")");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubmemvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	
	}

	@Override
	public int updateClubmem(clubmemVO clubmemvo) {
//		String q = "update sg_clubmem set " 
//				+ "owner_yn = ?  " 
//			    + "where club_id = ?"
//			    + "and uid = ?";
//		Object[] args = {clubmemvo.getOwner_yn(),clubmemvo.getClub_id(),clubmemvo.getUid()};
//		return jdbdtemplate.update(q, args);
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("update sg_clubmem set ");
		sql.append("\n").append("owner_yn = :owner_yn");
		sql.append("\n").append("where club_id = :club_id");
		sql.append("\n").append("and uid = :uid");
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubmemvo);
		
		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
	}

	@Override
	public int deleteClubmem(clubmemVO clubmemvo) {
//		String q = "delete from sg_clubmem where club_id = ? and uid = ?" ;
//		Object[] args = {clubmemvo.getClub_id(),clubmemvo.getUid()};
//		return jdbdtemplate.update(q,args);
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("delete from sg_clubmem ");
		sql.append("\n").append("where club_id = :club_id");
		sql.append("\n").append("and uid = :uid");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubmemvo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
		
	}

	@Override
	public int deleteClubmemsByClubid(clubmemVO clubmemvo) {
//		String q = "delete from sg_clubmem where club_id = ?" ;
//		Object[] args = {clubmemvo.getClub_id()};
//		return jdbdtemplate.update(q,args);
		StringBuffer sql = new StringBuffer();

		sql.append("\n").append("delete from sg_clubmem ");
		sql.append("\n").append("where club_id = :club_id");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubmemvo);

		return namedParameterJdbcTemplate.update(sql.toString(), paramSource);
	}

	@Override
	public int isExistMemberInClubByUid(clubmemVO clubmemvo) {
//		String q = "select count(*) from sg_clubmem where club_id = ? and uid = ?" ;
//		Object[] args = { clubmemvo.getClub_id(),clubmemvo.getUid() };
//		try {
//			return jdbdtemplate.queryForObject(q, args, Integer.class);
//		} catch (Exception e) {
//			return 0;
//		}
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("count(*) ");
		sql.append("\n").append("from sg_clubmem");
		sql.append("\n").append("where club_id = :club_id");
		sql.append("\n").append("and uid = :uid");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(clubmemvo);

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
		sql.append("\n").append("from sg_clubmem");
		sql.append("\n").append("where 1=1");

		if (searchvo.getUid() != null && searchvo.getUid() != "") {
			sql.append("\n").append("and uid = :uid");			
		}
		if (searchvo.getClub_id() != null && searchvo.getClub_id() != "") {
			sql.append("\n").append("and club_id = :club_id");
		}
		if (searchvo.getOwner_yn() != null && searchvo.getOwner_yn() != "") {
			sql.append("\n").append("and owner_yn = :owner_yn");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(searchvo);

		RowMapper<searchVO> mapper = new BeanPropertyRowMapper<searchVO>(searchVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(), paramSource, mapper);
	}




}
