package com.haidoan.automation.pageobject;

import com.haidoan.automation.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class DetailsPage extends abstractpage
{
    @FindBy(css = "div[data-gb-name='edit-detail-bar']")
    private WebElement divDetailsBar;

    @FindBy(xpath = "//label[contains(text(), 'DESTINATION')]/following-sibling::div")
    private WebElement divDESTINATION;

    @FindBy(xpath = "//label[contains(text(), 'DESTINATION')]/following-sibling::div")
    private WebElement divDropDownList;
    private DetailsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        Assert.assertTrue(isAt(), "sort page is not displayed");

    }

    @Override
    public boolean isAt()
    {
        WaitUtils.waitUntilElementVisible(driver, divDetailsBar);
        return divDetailsBar.isDisplayed();
    }

    public static DetailsPage using(WebDriver driver)
    {
        return new DetailsPage(driver);
    }



    public DetailsPage selectCountryInDropDownList(String countryName)
    {
        WebElement elementCountryName = divDESTINATION.findElement(By.xpath("//div[@class = 'dropdown-menu open']//span[contains(text(), '" + countryName + "')]/following-sibling::link"));
        elementCountryName.click();
        return this;
    }

    public DetailsPage clickDivDropDownList()
    {
        WaitUtils.waitUntilElementIsClickable(driver, divDropDownList);
        divDropDownList.click();
        return this;
    }
}
