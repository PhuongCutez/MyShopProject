/**
 *
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

/**
 * @author Hitendra
 *
 */
public class ShippingPage extends BaseClass {

    Action action= new Action();
    @FindBy(xpath="//*[@id=\"js-delivery\"]/button")
    private WebElement proceedToCheckOutBtn;

    public ShippingPage() {
        PageFactory.initElements(getDriver(), this);
    }


    public PaymentPage clickOnProceedToCheckOut() throws Throwable {
        action.click(driver, proceedToCheckOutBtn);
        return new PaymentPage();
    }

}