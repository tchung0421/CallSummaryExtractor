package com.snva.callsummaryextractor.runner;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.snva.callsummaryextractor.service.FileUiServiceImpl;
import com.snva.callsummaryextractor.service.IFileUiService;
import com.snva.callsummaryextractor.utils.ReadUtil;

/**
 *This is the Runner class
 */
public class Runner
{
    private ReadUtil m_readUtil;

    private IFileUiService m_FileUiService;

    /**
     *This is a default constructor of the class
     */
    public Runner() throws IOException {
        m_readUtil=new ReadUtil();
        m_FileUiService= new FileUiServiceImpl();
        m_FileUiService.processFile();
    }

    /**
     *This function takes the user choice as the menu is displayed and
     *call the functions accordingly.
     *
     */
    /**
     *This fuction displays the main menu of the system.
     *
     */

//	private String m_extension;
//	private String m_date;
//	private String m_totalCallTime;
//	private String m_totalCallNumber;
//	private String m_averageCall;
//	private String m_firstCall;
//	private String m_lastCall;

    /**
     * This is the main fuction which runs the default constructor of the class.
     */
    public static void main(String[] args) throws IOException {
        new Runner();
    }

}