package com.juaracoding;

import com.juaracoding.drivers.DriverSingleton;
import com.juaracoding.pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import com.juaracoding.pages.LoginPage;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private HomePage homePage;
    private String username;
    private String password;

    @BeforeClass
    @Parameters({"URL","Browser"})
    public void setUp(String URL,String Browser){
        DriverSingleton.getInstance(Browser);
        driver = DriverSingleton.getDriver();
        driver.get(URL);
        loginPage = new LoginPage();
    }

    @AfterClass
    public void finish(){
        DriverSingleton.closeObjectInstance();
    }

    @BeforeMethod()
    public void initiateForm(){
        username="";
        password="";
        loginPage.clearPage();
    }

    @Test(priority = 1)
    public void testLoginEmptyUserNameAndPassword(){
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getTxtError(), "Epic sadface: Username is required");
        loginPage.clearBtnError();
    }
    @Test(priority = 2)
    public void testLoginEmptyPassword(){
        username = "EmptyPassword";
        password = "";
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getTxtError(), "Epic sadface: Password is required");
        loginPage.clearBtnError();
    }
    @Test(priority = 3)
    public void testLoginEmptyUserName(){
        username = "";
        password = "EmptyUsername";
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getTxtError(), "Epic sadface: Username is required");
        loginPage.clearBtnError();
    }
    @Test(priority = 4)
    public void testLoginInvalidUsername(){
        username = "InvalidUsername";
        password = "secret_sauce";
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getTxtError(), "Epic sadface: Username and password do not match any user in this service");
        loginPage.clearBtnError();
    }
    @Test(priority = 5)
    public void testLoginInvalidPassword(){
        username = "standard_user";
        password = "InvalidPassword";
        loginPage.login(username, password);
        Assert.assertEquals(loginPage.getTxtError(), "Epic sadface: Username and password do not match any user in this service");
        loginPage.clearBtnError();
    }
    @Test(priority = 6)
    public void testLoginValid(){
        username = "standard_user";
        password = "secret_sauce";
        loginPage.login(username, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
    }
}
