
package com.mystore.pageobjects;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AccountCreationPage extends BaseClass {

    Action action= new Action();

    @FindBy(xpath = "//h1[text()='Create an account']")
    private WebElement formTitle;

    @FindBy(id = "field-id_gender-1")
    private WebElement mr;

    @FindBy(id = "field-id_gender-2")
    private WebElement mrs;

    @FindBy(name = "firstname")
    private WebElement firstName;

    @FindBy(name = "lastname")
    private WebElement lastName;

    @FindBy(id = "field-email")
    private WebElement email;
    @FindBy(id = "field-password")
    private WebElement passWord;

    @FindBy(id = "field-birthday")
    private WebElement birthDay;
    @FindBy(name = "optin")
    private WebElement receiveOffers;
    @FindBy(name = "psgdpr")
    private WebElement signUpNewsLetter;
    @FindBy(name = "newsletter")
    private WebElement privatePolicy;
    @FindBy(name = "customer_privacy")
    private WebElement privacyPolicy;
    @FindBy(xpath = "//buttion[text()='Save']")
    private WebElement saveBtn;

    public AccountCreationPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void createAccount(String gender,String fName,
                              String lName,
                              String emails,
                              String passwd,
                              String birth) throws Throwable {

        if(gender.equalsIgnoreCase("Mr")) {
            action.click(getDriver(), mr);
        } else {
            action.click(getDriver(), mrs);
        }
        action.type(firstName, fName);
        action.type(lastName, lName);
        action.type(email, emails);
        action.type(passWord, passwd);
        action.type(birthDay, birth);
        action.click(getDriver(), receiveOffers);
        action.click(getDriver(), signUpNewsLetter);
        action.click(getDriver(), privatePolicy);
        action.click(getDriver(), privacyPolicy);


    }

    public HomePage validateRegistration() throws Throwable {
        saveBtn.click();
        return new HomePage();
    }

    public boolean validateAcountCreatePage() throws Throwable {
        return action.isDisplayed(getDriver(), formTitle);
    }

}