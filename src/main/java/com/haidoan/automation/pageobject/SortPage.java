package com.haidoan.automation.pageobject;

import com.haidoan.automation.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class SortPage extends abstractpage
{
    @FindBy(css = "div[data-gb-name='sort-bar']")
    private WebElement divSortBar;


    private SortPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        Assert.assertTrue(isAt(), "sort page is not displayed");

    }

    @Override
    public boolean isAt()
    {
        WaitUtils.waitUntilElementVisible(driver, divSortBar);
        return divSortBar.isDisplayed();
    }

    public static SortPage using(WebDriver driver)
    {
        return new SortPage(driver);
    }

    public  SortPage selectSortType(String sortName)
    {
        WebElement element = driver.findElement(By.xpath("//label[contains(text(), '" + sortName +"')]/preceding-sibling::input[contains(@id, 'gb_radio')]"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
        return this;
    }
}
