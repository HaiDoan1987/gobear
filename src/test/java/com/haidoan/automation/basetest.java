package com.haidoan.automation;

import com.haidoan.automation.manager.DriverManager;
import com.haidoan.automation.manager.DriverManagerFactory;
import com.haidoan.automation.manager.DriverType;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class basetest
{
    private DriverManager driverManager;

    @BeforeTest
    @Parameters({"browser"})
    public void setUpBrowser(String browser)
    {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.valueOf(browser));
    }


    @AfterTest
    public void closeTest()
    {
        driverManager.getDriver().quit();
    }
}
