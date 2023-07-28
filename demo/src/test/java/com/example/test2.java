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

public class test2 {
    
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
        driver.get("https://test-app.tlpe.io/login"); // access the url

        elements = new TLPEElements(driver);
    }

    /* @Test (priority = 4)
    public void TLPETC_AC_004() {
        ExtentTest test = extent.createTest("TLPETC_AC_004 - Unsuccessful request to Forgot Password due to empty email");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10 seconds hulton si username mag load

        WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]"));
        forgotPassword.click();
        
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='btn-forgot-password']"));
        sendBtn.click();
        
        WebElement error = driver.findElement(By.xpath("//label[@id='email-error']"));
        String errorMessage  = error.getText();;
        String expectedText = "This field is required";

        test.log(
            errorMessage.contains(expectedText) ? Status.PASS : Status.FAIL,
            errorMessage.contains(expectedText) ? "Error prompt \"This field is required\" is visible" : "Error prompt \"This field is required\" is not visible"
        );

    }

    @Test (priority = 5)
    public void TLPETC_AC_005() {
        ExtentTest test = extent.createTest("TLPETC_AC_005 - Unsuccessful request to Forgot password due to invalid email");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10 seconds hulton si username mag load

        driver.get("https://test-app.tlpe.io/login");
        WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]"));
        forgotPassword.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='btn-forgot-password']"));

        email.sendKeys("test-email");
        sendBtn.click();

        WebElement error = driver.findElement(By.xpath("//label[@id='email-error']"));
        String errorMessage  = error.getText();;
        String expectedText = "Invalid email format";

        test.log(
            errorMessage.contains(expectedText) ? Status.PASS : Status.FAIL,
            errorMessage.contains(expectedText) ? "Error prompt \"Invalid email format\" is visible" : "Error prompt \"Invalid email format\" is not visible"
        );
    }

    @Test (priority = 6)
    public void TLPETC_AC_006() {
        ExtentTest test = extent.createTest("TLPETC_AC_006 - Unsuccessful request to Forgot Password due to unregistered email");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10 seconds hulton si username mag load

        driver.get("https://test-app.tlpe.io/login");
        WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]"));
        forgotPassword.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='btn-forgot-password']"));

        email.sendKeys("nonregisteredemail@gmail.com");
        sendBtn.click();

        WebElement error = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/span[1]")));
        String errorMessage  = error.getText();
        String expectedText = "Uh-oh! The email address provided is not registered";

        test.log(
            errorMessage.contains(expectedText) ? Status.PASS : Status.FAIL,
            errorMessage.contains(expectedText) ? "Error prompt \"Uh-oh! The email address provided is not registered\" is visible" : "Error prompt \"Uh-oh! The email address provided is not registered\" is not visible"
        );
    }

    @Test (priority = 7)
    public void TLPETC_AC_007() {
        ExtentTest test = extent.createTest("TLPETC_AC_007 - Successfully request to Forgot Password using valid email");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10 seconds hulton si username mag load

        driver.get("https://test-app.tlpe.io/login");
        WebElement forgotPassword = driver.findElement(By.xpath("//a[contains(text(),'Forgot password?')]"));
        forgotPassword.click();

        WebElement email = driver.findElement(By.xpath("//input[@id='email']"));
        WebElement sendBtn = driver.findElement(By.xpath("//button[@id='btn-forgot-password']"));
        WebElement backToLoginBtn = driver.findElement(By.xpath("//a[contains(text(),'Back To Login')]"));

        email.sendKeys("test@altpaynet.com");
        sendBtn.click();

        WebElement prompt = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/form[1]/div[1]/span[1]")));
        String promptText = prompt.getText();
        String expectedText = "All good! Email sent! Click the link in the email to reset your password.";

        test.log(
            promptText.contains(expectedText) ? Status.PASS : Status.FAIL,
            promptText.contains(expectedText) ? "Error prompt \"All good! Email sent! Click the link in the email to reset your password.\" is visible" : "Error prompt \"All good! Email sent! Click the link in the email to reset your password.\" is not visible"
        );

        backToLoginBtn.click();
    } */

}
