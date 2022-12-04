package com.example.lb.dao;

import com.example.lb.entity.ReportPaperParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<ReportPaperParticipant> getResult(){

        return jdbcTemplate.query("SELECT * FROM PAPERS JOIN PARTICIPANTS ON PAPERS.ID=PARTICIPANTS.ID",new ResultMapper());
    }
}
