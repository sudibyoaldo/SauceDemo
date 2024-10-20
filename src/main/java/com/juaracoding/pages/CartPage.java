package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.checkerframework.checker.signature.qual.FieldDescriptor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    private static WebDriver driver;

    public CartPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='continue-shopping']")
    private WebElement continueShopping;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkout;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
    private WebElement Backpack_price;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[2]")
    private WebElement BikeLight_price;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[3]")
    private WebElement TShirt_price;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[4]")
    private WebElement Jacket_price;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[5]")
    private WebElement Onesie_price;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[6]")
    private WebElement RedTShirt_price;

    public void klikContinueShopping(){
        continueShopping.click();
    }
    public void klikCheckout(){
        checkout.click();
    }
    public String getBackPackPrice(){
        return Backpack_price.getText();
    }
    public String getBikeLightPrice(){
        return BikeLight_price.getText();
    }
    public String getTShirtPrice(){
        return TShirt_price.getText();
    }
    public String getJacketPrice(){
        return Jacket_price.getText();
    }
    public String getOneSiePrice(){
        return Onesie_price.getText();
    }
    public String getRedTshirtPrice(){
        return RedTShirt_price.getText();
    }

}
