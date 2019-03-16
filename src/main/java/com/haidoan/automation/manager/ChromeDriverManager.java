package com.haidoan.automation.manager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ChromeDriverManager extends DriverManager
{
    private ChromeDriver chromeDriver;

    @Override
    public void createDriver()
    {
        DesiredCapabilities capabilities = DesiredCapabilities.chrome();
        ChromeOptions optChrome = new ChromeOptions();
        optChrome.addArguments("test-type");
        capabilities.setCapability(ChromeOptions.CAPABILITY, optChrome);
        chromeDriver = new ChromeDriver();
    }
}
