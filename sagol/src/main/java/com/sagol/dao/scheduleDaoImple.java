package com.sagol.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.sagol.dto.scheduleVO;

@Repository
public class scheduleDaoImple implements scheduleDao {

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate; 


	@Override
	public List<scheduleVO> selectScheduleList(scheduleVO schedulevo) {
	    StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_schedule ");
		if (schedulevo.getOrderby_key() != null && schedulevo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(schedulevo.getOrderby_key());	
			if (schedulevo.getOrderby_rule() != null && schedulevo.getOrderby_rule() != "") {
				sql.append(" ").append(schedulevo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedulevo);

		RowMapper<scheduleVO> mapper = new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}


	@Override
	public List<scheduleVO> selectScheduleListByClubId(scheduleVO schedulevo) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_schedule ");
		sql.append("\n").append("where club_id = :club_id");
		if (schedulevo.getOrderby_key() != null && schedulevo.getOrderby_key() != "") {
			sql.append("\n").append("order by ").append(schedulevo.getOrderby_key());	
			if (schedulevo.getOrderby_rule() != null && schedulevo.getOrderby_rule() != "") {
				sql.append(" ").append(schedulevo.getOrderby_rule());	
			}
		}else {
			sql.append("\n").append("order by mdfy_dt");
		}
		
		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedulevo);

		RowMapper<scheduleVO> mapper = new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class);
		return namedParameterJdbcTemplate.query(sql.toString(),paramSource, mapper);
	}


	@Override
	public scheduleVO selectSchedule(scheduleVO schedulevo) {
		StringBuffer sql = new StringBuffer();
		
		sql.append("\n").append("select ");
		sql.append("\n").append("* ");
		sql.append("\n").append("from sg_schedule");
		sql.append("\n").append("where schedule_id = :schedule_id ");
		sql.append("\n").append("and club_id = :club_id ");

		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(schedulevo);
		RowMapper<scheduleVO> mapper = new BeanPropertyRowMapper<scheduleVO>(scheduleVO.class);
		try {
			return namedParameterJdbcTemplate.queryForObject(sql.toString(), paramSource, mapper);
		} catch (Exception e) {
			return null;
		}
	}
	

}
