package com.example.lb.entity;


import lombok.Getter;
import lombok.Setter;

import  java.sql.Date;

@Getter
@Setter
public class Participant {
    private  Integer ID;
    private  String FNAME;
    private  String ACADEMICDEGREE;
    private  String PLACEOFWORK;
    private  String POSITION;
    private  String CITIZENSHIP;
    private  Date BDATE;

    public Participant(){};
}
