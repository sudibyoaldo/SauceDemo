package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.domstorage.model.Item;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.List;

public class HomePage {
    private static WebDriver driver;

    public HomePage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='inventory_list']/div")
    private List<WebElement> ItemList;

    @FindBy(xpath = "//div[@class='app_logo']")
    private WebElement webLogo;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement cart;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement sorting;

    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement tabMenu;

    @FindBy(xpath = "//nav[@class='bm-item-list']/a[(text()='Logout')]")
    private WebElement logOutbtn;

    @FindBy(xpath = "(//div[@class='inventory_item_name '])[1]")
    private WebElement Backpack_ProductName;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement Backpack_addCartBtn;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[1]")
    private WebElement Backpack_price;

    @FindBy(xpath = "(//div[@class='inventory_item_name '])[2]")
    private WebElement BikeLight_ProductName;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement BikeLight_addCartBtn;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[2]")
    private WebElement BikeLight_price;

    @FindBy(xpath = "(//div[@class='inventory_item_name '])[3]")
    private WebElement TShirt_ProductName;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bolt-t-shirt']")
    private WebElement TShirt_addCartBtn;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[3]")
    private WebElement TShirt_price;

    @FindBy(xpath = "(//div[@class='inventory_item_name '])[4]")
    private WebElement Jacket_ProductName;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
    private WebElement Jacket_addCartBtn;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[4]")
    private WebElement Jacket_price;

    @FindBy(xpath = "(//div[@class='inventory_item_name '])[5]")
    private WebElement Onesie_ProductName;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement Onesie_addCartBtn;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[5]")
    private WebElement Onesie_price;

    @FindBy(xpath = "(//div[@class='inventory_item_name '])[6]")
    private WebElement RedTShirt_ProductName;

    @FindBy(xpath = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
    private WebElement RedTShirt_addCartBtn;

    @FindBy(xpath = "(//div[@class='inventory_item_price'])[6]")
    private WebElement RedTShirt_price;

    public void klikCart(){
        cart.click();
    }
    public String getTextWebLogo(){
        return webLogo.getText();
    }

    public void logout(){
        tabMenu.click();
        logOutbtn.click();
    }

    public void sortingProduct(String sortingOption){
        Select select = new Select(sorting);
        select.selectByVisibleText(sortingOption);
    }

    public String getFirstPrice(){
        return ItemList.get(1).findElement(By.xpath("//div[@class='inventory_item_price']")).getText();
    }

    public String getFirstProductName(){
        return ItemList.get(1).findElement(By.xpath("//div[@class='inventory_item_name ']")).getText();
    }

    public void addBackpack(){
        Backpack_addCartBtn.click();
    }
    public String getBackPackPrice(){
        return Backpack_price.getText();
    }

    public void addBikeLight(){
        BikeLight_addCartBtn.click();
    }
    public String getBikeLightPrice(){
        return BikeLight_price.getText();
    }

    public void addTShirt(){
        TShirt_addCartBtn.click();
    }
    public String getTShirtPrice(){
        return TShirt_price.getText();
    }

    public void addJacket(){
        Jacket_addCartBtn.click();
    }
    public String getJacketPrice(){
        return Jacket_price.getText();
    }

    public void addOneSie(){
        Onesie_addCartBtn.click();
    }
    public String getOneSiePrice(){
        return Onesie_price.getText();
    }

    public void addRedTshirt(){
        RedTShirt_addCartBtn.click();
    }
    public String getRedTshirtPrice(){
        return RedTShirt_price.getText();
    }

    public void addAllItems(){
        addBackpack();
        addBikeLight();
        addJacket();
        addOneSie();
        addRedTshirt();
        addTShirt();
    }

}
