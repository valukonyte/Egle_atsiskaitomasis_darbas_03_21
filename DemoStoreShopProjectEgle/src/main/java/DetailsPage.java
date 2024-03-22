import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DetailsPage extends BasePage {
    @FindBy(xpath = "//h3[normalize-space()='Mom Tattoo Cushion']")
    private WebElement momTattooCushionDetails;
    @FindBy(xpath = "(//img[@alt='Product Image'])[4]")
    private WebElement momTattooCushionImage;
    @FindBy(css = "h3[data-testid='product-title']")
    private WebElement productDetailsLabel;
    @FindBy(xpath = "//button[contains(@aria-label, 'color')]")
    private List<WebElement> colorList;
    @FindBy(xpath = "//button[contains(@aria-label, 'size')]")
    private List<WebElement> sizeList;
    @FindBy(css = ".mb-3>*:nth-child(2)")
    private WebElement selectedColorLabel;
    @FindBy(css = "#product-sizes>*:first-child")
    private WebElement selectedSizeLabel;
    @FindBy(css = ".MuiFormControl-root")
    private WebElement quantityMeniu;
    @FindBy(css = ".MuiMenuItem-root")
    private List<WebElement> quantityDropDown;
    @FindBy(css = "#mui-component-select-quantity")
    private WebElement selectedQuantity;
    @FindBy(xpath = "//div[contains(@data-testid, 'productId-drop-down')]")
    private WebElement productWomanManMeniu;
    @FindBy(css = ".MuiMenuItem-root")
    private List<WebElement> womanManDropDownLi;
    @FindBy(xpath = "//div[normalize-space()='Classic Unisex T-Shirt']")
    private WebElement selectedWomanManDropDownLi;
    @FindBy(css = "button[aria-label='Add to cart']")
    private WebElement btnBuyNow;
    @FindBy(css = "#dialog-title-cart")
    private WebElement yourCart;
    @FindBy(xpath = "//p[normalize-space()='Size:']")
    private WebElement selectSizeMessage;
    @FindBy(xpath = "//a[contains(@data-testid, 'proceed-to-checkout')]")
    private WebElement btnProceedToSecureCheckout;

    public DetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getMomTattooCushionTextInDetailsPage() {
        return momTattooCushionDetails.getText();
    }

    public boolean productImageIsDisplayed() {
//nereikalingas tarpas
        return momTattooCushionImage.isDisplayed();
    }
    public boolean productLabelIsDisplayed() {
//nereikalingas tarpas
        return productDetailsLabel.isDisplayed();
    }
    public boolean productColorIsDisplayed() {
        return colorList.get(3).isDisplayed();
    }
    public boolean productSizeIsDisplayed() {
        return sizeList.get(0).isDisplayed();
    }
    public void selectDifferentProductColor(int nr) {
        colorList.get(--nr).click();
    }
    public String selectedColorLabelText() {
        return selectedColorLabel.getText();
    }
    public void selectDifferentProductSize(int nr) {
        sizeList.get(--nr).click();
    }
    public String selectedSizeButtonText() {
        return sizeList.get(1).getText();
    }
    public String selectedSizeLabelText() {
        return selectedSizeLabel.getText().split(":")[1].trim();
    }
    public void clickQuantityMeniu() {
        quantityMeniu.click();
    }
    public void clickSelectedQuantity(int quantity) {
        quantityDropDown.get(quantity).click();
    }
    public String getSelectedQuantityText() {
//tarpas
        return selectedQuantity.getText().trim();
    }
    public void clickProductWomanManMeniu() {
        productWomanManMeniu.click();
    }
    public void clickSelectedItemWomanManLi(int nr) {
        womanManDropDownLi.get(--nr).click();
    }
    public String getSelectedItemWomanManLiText() {
        return selectedWomanManDropDownLi.getText();
    }
    public void clickBuyNow() {
        btnBuyNow.click();
    }
    public String yourCartText() {
        return yourCart.getText();
    }
    public boolean selectSizeMessageIsDisplayed() {
        return selectSizeMessage.isDisplayed();
    }
    public void clickProceedToSecureCheckout() {
        btnProceedToSecureCheckout.click();
    }
}

