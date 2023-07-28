package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TLPEElements {

    private final WebDriver driver;

    public TLPEElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 
    }

    @FindBy(xpath = "//input[@id='email']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@id='js-login-btn']")
    public WebElement loginBtn;

    @FindBy(xpath = "//a[contains(text(),'Forgot password?')]")
    public WebElement forgotPasswordBtn;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]")
    public WebElement blankError;

    @FindBy(xpath = "//div[contains(text(),'Invalid username or password')]")
    public WebElement invalidError;

    public String errorMessage1 = "This is required.";
    public String errorMessage2 = "Invalid username or password";
    public String errorMessage3 = "Your account is locked due to multiple failed attempts. Account will be unlocked after 15 minutes or contact the administrator.";



}
