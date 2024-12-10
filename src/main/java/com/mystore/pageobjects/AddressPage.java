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

    public AddressPage() {
        PageFactory.initElements(driver, this);
    }
   public void enterAlias(String alias) throws Throwable {
        action.type(aliasAddress, alias);
    }
    public void enterFirstName(String fName) throws Throwable {
        if(fName.equals("")) {
            action.type(firstName, fName);
        }
    }
    public void enterLastName(String lName) throws Throwable {
        if(lName.equals("")) {
            action.type(lastName, lName);
        }
    }
    public void enterCompany(String comp) throws Throwable {
        action.type(company, comp);
    }
    public void enterAddress(String add) throws Throwable {
        action.type(address, add);
    }
    public void enterAddressComplement(String addComp) throws Throwable {
        action.type(addressComplement, addComp);
    }
    public void enterCity(String cityName) throws Throwable {
        action.type(city, cityName);
    }
    public void enterState(String stateName) throws Throwable {
        action.selectByVisibleText(stateName, state);
    }
    public void enterPostalCode(String postCode) throws Throwable {
        action.type(postalCode, postCode);
    }
    public void enterCountry(String countryName) throws Throwable {
        action.selectByVisibleText(countryName, country);
    }
    public void enterMobilePhone(String phone) throws Throwable {
        action.type(mobilePhone, phone);
    }
    public ShippingPage clickOnContinueBtn() throws Throwable {
        action.JSClick(driver, continueBtn);
        return new ShippingPage();

   }



}