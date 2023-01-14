package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import pages.SocialMediaPage;
import pages.Strings;
import java.util.ArrayList;

import static java.lang.Thread.sleep;

/**
 * TEST SOCIAL MEDIA BUTTONS
 * Steps
 * 1. Navigate to Laguna.rs main page
 * 2. Click on the FACEBOOK icon
 * 3. Click on the TWITTER icon
 * 4. Click on the INSTAGRAM icon
 * 5. Click on the YOUTUBE icon
 * 6. Click on the TIKTOK icon
 *
 * Expected results
 * 7. User is successfully redirected to each Social Media page of Laguna.rs
 */

public class SocialMediaTests extends BaseTest {

    @Test

    public void socialMediaTests() {

        //Loading Chrome driver
        ChromeDriver driver = openChromeDriver();

        try {

            driver.get(Strings.MAIN_PAGE_URL);

            print("Clicking icons that redirect to FACEBOOK, TWITTER, INSTAGRAM, YOUTUBE and TIKTOK social pages of the Laguna.rs");

            //Testing Facebook
            print( "Testing Facebook button");
            SocialMediaPage socialMedia = new SocialMediaPage(driver);
            socialMedia.testFacebookButton();
            ArrayList<String> tab = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab.get(1));
            String currentURL = driver.getCurrentUrl();
            assert currentURL.equals("https://www.facebook.com/LagunaKnjige/") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));

            //Testing Twitter
            print( "Testing Twitter button");
            socialMedia.testTwitterButton();
            ArrayList<String> tab1 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab1.get(1));
            String currentURL1 = driver.getCurrentUrl();
            assert currentURL1.equals("https://twitter.com/IPLaguna") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));

            //Testing Instagram
            print( "Testing Instagram button");
            socialMedia.testInstagramButton();
            ArrayList<String> tab2 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab2.get(1));
            String currentURL2 = driver.getCurrentUrl();
            assert currentURL2.equals("https://www.instagram.com/laguna_knjige/") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));

            //Test YouTube
            print( "Testing YouTube button");
            socialMedia.testYouTubeButton();
            ArrayList<String> tab3 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab3.get(1));
            String currentURL3 = driver.getCurrentUrl();
            assert currentURL3.equals("https://www.youtube.com/user/lagunaknjige") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));

            //Test YouTube
            print( "Testing TikTok button");
            socialMedia.testTikTokButton();
            ArrayList<String> tab4 = new ArrayList<>(driver.getWindowHandles());
            driver.switchTo().window(tab4.get(1));
            String currentURL4 = driver.getCurrentUrl();
            assert currentURL4.equals("https://www.tiktok.com/@laguna_knjige") : "User is on the wrong page. " + "  Actual: " + currentURL;
            driver.close();
            driver.switchTo().window(tab.get(0));

        } finally {

            driver.quit();

        }

    }
}
