package com.haidoan.automation;


import com.haidoan.automation.pageobject.*;
import com.haidoan.automation.utils.AssertionManager;
import org.testng.annotations.Test;

public class TravelTestSuite extends basetest
{
    @Test
    public void testTravelCase() throws Exception
    {
        HomePage.using(getTestWebDriver())
                .switchToTab("Insurance")
                .switchToTab("Travel")
                .clickSubmit();

        AssertionManager.verifyTrue(TravelResultPage.using(getTestWebDriver()).getListCard().size() >= 3);

        FilterCategoriesPage.using(getTestWebDriver())
                .clickBtnCancelOfFilterTipPopUp()
                .clickBtnGotItFromGladToHelpPopUp()
                .clickShowMore()
                .dragMinSlider("Personal Accident")
                .checkInsurersCheckBox("FPG Insurance");

        AssertionManager.verifyTrue(TravelResultPage.using(getTestWebDriver()).getListCard().size() >= 2);



        SortPage.using(getTestWebDriver())
                .selectSortType("Price: Low to high ");

        DetailsPage.using(getTestWebDriver())
                .clickDivDropDownList()
                .selectCountryInDropDownList("Japan");
    }
}
