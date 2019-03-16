package com.haidoan.automation.manager;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager
{


    ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();

    public abstract void createDriver();


    public   WebDriver getDriver()
    {
         if (driver.get() == null)
         {
             createDriver();
         }
        return driver.get();
    }

    public void quitDriver()
    {
        driver.get().quit();
    }


}
