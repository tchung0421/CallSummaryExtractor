package com.snva.callsummaryextractor.filesumservice;

import com.snva.callsummaryextractor.bean.CallSummary;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface IFileSummaryService {

    List<CallSummary> processFile(File path) throws IOException;

    String saveToFile(List<CallSummary> processFile) throws IOException;
}