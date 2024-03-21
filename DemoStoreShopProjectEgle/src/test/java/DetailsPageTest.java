import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

public class DetailsPageTest extends BaseTest {
    HomePage homePage;
    DetailsPage detailsPage;

    @Test
    void userCanNavigateToAnyProduct() {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        String ProductMomTattooCushion = homePage.getMomTattooCushionText();
        homePage.navigateToAnyProduct(4);
        Assertions.assertEquals(ProductMomTattooCushion, detailsPage.getMomTattooCushionTextInDetailsPage(), "Nuoroda neatitinka produkto");
    }

    @Test
    void userCanViewInformationAboutProduct() {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        homePage.navigateToAnyProduct(4);
        Assertions.assertTrue(detailsPage.productLabelIsDisplayed());
        Assertions.assertTrue(detailsPage.productImageIsDisplayed());
        Assertions.assertTrue(detailsPage.productColorIsDisplayed());
        Assertions.assertTrue(detailsPage.productSizeIsDisplayed());
    }

    @Test
    void userCanSelectDifferentProductColor() {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductColor(4);
        Assertions.assertEquals("Burgundy", detailsPage.selectedColorLabelText(), "Spalvos nesutampa");
    }

    @Test
    void userCanSelectDifferentProductSize() {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        Assertions.assertEquals(detailsPage.selectedSizeButtonText(), detailsPage.selectedSizeLabelText(), "Dydžiai nesutampa");
    }

    @Test
    void userCanSelectDifferentProductQuantity() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.clickQuantityMeniu();
        Thread.sleep(2000);
        detailsPage.clickSelectedQuantity(2);
        Assertions.assertEquals("2", detailsPage.getSelectedQuantityText(), "Kiekiai nesutampa");
    }

    @Test
    void userCanSelectDifferentProductType() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        homePage.clickOneCategory(1);
        Thread.sleep(5000);
        homePage.navigateToAnyProduct(1);
        detailsPage.clickProductWomanManMeniu();
        Thread.sleep(5000);
        detailsPage.clickSelectedItemWomanManLi(1);
        Assertions.assertEquals("Classic Unisex T-Shirt", detailsPage.getSelectedItemWomanManLiText(), "Tipai nesutampa");
    }

    @Test
    void userCanAddProductToTheCartWhenColorAndSizeSelected() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        homePage.clickOneCategory(1);
        Thread.sleep(3000);
        homePage.navigateToAnyProduct(1);
        detailsPage.selectDifferentProductColor(2);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        Assertions.assertEquals("Your Cart", detailsPage.yourCartText(), "Į krepšelį nepatekote");
    }

    @Test
    void userCanAddProductToTheCartWhenColorIsDefaultAndSizeSelected() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        Assertions.assertEquals("Your Cart", detailsPage.yourCartText(), "Į krepšelį nepatekote");
    }

    @Test
    void userMustSelectProductSize() {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.clickBuyNow();
        Assertions.assertTrue(detailsPage.selectSizeMessageIsDisplayed());
    }
}
