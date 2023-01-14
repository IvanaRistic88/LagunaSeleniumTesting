package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SocialMediaPage {

    //Selektori
    @FindBy(xpath = "//a [ @href = 'https://www.facebook.com/laguna.knjige' ]")
    WebElement facebookButton;

    @FindBy(xpath = "//a [ @href = 'http://twitter.com/IPLaguna' ]")
    WebElement twitterButton;

    @FindBy(xpath = "//a [ @href = 'https://www.instagram.com/laguna_knjige/' ]")
    WebElement instagramButton;

    @FindBy(xpath = "//a [ @href = 'https://www.youtube.com/user/lagunaknjige' ]")
    WebElement youtubeButton;

    @FindBy(xpath = "//a [ @href = 'https://www.tiktok.com/@laguna_knjige' ]")
    WebElement tiktokButton;

    //Invoking Chrome driver
    public ChromeDriver driver = null;

    //Konstruktor
    public SocialMediaPage(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Metode
    /**
     * THIS Method redirect user to Facebook page of Laguna.rs
     */

    public void testFacebookButton( ) {

        assert facebookButton.isDisplayed( ) : "Facebook button is not present. Expected to be there";

        facebookButton.click( );

    }

    /**
     * Method redirect user to Twitter page of Laguna.rs
     */

    public void testTwitterButton( ) {

        assert twitterButton.isDisplayed( ) : "Twitter button is not present. Expected to be there";

        twitterButton.click( );

    }

    /**
     * Method redirect user to Instagram page of Laguna.rs
     */

    public void testInstagramButton() {

        assert instagramButton.isDisplayed() : "Instagram button is not present. Expected to be there";

        instagramButton.click();

    }

    /**
     * Method redirect user to YouTube page of Laguna.rs
     */

    public void testYouTubeButton() {

        assert youtubeButton.isDisplayed() : "YouTube button is not present. Expected to be there";

        youtubeButton.click();

    }

    /**
     * Method redirect user to TikTok page of Laguna.rs
     */

    public void testTikTokButton() {

        assert tiktokButton.isDisplayed() : "TikTok button is not present. Expected to be there";

        tiktokButton.click();

    }


}
