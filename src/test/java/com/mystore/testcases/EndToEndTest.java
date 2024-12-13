package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.HashMap;

public class EndToEndTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
    private AddressPage addressPage;
    private ShippingPage shippingPage;
    private PaymentPage paymentPage;
    @Parameters("browser")
    @BeforeMethod
    public void setup(@org.testng.annotations.Optional("browser") String browser){
        launchApp(browser);
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
    @Test
    public void addAddress(String productName, String qty, String size) throws Throwable {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(size);
        addToCartPage.enterQuantity(qty);
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckOut();
        orderPage.clickOnCheckOut();
        boolean result = addressPage.verifyAddressTitle();
        Assert.assertTrue(result);
    }
    @Test
    public void addAddress(HashMap<String, String> hashMapValue) throws Throwable {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct(hashMapValue.get("ProductName"));
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(hashMapValue.get("Size"));
        addToCartPage.enterQuantity(hashMapValue.get("Quantity"));
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckOut();
        orderPage.clickOnCheckOut();
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
        shippingPage.clickOnProceedToCheckOut();
        paymentPage.clickCheckBox();
        paymentPage.clickOnPaymentMethod();
        paymentPage.clickPayment();

    }

}
