package com.juaracoding.pages;

import com.juaracoding.drivers.DriverSingleton;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.Key;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(){
        this.driver = DriverSingleton.getDriver();
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement password;

    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement loginBtn;

    @FindBy(xpath = "//button[@class='error-button']")
    private WebElement clearBtnError;

    @FindBy(xpath = "//h3[@data-test='error']")
    private WebElement txtError;

    @FindBy(xpath = "//div[@class='login_logo']")
    private WebElement attrLoginLogo;


    public void login(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        loginBtn.click();
    }

    public String getTxtError(){
        return txtError.getText();
    }

    //get attribute
    public String getAttributeLoginLogo(){
        return attrLoginLogo.getAttribute("class");
    }

    public void clearBtnError(){
        clearBtnError.click();
    }
    public void clearPage(){
        this.username.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
        this.password.sendKeys(Keys.CONTROL, "a", Keys.BACK_SPACE);
    }
}
