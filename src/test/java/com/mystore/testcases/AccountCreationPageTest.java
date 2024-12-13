package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.HomePage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

public class AccountCreationPageTest extends BaseClass {
    private IndexPage indexPage;
    private LoginPage loginPage;
    private AccountCreationPage accountCreationPage;
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
    public void verifyCreateAccountPageTest() throws Throwable {
        indexPage = new IndexPage();
        loginPage = indexPage.clickOnSignIn();
        accountCreationPage = loginPage.createNewAccount();
        boolean result = accountCreationPage.validateAcountCreatePage();
        Assert.assertTrue(result);
    }
    @Test
    public void createAccountTest(HashMap<String, String> hashMapValue) throws Throwable {
        indexPage = new IndexPage();
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
        Assert.assertEquals("https://demo.prestashop.com/#/en/front", homePage.getCurrURL());
    }
}

