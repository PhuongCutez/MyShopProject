
package com.mystore.pageobjects;

import com.mystore.utility.Log;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class AddToCartPage extends BaseClass {

    Action action= new Action();

    @FindBy(id="group_1")
    private WebElement size;

    @FindBy(id="quantity_wanted")
    private WebElement quantity;


    @FindBy(xpath = "//*[@id=\"add-to-cart-or-refresh\"]/div[2]/div/div[2]/button")
    private WebElement addToCartBtn;

    @FindBy(xpath="//*[@id=\"myModalLabel\"]/i")
    private WebElement addToCartMessag;

    @FindBy(xpath="//*[@id=\"blockcart-modal\"]/div/div/div[2]/div/div[2]/div/div/a")
    private WebElement proceedToCheckOutBtn;

    public AddToCartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void selectSize(String size1) throws Throwable {
        action.selectByVisibleText(size1, size);
    }

    public void enterQuantity(String quantity1) throws Throwable {
        action.fluentWait(getDriver(), quantity, 10);
        quantity.click(); // Click vào ô nhập liệu
        quantity.clear(); // Xóa giá trị hiện tại (nếu có)
        quantity.sendKeys(Keys.CONTROL + "a"); // Chọn toàn bộ giá trị
        quantity.sendKeys(Keys.BACK_SPACE); // Xóa toàn bộ giá trị

        action.type(quantity, quantity1);
    }

    public void clickOnAddToCart() throws Throwable {
        action.click(getDriver(), addToCartBtn);
    }

    public boolean validateAddtoCart() throws Throwable {
        action.fluentWait(getDriver(), addToCartMessag, 10);
        return action.isDisplayed(getDriver(), addToCartMessag);
    }

    public OrderPage clickOnCheckOut() throws Throwable {
        action.fluentWait(getDriver(), proceedToCheckOutBtn, 10);
        action.JSClick(getDriver(), proceedToCheckOutBtn);
        return new OrderPage();
    }

}