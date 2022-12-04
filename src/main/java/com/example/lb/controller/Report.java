package com.example.lb.controller;

import com.example.lb.dao.ResultDao;
import com.example.lb.entity.ReportPaperParticipant;
import com.example.lb.service.CSVService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class Report {

    @Autowired
    public ResultDao resultDao;
    @Autowired
    CSVService fileService;
    @GetMapping("/report")
    public String getReport(Map<String, List<ReportPaperParticipant>> model){
        model.put("report",resultDao.getResult());
        return "report";
    }

    @GetMapping("/download")
    public ResponseEntity<Resource> download() throws IOException {
        String filename = "Report.csv";
        InputStreamResource file = new InputStreamResource(fileService.load());

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/csv"))
                .body(file);
    }

}
