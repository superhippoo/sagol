package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.clubmemVO;

@Repository
public class clubmemDaoImple implements clubmemDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<clubmemVO> selectClubmemList(clubmemVO clubmemvo) {

		String q = "select * from sg_clubmem";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class));

	}
	
	@Override
	public List<clubmemVO> selectClubmemListByClubId(clubmemVO clubmemvo) {

		String q = "select * from sg_clubmem " 
					+ "where club_id = ?" ;
		Object[] args = { clubmemvo.getClub_id()};
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class));
	}

	@Override
	public clubmemVO selectClubmem(clubmemVO clubmemvo) {
		String q = "select * from sg_clubmem where club_id = ? and uid = ?" ;
		Object[] args = { clubmemvo.getClub_id(),clubmemvo.getUid()};
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<clubmemVO>(clubmemVO.class));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertClubmem(clubmemVO clubmemvo) {
		String q = "  INSERT INTO sg_clubmem VALUES(?,?,?,?)";
		Object[] args = {clubmemvo.getClub_id(),clubmemvo.getUid(),clubmemvo.getOwner_yn(),clubmemvo.getReg_dt()};
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int updateClubmem(clubmemVO clubmemvo) {
		String q = "update sg_clubmem set " 
				+ "owner_yn = ?  " 
			    + "where club_id = ?"
			    + "and uid = ?";
		Object[] args = {clubmemvo.getOwner_yn(),clubmemvo.getClub_id(),clubmemvo.getUid()};
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int deleteClubmem(clubmemVO clubmemvo) {
		String q = "delete from sg_clubmem where club_id = ? and uid = ?" ;
		Object[] args = {clubmemvo.getClub_id(),clubmemvo.getUid()};
		return jdbdtemplate.update(q,args);
		//fuid 하위 일정들 일괄 삭제 기능 구현해야됨
	}




}
