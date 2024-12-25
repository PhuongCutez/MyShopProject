
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.mystore.actiondriver.Action;
import com.mystore.base.BaseClass;

public class OrderPage extends BaseClass {

    Action action= new Action();

    @FindBy(xpath="//*[@id=\"main\"]/div/div[1]/div/div[2]/ul/li/div/div[2]/div[2]/div[2]/span")
    private WebElement unitPrice;

    @FindBy(xpath = "//*[@id=\"main\"]/div/div[2]/div[1]/div[1]/div[2]/div/span[2]")
    private WebElement totalPrice;

    @FindBy(xpath="//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a")
    private WebElement proceedToCheckOut;

    public OrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public double getUnitPrice() {
        String unitPrice1=unitPrice.getText();
        String unit=unitPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalUnitPrice=Double.parseDouble(unit);
        return finalUnitPrice/100;
    }

    public double getTotalPrice() {
        String totalPrice1=totalPrice.getText();
        String tot=totalPrice1.replaceAll("[^a-zA-Z0-9]","");
        double finalTotalPrice=Double.parseDouble(tot);
        return finalTotalPrice/100;
    }

    public AccountCreationPage clickOnCheckOut() throws Throwable {
        action.click(getDriver(), proceedToCheckOut);
        return new AccountCreationPage();
    }

}