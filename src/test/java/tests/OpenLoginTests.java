package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.OpenLoginPage;

/**
 * Load login page test
 * Steps
 * 1. Navigate to a MAIN PAGE URL
 * 2. Click on Prijava in header
 * Expected results
 * 3. User is on LOGIN PAGE Laguna.rs
*/

public class OpenLoginTests extends BaseTest {

    @Test
    public void clickToOpenLoginPage() {
        ChromeDriver driver =  new ChromeDriver();
        try {
            //Test of loading Login page
            print("Opening Login Page");
            OpenLoginPage openLoginPage = new OpenLoginPage(driver);

            //Click "Prijava" to load login page
            openLoginPage.loadLoginPage();

        }finally {
            driver.quit();
        }
    }
}
