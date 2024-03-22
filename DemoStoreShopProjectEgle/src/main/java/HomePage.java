import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends BasePage {
    @FindBy(css = ".MuiRadio-root")
    private List<WebElement> radioBtnCategory;
    @FindBy(xpath = "//span[normalize-space()='Hoodies']")
    private WebElement category3Text; //pakeisti pavadinima , kad nebutu 3 , o atspindetu, kad tai Hoodies
    @FindBy(xpath = "//span[normalize-space()='Drinkware']")
    private WebElement category2Text; //pakeisti pavadinima , kad nebutu 3 , o atspindetu, kad tai Drinkware
    @FindBy(css = ".MuiRadio-root.Mui-checked")
    private List<WebElement> checkedCategory;
    @FindBy(css = ".MuiCheckbox-root")
    private List<WebElement> checkBoxType;
    @FindBy(xpath = "//span[normalize-space()='Tote Bag']")
    private WebElement type5Text; //pakeisti pavadinima , kad nebutu 3 , o atspindetu, kad tai Tote Bag
    @FindBy(css = ".MuiCheckbox-root.Mui-checked")
    private List<WebElement> checkedType;
    @FindBy(xpath = "//span[normalize-space()='Blanket']")
    private WebElement type7Text; //pakeisti pavadinima , kad nebutu 3 , o atspindetu, kad tai Blanket
    @FindBy(xpath = "//button[normalize-space()='View more products']")
    private WebElement btnViewMoreProducts;
    @FindBy(css = ".ProductCard_productImage__nbfNy")
    private List<WebElement> productsInTheProductList;
    @FindBy(css = ".MuiSvgIcon-root[data-testid=ExpandMoreIcon]")
    private List<WebElement> expandReduceIcons;
    @FindBy(css = "#filter-panel-content-category label")
    private List<WebElement> categoriesLabel;
    @FindBy(css = "#filter-panel-content-type label")
    private List<WebElement> typesLabel;
    @FindBy(xpath = "//span[normalize-space()='Mom Tattoo Cushion']")
    private WebElement momTattooCushion;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void clickOneCategory(int nr) {
        radioBtnCategory.get(--nr).click();
    }

    public String getCategory3Text() {
        return category3Text.getText();
    }

    public String getCategory2Text() {
        return category2Text.getText();
    }

    public int countCheckedCategory() {
        return checkedCategory.size();
    }

    public void SelectOneType(int nr) {
        checkBoxType.get(--nr).click();
    }

    public String getType5Text() {
        return type5Text.getText();
    }

    public int countCheckedTypes() {
        return checkedType.size();
    }

    public String getType7Text() {
        return type7Text.getText();
    }

    public void expandTheProductList() {
        btnViewMoreProducts.click();
    }

    public int countProductsInTheProductList() {
        return productsInTheProductList.size();
    }

    public void expandReduceCategoryFilter() {
        expandReduceIcons.get(0).click();
    }

    public boolean productCategoryIsDisplayed() {

        return categoriesLabel.get(2).isDisplayed();
    }

    public void expandReduceTypeFilter() {
        expandReduceIcons.get(1).click();
    }

    public boolean productTypesIsDisplayed() {

        return typesLabel.get(3).isDisplayed();
    }

    public void navigateToAnyProduct(int nr) {
        productsInTheProductList.get(--nr).click();
    }

    public String getMomTattooCushionText() {
        return momTattooCushion.getText();
    }
}
