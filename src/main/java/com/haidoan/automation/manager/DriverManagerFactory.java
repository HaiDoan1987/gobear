package com.haidoan.automation.manager;

import static com.haidoan.automation.manager.DriverType.CHROME;

public class DriverManagerFactory
{
    public static DriverManager getDriverManager(DriverType typeDriver)
    {
        DriverManager driverManager;
        switch(typeDriver)
        {
            case CHROME:
                driverManager = new ChromeDriverManager();
                break;
            case FIREFOX:
                driverManager = new FireFoxDriverManager();
                break;
            default:
                driverManager = new InternetExplorerDriverManager();
                break;
        }

        return driverManager;
    }


}
