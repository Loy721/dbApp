package com.example.lb.dao;

import com.example.lb.entity.Paper;
import com.example.lb.entity.Participant;
import com.example.lb.entity.ReportPaperParticipant;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultMapper  implements org.springframework.jdbc.core.RowMapper<ReportPaperParticipant> {
    @Override
    public ReportPaperParticipant mapRow(ResultSet rs, int rowNum) throws SQLException {
        Paper paper= (new PaperMapper()).mapRow(rs,rowNum);
        Participant participant =(new PartcicipantMapper()).mapRow(rs,rowNum);
        return new ReportPaperParticipant(paper,participant);
    }
}
