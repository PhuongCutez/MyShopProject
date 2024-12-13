/**
 *
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddressPage extends BaseClass {

    Action action= new Action();

    @FindBy(id = "field-alias")
    private WebElement aliasAddress;
    @FindBy(id = "field-firstname")
    private WebElement firstName;
    @FindBy(id = "field-lastname")
    private WebElement lastName;
    @FindBy(id = "field-company")
    private WebElement company;
    @FindBy(id = "field-address1")
    private WebElement address;
    @FindBy(id = "field-address2")
    private WebElement addressComplement;
    @FindBy(id = "field-city")
    private WebElement city;
    @FindBy(id = "field-id_state")
    private WebElement state;
    @FindBy(id = "field-postcode")
    private WebElement postalCode;
    @FindBy(id = "field-id_country")
    private WebElement country;
    @FindBy(id = "field-phone")
    private WebElement mobilePhone;
    @FindBy(xpath = "//*[@id=\"delivery-address\"]/div/footer/button")
    private WebElement continueBtn;
    @FindBy(xpath = "//*[@id=\"checkout-addresses-step\"]/h1")
    private WebElement addressTitle;

    public AddressPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void addAddress(String alias, String fName, String lName, String comp, String add, String addComp, String cty, String lstate, String postalCode, String ctry, String phone) {
        if(fName.equals("") || lName.equals("")) {
            action.type(firstName, fName);
            action.type(lastName, lName);
        }

        action.type(aliasAddress, alias);
        action.type(firstName, fName);
        action.type(lastName, lName);
        action.type(company, comp);
        action.type(address, add);
        action.type(addressComplement, addComp);
        action.type(city, cty);
        action.selectByVisibleText(lstate, state);
        action.type(this.postalCode, postalCode);
        action.selectByVisibleText(ctry, country);
        action.type(mobilePhone, phone);
    }
    public boolean verifyAddressTitle() {
       return action.isDisplayed(getDriver(), addressTitle);
    }
    public ShippingPage clickOnContinueBtn() throws Throwable {
        action.JSClick(getDriver(), continueBtn);
        return new ShippingPage();

   }



}