package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {

    @FindBy( xpath = "//a[@id = 'dugme-korpa']")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@id = 'korpa_broj']")
    WebElement shoppingCartBadge;

    //Invoking Chrome driver
    public ChromeDriver driver = null;

    //Constructor
    public AddToCartPage(ChromeDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    /**
     * Method adds book to cart
     */

    public void addBookToCart () {
        addToCartButton.click();
    }

    /**
     * Method returns number of book(s) in cart from art icon
     */
    public String getNumberFromShoppingCartIcon() {
        String number = shoppingCartBadge.getText();
        return number;
    }

}
