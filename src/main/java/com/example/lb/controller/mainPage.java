package com.example.lb.controller;

import com.example.lb.dao.PaperDao;
import com.example.lb.entity.Paper;
import com.example.lb.entity.extPaper;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;

@Controller
public class mainPage {

    @Autowired
    public PaperDao paperDao;
    @GetMapping("/")
        public String getMain(Map<String, List<Paper>> model){
            model.put("papers",paperDao.getAll());
            return "main";
        }
//ResponseEntity
    @PostMapping("/update")
    public ResponseEntity update(@RequestBody extPaper paper){
        try {
        paperDao.update(paper,paper.getLastID());
        }catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Error");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Correctly");
    }

    @PostMapping("/insert")
    public ResponseEntity insert(@RequestBody Paper paper){
        try {
            paperDao.insert(paper);
        }catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body(e.getMessage());
        }
        return ResponseEntity.status(HttpStatus.OK).body("Correctly");
    }

    @PostMapping("/delete")
    public ResponseEntity delete(@RequestBody Paper paper){
        try {
        paperDao.delete(paper); }
        catch (DataAccessException e){
            return ResponseEntity.status(HttpStatus.UNSUPPORTED_MEDIA_TYPE).body("Error");
        }
        return ResponseEntity.status(HttpStatus.OK).body("Correctly");
    }
}
