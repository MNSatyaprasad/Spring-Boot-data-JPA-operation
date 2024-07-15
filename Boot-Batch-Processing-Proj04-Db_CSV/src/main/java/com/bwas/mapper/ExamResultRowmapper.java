package com.bwas.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.bwas.model.ExamResult;
@Component
public class ExamResultRowmapper implements RowMapper<ExamResult> {

	@Override
	public ExamResult mapRow(ResultSet rs, int rowNum) throws SQLException {

		return new ExamResult(rs.getInt(1), rs.getDate(2), rs.getInt(3), rs.getFloat(4));
	}

}
