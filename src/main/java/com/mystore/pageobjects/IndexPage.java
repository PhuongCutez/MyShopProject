package com.mystore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

    Action action= new Action();

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a")
    private WebElement signInBtn;

    @FindBy(xpath = "//*[@id=\"_desktop_logo\"]/a/img")
    private WebElement myStoreLogo;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/input[2]")
    private WebElement searchProductBox;


    public IndexPage() {
        PageFactory.initElements(driver, this);
    }

    public LoginPage clickOnSignIn() throws Throwable {
        action.fluentWait(driver, signInBtn, 10);
        action.click(driver, signInBtn);
        return new LoginPage();
    }

    public boolean validateLogo() throws Throwable {
        return action.isDisplayed(driver, myStoreLogo);
    }

    public String getMyStoreTitle() {
        String myStoreTitel=driver.getTitle();
        return myStoreTitel;
    }

    public SearchResultPage searchProduct(String productName) throws Throwable {
        action.type(searchProductBox, productName);
        searchProductBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        return new SearchResultPage();
    }



}