package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class AddToCartPageTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    private AddToCartPage addToCartPage;
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("browser") String browser){
        launchApp(browser);
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
    @Test
    public void addToCartTest(String productName, String size, String qty) throws Throwable{
        indexPage = new IndexPage();
        searchResultPage = indexPage.searchProduct(productName);
        addToCartPage = searchResultPage.clickOnProduct();
        addToCartPage.selectSize(size);
        addToCartPage.enterQuantity(qty);
        addToCartPage.clickOnAddToCart();
        boolean result = addToCartPage.validateAddtoCart();
        Assert.assertTrue(result);
    }
}
