package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

public class IndexPageTest extends BaseClass {
    private IndexPage indexPage;
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(@Optional("Chrome") String browser){
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }

    @Test(groups = "Smoke")
    public void verifyLogo() throws Throwable {
        Log.startTestCase("verifyLogo");
        indexPage = new IndexPage();
        getDriver().switchTo().frame("framelive");
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
        Log.endTestCase("verifyLogo");
    }
    @Test(groups = "Smoke")
    public void verifyTitle() throws Throwable {
        Log.startTestCase("verifyTitle");
        getDriver().switchTo().frame("framelive");
        String title = indexPage.getMyStoreTitle();
        Assert.assertEquals(title, "PrestaShop Live Demo");
        Log.endTestCase("verifyTitle");
    }

}
