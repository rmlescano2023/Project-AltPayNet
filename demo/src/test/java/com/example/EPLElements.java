package com.example;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EPLElements {

    private final WebDriver driver;

    public EPLElements(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this); 

        // Transaction Page WebElements
        transactionPageWebElements.add(amount);
        transactionPageWebElements.add(currencyDropdown);
        // transactionPageWebElements.add(currencyField);              // Not included in initial access of the website
        transactionPageWebElements.add(paymentDescription);
        // transactionPageWebElements.add(cardOptionBtn);              // Not included in initial access of the website
        // transactionPageWebElements.add(visaBtn);                    // Not included in initial access of the website
        transactionPageWebElements.add(firstName);
        transactionPageWebElements.add(lastName);
        transactionPageWebElements.add(emailAddress);
        transactionPageWebElements.add(mobileNumberCountryCode);
        transactionPageWebElements.add(mobileNumber);
        transactionPageWebElements.add(addressLine1);
        transactionPageWebElements.add(addressLine2);
        transactionPageWebElements.add(cityMunicipalityLocality);
        transactionPageWebElements.add(zipCode);
        transactionPageWebElements.add(stateProvinceRegion);
        transactionPageWebElements.add(countryDropdown);
        // transactionPageWebElements.add(countryField);               // Not included in initial access of the website
        transactionPageWebElements.add(nextBtn);

        transactionPageWebElementNames.add(amountFieldElementName);
        transactionPageWebElementNames.add(currencyDropdownElementName);
        transactionPageWebElementNames.add(currencyFieldElementName);
        transactionPageWebElementNames.add(paymentDescriptionElementName);
        transactionPageWebElementNames.add(cardOptionBtnelementName);
        transactionPageWebElementNames.add(visaBtnElementName);
        transactionPageWebElementNames.add(firstNameElementName);
        transactionPageWebElementNames.add(lastNameElementName);
        transactionPageWebElementNames.add(emailAddressElementName);
        transactionPageWebElementNames.add(mobileNumberCountryCodeElementName);
        transactionPageWebElementNames.add(mobileNumberElementName);
        transactionPageWebElementNames.add(addressLine1ElementName);
        transactionPageWebElementNames.add(addressLine2ElementName);
        transactionPageWebElementNames.add(cityMunicipalityLocalityElementName);
        transactionPageWebElementNames.add(zipCodeElementName);
        transactionPageWebElementNames.add(stateProvinceRegionElementName);
        transactionPageWebElementNames.add(countryDropdownElementName);
        transactionPageWebElementNames.add(countryFieldElementName);
        transactionPageWebElementNames.add(nextBtnElementName);
        
        
        // Confirm Payment Page WebElements
        confirmPaymentPageWebElements.add(cardNumber);
        confirmPaymentPageWebElements.add(cardholderName);
        confirmPaymentPageWebElements.add(expiryDate);
        confirmPaymentPageWebElements.add(CVV);
        confirmPaymentPageWebElements.add(submitPaymentBtn);

        confirmPaymentPageWebElementNames.add(cardNumberElementName);
        confirmPaymentPageWebElementNames.add(cardholderNameElementName);
        confirmPaymentPageWebElementNames.add(expiryDateElementName);
        confirmPaymentPageWebElementNames.add(CVVElementName);
        confirmPaymentPageWebElementNames.add(submitPaymentBtnElementName);

        confirmPaymentPageWebElements.add(proceedToPaymentBtn); // GCash
        

        // Errors
        errorList.add(paymentCurrencyError);
        errorList.add(paymentDescriptionError);
        errorList.add(cardOptionError);
        errorList.add(firstNameError);
        errorList.add(lastNameError);
        errorList.add(emailAddressError);
        errorList.add(mobileNumberError);

        errorNames.add(paymentCurrencyErrorName);
        errorNames.add(paymentDescriptionErrorName);
        errorNames.add(cardOptionErrorName);
        errorNames.add(firstNameErrorName);
        errorNames.add(lastNameErrorName);
        errorNames.add(emailAddressErrorName);
        errorNames.add(mobileNumberErrorName);


        // GCash Authentication Code fields
        gcashAuthenticationCodeList.add(gcashAuthenticationCode1);
        gcashAuthenticationCodeList.add(gcashAuthenticationCode2);
        gcashAuthenticationCodeList.add(gcashAuthenticationCode3);
        gcashAuthenticationCodeList.add(gcashAuthenticationCode4);
        gcashAuthenticationCodeList.add(gcashAuthenticationCode5);
        gcashAuthenticationCodeList.add(gcashAuthenticationCode6);

        // GCash MPIN fields
        gcashMPINList.add(MPIN1);
        gcashMPINList.add(MPIN2);
        gcashMPINList.add(MPIN3);
        gcashMPINList.add(MPIN4);
        
    }


    // List of objects
    List<WebElement> transactionPageWebElements = new ArrayList<>();
    List<String> transactionPageWebElementNames = new ArrayList<>();

    List<WebElement> confirmPaymentPageWebElements = new ArrayList<>();
    List<String> confirmPaymentPageWebElementNames = new ArrayList<>();

    List<WebElement> errorList = new ArrayList<>();
    List<String> errorNames = new ArrayList<>();

    List<WebElement> gcashAuthenticationCodeList = new ArrayList<>();
    List<WebElement> gcashMPINList = new ArrayList<>();


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
    public WebElement cardOptionError;
    String cardOptionErrorName = "Payment Option field";
    
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

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[1]/div[1]/div[2]/img[1]")
    public WebElement gcashConfirmPayment;


    // GCash Elements
    @FindBy(xpath = "//body/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/input[1]")
    public WebElement gcashMobileNumberField;
    String gcashMobileNumberFieldName = "GCash Mobile Number field";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[3]/div[1]/div[1]/div[2]/button[1]")
    public WebElement eWalletOptionBtn;
    String eWalletOptionBtnName = "e-Wallet button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[2]/div[1]/div[4]/div[1]/div[2]/div[1]/div[2]/button[1]")
    public WebElement gcashBtn;
    String gcashBtnName = "GCash button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[2]/div[3]/div[2]/div[1]/a[1]")
    public WebElement proceedToPaymentBtn;
    String proceedToPaymentBtnName = "Proceed to Payment button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/footer[1]/div[1]/button[1]")
    public WebElement gcashLoginNextBtn;
    String gcashLoginNextBtnName = "Login - Next button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]/button[1]")
    public WebElement gcashAuthenticationNextBtn;
    String gcashAuthenticationNextBtnName = "Authentication Code - Next button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/footer[1]/div[1]/button[1]")
    public WebElement gcashMPINNextBtn;
    String gcashMPINNextBtnName = "MPIN - Next button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/footer[1]/div[1]/button[1]")
    public WebElement gcashPayBtn;
    String gcashPayBtnName = "Pay button";

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]")
    public WebElement gcashAuthenticationCode1;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]")
    public WebElement gcashAuthenticationCode2;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]")
    public WebElement gcashAuthenticationCode3;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]")
    public WebElement gcashAuthenticationCode4;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[5]")
    public WebElement gcashAuthenticationCode5;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[6]")
    public WebElement gcashAuthenticationCode6;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]")
    public WebElement MPIN1;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]")
    public WebElement MPIN2;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[3]")
    public WebElement MPIN3;

    @FindBy(xpath = "//body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[4]")
    public WebElement MPIN4;
    
}
