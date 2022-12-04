package com.example.lb.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import  java.sql.Date;

@Getter
@Setter
public class Paper {
    private Integer ID_R;
    private Integer ID;
    private String TITLE;
    private String TYPE;
    private String SECTIONNAME;
    private Date SDATE;

    public Paper(){}

    public Paper(@JsonProperty("ID_R")Integer ID_R, @JsonProperty("ID")Integer ID,
                 @JsonProperty("TITLE")String TITLE, @JsonProperty("TYPE")String TYPE,
                 @JsonProperty("SECTIONNAME")String SECTIONNAME, @JsonProperty("SDATE") Date SDATE){
                this.ID_R=ID_R;
                this.ID=ID;
                this.TITLE=TITLE;
                this.TYPE=TYPE;
                this.SDATE=SDATE;
                this.SECTIONNAME=SECTIONNAME;
    }

}
