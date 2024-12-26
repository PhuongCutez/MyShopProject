package com.mystore.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IndexPage extends BaseClass {

    Action action= new Action();

    @FindBy(xpath = "//*[@id=\"_desktop_user_info\"]/div/a")
    private WebElement signInBtn;

    @FindBy(className = "img-fluid")
    private WebElement myStoreLogo;

    @FindBy(xpath = "//*[@id=\"search_widget\"]/form/input[2]")
    private WebElement searchProductBox;


    public IndexPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public LoginPage clickOnSignIn() throws Throwable {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(signInBtn));
        action.click(getDriver(), signInBtn);
        return new LoginPage();
    }

    public boolean validateLogo() throws Throwable {
        return action.isDisplayed(getDriver(), myStoreLogo);
    }

    public String getMyStoreTitle() {
        String myStoreTitel=getDriver().getTitle();
        return myStoreTitel;
    }

    public SearchResultPage searchProduct(String productName) throws Throwable {
        Thread.sleep(3000);
        action.type(searchProductBox, productName);
        Thread.sleep(3000);
        searchProductBox.sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        return new SearchResultPage();
    }



}