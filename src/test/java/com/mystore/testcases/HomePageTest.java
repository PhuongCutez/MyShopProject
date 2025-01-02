package com.mystore.testcases;

import com.beust.ah.A;
import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class HomePageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void setup(String browser){
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke", "Sanity", "Regression"})
    public void tearDown() {
        getDriver().quit();
    }
    @Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void wishListTest(String uname, String paswd) throws Throwable{
        Log.startTestCase("wishListTest");
        indexPage = new IndexPage();
        getDriver().switchTo().frame("framelive");
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(uname, paswd, homePage);
       boolean result = homePage.validateMyWishList();
        Assert.assertTrue(result);
        Log.endTestCase("wishListTest");
    }
    @Test(groups = "Smoke", dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void orderHistoryTest(String uname, String paswd) throws Throwable {
        Log.startTestCase("orderHistoryTest");
        indexPage = new IndexPage();
        getDriver().switchTo().frame("framelive");
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), homePage);
        boolean result = homePage.validateOrderHistory();
        Assert.assertTrue(result);
        Log.endTestCase("orderHistoryTest");
    }
}
