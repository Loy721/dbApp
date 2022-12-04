package com.example.lb.service;


import com.example.lb.csv.CSVHelper;
import com.example.lb.dao.ResultDao;
import com.example.lb.entity.ReportPaperParticipant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.util.List;

@Service
    public class CSVService {


    @Autowired
    public ResultDao resultDao;

    public ByteArrayInputStream load() {
        List<ReportPaperParticipant> tutorials = resultDao.getResult();

        ByteArrayInputStream in = CSVHelper.tutorialsToCSV(tutorials);
        return in;
    }
}