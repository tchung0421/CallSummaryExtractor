package com.snva.callsummaryextractor.service;

import com.snva.callsummaryextractor.bean.CallSummary;
import com.snva.callsummaryextractor.filesumservice.FileSummaryServiceImpl;
import com.snva.callsummaryextractor.filesumservice.IFileSummaryService;
import com.snva.callsummaryextractor.utils.ReadUtil;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileUiServiceImpl implements IFileUiService {

    com.snva.callsummaryextractor.utils.ReadUtil readUtil;
    IFileSummaryService iFileService;

    public FileUiServiceImpl(){
        readUtil= new ReadUtil();
        iFileService = new FileSummaryServiceImpl();
    }






    @Override
    public void processFile() throws IOException {
        String filePath= readUtil.readString("Please enter a file path","Error could not read the input ");
        // check if this file path exists
        File isValidPath= new File(filePath);
        if (isValidPath.exists()){
            String savePath=iFileService.saveToFile(iFileService.processFile(isValidPath));
        }else{
            System.out.println("The path "+filePath+" does not exist");
        }

    }
}
