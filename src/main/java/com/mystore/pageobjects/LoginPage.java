/**
 *
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Hitendra
 *
 */
public class LoginPage extends BaseClass {

    Action action= new Action();

    @FindBy(id="field-email")
    private WebElement userName;

    @FindBy(id="field-password")
    private WebElement password;

    @FindBy(id="submit-login")
    private WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"login-form\"]/div/div[3]/a")
    private WebElement onNewAccount;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public HomePage login(String uname, String pswd,HomePage homePage) throws Throwable {
        action.scrollByVisibilityOfElement(driver, userName);
        action.type(userName, uname);
        action.type(password, pswd);
        action.JSClick(driver, signInBtn);
        Thread.sleep(2000);
        homePage=new HomePage();
        return homePage;
    }

    public AddressPage login(String uname, String pswd,AddressPage addressPage) throws Throwable {
        action.scrollByVisibilityOfElement(driver, userName);
        action.type(userName, uname);
        action.type(password, pswd);
        action.click(driver, signInBtn);
        Thread.sleep(2000);
        addressPage=new AddressPage();
        return addressPage;
    }

    public AccountCreationPage createNewAccount(String newEmail) throws Throwable {
        action.click(driver, onNewAccount);
        return new AccountCreationPage();
    }

}