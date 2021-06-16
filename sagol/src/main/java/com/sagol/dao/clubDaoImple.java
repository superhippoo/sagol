package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.clubVO;

@Repository
public class clubDaoImple implements clubDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<clubVO> selectClubList(clubVO clubvo) {

		String q = "select * from sg_club " 
				    + "where club_type = ?" ;
	    Object[] args = {clubvo.getClub_type()};
	    return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<clubVO>(clubVO.class));

	}
	
	@Override
	public List<clubVO> selectClubListByCcId(clubVO clubvo) {

		String q = "select * from sg_club " 
					+ "where cc_id = ? and club_type = ?" ;
		Object[] args = { clubvo.getCc_id(),clubvo.getClub_type()};
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<clubVO>(clubVO.class));
	}

	@Override
	public clubVO selectClub(clubVO clubvo) {
		String q = "select * from sg_club where club_id = ? and club_type = ?";
		Object[] args = { clubvo.getClub_id(),clubvo.getClub_type()};
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<clubVO>(clubVO.class));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertClub(clubVO clubvo) {
		String q = "  INSERT INTO sg_club VALUES(?,?,?,?,?,?,?,?,?,?)";
		Object[] args = { clubvo.getClub_id(), clubvo.getClub_nm(), clubvo.getClub_mem_num(), clubvo.getGender(),
				clubvo.getHit(), clubvo.getComp_year(), clubvo.getCc_id(),clubvo.getClub_type(), clubvo.getReg_dt(), clubvo.getMdfy_dt() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int updateClub(clubVO clubvo) {
		String q = "update sg_club set " 
				+ "club_nm = ? , " 
				+ "club_mem_num = ? , " 
				+ "gender = ? , " 
				+ "hit = ? , " 
				+ "comp_year = ? , " 
				+ "cc_id = ? , " 
			    + "mdfy_dt = ?"
			+ "where club_id = ?";
		Object[] args = { clubvo.getClub_nm(), clubvo.getClub_mem_num(), clubvo.getGender(), clubvo.getHit(),
				clubvo.getComp_year(), clubvo.getCc_id(), clubvo.getMdfy_dt(), clubvo.getClub_id() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int deleteClub(clubVO clubvo) {
		String q = "delete from sg_club where club_id = ?" ;
		Object[] args = {clubvo.getClub_id()};
		return jdbdtemplate.update(q,args);
		//fuid 하위 일정들 일괄 삭제 기능 구현해야됨
	}


}
