package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.CartPage;
import com.juaracoding.pages.HomePage;
import com.juaracoding.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class AddCart {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private CartPage cartPage;
    private String username;
    private String password;

    @BeforeClass
    @Parameters({"URL","Browser"})
    public void setUp(String URL,String Browser){
        DriverSingleton.getInstance(Browser);
        driver = DriverSingleton.getDriver();
        driver.get(URL);
        loginPage = new LoginPage();
        homePage = new HomePage();
        cartPage = new CartPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.closeObjectInstance();
    }

    @Test(priority = 1)
    public void loginUser(){
        username = "standard_user";
        password = "secret_sauce";
        loginPage.login(username, password);
    }
    @Test(priority = 2)
    public void sortingProductByHighestPrice(){
        homePage.sortingProduct("Price (high to low)");
        Assert.assertEquals(homePage.getFirstPrice(),"$49.99");
    }
    @Test(priority = 3)
    public void sortingProductByLowestPrice(){
        homePage.sortingProduct("Price (low to high)");
        Assert.assertEquals(homePage.getFirstPrice(),"$7.99");
    }
    @Test(priority = 4)
    public void sortingProductByNameAscending(){
        homePage.sortingProduct("Name (Z to A)");
        Assert.assertEquals(homePage.getFirstProductName(),"Test.allTheThings() T-Shirt (Red)");
    }
    @Test(priority = 5)
    public void sortingProductByNameDescending(){
        homePage.sortingProduct("Name (A to Z)");
        Assert.assertEquals(homePage.getFirstProductName(),"Sauce Labs Backpack");
    }

    @Test(priority = 7)
    public void addBackpack(){
        String backPackPrice = homePage.getBackPackPrice();
        homePage.addBackpack();
        homePage.klikCart();
        String confirmBackPackPrice = cartPage.getBackPackPrice();
        Assert.assertEquals(backPackPrice,confirmBackPackPrice);
        cartPage.klikContinueShopping();
    }

    @Test(priority = 8)
    public void addBikeLight(){
        String bikeLightPrice = homePage.getBikeLightPrice();
        homePage.addBikeLight();
        homePage.klikCart();
        String confirmBikeLightPrice = cartPage.getBikeLightPrice();
        Assert.assertEquals(bikeLightPrice,confirmBikeLightPrice);
        cartPage.klikContinueShopping();
    }

    @Test(priority = 9)
    public void addTshirt(){
        String tShirtPrice = homePage.getTShirtPrice();
        homePage.addTShirt();
        homePage.klikCart();
        String confirmTshirtPrice = cartPage.getTShirtPrice();
        Assert.assertEquals(tShirtPrice,confirmTshirtPrice);
        cartPage.klikContinueShopping();
    }

    @Test(priority = 10)
    public void addJacket(){
        String jacketPrice = homePage.getJacketPrice();
        homePage.addJacket();
        homePage.klikCart();
        String confirmJacketPrice = cartPage.getJacketPrice();
        Assert.assertEquals(jacketPrice,confirmJacketPrice);
        cartPage.klikContinueShopping();
    }

    @Test(priority = 11)
    public void addOneSie(){
        String oneSiePrice = homePage.getOneSiePrice();
        homePage.addOneSie();
        homePage.klikCart();
        String confirmOneSiePrice = cartPage.getOneSiePrice();
        Assert.assertEquals(oneSiePrice,confirmOneSiePrice);
        cartPage.klikContinueShopping();
    }

    @Test(priority = 12)
    public void addRedTshirt(){
        String redTshirtPrice = homePage.getRedTshirtPrice();
        homePage.addRedTshirt();
        homePage.klikCart();
        String confirmredTshirtPrice = cartPage.getRedTshirtPrice();
        Assert.assertEquals(redTshirtPrice,confirmredTshirtPrice);
        //cartPage.klikContinueShopping();
    }
}
