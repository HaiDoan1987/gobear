package com.haidoan.automation.pageobject;

import org.openqa.selenium.WebDriver;

public abstract class abstractpage
{
    private final WebDriver driver;

    public abstractpage(WebDriver driver)
    {
        this.driver = driver;
    }
    public abstract boolean isAt();
}
