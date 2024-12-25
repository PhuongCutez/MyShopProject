package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;

public class AccountCreationPageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private AccountCreationPage accountCreationPage;
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
    @Test(dataProvider = "newAccountDetailsData", dataProviderClass = DataProviders.class)
    public void createAccountTest(HashMap<String, String> hashMapValue) throws Throwable {
        Log.startTestCase("createAccountTest");
        indexPage = new IndexPage();
        getDriver().switchTo().frame("framelive");
        loginPage = indexPage.clickOnSignIn();
        accountCreationPage = loginPage.createNewAccount();
        accountCreationPage.createAccount(
                hashMapValue.get("Gender"),
                hashMapValue.get("FirstName"),
                hashMapValue.get("LastName"),
                hashMapValue.get("Email"),
                hashMapValue.get("Password"),
                hashMapValue.get("BirthDay"));
        homePage = accountCreationPage.validateRegistration();
//        Assert.assertEquals("https://demo.prestashop.com/#/en/front", homePage.getCurrURL());
        Log.endTestCase("createAccountTest");
    }
}

