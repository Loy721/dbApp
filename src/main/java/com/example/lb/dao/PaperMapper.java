package com.example.lb.dao;

import com.example.lb.entity.Paper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PaperMapper implements org.springframework.jdbc.core.RowMapper<Paper> {

    @Override
    public Paper mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Paper paper= new Paper();
        paper.setID_R(resultSet.getInt("ID_R"));
        paper.setID(resultSet.getInt("ID"));
        paper.setSDATE(resultSet.getDate("SDATE"));
        paper.setSECTIONNAME(resultSet.getString("SECTIONNAME"));
        paper.setTITLE(resultSet.getString("TITLE"));
        paper.setTYPE(resultSet.getString("TYPE"));
        return paper;
    }
}
