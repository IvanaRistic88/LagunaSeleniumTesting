package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.*;

/**
 * Add to cart test
 * Steps
 * 1. Click on first book on page on inventory page to go to single book page
 * 2. On single book page click add to cart and then click cart icon
 * 4. On shopping cart page click "DALJE" to go to checkout
 * 5. Fill in checkout page first step fields (user details) and click on "DALJE"
 * 6. Fill in checkout page second step fields (paymant methods) and click on "DALJE"
 * 7. On confirm order page check "uslovi kupovine" and "troskovi" checkboxes and click on "KUPOVINA"
 * Expected results
 * 5. You have landed on confirmed order/thank you page
 */

public class CheckoutPageTests {

    @Test
    public void testBookBuying() {

        //Invoking Chrome driver
        ChromeDriver driver = new ChromeDriver();

        try {

            //Adding products to shopping chart
            InventoryPage inventoryPage = new InventoryPage( driver );
            inventoryPage.clickPrvaKnjigaNaSpisku();
            AddToCartPage addToCartPage = new AddToCartPage(driver);
            addToCartPage.addBookToCart();
            //Going to Cart Page
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            shoppingCartPage.clickCartIcon();
            //Going to Checkout page step 1
            shoppingCartPage.clickCheckoutButton();
            CheckoutPage checkoutPage = new CheckoutPage(driver);
            //Fill in buyer details
            checkoutPage.buyerDetails();
            //Select payment method
            checkoutPage.paymentMethod();
            //FConfirm nying a book
            checkoutPage.confirmBuy();

            //Check if we are redirected to thank you page
            String currentURL = driver.getCurrentUrl();
            assert currentURL.equals(Strings.THANK_YOU_PAGE_URL) : "User is on not on the THANK YOU page " + "  Actual: " + currentURL;
        }
        finally {

            driver.quit();

        }

    }
}
