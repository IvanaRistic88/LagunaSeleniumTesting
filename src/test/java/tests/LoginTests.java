package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.Strings;

/**
 * Login test for Laguna.rs with VALID credentials
 * Steps
 * 1. Navigate to a login page
 * 2. Click and type in VALID USERNAME
 * 3. Click and type in VALID PASWWORD
 * 4. Click LOGIN button
 * Expected results
 * 5. User is successfully logged in to Laguna.rs

 * Login test for Laguna.rs with INVALID credentials
 * Steps
 * 1. Navigate to a login page
 * 2. Click and type in INVALID USERNAME
 * 3. Click and type in INVALID PASWWORD
 * 4. Click LOGIN button
 * Expected results
 * 5. User is not successfully logged in to Laguna.rs, stays on login page
 */

public class LoginTests extends BaseTest {

    @Test
    public void loginWithValidCreds() {
        ChromeDriver driver =  new ChromeDriver();
        try {
            print("Logging in with valid username and password");
            LoginPage loginPage = new LoginPage(driver);

            //Enter valid username and password and click login
            loginPage.logInUser(Strings.VALID_USERNAME,Strings.VALID_PASSWORD );

            //Check if we are redirected to Laguna.rs main page
            driver.get(Strings.MAIN_PAGE_URL);
            String currentURL = driver.getCurrentUrl();
            assert currentURL.equals(Strings.MAIN_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;
        }finally {
            driver.quit();
        }
    }

    /**
     *
     */
    @Test
    public void loginWithInValidUserName() {
        ChromeDriver driver =  new ChromeDriver();
        try {
            print("Logging in with invalid username and password");
            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserName(Strings.INVALID_USERNAME);
            loginPage.enterPassword(Strings.INVALID_PASSWORD);
            loginPage.clickLoginButton();

            //Check if we are on Laguna.rs login page
            driver.get(Strings.LOGIN_PAGE_URL);
            String currentURL = driver.getCurrentUrl();
            assert currentURL.equals(Strings.LOGIN_PAGE_URL) : "User is on the wrong page. " + "  Actual: " + currentURL;
        }finally {
            driver.quit();
        }
    }

}
