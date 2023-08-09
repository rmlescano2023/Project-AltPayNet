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
import org.openqa.selenium.NoSuchElementException;

import org.testng.ITestResult;
import org.testng.annotations.*;
import org.testng.Assert;
/* import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test; */

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

    // ESSENTIAL FUNCTIONS ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    
    // Happy Path for Transaction Details page
    public void transactionDetailsPageHappyPath() {

        // wait = new WebDriverWait(driver, Duration.ofSeconds(20));    // Test out if this is necessary to be included in this function

        elements.amount.sendKeys("500000"); // This is 5,000 pesos since the field accounts for the two decimal values
        elements.currencyDropdown.click();

        wait.until(ExpectedConditions.visibilityOf(elements.currencyField));

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

    // Happy Path for Confirm Payment page
    public void confirmPaymentPageHappyPath() {

        // wait = new WebDriverWait(driver, Duration.ofSeconds(20));    // Test out if this is necessary to be included in this function

        elements.cardNumber.sendKeys("4111111111111111");
        elements.cardholderName.sendKeys("Renmar Lescano");
        elements.expiryDate.sendKeys("1226");
        elements.CVV.sendKeys("123");
    }

    // Check if Transaction Page is accessible
    public void transactionDetailsPageAccessibility(ExtentTest test) {

        test.log(
            elements.amount.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.amount.isDisplayed() ? "Transaction Details page is accessible" : "Transaction Details page is not visible"
        );
    }

    // Check if Confirm Payment Page is accessible
    public void confirmPaymentPageAccessibility(ExtentTest test) {

        test.log(
            elements.cardNumber.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.cardNumber.isDisplayed() ? "Confirm Payment page is accessible" : "Confirm Payment page is not accessible"
        );
    }

    // Check if all Transaction Page WebElements are visible except: Currency field, Card option, VISA button, and Country field
    public void transactionDetailsPageWebElementsVisibility(ExtentTest test) {

        for (int i = 0; i < elements.transactionPageWebElements.size(); i++) {
            test.log(
                elements.transactionPageWebElements.get(i).isDisplayed() ? Status.PASS : Status.FAIL,
                elements.transactionPageWebElements.get(i).isDisplayed() ? "The " + elements.transactionPageWebElementNames.get(i) + " is visible" : "The " + elements.transactionPageWebElementNames.get(i) + " is not visible"
            );
        }
    }

    // Check if all Confirm Payment Page WebElements are visible except
    public void confirmPaymentPageWebElementsVisibility(ExtentTest test) {

        for (int i = 0; i < elements.confirmPaymentPageWebElements.size(); i++) {
            test.log(
                elements.confirmPaymentPageWebElements.get(i).isDisplayed() ? Status.PASS : Status.FAIL,
                elements.confirmPaymentPageWebElements.get(i).isDisplayed() ? "The " + elements.confirmPaymentPageWebElementNames.get(i) + " is visible" : "The " + elements.confirmPaymentPageWebElementNames.get(i) + " is not visible"
            );
        }
    }

    // Check if there are any existing error on the current page
    public boolean errorChecker(ExtentTest test) {
        boolean existingError = false;
    
        for (int i = 0; i < elements.errorList.size(); i++) {
            try {
                if (elements.errorList.get(i).isDisplayed()) {
                    test.log(Status.FAIL, "Error in " + elements.errorNames.get(i) + " is visible");
                    existingError = true;
                }
            } catch (NoSuchElementException e) {
                test.log(Status.PASS, "Error in " + elements.errorNames.get(i) + " is not visible");
            }
        }

        return existingError;
    }
    


    // TEST CASES ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- 
    /* @Test (priority = 0)    // OK
    public void TLPEAPI_OPP_01() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_01 - Unsuccessful transaction due to empty required fields");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Actual test
        elements.nextBtn.click();
        
        // Check if error prompts are visible (PASS if error is visible)
        for (int i = 0; i < elements.errorList.size(); i++) {
            test.log(
                elements.errorList.get(i).isDisplayed() ? Status.PASS : Status.FAIL,
                elements.errorList.get(i).isDisplayed() ? "Error in " + elements.errorNames.get(i) + " is visible" : "Error " + elements.errorNames.get(i) + " is not visible"
            );
        }
    }

    @Test (priority = 1)    // OK
    public void TLPEAPI_OPP_02() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_02 - Successful transaction due to correct inputs on all fields in Transaction Details page");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Call this function to check if all Transaction Page WebElements are visible except: Currency field, Card option, VISA button, and Country field
        transactionDetailsPageWebElementsVisibility(test);

        // Actual test
        transactionDetailsPageHappyPath();
        elements.nextBtn.click();

        // Check if there are any errors from the required fields
        boolean existingError = errorChecker(test);

        // Check if redirection to the Confirm Payment page is successful
        if (existingError == false) {
            test.log(
                elements.cardNumber.isDisplayed() ? Status.PASS : Status.FAIL,
                elements.cardNumber.isDisplayed() ? "Redirection to Confirm Payment page was successful" : "Redirection to Confirm Payment page was unsuccessful"
            );
        }        
    }

    @Test (priority = 2)    // OK
    public void TLPEAPI_OPP_03() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_03 - Successful transaction due to correct inputs on all fields in Confirm Payment page");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to input all correct values on the Transaction Details page so we can proceed to the Confirm Payment page
        transactionDetailsPageHappyPath();
        elements.nextBtn.click();

        // Call this function to check if Confirm Payment page is accessible
        confirmPaymentPageAccessibility(test);

        // Call this function to check if all Confirm Payment Page WebElements are visible
        confirmPaymentPageWebElementsVisibility(test);

        // Actual test
        confirmPaymentPageHappyPath();
        elements.submitPaymentBtn.click();

        // Check if redirection to the 3DS Simulator page is successful
        test.log(
            elements.authenticationDropdown.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.authenticationDropdown.isDisplayed() ? "Redirection to 3DS Simulator page was successful" : "Redirection to 3DS Simulator page was unsuccessful"
        );
    }

    @Test (priority = 3)    // OK
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

    @Test (priority = 4)    // OK
    public void TLPEAPI_OPP_05() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_05 - Validation testing on the Amount field by forcing invalid values");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        
        // String array for test data of alphabetic, numeric, and special characters
        String[] testDataArray = {"askdjaAKJSDN", "!@#$%"};
        String[] testDataCharacterTypeArray = {"Alphabetic characters", "Special characters"};

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        for (int i = 0; i < testDataArray.length; i++) {

            elements.amount.clear();
            elements.amount.sendKeys(testDataArray[i]);
            elements.amount.getText();
            test.log(
                elements.amount.getText().equals(testDataArray[i]) ? Status.FAIL : Status.PASS,
                elements.amount.getText().equals(testDataArray[i]) ? "Amount field accepted " + testDataCharacterTypeArray[i] : "Amount field did not accept " + testDataCharacterTypeArray[i]
            );
        }
    }

    @Test (priority = 5)    // OK
    public void TLPEAPI_OPP_06() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_06 - Test the selection of options in the Currency dropdown");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Check if the Currency dropdown is visible
        test.log(
            elements.currencyDropdown.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.currencyDropdown.isDisplayed() ? "Currency dropdown is visible" : "Currency dropdown is not visible"
        );

        // Actual Test
        transactionDetailsPageHappyPath();
        elements.nextBtn.click();
        test.log(
            elements.cardNumber.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.cardNumber.isDisplayed() ? "Selecting PHP - Philippine Peso currency was successful" : "Selecting PHP - Philippine Peso currency was unsuccessful"
        );

        driver.get(URL_EPL);
        transactionDetailsPageHappyPath();
        elements.currencyDropdown.click();
        elements.currencyField.sendKeys("ADP - Andorran Peseta", Keys.ENTER);
        elements.nextBtn.click();
        test.log(
            elements.cardOptionError.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.cardOptionError.isDisplayed() ? "Error prompt on selecting ADP - Andorran Peseta currency is visible" : "Error prompt on selecting ADP - Andorran Peseta currency is visible"
        );
    }

    @Test (priority = 6)    // OK
    public void TLPEAPI_OPP_07() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_07 - Validation testing on the Description of Payment field");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // String array for test data of alphabetic, numeric, and special characters
        String[] testDataArray = {"askdjaAKJSDN", "012345", "!@#$%"};
        String[] testDataCharacterTypeArray = {"Alphabetic characters", "Numeric characters", "Special characters"};

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Actual Test
        for (int i = 0; i < testDataArray.length; i++) {

            // Call this function to input all correct values on the Transaction Details page
            transactionDetailsPageHappyPath();
            elements.paymentDescription.clear();

            elements.paymentDescription.sendKeys(testDataArray[i]);
            elements.nextBtn.click();

            // Check if redirection to Confirm Payment page is successful, meaning the test data was accepted
            test.log(
                elements.cardNumber.isDisplayed() ? Status.PASS : Status.FAIL,
                elements.cardNumber.isDisplayed() ? "Payment Description field accepted " + testDataCharacterTypeArray[i] : "Payment Description field did not accept " + testDataCharacterTypeArray[i]
            );

            // Reload Transaction Details page (all inputs will automatically be cleared out)
            driver.get(URL_EPL);
        }
    } */

    /* @Test (priority = 7)     // UNFINISHED
    public void TLPEAPI_OPP_08() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_08 - Validation testing on the GCash payment option");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Actual Test
        transactionDetailsPageHappyPath();
        elements.amount.clear();
        elements.amount.sendKeys("100");
        elements.eWalletOptionBtn.click();
        elements.eWalletOptionBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.gcashBtn));
        elements.gcashBtn.click();
        elements.nextBtn.click();

        // Check if GCash payment method is enabled in the Confirm Payment page
        test.log(
            elements.gcashConfirmPayment.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.gcashConfirmPayment.isDisplayed() ? "GCash payment method in Confirm Payment page is visible" : "GCash payment method in Confirm Payment page is not visible"
        );

        elements.proceedToPaymentBtn.click();
        wait.until(ExpectedConditions.visibilityOf(elements.gcashMobileNumberField));

        // Check if GCash Login Portal is accessible
        test.log(
            elements.gcashMobileNumberField.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.gcashMobileNumberField.isDisplayed() ? "GCash Login Portal is accessible" : "GCash Login Portal is not accessible"
        );

        elements.gcashMobileNumberField.sendKeys("9175000011");
        // wait.until(ExpectedConditions.visibilityOf(elements.gcashLoginNextBtn));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        elements.gcashLoginNextBtn.click();

        // Check if GCash Authentication Portal is accessible
        wait.until(ExpectedConditions.visibilityOf(elements.gcashAuthenticationCode1));
        test.log(
            elements.gcashAuthenticationCode1.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.gcashAuthenticationCode1.isDisplayed() ? "GCash Authentication Portal is accessible" : "GCash Authentication Portal is not accessible"
        );

        for (int i = 0; i < elements.gcashAuthenticationCodeList.size(); i++) {
            elements.gcashAuthenticationCodeList.get(i).click();
            elements.gcashAuthenticationCodeList.get(i).sendKeys("8");
        }
        // wait.until(ExpectedConditions.visibilityOf(elements.gcashAuthenticationNextBtn));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            // Auto-generated catch block
            e.printStackTrace();
        }
        elements.gcashAuthenticationNextBtn.click( );

        // Check if GCash MPIN Portal is accessible
        wait.until(ExpectedConditions.visibilityOf(elements.MPIN1));
        test.log(
            elements.MPIN1.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.MPIN1.isDisplayed() ? "GCash MPIN Portal is accessible" : "GCash MPIN Portal is not accessible"
        );

        for (int i = 0; i < elements.gcashMPINList.size(); i++) {
            elements.gcashMPINList.get(i).click();
            elements.gcashMPINList.get(i).sendKeys("1");
        }
        wait.until(ExpectedConditions.visibilityOf(elements.gcashMPINNextBtn));
        elements.gcashMPINNextBtn.click();

        // Check if GCash MPIN Portal is accessible
        wait.until(ExpectedConditions.visibilityOf(elements.gcashPayBtn));
        test.log(
            elements.gcashPayBtn.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.gcashPayBtn.isDisplayed() ? "GCash Payment Portal is accessible" : "GCash Payment Portal is not accessible"
        );
        elements.gcashPayBtn.click();

    } */

    /* @Test (priority = 8)    // OK
    public void TLPEAPI_OPP_09() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_09 - Validation testing on the First Name and Last Name fields by forcing invalid values");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // String array for test data of alphabetic, numeric, and special characters
        String[] testDataArray = {"012345", "!@#$%"};
        String[] testDataCharacterTypeArray = {"Numeric characters", "Special characters"};

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Check if First Name and Last Name fields are visible
        test.log(
            elements.firstName.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.firstName.isDisplayed() ? "First Name field is visible" : "First Name field is not visible"
        );
        test.log(
            elements.lastName.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.lastName.isDisplayed() ? "Last Name field is visible" : "Last Name field is not visible"
        );

        // Actual Test
        for (int i = 0; i < testDataArray.length; i++) {

            // Call this function to input all correct values on the Transaction Details page
            transactionDetailsPageHappyPath();
            elements.firstName.clear();
            elements.lastName.clear();

            elements.firstName.sendKeys(testDataArray[i]);
            elements.lastName.sendKeys(testDataArray[i]);
            elements.nextBtn.click();

            // Check if redirection to Confirm Payment page is successful, meaning the test data was accepted
            test.log(
                elements.cardNumber.isDisplayed() ? Status.FAIL : Status.PASS,
                elements.cardNumber.isDisplayed() ? "Payment Description field accepted " + testDataCharacterTypeArray[i] : "Payment Description field did not accept " + testDataCharacterTypeArray[i]
            );

            // Reload Transaction Details page (all inputs will automatically be cleared out)
            driver.get(URL_EPL);
        }
    } */

    /* @Test (priority = 9)
    public void TLPEAPI_OPP_10() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_10 - Validation testing on the Email field");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        String[] testDataArray = {
            ""
        };
        
    } */

    // Error Tests
    /* @Test (priority = 21)    // UNFINISHED
    public void TLPEAPI_OPP_22() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_22 - Unsuccessful transaction due to empty Amount field");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Check if Amount field is visible
        test.log(
            elements.amount.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.amount.isDisplayed() ? "Amount field is visible" : "Amount field is not visible"
        );

        // Call this function to input all required fields in the Transaction Details page
        transactionDetailsPageHappyPath();

        // Force removal of input in the Amount field
        elements.amount.clear();
        elements.amount.sendKeys("0", Keys.ENTER);
        if (elements.amount.getText().equals("0")) {
            test.log(
                elements.amount.isDisplayed() ? Status.PASS : Status.FAIL,
                elements.amount.isDisplayed() ? "Amount field is visible" : "Amount field is not visible"
            );
        }

        wait.until(ExpectedConditions.visibilityOf(elements.nextBtn));
        elements.nextBtn.click();
    } */

    /* @Test (priority = 22)   // OK
    public void TLPEAPI_OPP_23() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_23 - Error Test on unselected Currency option");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Check if Currency dropdown is visible
        test.log(
            elements.currencyDropdown.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.currencyDropdown.isDisplayed() ? "Currency dropdown button is visible" : "Currency dropdown button is not visible"
        );

        /// Actual Test
        elements.amount.sendKeys("500000"); // This is 5,000 pesos since the field accounts for the two decimal values
        elements.paymentDescription.sendKeys("TEST");
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
        elements.nextBtn.click();

        wait.until(ExpectedConditions.visibilityOf(elements.paymentCurrencyError));
        test.log(
            elements.paymentCurrencyError.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.paymentCurrencyError.isDisplayed() ? "Payment Currency Error is visible" : "Payment Currency Error is not visible"
        );

    } */

    /* @Test (priority = 23)   // OK
    public void TLPEAPI_OPP_24() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_24 - Error Test on empty Payment Description field");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Check if Payment Description field is visible
        test.log(
            elements.paymentDescription.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.paymentDescription.isDisplayed() ? "Payment Description field is visible" : "Payment Description field is not visible"
        );

        /// Actual Test
        transactionDetailsPageHappyPath();
        elements.paymentDescription.clear();
        elements.nextBtn.click();

        wait.until(ExpectedConditions.visibilityOf(elements.paymentDescriptionError));
        test.log(
            elements.paymentDescriptionError.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.paymentDescriptionError.isDisplayed() ? "Payment Description Error is visible" : "Payment Description Error is not visible"
        );

    } */

    /* @Test (priority = 24)    // OK
    public void TLPEAPI_OPP_25() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_25 - Error Test on unselected Payment option");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        /// Actual Test
        elements.amount.sendKeys("500000"); // This is 5,000 pesos since the field accounts for the two decimal values
        elements.currencyDropdown.click();

        wait.until(ExpectedConditions.visibilityOf(elements.currencyField));

        elements.currencyField.sendKeys("PHP - Philippine Peso", Keys.ENTER);
        elements.paymentDescription.sendKeys("TEST");

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
        elements.nextBtn.click();

        wait.until(ExpectedConditions.visibilityOf(elements.cardOptionError));
        test.log(
            elements.cardOptionError.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.cardOptionError.isDisplayed() ? "Card Option Error is visible" : "Card Option Error is not visible"
        );

    } */

    /* @Test (priority = 25)   // OK
    public void TLPEAPI_OPP_26() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_26 - Error Test on empty First Name and Last Name fields");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Check if First Name and Last Name fields are visible
        test.log(
            elements.firstName.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.firstName.isDisplayed() ? "First Name field is visible" : "First Name field is not visible"
        );
        test.log(
            elements.lastName.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.lastName.isDisplayed() ? "Last Name field is visible" : "Last Name field is not visible"
        );

        /// Actual Test
        transactionDetailsPageHappyPath();
        elements.firstName.clear();
        elements.lastName.clear();
        elements.nextBtn.click();

        wait.until(ExpectedConditions.visibilityOf(elements.firstName));
        test.log(
            elements.firstNameError.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.firstNameError.isDisplayed() ? "First Name field error is visible" : "First Name field error is not visible"
        );
        test.log(
            elements.lastNameError.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.lastNameError.isDisplayed() ? "Last Name field error is visible" : "Last Name field error is not visible"
        );

    } */

    /* @Test (priority = 26)   // OK
    public void TLPEAPI_OPP_27() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_27 - Error Test on empty Email Address field");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Check if Email Address field is visible
        test.log(
            elements.emailAddress.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.emailAddress.isDisplayed() ? "Email Address field is visible" : "Email Address field is not visible"
        );

        /// Actual Test
        transactionDetailsPageHappyPath();
        elements.emailAddress.clear();
        elements.nextBtn.click();


        wait.until(ExpectedConditions.visibilityOf(elements.emailAddressError));
        test.log(
            elements.emailAddressError.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.emailAddressError.isDisplayed() ? "Email Address field error is visible" : "Email Address field error is not visible"
        );
    } */

    /* @Test (priority = 27)   // OK
    public void TLPEAPI_OPP_28() {
        driver.get(URL_EPL);

        ExtentTest test = extent.createTest("TLPEAPI_OPP_28 - Error Test on empty Mobile Number field");
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Call this function to check if the Transaction Details page is accessible
        transactionDetailsPageAccessibility(test);

        // Check if Email Address field is visible
        test.log(
            elements.emailAddress.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.emailAddress.isDisplayed() ? "Email Address field is visible" : "Email Address field is not visible"
        );

        /// Actual Test
        transactionDetailsPageHappyPath();
        elements.emailAddress.clear();
        elements.nextBtn.click();

        wait.until(ExpectedConditions.visibilityOf(elements.emailAddressError));
        test.log(
            elements.emailAddressError.isDisplayed() ? Status.PASS : Status.FAIL,
            elements.emailAddressError.isDisplayed() ? "Email Address field error is visible" : "Email Address field error is not visible"
        );
    } */

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
