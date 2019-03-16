package com.haidoan.automation.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends abstractpage
{


    @FindBy(className = "product-form-submit")
    private WebElement btnSubmit;

    @FindBy(linkText = "#Insurance")
    private WebElement tabInsurance;

    @FindBy(linkText = "#Travel")
    private WebElement tabInsuranceTravel;

    private HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public static HomePage using(WebDriver driver)
    {
        return new HomePage(driver);
    }

    @Override
    public boolean isAt()
    {
        return btnSubmit.isDisplayed();
    }
}
