import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePageTest extends BaseTest { //pabandykime kur imanoma sleep pakeisti i waiter'ius (cia visuose testu klasese turiu omeny)
    HomePage homePage;

    @Test
    void userCanSelectOneCategory() {
        homePage = new HomePage(driver);
        homePage.clickOneCategory(3);
        Assertions.assertEquals("Hoodies", homePage.getCategory3Text(), "Pasirinkta kategorija nesutampa"); //Visur lietuviskus tekstus pakeisti i angliskus
        Assertions.assertEquals(1, homePage.countCheckedCategory());
    }

    @Test
    void userCannotSelectTwoCategoriesAtTheSameTime() {
        homePage = new HomePage(driver);
        homePage.clickOneCategory(3);
        homePage.clickOneCategory(2);
        Assertions.assertEquals("Drinkware", homePage.getCategory2Text(), "Pasirinkta kategorija nesutampa");
        Assertions.assertEquals(1, homePage.countCheckedCategory());
    }

    @Test
    void userCanSelectOneType() {
        homePage = new HomePage(driver);
        homePage.SelectOneType(5);
        Assertions.assertEquals("Tote Bag", homePage.getType5Text(), "Pasirinktas tipas nesutampa");
        Assertions.assertEquals(1, homePage.countCheckedTypes());
    }

    @Test
    void userCanSelectTwoTypeFilterOptions() {
        homePage = new HomePage(driver);
        homePage.SelectOneType(5);
        homePage.SelectOneType(7);
        Assertions.assertEquals("Tote Bag", homePage.getType5Text(), "Pasirinktas tipas nesutampa");
        Assertions.assertEquals("Blanket", homePage.getType7Text(), "Pasirinktas tipas nesutampa");
        Assertions.assertEquals(2, homePage.countCheckedTypes());
    }

    @Test
    void userCanExpandTheProductList() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.expandTheProductList();
        Thread.sleep(5000);
        Assertions.assertEquals(24, homePage.countProductsInTheProductList());
    }

    @Test
    void userCanExpandReduceCategoryFilter() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.expandReduceCategoryFilter();
        Thread.sleep(5000);
        Assertions.assertFalse(homePage.productCategoryIsDisplayed());
        homePage.expandReduceCategoryFilter();
        Assertions.assertTrue(homePage.productCategoryIsDisplayed());
    }

    @Test
    void userCanExpandReduceTypeFilter() {
        homePage = new HomePage(driver);
        homePage.expandReduceTypeFilter();
        Assertions.assertFalse(homePage.productTypesIsDisplayed());
        homePage.expandReduceTypeFilter();
        Assertions.assertTrue(homePage.productTypesIsDisplayed());
    }
}



