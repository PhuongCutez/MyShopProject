package com.mystore.testcases;

import com.mystore.base.BaseClass;
import com.mystore.pageobjects.IndexPage;
import org.testng.Assert;
import org.testng.annotations.*;

public class IndexPageTest extends BaseClass {
    private IndexPage indexPage;
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
    public void verifyLogo() throws Throwable {
        indexPage = new IndexPage();
        boolean result = indexPage.validateLogo();
        Assert.assertTrue(result);
    }
    @Test
    public void verifyTitle() throws Throwable {
        String title = indexPage.getMyStoreTitle();
        Assert.assertEquals(title, "PrestaShop Live Demo");
    }

}
