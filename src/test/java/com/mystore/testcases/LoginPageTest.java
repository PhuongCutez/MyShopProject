package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;
    @Parameters("browser")
    @BeforeMethod(groups = {"Smoke","Sanity","Regression"})
    public void setup(@Optional("chrome") String browser){
        launchApp(browser);
    }
    @AfterMethod(groups = {"Smoke","Sanity","Regression"})
    public void tearDown() {
        getDriver().quit();
    }


    @Test(groups = {"Smoke","Sanity"}, dataProvider = "credentials", dataProviderClass = DataProviders.class)
    public void LoginTest(String uname, String pswd) throws Throwable {
        Log.startTestCase("LoginTest");
        indexPage = new IndexPage();
        Log.info("User is going to click on Sign In");
        getDriver().switchTo().frame("framelive");
        loginPage = indexPage.clickOnSignIn();
        Log.info("Enter the username and password");
        homePage = loginPage.login(uname, pswd, homePage);
        String actualUrl = homePage.getCurrURL();
        String expectedUrl = "https://demo.prestashop.com/#/en/front";
        Log.info("Verifying if user is able to login");
        Assert.assertEquals(actualUrl, expectedUrl);
        Log.info("Login is successful");
        Log.endTestCase("LoginTest");

    }

}
