package com.haidoan.automation.pageobject;

import com.haidoan.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class TravelResultPage extends abstractpage
{

    @FindBy(id = "travel-quote-list")
    private WebElement gridResultCard;


    private TravelResultPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        Assert.assertTrue(isAt(), "result is not displayed");

    }

    @Override
    public boolean isAt()
    {
        WaitUtils.waitUntilElementVisible(driver, gridResultCard);
        return gridResultCard.isDisplayed();
    }

    public static TravelResultPage using(WebDriver driver)
    {
        return new TravelResultPage(driver);
    }

    public List<WebElement> getListCard()
    {
        return gridResultCard.findElements(By.xpath("//div[@class='col-sm-4 card-full']"));
    }



}
