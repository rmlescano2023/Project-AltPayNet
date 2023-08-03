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

    // Essential Functions ----------------------------------------------------------------------------------------------------------------------------------------- START
    public void transactionDetailsPageHappyPath() {

        // wait = new WebDriverWait(driver, Duration.ofSeconds(20));    // Test out if this is necessary to be included in this function

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
        elements.countryCodePH.click();
        elements.mobileNumber.sendKeys("9455179898");
        elements.addressLine1.sendKeys("TEST");
        elements.addressLine2.sendKeys("TEST");
        elements.cityMunicipalityLocality.sendKeys("Silay City");
        elements.zipCode.sendKeys("6116");
        elements.stateProvinceRegion.sendKeys("Negros Occidental");
        elements.countryDropdown.click();
        elements.countryField.sendKeys("PH - Philippines", Keys.ENTER);
    }

    public void confirmPaymentPageHappyPath() {

        // wait = new WebDriverWait(driver, Duration.ofSeconds(20));    // Test out if this is necessary to be included in this function

        elements.cardNumber.sendKeys("4111111111111111");
        elements.cardholderName.sendKeys("Renmar Lescano");
        elements.expiryDate.sendKeys("1226");
        elements.CVV.sendKeys("123");
    }

    // Create a function containing ang error checker, looping through all errors in the Error List, and returns the index of that error if it is visible
    // ...

    // Essential Functions ----------------------------------------------------------------------------------------------------------------------------------------- END

    @Test (priority = 0)
    public void TLPEAPI_OPP_01() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_01 - Unsuccessful transaction due to empty required fields");

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

        driver.quit();
    }

    @Test (priority = 1)
    public void TLPEAPI_OPP_02() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_02 - Successful transaction due to correct inputs on all fields in Transaction Details page");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Check if Transaction Details page is accessible
        test.log(
            elements.amount.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.amount.isDisplayed() ? "Transaction Details page is accessible" : "Transaction Details page is not accessible"
        );

        // Actual test
        transactionDetailsPageHappyPath();
        elements.nextBtn.click();

        // Check if there are any errors from the required fields
        boolean existingError = false;
        for (int i = 0; i < elements.errorList.size(); i++) {
            if (elements.errorList.get(i).isDisplayed()) {
                test.log(Status.FAIL, "Error in " + elements.errorNames.get(i) + " is visible");
                existingError = true;
            } else {
                test.log(Status.PASS, "Error " + elements.errorNames.get(i) + " is not visible");
            }
        }

        // Check if redirection to the Confirm Payment page is successful
        if (existingError == false) {
            test.log(
                elements.cardNumber.isDisplayed() ? Status.PASS : Status.FAIL,
                elements.cardNumber.isDisplayed() ? "Redirection to Confirm Payment page was successful" : "Redirection to Confirm Payment page was unsuccessful"
            );
        }
        
        driver.quit();
    }

    @Test (priority = 2)
    public void TLPEAPI_OPP_03() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_03 - Successful transaction due to correct inputs on all fields in Confirm Payment page");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to input all correct values on the Transaction Details page  so we can proceed to the Confirm Payment page
        transactionDetailsPageHappyPath();
        elements.nextBtn.click();

        // Check if Confirm Payment page is accessible
        test.log(
            elements.cardNumber.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.cardNumber.isDisplayed() ? "Confirm Payment page is accessible" : "Confirm Payment page is not accessible"
        );

        // Actual test
        elements.cardNumber.sendKeys("4111111111111111");
        elements.cardholderName.sendKeys("Renmar Lescano");
        elements.expiryDate.sendKeys("1226");
        elements.CVV.sendKeys("123");
        elements.submitPaymentBtn.click();

        // Check if 3DS Simulator page is visible
        test.log(
            elements.authenticationDropdown.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.authenticationDropdown.isDisplayed() ? "3DS Simulator page is visible" : "3DS Simulator page is not visible"
        );
    }

    @Test (priority = 3)
    public void TLPEAPI_OPP_04() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_04 - Successful transaction due to correct inputs on all fields in 3DS Simulator page");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call these functions to input all correct values on the Transaction Details page and Confirm Payment page so we can proceed to the 3DS Simulator page
        transactionDetailsPageHappyPath();
        elements.nextBtn.click();
        confirmPaymentPageHappyPath();
        elements.submitPaymentBtn.click();

        // Check if 3DS Simulator page is accessible
        test.log(
            elements.authenticationDropdown.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.authenticationDropdown.isDisplayed() ? "3DS Simulator page is accessible" : "3DS Simulator page is not accessible"
        );

        // Actual test
        elements.submitAuthenticationBtn.click();
        
        // Payment Result page
        wait.until(ExpectedConditions.visibilityOf(elements.paymentResult));
        test.log(
            elements.paymentResult.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.paymentResult.isDisplayed() ? "Payment Result page is visible" : "Payment Result page is not visible"
        );
    }

    @Test (priority = 4)
    public void TLPEAPI_OPP_05() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_03 - Validation testing on Amount field");
        String testData = "aaaaa";

        test.log(
            elements.amount.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.amount.isDisplayed() ? "Transaction Details page is accessible" : "Transaction Details page is not accessible"
        );

        TLPEAPI_OPP_02();   // Call function TLPEAPI_OPP_02 to input all correct values on the Transaction Details page

        elements.amount.sendKeys(testData);
        elements.amount.getText();
        test.log(
            elements.amount.getText().equals(testData) ? Status.FAIL : Status.PASS,
            elements.amount.getText().equals(testData) ? "Amount field accepted non-numeric characters" : "Amount field did not accept non-numeric characters"
        );
    }

    @Test (priority = 5)
    public void TLPEAPI_OPP_06() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_04 - Validation testing on Description of Payment field");
        String testData = "askdjaAKJSDN 12344 @#$%^";

        test.log(
            elements.paymentDescription.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.paymentDescription.isDisplayed() ? "Transaction Details page is accessible" : "Transaction Details page is not accessible"
        );

        elements.paymentDescription.sendKeys(testData);
        elements.paymentDescription.getText();
        test.log(
            elements.paymentDescription.getText().equals(testData) ? Status.PASS : Status.FAIL,
            elements.paymentDescription.getText().equals(testData) ? "Payment Description field accepted alphanumeric and special characters" : "Payment Description field did not accept alphanumeric and special characters"
        );
    }

    @Test (priority = 6)
    public void TLPEAPI_OPP_07() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_05 - Validation testing on First Name and Last Name fields");
        String testData1 = "TEST", testData2 = "0123", testData3 = "!@#$%";

        test.log(
            elements.firstName.isDisplayed() && elements.lastName.isDisplayed()? Status.PASS : Status.FAIL,
            elements.firstName.isDisplayed() && elements.lastName.isDisplayed()? "First Name and Last Name fields are visible" : "First Name and Last Name fields are visible"
        );

        elements.firstName.sendKeys(testData1);
        elements.lastName.sendKeys(testData1);
        elements.firstName.getText();
        elements.lastName.getText();
        test.log(
            elements.firstName.getText().equals(testData1) && elements.lastName.getText().equals(testData1)? Status.PASS : Status.FAIL,
            elements.firstName.getText().equals(testData1) && elements.lastName.getText().equals(testData1)? "First Name and Last Name fields accepted alphabetic characters" : "First Name and Last Name fields did not accept alphabetic characters"
        );

        
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
