package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.*;
import com.mystore.utility.Log;
import org.testng.annotations.*;

import java.util.HashMap;

public class EndToEndTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    private AccountCreationPage accountCreationPage;
    private ShippingPage shippingPage;
    private AddressPage addressPage;
    private PaymentPage paymentPage;
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
        launchApp(browser);
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
    @Test(dataProvider = "getProduct", dataProviderClass = DataProviders.class)
    public void addAddress(String productName, String size, String qty) throws Throwable {
        Log.startTestCase("addAddress");
        indexPage = new IndexPage();
        getDriver().switchTo().frame("framelive");
        searchResultPage = indexPage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(size);
        addToCartPage.enterQuantity(qty);
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckOut();
        orderPage.clickOnCheckOut();
        HashMap<String, String> hashMapValue = new HashMap<String, String>();
        hashMapValue.put("Gender", "Mr");
        hashMapValue.put("FirstName", "John");
        hashMapValue.put("LastName", "Doe");
        hashMapValue.put("Email", "phuonphuon@gmail.com");
        hashMapValue.put("Password", "12345iudp&P6");
        hashMapValue.put("BirthDay", "12/12/1990");
        accountCreationPage = new AccountCreationPage();
        accountCreationPage.createAccount(
                hashMapValue.get("Gender"),
                hashMapValue.get("FirstName"),
                hashMapValue.get("LastName"),
                hashMapValue.get("Email"),
                hashMapValue.get("Password"),
                hashMapValue.get("BirthDay"));
        accountCreationPage.clickOnContinue();
        addressPage = new AddressPage();
        hashMapValue.put("Alias", "My Address");
        hashMapValue.put("Company", "My Company");
        hashMapValue.put("Address", "1234");
        hashMapValue.put("AddressComplement", "1234");
        hashMapValue.put("City", "Ho Chi Minh");
        hashMapValue.put("State", "AE");
        hashMapValue.put("PostalCode", "70000");
        hashMapValue.put("Country", "United States");
        hashMapValue.put("Phone", "1234567890");
        addressPage.addAddress(
                hashMapValue.get("Alias"),
                hashMapValue.get("FirstName"),
                hashMapValue.get("LastName"),
                hashMapValue.get("Company"),
                hashMapValue.get("Address"),
                hashMapValue.get("AddressComplement"),
                hashMapValue.get("City"),
                hashMapValue.get("State"),
                hashMapValue.get("PostalCode"),
                hashMapValue.get("Country"),
                hashMapValue.get("Phone"));
        addressPage.clickOnContinueBtn();
        shippingPage = new ShippingPage();
        shippingPage.clickOnProceedToCheckOut();
        paymentPage = new PaymentPage();
        paymentPage.clickCheckBox();
        paymentPage.clickOnPaymentMethod();
        paymentPage.clickPayment();



    //        boolean result = addressPage.verifyAddressTitle();
//        Assert.assertTrue(result);
    }

}
