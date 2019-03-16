package com.haidoan.automation.utils;

import com.haidoan.automation.manager.DriverManager;
import com.haidoan.automation.manager.DriverManagerFactory;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public final class WaitUtils
{
    private final static int timeout = 30;
    private final static int poilling = 5;

    public static void waitUntilElementIsClickable(WebDriver driver, WebElement element)
    {
        if (element == null)
        {
            throw new NoSuchElementException(" element parameter is null");
        }
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.pollingEvery(Duration.ofSeconds(poilling));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static void waitUntilElementVisible(WebDriver driver, WebElement element)
    {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.pollingEvery(Duration.ofSeconds(poilling));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
