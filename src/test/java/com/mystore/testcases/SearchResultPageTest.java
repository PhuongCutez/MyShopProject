package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.utility.Log;
import org.testng.Assert;
import org.testng.annotations.*;

public class SearchResultPageTest extends BaseClass {
    private IndexPage indexPage;
    private SearchResultPage searchResultPage;
    @Parameters("browser")
    @BeforeMethod
    public void setup(@Optional("chrome") String browser){
        launchApp(browser);
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }
    @Test(dataProvider = "searchProduct", dataProviderClass = DataProviders.class)
    public void productAvailabilityTest(String productName) throws Throwable {
        Log.startTestCase("productAvailabilityTest");
       indexPage = new IndexPage();
       getDriver().switchTo().frame("framelive");
         searchResultPage = indexPage.searchProduct(productName);
         Thread.sleep(3000);
            boolean result = searchResultPage.isProductAvailable();
        Assert.assertTrue(result);
        Log.endTestCase("productAvailabilityTest");

    }
}
