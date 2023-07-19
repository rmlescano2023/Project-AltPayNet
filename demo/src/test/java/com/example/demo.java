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

public class demo {
    public WebDriver driver;    /* driver is the Chrome, gagamitin na browser for testing */
    public WebDriverWait wait;

    /* @Test (priority = 0)    // declare this method as the first priority of testing, with priority = 0
    public void testFirst() {
        System.getProperty("webdriver.chrome.driver", "D:\\Documents\\[UP DOCUMENTS]\\[INTERNSHIP]\\AltPayNet\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/login"); // i-aaccess nya yung url
    }

    @Test (priority = 1)
    public void login() {
        // webelement is ang i access mo na mga elements sa website
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10 seconds hulton si username mag load
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        WebElement loginbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='login']")));

        username.sendKeys("testUsername");
        password.sendKeys("testPassword");
        loginbtn.click();

        driver.quit();
    }

    @Test (priority = 2)    // declare this method as the first priority of testing, with priority = 0
    public void testSecond() {
        System.getProperty("webdriver.chrome.driver", "D:\\Documents\\[UP DOCUMENTS]\\[INTERNSHIP]\\AltPayNet\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/register"); // i-aaccess nya yung url
    }

    @Test (priority = 3)
    public void register() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10 seconds hulton si username mag load
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstname']")));
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lastname']")));
        WebElement username = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='userName']")));
        WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']")));
        // WebElement registerBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='register']")));
        
        firstName.sendKeys("Renmar");
        lastName.sendKeys("Lescano");
        username.sendKeys("rlescano");
        password.sendKeys("Br@veheart1");
        
        //driver.quit();
    } */

    @Test (priority = 4)    // declare this method as the first priority of testing, with priority = 0
    public void testThird() {
        System.getProperty("webdriver.chrome.driver", "D:\\Documents\\[UP DOCUMENTS]\\[INTERNSHIP]\\AltPayNet\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/automation-practice-form"); // i-aaccess nya yung url
    }
    
    @Test (priority = 5)
    public void practiceForm() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));   // 10 seconds hulton si username mag load
        WebElement firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='firstName']")));
        WebElement lastName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='lastName']")));
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


        // test changes

    }
}

// task for today is to register and then try logging in
// https://demoqa.com/register
// https://demoqa.com/automation-practice-form
// different classes yung register and automation practice form

// read this: https://toolsqa.com/selenium-webdriver/selenium-tutorial/