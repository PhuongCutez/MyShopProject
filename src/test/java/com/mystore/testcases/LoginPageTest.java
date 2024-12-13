package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginPageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private HomePage homePage;
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
        launchApp(browser);
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }


    @Test
    public void LoginTest(String uname, String pswd) throws Throwable {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), homePage);
//        homePage = loginPage.login(uname, pswd, homePage);
        String actualUrl = homePage.getCurrURL();
        String expectedUrl = "https://demo.prestashop.com/#/en/front";
        Assert.assertEquals(actualUrl, expectedUrl);

    }

}
