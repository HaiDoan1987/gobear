package com.haidoan.automation.utils;

public class LogManager
{
    /*
    * implement log4j later if have enough time
    * */
    private  static LogManager  log;
    public static LogManager getInstace()
    {
        if (log == null)
        {
            log = new LogManager();
        }
        return log;
    }

    public void logInfo(String strMessage)
    {
        System.out.println(strMessage);
    }

}
