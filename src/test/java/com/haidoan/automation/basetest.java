package com.haidoan.automation;

import com.haidoan.automation.manager.DriverManager;
import com.haidoan.automation.manager.DriverManagerFactory;
import com.haidoan.automation.manager.DriverType;
import com.haidoan.automation.pageobject.FilterCategoriesPage;
import com.haidoan.automation.pageobject.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.util.concurrent.TimeUnit;

public class basetest
{
    private DriverManager driverManager;
    private WebDriver testDriver;
    private FilterCategoriesPage filterPage;

    private HomePage homePage;
    @BeforeTest
    @Parameters({"browser"})
    public void setUpBrowser(String browser)
    {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.valueOf(browser));
        testDriver = driverManager.getDriver();
        testDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        testDriver.get("https://www.gobear.com/ph?x_session_type=UAT");

    }

    public WebDriver getTestWebDriver()
    {
        return testDriver;
    }

    public HomePage getHomePage() {
        return homePage;
    }

    public FilterCategoriesPage getFilterPage() {
        return filterPage;
    }


    @AfterTest(alwaysRun = true)
    public void closeTest()
    {
        driverManager.quitDriver();
    }
}
