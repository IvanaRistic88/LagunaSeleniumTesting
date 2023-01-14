package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //Selektori
    @FindBy(xpath = "//input [ @id = 'broj-f' ]" )
    WebElement userNameField;

    @FindBy(xpath = "//input [ @id = 'lozinka-f' ]" )
    WebElement passwordField;

    @FindBy(xpath = "//a[@id='form-prijava-s']")
    WebElement loginButton;

    //ovo mi je potrebno da bih mogla da koristim metode nad drajverom
    ChromeDriver driver = null;

    //ovo je konstruktor
    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        driver.get(Strings.LOGIN_PAGE_URL);
        PageFactory.initElements(driver, this);
        assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE_URL) : "User is not on Login page";
    }

    /**
     * This method checks if input is present and clicks on a field and enters username
     * @param name
     */

    public void enterUserName(String name) {
        assert userNameField.isDisplayed() : "Username field is not present";
        userNameField.click();
        userNameField.sendKeys(name);
    }

    /**
     * This method checks if input is present and clicks on a field and enters password
     * @param password
     */
    public void enterPassword(String password) {
        assert passwordField.isDisplayed() : "Password field is not present";
        passwordField.sendKeys(password);
    }

    /**
     * This method checks if button is present and clicks on login button
     */
    public void clickLoginButton() {
        assert loginButton.isDisplayed() : "Login button is not present";
        loginButton.click();
    }

    /**
     * This method combines all three methods for login in one method
     * @param userName
     * @param password
     */
    public void logInUser(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickLoginButton();
    }

}
