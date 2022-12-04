package com.example.lb.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
public class extPaper extends Paper{

    public final Integer lastID;

    extPaper(@JsonProperty("ID_R")Integer ID_R, @JsonProperty("ID")Integer ID,
             @JsonProperty("TITLE")String TITLE, @JsonProperty("TYPE")String TYPE,
             @JsonProperty("SECTIONNAME")String SECTIONNAME, @JsonProperty("SDATE") Date SDATE,
             @JsonProperty("LAST_ID")Integer lastID){
        super(ID_R,ID,TITLE,TYPE,SECTIONNAME,SDATE);
        this.lastID=lastID;

    }
}
