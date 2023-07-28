package com.example;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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

public class test1 {
    public WebDriver driver;    /* driver is the Chrome, gagamitin na browser for testing */
    public WebDriverWait wait;

    ExtentSparkReporter spark = new ExtentSparkReporter("Report.html");
    ExtentReports extent = new ExtentReports();

    @BeforeTest
    public void SetUp() {
        extent.attachReporter(spark);

        System.getProperty("webdriver.chrome.driver", "D:\\Documents\\[UP DOCUMENTS]\\[INTERNSHIP]\\AltPayNet\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form"); // i-aaccess nya yung url
    }
    
    @Test (priority = 1)
    public void TLPETC_AC_001() {
        ExtentTest test = extent.createTest("TLPETC_AC_001 - Unsuccessful login due to empty username and password fields");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10 seconds hulton si username mag load

        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
        if (firstName.isDisplayed()) {
            test.log(Status.PASS, "First Name field is visible");
        }
        else {
            test.log(Status.FAIL, "First Name field is not visible");
        }

        if (firstName.isEnabled()) {
            test.log(Status.PASS, "First Name field is enabled");
        }
        else {
            test.log(Status.FAIL, "First Name field is disabled");
        }

        
        
        firstName.sendKeys("Renmar");


        WebElement submitBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='submit']")));

        submitBtn.click();
        if (submitBtn.isEnabled()) {
            test.log(Status.PASS, "Submit is enabled");
        }
        else {
            test.log(Status.FAIL, "Submit is disabled");
        }

        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));
        if (email.isDisplayed()) {
            test.log(Status.PASS, "Submit is enabled");
        }
        else {
            test.log(Status.FAIL, "Submit is disabled");
        }



        /* WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lastName']")));
        WebElement email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userEmail']")));
        WebElement maleBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Male')]")));
        WebElement mobileNumber = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userNumber']")));
        
        firstName.sendKeys("Renmar");
        lastName.sendKeys("Lescano");
        email.sendKeys("rlescano1234@gmail.com");
        maleBtn.click();
        mobileNumber.sendKeys("01234567890");
        
        WebElement calendar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='dateOfBirthInput']")));
        calendar.click();
        
        WebElement cMonth = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/select[1]")));
        WebElement cYear = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/form[1]/div[5]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/select[1]")));
        cMonth.sendKeys("November");
        cYear.sendKeys("2000");
        
        WebElement cDay = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'21')]")));
        cDay.click();

        WebElement subjects = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='subjectsInput']")));
        WebElement hobbies = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Sports')]")));
        WebElement pictureBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='uploadPicture']")));
        WebElement address = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@id='currentAddress']")));
        // WebElement selectState = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Select State')]")));
        // WebElement stateNCR = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'NCR')]")));
        
        subjects.sendKeys("CMSC195, CMSC192");
        hobbies.click();
        pictureBtn.sendKeys("D:\\Desktop\\Project - AltPayNet\\sample.jpg");
        address.sendKeys("St. Francis Nature Villages, Barangay 5");
        // selectState.click();
        // stateNCR.sendKeys("NCR");

 */

    }

    @AfterTest
    public void AT(){
        extent.flush();
    }
}
