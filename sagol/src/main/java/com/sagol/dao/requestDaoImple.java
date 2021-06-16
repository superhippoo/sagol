package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.requestVO;

@Repository
public class requestDaoImple implements requestDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<requestVO> selectRequestList(requestVO requestvo) {

		String q = "select * from sg_request";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<requestVO>(requestVO.class));

	}

	@Override
	public List<requestVO> selectRequestListByUid(requestVO requestvo) {
		String q = "select * from sg_request " 
				+ "where uid = ?" ;
		Object[] args = { requestvo.getUid()};
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<requestVO>(requestVO.class));
	}
	
	@Override
	public List<requestVO> selectRequestListByCompleteYn(requestVO requestvo) {
		String q = "select * from sg_request " 
				+ "where complete_yn = ?" ;
		Object[] args = { requestvo.getComplete_yn()};
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<requestVO>(requestVO.class));
	}
	
	@Override
	public List<requestVO> selectRequestListByReqCd(requestVO requestvo) {
		String q = "select * from sg_request " 
				+ "where req_cd = ?" ;
		Object[] args = { requestvo.getReq_cd()};
		return jdbdtemplate.query(q, args, new BeanPropertyRowMapper<requestVO>(requestVO.class));
	}
	

	@Override
	public requestVO selectRequest(requestVO requestvo) {
		String q = "select * from sg_request where req_id = ? " ;
		Object[] args = { requestvo.getReq_id()};
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<requestVO>(requestVO.class));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertRequest(requestVO requestvo) {
		String q = "  INSERT INTO sg_request VALUES(?,?,?,?,?,?,?,?)";
		Object[] args = { requestvo.getReq_id(),requestvo.getReq_cd(), requestvo.getTitle(), requestvo.getBody(), requestvo.getUid(),
				requestvo.getComplete_yn(), requestvo.getReg_dt(), requestvo.getMdfy_dt() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int updateRequest(requestVO requestvo) {
		String q = "update sg_request set "
				+ "req_cd = ?  ,"
				+ "title = ?  ," 
				+ "body = ?  ," 
				+ "complete_yn = ?  ,"
				+ "mdfy_dt = ?  "
			    + "where req_id = ?";
		Object[] args = {requestvo.getReq_cd(),requestvo.getTitle(),requestvo.getBody(),requestvo.getComplete_yn(),requestvo.getMdfy_dt(),requestvo.getReq_id()};
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int deleteRequest(requestVO requestvo) {
		String q = "delete from sg_request where req_id = ?" ;
		Object[] args = {requestvo.getReq_id()};
		return jdbdtemplate.update(q,args);
	}





}
