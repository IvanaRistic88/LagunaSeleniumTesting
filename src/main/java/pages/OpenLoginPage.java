package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OpenLoginPage {

    @FindBy( xpath = "//a [ @href= 'prijava.html' ]" )
    WebElement loadLoginPageLink;

    //ovo mi je potrebno da bih mogao da koristim metode nad drajverom
    ChromeDriver driver = null;

    //ovo je konstruktor - ucitavam naslovnu stranu da bih mogla da kliknem na Prijava link
    public OpenLoginPage(ChromeDriver driver) {
        this.driver = driver;
        driver.get(Strings.MAIN_PAGE_URL);
        PageFactory.initElements(driver, this);
        assert driver.getCurrentUrl().equals(Strings.MAIN_PAGE_URL) : "User is not on MAIN page";
    }

    /**
     * Method clicks Prijava to load Login Page
     * @param
     */

    public void loadLoginPage() {
        assert loadLoginPageLink.isDisplayed() : "Login link is not present";
        loadLoginPageLink.click();
        assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "User is not on LOGIN page";
    }
}
