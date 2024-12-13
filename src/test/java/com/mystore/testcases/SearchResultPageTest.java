package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SearchResultPageTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    @Parameters("browser")
    @BeforeMethod
    public void setup(String browser){
        launchApp(browser);
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
    @Test
    public void productAvailabilityTest(String productName) throws Throwable {
       indexPage = new IndexPage();
         searchResultPage = indexPage.searchProduct(productName);
            boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);

    }
}
