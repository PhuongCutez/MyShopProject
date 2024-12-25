package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddToCartTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
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
    public void addToCartTest(String productName, String size, String qty) throws Throwable{
        Log.startTestCase("addToCartTest");
        indexPage = new IndexPage();
        getDriver().switchTo().frame("framelive");
        searchResultPage = indexPage.searchProduct(productName);
        Thread.sleep(3000);
        addToCartPage = searchResultPage.clickOnProduct();
        Thread.sleep(3000);
        addToCartPage.enterQuantity(qty);
        Thread.sleep(3000);
        addToCartPage.selectSize(size);
        Thread.sleep(3000);
        addToCartPage.clickOnAddToCart();
        boolean result = addToCartPage.validateAddtoCart();
        Assert.assertTrue(result);
        Log.endTestCase("addToCartTest");
    }
}
