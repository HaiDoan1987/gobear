package com.haidoan.automation.pageobject;

import com.haidoan.automation.utils.WaitUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class FilterCategoriesPage extends abstractpage
{


    @FindBy(id = "collapseSeemoreBtn")
    private WebElement btnShowMore;

    @FindBy(css = "div[data-gb-name='filter-bar']")
    private WebElement divFilter;


    @FindBy(xpath = "//label[contains(text(), 'Insurers')]")
    private WebElement divInsurers;

    @FindBy(css = "button[data-role = 'cancel']")
    private WebElement btnCancelOfFilterTipPopUp;

    @FindBy(css = "button[data-role = 'end']")
    private WebElement btnGotItFromGladToHelpPopUp;

    @Override
    public boolean isAt()
    {
        WaitUtils.waitUntilElementVisible(driver, divFilter);
        return divFilter.isDisplayed();
    }

    private FilterCategoriesPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
        Assert.assertTrue(isAt(), "can not reach filter page");

    }

    public static FilterCategoriesPage using (WebDriver driver)
    {
        return new FilterCategoriesPage(driver);
    }


    public WebElement getSlider(String strSliderName)
    {
        return driver.findElement(By.xpath("//label[contains(text(),'" + strSliderName +"')]/following-sibling::div[@class='bootstrap-slider']//div[@class= 'slider-handle min-slider-handle round']"));
    }

    public FilterCategoriesPage dragMinSlider(String strSliderName)
    {
        Actions action = new Actions(driver);
        action.dragAndDropBy(getSlider(strSliderName), 20, 0).perform();
        return this;
    }

    public FilterCategoriesPage checkInsurersCheckBox(String nameInsurer)
    {
        WebElement ckInsurer = divInsurers.findElement(By.xpath("//label[contains(text(), '" + nameInsurer + "')]/preceding-sibling::input[@type= 'checkbox']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", ckInsurer);
        return this;
    }

    public FilterCategoriesPage clickShowMore()
    {
        WaitUtils.waitUntilElementVisible(driver, btnShowMore);
        btnShowMore.click();
        return this;
    }

    public FilterCategoriesPage clickBtnCancelOfFilterTipPopUp()
    {
        WaitUtils.waitUntilElementVisible(driver, btnCancelOfFilterTipPopUp);
        btnCancelOfFilterTipPopUp.click();
        return this;
    }

    public FilterCategoriesPage clickBtnGotItFromGladToHelpPopUp()
    {
        WaitUtils.waitUntilElementVisible(driver, btnGotItFromGladToHelpPopUp);
        btnGotItFromGladToHelpPopUp.click();
        return this;
    }



}
