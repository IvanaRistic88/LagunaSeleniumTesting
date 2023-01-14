package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.InventoryPage;
import pages.Strings;

/**
 * Check if we are on inventory (KNJIGE) page
 * Steps
 * 1. Load inventory page
 * 2. Check if a book exists on page
 * 3. Click on first book
 * 4. Assert if body tag has "knjiga_page" CSS ID
 * Expected results
 * 4. User is on book page
 **/

public class InventoryPageTests extends BaseTest{

    @Test

    public void clickFirstBook() {

        //Invoking Chrome driver
        ChromeDriver driver =  new ChromeDriver();

        try {

            //Load Inventory Page
            print("Loading Inventory page");
            InventoryPage inventoryPage = new InventoryPage(driver);
            print("Clicking first book on page");
            inventoryPage.clickPrvaKnjigaNaSpisku();

            //Check if we are redirected a(any) single book page - body should have "knjiga_page" ID
            WebElement bodyID = driver.findElementById("knjiga_page");
            assert bodyID.isDisplayed():"We are not on single book page";
        }
        finally {

            driver.quit();

        }

    }

}