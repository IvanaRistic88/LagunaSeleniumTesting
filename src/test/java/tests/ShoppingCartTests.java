package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.ShoppingCartPage;


/**
 * Test for loading Shopping Cart Page on Laguna.rs
 * Steps
 * 1. Navigate to Main page
 * 2. Click Cart Icon
 * Expected results
 * 5. User is on Shopping Cart page of Laguna.rs
 */

public class ShoppingCartTests {

    @Test
    public void clickCartIcon () {
        ChromeDriver driver = new ChromeDriver();
        try {
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            shoppingCartPage.clickCartIcon ();

        }
        finally {
            driver.quit();
        }
    }
}
