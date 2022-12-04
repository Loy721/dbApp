package com.example.lb.dao;

import com.example.lb.entity.Paper;
import com.example.lb.entity.Participant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PartcicipantMapper implements org.springframework.jdbc.core.RowMapper<Participant>{
    @Override
    public Participant mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        Participant participant= new Participant();
        participant.setID(resultSet.getInt("ID"));
        participant.setBDATE(resultSet.getDate("BDATE"));
        participant.setFNAME(resultSet.getString("FNAME"));
        participant.setACADEMICDEGREE(resultSet.getString("ACADEMICDEGREE"));
        participant.setPLACEOFWORK(resultSet.getString("PLACEOFWORK"));
        participant.setPOSITION(resultSet.getString("POSITION"));
        participant.setCITIZENSHIP(resultSet.getString("CITIZENSHIP"));
        return participant;
    }
}
