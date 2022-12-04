package com.example.lb.dao;

import com.example.lb.entity.Paper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;
@Component
public class PaperDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Paper> getAll(){
        return jdbcTemplate.query("SELECT * FROM PAPERS",new PaperMapper());
    }

    public void update(Paper paper,Integer last_id_R) throws DataAccessException {

        jdbcTemplate.update("UPDATE PAPERS SET ID_R=?,ID=?,SDATE=?,TITLE=?,SECTIONNAME=?,TYPE=?  WHERE ID_R=?",
        paper.getID_R(),paper.getID(),paper.getSDATE(),paper.getTITLE(),paper.getSECTIONNAME(),paper.getTYPE(),
                last_id_R);
    }

    public void insert(Paper paper) throws DataAccessException {
        jdbcTemplate.update("INSERT INTO PAPERS VALUES(?,?,?,?,?,?)",paper.getID_R(),paper.getTITLE(),paper.getID()
                ,paper.getTYPE(),paper.getSECTIONNAME(),paper.getSDATE());
    }
    public void delete(Paper paper) throws DataAccessException {
        jdbcTemplate.update("DELETE FROM PAPERS WHERE ID_R= ? AND ID = ? AND SDATE = ? AND TITLE = ? AND" +
                        " SECTIONNAME = ? AND PAPERS.TYPE = ?",
                paper.getID_R(),paper.getID(),paper.getSDATE(),paper.getTITLE(),paper.getSECTIONNAME(),paper.getTYPE());
    }
}
