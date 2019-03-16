package com.haidoan.automation.manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager
{


    private ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public abstract void createDriver();


    public  WebDriver getDriver()
    {
        return driver.get();
    }

    public void setDriver(WebDriver driver)
    {
        this.driver.set(driver);
    }

    public void quitDriver()
    {
        this.driver.get().quit();
    }


}
