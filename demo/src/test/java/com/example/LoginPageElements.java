package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageElements {

    public LoginPageElements(WebDriver driver) {
    }

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    public WebElement loginForm;

    @FindBy(xpath = "//button[@id='js-login-btn']")
    public WebElement loginBtn;

    @FindBy(xpath = "//body/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]")
    public WebElement error;

}
