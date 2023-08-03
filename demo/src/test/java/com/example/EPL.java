package com.example;

import java.time.Duration;
import java.util.List;

import javax.swing.text.html.parser.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

public class EPL {

    public WebDriver driver;    /* driver is the Chrome, gagamitin na browser for testing */
    public WebDriverWait wait;
    
    ExtentSparkReporter spark = new ExtentSparkReporter("Report.html");
    ExtentReports extent = new ExtentReports();

    private EPLElements elements;

    String URL_EPL = "https://test-webapi.tlpe.io/transaction/pay?token=Bearer%20eyJhbGciOiJIUzI1NiJ9.eyJwYXlsb2FkIjoiZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKc2FXNXJTV1FpT2lJd016TXdOV0ZpTVMxa1pUUTNMVFE0WWpndE9URmpZeTAxT0RJek5EQmtPR0l6T0RnaWZRLktGbHA3V1Z0SF9xdVdyQkwyUEdZamZ5YWJ5SVpZR3BhSDZ3akhsS1M0dlEiLCJ0eXBlIjoiU1RBVElDIiwia2V5IjoiTUZ3d0RRWUpLb1pJaHZjTkFRRUJCUUFEU3dBd1NBSkJBSTZGOTMyV1lGajZtQWd0SGp3bGlTY0h0SjBwb0lGNkY1d0FSTTE1dHdyemQzaUtmRkJHelJDWUxnQ2JDOWJXd3V0eXgrcW1TaVNRUXR2Uk8rQnJTLzBDQXdFQUFRPT0ifQ.MgLSXublBeDymaUnYyKt-TunqBEM91inQwpZs8AZyGc";

    @BeforeTest
    public void SetUp() {
        extent.attachReporter(spark);


        System.getProperty("webdriver.chrome.driver", "D:\\Documents\\[UP DOCUMENTS]\\[INTERNSHIP]\\AltPayNet\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_EPL); // i-aaccess nya yung link

        elements = new EPLElements(driver);
    }

    /* @Test (priority = 0)
    public void TLPEAPI_OPP_01() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_01 - Unsuccessful transaction due to empty required fields");
        // wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        test.log(
            elements.amount.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.amount.isDisplayed() ? "Transaction Details page is accessible" : "Transaction Details page is not visible"
        );

        elements.nextBtn.click();
        
        for (int i = 0; i < elements.errorList.size(); i++) {
            test.log(
                elements.errorList.get(i).isDisplayed() ? Status.PASS : Status.FAIL,
                elements.errorList.get(i).isDisplayed() ? "Error in " + elements.errorNames.get(i) + " is visible" : "Error " + elements.errorNames.get(i) + " is not visible"
            );
        }
    } */

    @Test (priority = 1)
    public void TLPEAPI_OPP_02() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_02 - Successful transaction due to correct inputs on all fields");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        test.log(
            elements.amount.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.amount.isDisplayed() ? "Transaction Details page is accessible" : "Transaction Details page is not visible"
        );

        elements.amount.sendKeys("500000"); // This is 5,000 pesos since the field accounts for the two decimal values
        
        elements.currencyDropdown.click();
        elements.currencyField.sendKeys("PHP - Philippine Peso", Keys.ENTER);
        
        elements.paymentDescription.sendKeys("TEST");

        elements.cardOptionBtn.click();
        
        wait.until(ExpectedConditions.visibilityOf(elements.visaBtn));
        elements.visaBtn.click();

        elements.firstName.sendKeys("Renmar");
        elements.lastName.sendKeys("Lescano");
        elements.emailAddress.sendKeys("renmar.lescano@altpaynet.com");

        elements.mobileNumberCountryCode.click();
        elements.mobileNumberCountryCode.sendKeys("+63", Keys.ENTER);
    }
    

    @AfterTest
    public void AT(){
        extent.flush();
    }
}

// Test for Happy path and Validation Testing
// Happy Path is parang hardcoding, may specific test data (i.e. known inputs) lang nga gina test. Testcases are executed under expected conditions.
// GCash - Mynt
// Minsan sa ibang payments, required ang Address Line
// Sa Confirm Payment, amuni ang test card: 4111 1111 1111 1111
// Always advance dapat ang Expiry Date
// https://test-webapi.tlpe.io/transaction/pay?token=Bearer%20eyJhbGciOiJIUzI1NiJ9.eyJwYXlsb2FkIjoiZXlKaGJHY2lPaUpJVXpJMU5pSjkuZXlKc2FXNXJTV1FpT2lJd016TXdOV0ZpTVMxa1pUUTNMVFE0WWpndE9URmpZeTAxT0RJek5EQmtPR0l6T0RnaWZRLktGbHA3V1Z0SF9xdVdyQkwyUEdZamZ5YWJ5SVpZR3BhSDZ3akhsS1M0dlEiLCJ0eXBlIjoiU1RBVElDIiwia2V5IjoiTUZ3d0RRWUpLb1pJaHZjTkFRRUJCUUFEU3dBd1NBSkJBSTZGOTMyV1lGajZtQWd0SGp3bGlTY0h0SjBwb0lGNkY1d0FSTTE1dHdyemQzaUtmRkJHelJDWUxnQ2JDOWJXd3V0eXgrcW1TaVNRUXR2Uk8rQnJTLzBDQXdFQUFRPT0ifQ.MgLSXublBeDymaUnYyKt-TunqBEM91inQwpZs8AZyGc
// TLPEAPI_OPP_01
// Another class for the process, bawat intergration separate class like the OPP, iba naman sa MYNT
