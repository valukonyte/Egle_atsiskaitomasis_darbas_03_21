import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.interactions.Actions;

import java.util.Random;

import com.github.javafaker.Faker;
import utils.DataGenerator;

public class CheckoutPageTest extends BaseTest {
    HomePage homePage;
    DetailsPage detailsPage;
    CheckoutPage checkoutPage;

    @Test
    void userCanViewCartSummaryOnTheCheckoutPage() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        Assertions.assertEquals("Secure checkout", checkoutPage.secureCheckoutText(), "Į secure checkout puslapį nepatekote");
    }

    @Test
    void userCanChangeItemQuantityOnTheCheckoutPage() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        checkoutPage.clickBtnQuantityPlus();
        Thread.sleep(7000);
        Assertions.assertTrue(checkoutPage.getQuantityLblText().contains("2"));
        checkoutPage.clickBtnQuantityMinus();
        Thread.sleep(7000);
        Assertions.assertTrue(checkoutPage.getQuantityLblText().contains("1"));
    }

    @Test
    void userCanChangeQuantityByChangingTheNumber() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        checkoutPage.changeQuantityByEnteringNumber();
        Thread.sleep(7000);
        Assertions.assertTrue(checkoutPage.getQuantityLblText().contains("7"));
    }

    //    @Test
//    void userCannotEnterQuantityWithMinus() throws InterruptedException {
//        homePage = new HomePage(driver);
//        detailsPage = new DetailsPage(driver);
//        checkoutPage = new CheckoutPage(driver);
//        homePage.clickOneCategory(1);
//        Thread.sleep(3000);
//        homePage.navigateToAnyProduct(1);
//        detailsPage.selectDifferentProductSize(2);
//        detailsPage.clickBuyNow();
//        Thread.sleep(3000);
//        detailsPage.clickProceedToSecureCheckout();
//        checkoutPage.changeQuantityByEnteringQuantityWithMinus();
//        Thread.sleep(7000);
//       // Assertions.assertTrue(checkoutPage.allertMessageIsDisplayedAfterEnteringMinusQuantity().contains("Something went wrong, please try again."));
//    }
//       // Assertions.assertEquals("Something went wrong, please try again.",checkoutPage.allertMessageIsDisplayedAfterEnteringMinusQuantity());
//        //Assertions.assertTrue(checkoutPage.allertMessageIsDisplayedAfterEnteringMinusQuantity());
    @Test
    void userCanRemoveItemsFromTheCheckoutPage() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        checkoutPage.clickBtnRemove();
        Thread.sleep(3000);
        Assertions.assertEquals("Your cart is empty", checkoutPage.getCartEmptyText());
    }

    @Test
    void userCanProceedPaymentWithCorrectDetails() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        String email = faker.internet().emailAddress();
        String InputEmail = DataGenerator.getRandomEmail();
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String streetAddress = DataGenerator.getRandomStreetAddress();
        String PostCode = DataGenerator.getRandomPostCode();
        String City = DataGenerator.getRandomCity();
        checkoutPage.sendFirstName(firstName);
        checkoutPage.sendLastName(lastName);
        checkoutPage.sendEmail(email);
        checkoutPage.sendAddress(streetAddress);
        checkoutPage.sendCity(City);
        checkoutPage.sendPostCode(PostCode);
        checkoutPage.clickCountryMeniu();
        Thread.sleep(1000);
        checkoutPage.clickSelectedCountry("LT");
        Thread.sleep(3000);
        checkoutPage.clickProceedToPayment();
        Thread.sleep(3000);
        Assertions.assertEquals("Secure checkout", checkoutPage.getSecureCheckoutText(), "Į Secure checkout puslapį nepatekote");
    }

    @Test
    void userCanProceedPaymentWithAllCorrectData() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        Random rnd = new Random();
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        String email = faker.internet().emailAddress();
        String InputEmail = DataGenerator.getRandomEmail();
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String streetAddress = DataGenerator.getRandomStreetAddress();
        String PostCode = DataGenerator.getRandomPostCode();
        checkoutPage.sendFirstName(firstName);
        checkoutPage.sendLastName(lastName);
        checkoutPage.sendEmail(email);
        checkoutPage.sendAddress(streetAddress);
        checkoutPage.sendSuit("6");
        checkoutPage.sendCity("Kaunas");
        checkoutPage.sendPostCode(PostCode);
        checkoutPage.clickCountryMeniu();
        Thread.sleep(1000);
        checkoutPage.clickSelectedCountry("LT");
        Thread.sleep(3000);
        checkoutPage.clickProceedToPayment();
        Thread.sleep(3000);
        Assertions.assertEquals("Secure checkout", checkoutPage.getSecureCheckoutText(), "Į Secure checkout puslapį nepatekote");
    }

    @Test
    void userCanProceedPaymentWithAllCorrectDataAndExpressDelivery() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(2);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        String email = faker.internet().emailAddress();
        String InputEmail = DataGenerator.getRandomEmail();
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String streetAddress = DataGenerator.getRandomStreetAddress();
        String PostCode = DataGenerator.getRandomPostCode();
        checkoutPage.sendFirstName(firstName);
        checkoutPage.sendLastName(lastName);
        checkoutPage.sendEmail(email);
        checkoutPage.sendAddress(streetAddress);
        checkoutPage.sendSuit("6");
        checkoutPage.sendCity("Kaunas");
        checkoutPage.sendPostCode(PostCode);
        checkoutPage.clickCountryMeniu();
        Thread.sleep(1000);
        checkoutPage.clickSelectedCountry("LT");
        Thread.sleep(3000);
        checkoutPage.clickDeliveryExpress();
        checkoutPage.clickProceedToPayment();
        Thread.sleep(3000);
        Assertions.assertEquals("Secure checkout", checkoutPage.getSecureCheckoutText(), "Į Secure checkout puslapį nepatekote");
    }

    @Test
    void userCannotProceedToPaymentWithIncorectEmail() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(1);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        String InputEmail = DataGenerator.getRandomEmail();
        String firstName = DataGenerator.getRandomFirstName();
        String lastName = DataGenerator.getRandomLastName();
        String streetAddress = DataGenerator.getRandomStreetAddress();
        String PostCode = DataGenerator.getRandomPostCode();
        checkoutPage.sendFirstName(firstName);
        checkoutPage.sendLastName(lastName);
        checkoutPage.sendEmail("Antanas.lt");
        checkoutPage.sendAddress(streetAddress);
        checkoutPage.sendSuit("6");
        checkoutPage.sendCity("Kaunas");
        checkoutPage.sendPostCode(PostCode);
        checkoutPage.clickCountryMeniu();
        Thread.sleep(1000);
        checkoutPage.clickSelectedCountry("LT");
        Thread.sleep(3000);
        checkoutPage.clickProceedToPayment();
        Assertions.assertTrue(checkoutPage.enterValidEmailMessageIsDisplayed());
    }

    @Test
    void userCannotProceedToPaymentWithMandatoryFieldsBlank() throws InterruptedException {
        homePage = new HomePage(driver);
        detailsPage = new DetailsPage(driver);
        checkoutPage = new CheckoutPage(driver);
        homePage.navigateToAnyProduct(4);
        detailsPage.selectDifferentProductSize(1);
        detailsPage.clickBuyNow();
        Thread.sleep(3000);
        detailsPage.clickProceedToSecureCheckout();
        checkoutPage.clickProceedToPayment();
        Assertions.assertTrue(checkoutPage.firstNameIsRequiredMessageMessageIsDisplayed());
        Assertions.assertTrue(checkoutPage.emailIsRequiredMessageMessageIsDisplayed());
        Assertions.assertTrue(checkoutPage.lastNameIsRequiredMessageMessageIsDisplayed());
        Assertions.assertTrue(checkoutPage.addressIsRequiredMessageMessageIsDisplayed());
        Assertions.assertTrue(checkoutPage.cityIsRequiredMessageMessageIsDisplayed());
        Assertions.assertTrue(checkoutPage.postCodeIsRequiredMessageMessageIsDisplayed());
    }
}
