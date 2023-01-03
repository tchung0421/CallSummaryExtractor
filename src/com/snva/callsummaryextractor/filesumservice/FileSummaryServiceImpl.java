package com.snva.callsummaryextractor.filesumservice;

import com.snva.callsummaryextractor.bean.CallSummary;
import com.snva.callsummaryextractor.utils.ReadUtil;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileSummaryServiceImpl implements IFileSummaryService {


    ReadUtil  readUtil;



    public FileSummaryServiceImpl(){
        readUtil = new ReadUtil();
    }
    /**
     * @param path
     * @return
     */
    @Override
    public List<CallSummary> processFile(File path) throws IOException {




        List<CallSummary> callSummaryList = new ArrayList<>();
        List<String> filteredLines = new ArrayList<>();
        try{
            List<String> allLines = Files.readAllLines(Paths.get(path.getAbsolutePath()), Charset.defaultCharset());
            allLines.forEach(x->{
                if (isValidLine(x)){
                    CallSummary summary= buildCallSummary(x);
                    if (summary!=null){
                        callSummaryList.add(summary);
                    }
                    //filteredLines.add(x);
                }
            });
        } catch (Exception e){
            return null;
        }
        return callSummaryList;
    }

    /**
     * @param processFile
     * @return
     */
    @Override
    public String saveToFile(List<CallSummary> processFile)  {
        processFile.forEach(x->{
            System.out.print(x.toString());
        });

        return "The output";
    }

    private CallSummary buildCallSummary(String x) {
        CallSummary callSummary=null;
        String [] cols = x.split("\\s+");
        if (cols.length==8){
            callSummary  = new CallSummary();
            callSummary.setSrNo(cols[0]);
            callSummary.setExt(cols[1]);
            callSummary.setJun(cols[2]);
            callSummary.setDirectoryNo(cols[3]);
            callSummary.setDate(cols[4]);
            callSummary.setTime(cols[5]);
            callSummary.setDuration(cols[6]);
            callSummary.setBillAmt(cols[7]);
        }
        // we will a few more cases later
        return callSummary;
    }

    private boolean isValidLine(String x) {
        try{
            Integer.parseInt(x.split("\\s+")[0]);
            return true;
        }catch (NumberFormatException nFe){
            return false;
        }
        catch (Exception nFe){
            return false;
        }
    }
}