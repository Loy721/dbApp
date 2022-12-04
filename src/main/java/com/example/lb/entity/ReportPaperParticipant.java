package com.example.lb.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReportPaperParticipant {
    private Paper  paper;
    private Participant participant;

    public ReportPaperParticipant(){
    }

    public ReportPaperParticipant(Paper paper,Participant participant){
        this.participant=participant;
        this.paper=paper;
    }
}
