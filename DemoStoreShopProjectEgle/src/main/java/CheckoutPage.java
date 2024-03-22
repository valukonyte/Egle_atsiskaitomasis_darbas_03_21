import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPage extends BasePage {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Secure checkout']")
    private WebElement LblSecureCheckout;
    @FindBy(css = ".flex.flex-row.h-8 button")
    private List<WebElement> btnQuantity;
    @FindBy(css = ".flex.flex-row.h-8 input")
    private List<WebElement> quantityInput;
    @FindBy(xpath = "//span[contains(text(),'Total')]")
    private List<WebElement> quantityLbl;
    @FindBy(css = ".MuiAlert-message")
    private WebElement allertMessage;
    @FindBy(css = "button[data-testid='cart-remove-button']")
    private List<WebElement> btnRemove;
    @FindBy(xpath = "//h2[contains(text(),'Your cart is empty')]")
    private WebElement cartEmpty;
    @FindBy(css = "input[name='shippingAddress.firstName']")
    private WebElement firstname;
    @FindBy(css = "input[name='shippingAddress.lastName']")
    private WebElement lastname;
    @FindBy(css = "input[name='shippingAddress.address']")
    private WebElement address;
    @FindBy(css = "input[name='shippingAddress.city']")
    private WebElement city;
    @FindBy(css = "input[name='shippingAddress.zipCode']")
    private WebElement zipcode;
    @FindBy(css = "input[name='email']")
    private WebElement email;
    @FindBy(css = "  #mui-5")
    private WebElement suit;
    @FindBy(xpath = "//div[@id='mui-component-select-shippingAddress.country']")
    private WebElement countryMeniu;
    @FindBy(css = ".MuiList-root li")
    private List<WebElement> countryDropDownLi;
    @FindBy(css = "button[data-testid='proceed-to-payment']")
    private WebElement btnProceedToPayment;
    @FindBy(xpath = "//h1[normalize-space()='Secure checkout']")
    private WebElement lblSecureCheckout;
    @FindBy(css = "input[value='express']")
    private WebElement DeliveryExpress;
    @FindBy(xpath = "//p[contains(text(), 'Please enter a valid email address')]")
    private WebElement enterValidEmailMessage;
    @FindBy(xpath = "//p[contains(text(), 'First name is required')]") // siti visi kintamieji gali buti aprasomas kaip vianas ir zaidziama su parametrizacija
    private WebElement firstNameIsRequiredMessage;
    @FindBy(xpath = "//p[contains(text(), 'Email address is required')]")
    private WebElement emailIsRequiredMessage;
    @FindBy(xpath = "//p[contains(text(), 'Last name is required')]")
    private WebElement lastNameIsRequiredMessage;
    @FindBy(xpath = "//p[contains(text(), 'Address is required')]")
    private WebElement addressIsRequiredMessage;
    @FindBy(xpath = "//p[contains(text(), 'City is required')]")
    private WebElement cityIsRequiredMessage;
    @FindBy(xpath = "//p[contains(text(), 'Post code is required')]")
    private WebElement postCodeIsRequiredMessage;

    public String secureCheckoutText() {
        return LblSecureCheckout.getText();
    }

    public void clickBtnQuantityPlus() {
        btnQuantity.get(1).click();
    }

    public void clickBtnQuantityMinus() {
        btnQuantity.get(0).click();
    }

    public void changeQuantityByEnteringNumber() { //changeQuantityByEnteringNumber ir changeQuantityByEnteringQuantityWithMinus gali buti vienas metodas
        WebElement quantity = quantityInput.get(0);
        quantity.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        quantity.sendKeys("7");
        quantity.sendKeys(Keys.TAB);
    }

    public void changeQuantityByEnteringQuantityWithMinus() {
        WebElement quantity = quantityInput.get(0);
        quantity.sendKeys(Keys.chord(Keys.CONTROL, "a") + Keys.DELETE);
        quantity.sendKeys("-7");
        quantity.sendKeys(Keys.TAB);
    }

    public String getQuantityLblText() {
        return quantityLbl.get(0).getText();
    }

    public void clickBtnRemove() {
        btnRemove.get(0).click();
    }

    public String getCartEmptyText() {
        return cartEmpty.getText();
    }

    public void sendEmail(String Email) {
        email.sendKeys(Email);
    }

    public void sendFirstName(String firstName) {
        firstname.sendKeys(firstName);
    }

    public void sendLastName(String lastName) {
        lastname.sendKeys(lastName);
    }

    public void sendAddress(String Address) {
        address.sendKeys(Address);
    }

    public void sendCity(String City) {
        city.sendKeys(City);
    }

    public void sendPostCode(String PostCode) {
        zipcode.sendKeys(PostCode);
    }

    public void sendSuit(String Suit) {
        suit.sendKeys(Suit);
    }

    public void clickCountryMeniu() {
        countryMeniu.click();
    }

    public void clickSelectedCountry(String country) {
        driver.findElement(By.cssSelector("[data-value=\"" + country + "\"]")).click();
    }

    public void clickProceedToPayment() {
        btnProceedToPayment.click();
    }

    public String getSecureCheckoutText() {
        return lblSecureCheckout.getText();
    }

    public void clickDeliveryExpress() {
        DeliveryExpress.click();
    }

    public boolean enterValidEmailMessageIsDisplayed() {
        return enterValidEmailMessage.isDisplayed();
    }

    public boolean firstNameIsRequiredMessageMessageIsDisplayed() {
        return firstNameIsRequiredMessage.isDisplayed();
    }

    public boolean emailIsRequiredMessageMessageIsDisplayed() {
        return emailIsRequiredMessage.isDisplayed();
    }

    public boolean lastNameIsRequiredMessageMessageIsDisplayed() {
        return lastNameIsRequiredMessage.isDisplayed();
    }

    public boolean addressIsRequiredMessageMessageIsDisplayed() {
        return addressIsRequiredMessage.isDisplayed();
    }

    public boolean cityIsRequiredMessageMessageIsDisplayed() {
        return cityIsRequiredMessage.isDisplayed();
    }

    public boolean postCodeIsRequiredMessageMessageIsDisplayed() {
        return postCodeIsRequiredMessage.isDisplayed();
    }

}
