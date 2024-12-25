package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

public class OrderPageTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    private OrderPage orderPage;
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
    public void verifyTotalPrice(String productName, String size, String qty) throws Throwable {
        Log.startTestCase("verifyTotalPrice");
        indexPage = new IndexPage();
        getDriver().switchTo().frame("framelive");
        searchResultPage = indexPage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(size);
        addToCartPage.enterQuantity(qty);
        addToCartPage.clickOnAddToCart();
        Thread.sleep(2000);
        orderPage = addToCartPage.clickOnCheckOut();
        Thread.sleep(2000);
        Double unitPrice = orderPage.getUnitPrice();
        Thread.sleep(2000);
        Double totalPrice = orderPage.getTotalPrice();
        Thread.sleep(2000);
        Double totalExpectedPrice = (unitPrice*(Double.parseDouble(qty))) + 0.02;
        Assert.assertEquals(totalPrice, totalExpectedPrice, 0.1);
        Log.endTestCase("verifyTotalPrice");
    }

}
