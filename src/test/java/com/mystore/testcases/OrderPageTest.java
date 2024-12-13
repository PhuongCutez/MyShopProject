package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OrderPageTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
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
    public void verifyTotalPrice(String productName, String qty, String size) throws Throwable {
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(size);
        addToCartPage.enterQuantity(qty);
        addToCartPage.clickOnAddToCart();
        orderPage = addToCartPage.clickOnCheckOut();
        Double unitPrice = orderPage.getUnitPrice();
        Double totalPrice = orderPage.getTotalPrice();
        Double totalExpectedPrice = (unitPrice*(Double.parseDouble(qty))) + 2;
        Assert.assertEquals(totalPrice, totalExpectedPrice);
    }

}
