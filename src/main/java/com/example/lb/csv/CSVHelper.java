package com.example.lb.csv;

import com.example.lb.entity.Paper;
import com.example.lb.entity.Participant;
import com.example.lb.entity.ReportPaperParticipant;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.QuoteMode;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class CSVHelper {

    public static ByteArrayInputStream tutorialsToCSV(List<ReportPaperParticipant> results) {
        final CSVFormat format = CSVFormat.DEFAULT.withQuoteMode(QuoteMode.MINIMAL);

        try (ByteArrayOutputStream out = new ByteArrayOutputStream();
             CSVPrinter csvPrinter = new CSVPrinter(new PrintWriter(out), format)) {
            List<String> tittels = Arrays.asList(
                    "ID_R","TITLE","ID","TYPE","SECTIONNAME","SDATE","ID","FNAME","ACADEMICDEGREE","PLACEOFWORK",
                    "POSITION","CITIZENSHIP","BDATE");
            csvPrinter.printRecord(tittels);
            for (ReportPaperParticipant res : results) {
                Paper paper= res.getPaper();
                Participant participant= res.getParticipant();
                List<String> data = Arrays.asList(
                        String.valueOf(paper.getID_R()),
                        paper.getTITLE(),
                        String.valueOf(paper.getID()),
                        paper.getTYPE(),
                        paper.getSECTIONNAME(),
                        String.valueOf(paper.getSDATE()),
                        String.valueOf( participant.getID()),
                        participant.getFNAME(),
                        participant.getACADEMICDEGREE(),
                        participant.getPLACEOFWORK(),
                        participant.getPOSITION(),
                        participant.getCITIZENSHIP(),
                        String.valueOf(participant.getBDATE())
                );

                csvPrinter.printRecord(data);
            }
            csvPrinter.flush();
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
