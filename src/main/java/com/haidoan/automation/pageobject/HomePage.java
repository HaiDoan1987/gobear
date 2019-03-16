package com.haidoan.automation.pageobject;

import com.haidoan.automation.utils.LogManager;
import com.haidoan.automation.utils.WaitUtils;
import com.sun.xml.internal.ws.policy.AssertionSet;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class HomePage extends abstractpage
{


    @FindBy(css = "button[name='product-form-submit']")
    private WebElement btnSubmit;

    @FindBy(css = "a[href='#Insurance']")
    private WebElement tabInsurance;

    @FindBy(css = "a[href='#Travel']")
    private WebElement tabInsuranceTravel;

    private HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        Assert.assertTrue(isAt(), "can not reach home page");
    }

    public static HomePage using(WebDriver driver)
    {
        return new HomePage(driver);
    }

    @Override
    public boolean isAt()
    {
        WaitUtils.waitUntilElementVisible(driver, btnSubmit);
        return btnSubmit.isDisplayed();
    }

    public WebElement getBtnSubmit() {
        return btnSubmit;
    }

    public WebElement getTabInsurance()
    {
        WaitUtils.waitUntilElementIsClickable(driver, tabInsurance);
        return tabInsurance;
    }

    public WebElement getTabInsuranceTravel()
    {
        WaitUtils.waitUntilElementIsClickable(driver, tabInsuranceTravel);
        return tabInsuranceTravel;
    }

    public  HomePage switchToTab(String tabName)
    {
        if ("Insurance".equals(tabName))
        {
            WaitUtils.waitUntilElementIsClickable(super.driver, tabInsurance);
            tabInsurance.click();
        }
        else if ("Travel".equals(tabName))
        {
            WaitUtils.waitUntilElementIsClickable(super.driver, tabInsuranceTravel);
            tabInsuranceTravel.click();
        }
        return this;
    }

    public void clickSubmit()
    {
        WaitUtils.waitUntilElementIsClickable(super.driver, btnSubmit);
        btnSubmit.click();
    }

}
