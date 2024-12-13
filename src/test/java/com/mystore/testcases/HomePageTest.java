package com.mystore.testcases;

import com.beust.ah.A;
import com.mystore.base.BaseClass;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
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
    @BeforeMethod
    public void setup(String browser){
        launchApp(browser);
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
    @Test
    public void wishListTest(String uname, String paswd) throws Throwable{
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), homePage);
       boolean result = homePage.validateMyWishList();
        Assert.assertTrue(result);
    }
    @Test
    public void orderHistoryTest(String uname, String paswd) throws Throwable{
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"), homePage);
        boolean result = homePage.validateOrderHistory();
        Assert.assertTrue(result);
    }
}
