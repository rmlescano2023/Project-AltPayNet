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
    String amountFieldElementName = "Amount field";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[3]/div[1]/div[1]/input[1]")
    public WebElement paymentDescription;
    String paymentDescriptionElementName = "Description of Payment";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement firstName;
    String firstNameElementName = "First Name";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[2]/div[1]/input[1]")
    public WebElement lastName;
    String lastNameElementName = "Last Name";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/input[1]")
    public WebElement emailAddress;
    String emailAddressElementName = "Email Address";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/input[1]")
    public WebElement mobileNumber;
    String mobileNumberElementName = "Mobile Number";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[5]/div[1]/input[1]")
    public WebElement addressLine1;
    String addressLine1ElementName = "Address Line 1";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[6]/div[1]/input[1]")
    public WebElement addressLine2;
    String addressLine2ElementName = "Address Line 2";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[7]/div[1]/input[1]")
    public WebElement cityMunicipalityLocality;
    String cityMunicipalityLocalityElementName = "City/Municipality/Locality";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[8]/div[1]/input[1]")
    public WebElement zipCode;
    String zipCodeElementName = "ZIP Code";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[9]/div[1]/input[1]")
    public WebElement stateProvinceRegion;
    String stateProvinceRegionElementName = "State/Province/Region";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[2]/div[1]/input[1]")
    public WebElement cardNumber;
    String cardNumberElementName = "Card Number";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[3]/input[1]")
    public WebElement cardholderName;
    String cardholderNameElementName = "Cardholder Name";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[4]/div[1]/div[1]/input[1]")
    public WebElement expiryDate;
    String expiryDateElementName = "Expiry Date";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[4]/div[2]/div[1]/div[1]/input[1]")
    public WebElement CVV;
    String CVVElementName = "CVV";
    

    // Buttons
    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[2]/div[1]/span[2]/span[1]/span[1]/span[2]")
    public WebElement currencyDropdown;
    String currencyDropdownElementName = "Currency dropdown";

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement currencyField;
    String currencyFieldElementName = "Currency field";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/button[1]")
    public WebElement cardOptionBtn;
    String cardOptionBtnelementName = "Card Option button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div[1]/div[1]/div[2]/button[1]")
    public WebElement visaBtn;
    String visaBtnElementName = "VISA button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/div[1]/div[2]")
    public WebElement mobileNumberCountryCode;
    String mobileNumberCountryCodeElementName = "Mobile Number Country Code dropdown";

    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[4]/div[1]/div[1]/div[1]/ul[1]/li[173]")
    public WebElement countryCodePH; // Philippines
    String countryCodePHElementName = "PH Country Code option";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[2]/div[1]/div[1]/div[10]/div[1]/span[2]/span[1]/span[1]/span[1]")
    public WebElement countryDropdown;
    String countryDropdownElementName = "Country dropdown";

    @FindBy(xpath = "//body/span[1]/span[1]/span[1]/input[1]")
    public WebElement countryField;
    String countryFieldElementName = "Country field";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[3]/div[4]/div[1]/button[1]")
    public WebElement nextBtn;
    String nextBtnElementName = "Next button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/form[1]/div[2]/div[1]/button[1]")
    public WebElement submitPaymentBtn;
    String submitPaymentBtnElementName = "Submit Payment button";

    @FindBy(xpath = "//body[1]/div[1]/div[2]/form[1]/div[1]/select[1]")
    public WebElement authenticationDropdown;
    String authenticationDropdownElementName = "Authentication dropdown";

    @FindBy(xpath = "//body[1]/div[1]/div[2]/form[1]/button[1]")
    public WebElement submitAuthenticationBtn;
    String submitAuthenticationBtnElementName = "Submit Authentication button";


    // Errors
    @FindBy(xpath = "//label[@id='payment.currency-error']")
    public WebElement paymentCurrencyError;
    String paymentCurrencyErrorName = "Payment Currency dropdown";
    
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


    // Information Elements
    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[2]/div[3]")
    public WebElement paymentResult;
    
}
