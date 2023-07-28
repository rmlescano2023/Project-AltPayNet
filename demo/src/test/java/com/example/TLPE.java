package com.example;

import java.time.Duration;
import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Navigation;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TLPE {

    public WebDriver driver;    /* driver is the Chrome, gagamitin na browser for testing */
    public WebDriverWait wait;
    
    ExtentSparkReporter spark = new ExtentSparkReporter("Report.html");
    ExtentReports extent = new ExtentReports();

    private TLPEElements elements;

    @BeforeTest
    public void SetUp() {
        extent.attachReporter(spark);

        System.getProperty("webdriver.chrome.driver", "D:\\Documents\\[UP DOCUMENTS]\\[INTERNSHIP]\\AltPayNet\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        // driver.get("https://test-app.tlpe.io/login"); // i-aaccess nya yung url

        elements = new TLPEElements(driver);
    }

    @Test (priority = 1)
    public void TLPETC_AC_001() {
        driver.get("https://test-app.tlpe.io/login");

        ExtentTest test = extent.createTest("TLPETC_AC_001 - Unsuccessful login due to empty username and password fields");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        test.log(
            elements.username.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.username.isDisplayed() ? "Login form is visible" : "Login form is not visible"
        );

        elements.loginBtn.click();
        String prompt = elements.blankError.getText();
        
        test.log(
            prompt.contains(elements.errorMessage1) ? Status.PASS : Status.FAIL,
            prompt.contains(elements.errorMessage1) ? "Error prompt \"This is required.\" is visible" : "Error prompt \"This is required.\" is not visible"
        );
    }

    @Test (priority = 2)
    public void TLPETC_AC_002() {
        driver.get("https://test-app.tlpe.io/login");

        ExtentTest test = extent.createTest("TLPETC_AC_002 - Unsuccessful login due to invalid username and password");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        test.log(
            elements.username.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.username.isDisplayed() ? "Username field is visible" : "Username field is not visible"
        );

        test.log(
            elements.password.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.password.isDisplayed() ? "Password field is visible" : "Password field is not visible"
        );

        elements.username.sendKeys("testaltpaynet");
        elements.password.sendKeys("wrongpassword");

        elements.loginBtn.click();
        String prompt = elements.invalidError.getText();

        test.log(
            prompt.contains(elements.errorMessage2) ? Status.PASS : Status.FAIL,
            prompt.contains(elements.errorMessage2) ? "Error prompt \"Invalid username or password\" is visible" : "Error prompt \"Invalid username or password\" is not visible"
        );
    }

    @Test (priority = 3)
    public void TLPETC_AC_003() {
        driver.get("https://test-app.tlpe.io/login");

        ExtentTest test = extent.createTest("TLPETC_AC_003 - Unsuccessful login due to reaching maximum attempt of incorrect password");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        test.log(
            elements.username.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.username.isDisplayed() ? "Username field is visible" : "Username field is not visible"
        );

        test.log(
            elements.password.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.password.isDisplayed() ? "Password field is visible" : "Password field is not visible"
        );
        
        for (int i = 0; i < 4; i++) {
            elements.username.clear();
            elements.password.clear();

            elements.username.sendKeys("renmar.lescano@altpaynet.com");
            elements.password.sendKeys("wrongpassword");
            elements.loginBtn.click();

            String prompt = elements.invalidError.getText();

            if (i != 3) {
                test.log(
                    prompt.contains(elements.errorMessage2) ? Status.PASS : Status.FAIL,
                    prompt.contains(elements.errorMessage2) ? "Error prompt \"Invalid username or password\" is visible" : "Error prompt \"Invalid username or password\" is not visible"
                );
            }
            else {
                test.log(
                    prompt.contains(elements.errorMessage3) ? Status.PASS : Status.FAIL,
                    prompt.contains(elements.errorMessage3) ? 
                        "Error prompt \"Your account is locked due to multiple failed attempts. Account will be unlocked after 15 minutes or contact the administrator.\" is visible" : 
                        "Error prompt \"Your account is locked due to multiple failed attempts. Account will be unlocked after 15 minutes or contact the administrator.\" is not visible"
                );
            }
        }
    }

    @AfterTest
    public void AT(){
        extent.flush();
    }
}
