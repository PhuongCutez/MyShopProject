
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class SearchResultPage extends BaseClass {

    Action action= new Action();

    @FindBy(xpath="//*[@id=\"js-product-list\"]/div[1]/div/article/div/div[1]/a/picture/img")
    private WebElement productResult;

    public SearchResultPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean isProductAvailable() throws Throwable {
        return action.isDisplayed(driver, productResult);
    }

    public AddToCartPage clickOnProduct() throws Throwable {
        action.click(driver, productResult);
        return new AddToCartPage();
    }

}