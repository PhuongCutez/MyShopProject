
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class PaymentPage extends BaseClass {
    Action action= new Action();
    @FindBy(xpath = "//*[@id=\"conditions_to_approve[terms-and-conditions]\"]")
    private WebElement agreeClick;
    @FindBy(xpath = "//*[@id=\"payment-confirmation\"]/div[1]/button")
    private WebElement paymentBtn;

    public PaymentPage() {
        PageFactory.initElements(driver, this);
    }

    public void clickOnPaymentMethod() throws Throwable {
        action.click(driver, agreeClick);
    }
    public void clickPayment() {
        action.click(driver, paymentBtn);
    }

}