package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.ArrayList;

public class EPLElements {

    private final WebDriver driver;

    public EPLElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 

        errorList.add(paymentCurrencyError);
        errorList.add(paymentDescriptionError);
        errorList.add(paymentOptionError);
        errorList.add(firstNameError);
        errorList.add(lastNameError);
        errorList.add(emailAddressError);
        errorList.add(mobileNumberError);

        errorNames.add(paymentCurrencyErrorName);
        errorNames.add(paymentDescriptionErrorName);
        errorNames.add(paymentOptionErrorName);
        errorNames.add(firstNameErrorName);
        errorNames.add(lastNameErrorName);
        errorNames.add(emailAddressErrorName);
        errorNames.add(mobileNumberErrorName);        
    }

    List<WebElement> errorList = new ArrayList<>();
    List<String> errorNames = new ArrayList<>();

    // Text fields
    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement amount;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]")
    public WebElement paymentDescription;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement firstName;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")
    public WebElement lastName;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/input[1]")
    public WebElement emailAddress;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/input[1]")
    public WebElement mobileNumber;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[1]/input[1]")
    public WebElement addressLine1;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[6]/div[1]/input[1]")
    public WebElement addressLine2;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[7]/div[1]/input[1]")
    public WebElement cityMunicipalityLocality;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[8]/div[1]/input[1]")
    public WebElement zipCode;

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[9]/div[1]/input[1]")
    public WebElement stateProvinceRegion;
    

    // Buttons
    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]/span[1]/span[1]/span[2]")
    public WebElement currencyDropdown;

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement currencyField;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]")
    public WebElement cardOptionBtn;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/button[1]")
    public WebElement visaBtn;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]")
    public WebElement mobileNumberCountryCode;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[10]/div[1]/span[2]/span[1]/span[1]/span[1]")
    public WebElement country;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[4]/div[1]/button[1]")
    public WebElement nextBtn;

    // Errors
    @FindBy(xpath = "//label[@id='payment.currency-error']")
    public WebElement paymentCurrencyError;
    String paymentCurrencyErrorName = "Payment Currency dropbox";
    
    @FindBy(xpath = "//label[@id='payment.description-error']")
    public WebElement paymentDescriptionError ;
    String paymentDescriptionErrorName = "Payment Description field";
    
    @FindBy(xpath = "//div[@id='paymentoption-error']")
    public WebElement paymentOptionError;
    String paymentOptionErrorName = "Payment Option field";
    
    @FindBy(xpath = "//label[@id='customer.firstName-error']")
    public WebElement firstNameError;
    String firstNameErrorName = "First Name field";
    
    @FindBy(xpath = "//label[@id='customer.lastName-error']")
    public WebElement lastNameError;
    String lastNameErrorName = "Last Name field";
    
    @FindBy(xpath = "//label[@id='customer.contact.email-error']")
    public WebElement emailAddressError;
    String emailAddressErrorName = "Email Address field";
    
    @FindBy(xpath = "//label[@id='customer.contact.mobile-error']")
    public WebElement mobileNumberError;
    String mobileNumberErrorName = "Mobile Number field";
    
}
