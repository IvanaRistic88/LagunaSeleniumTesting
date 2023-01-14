package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.AddToCartPage;
import pages.InventoryPage;

/**
 * Add to cart test
 * Steps
 * 1. Navigate to a INVENTORY PAGE URL
 * 2. Click on first book on page
 * 3. On book page click add to cart
 * 4. Check if cart contains 1 (book)
 *
 * Expected results
 * 5. There is 1 (book) added to cart
 */

public class AddToCartPageTests extends BaseTest{

    @Test

    public void clickAddToCartButton () {
        ChromeDriver driver = new ChromeDriver();
            try {

                InventoryPage inventoryPage = new InventoryPage(driver);
                inventoryPage.clickPrvaKnjigaNaSpisku();

                AddToCartPage addToCartPage = new AddToCartPage(driver);
                addToCartPage.addBookToCart();

                //Add pause() to wait for cart icon to refresh and add a number
                pause();

                String brojIzKorpe = addToCartPage.getNumberFromShoppingCartIcon();
                System.out.println("Broj knjiga u korpi: " + brojIzKorpe);
                assert addToCartPage.getNumberFromShoppingCartIcon().equals("1") : "Wrong number of items. Expected: 1, Actual " + addToCartPage.getNumberFromShoppingCartIcon();
            }
           finally {
                driver.quit();
           }
    }
}
