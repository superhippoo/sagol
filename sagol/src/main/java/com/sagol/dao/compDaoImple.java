package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.compVO;
import com.sagol.dto.userVO;

@Repository
public class compDaoImple implements compDao {

	@Autowired
	private JdbcTemplate jdbdtemplate;

	@Override
	public List<compVO> selectCompList(compVO compvo) {

		String q = "select * from sg_comp";
		return jdbdtemplate.query(q, new BeanPropertyRowMapper<compVO>(compVO.class));

	}

	@Override
	public compVO selectComp(compVO compvo) {
		String q = "select * from sg_comp where comp_cd = ?";
		Object[] args = { compvo.getComp_cd() };
		try {
			return jdbdtemplate.queryForObject(q, args, new BeanPropertyRowMapper<compVO>(compVO.class));
		} catch (Exception e) {
			return null;
		}
	}

	@Override
	public int insertComp(compVO compvo) {
		String q = "  INSERT INTO sg_comp VALUES(?,?,?,?,?,?)";
		Object[] args = { compvo.getComp_cd(), compvo.getComp_nm(), compvo.getComp_stat(), compvo.getComp_user_num(),
				compvo.getReg_dt(), compvo.getMdfy_dt() };
		return jdbdtemplate.update(q, args);
	}

	@Override
	public int updateComp(compVO compvo) {
		String q = "update sg_comp set " 
				+ "comp_nm = ? , " 
				+ "comp_stat = ? , " 
				+ "comp_user_num = ? , " 
			    + "mdfy_dt = ?"
			+ "where comp_cd = ?";
	Object[] args = { compvo.getComp_nm(),compvo.getComp_stat(),compvo.getComp_user_num() ,compvo.getMdfy_dt(),compvo.getComp_cd()};
	return jdbdtemplate.update(q, args);
	}

	@Override
	public int deleteComp(compVO compvo) {
		String q = "update sg_comp set " 
	              + "comp_stat = ? ," 
				  + "mdfy_dt = ? "
	              + "where comp_cd = ?";
		Object[] args = { compvo.getComp_stat(),compvo.getMdfy_dt(),compvo.getComp_cd() };
		return jdbdtemplate.update(q, args);
	}


}
