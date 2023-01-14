package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage {

    //Selektori
    @FindBy(xpath = "//a[@href = 'kupovina_unos_podataka.html']")
    WebElement checkoutButton;

    @FindBy(xpath = "//div[@id = 'korpa']")
    WebElement cartIcon;

    //ovo mi je potrebno da bih mogao da koristim metode nad drajverom
    ChromeDriver driver = null;

    //Konstruktor
    public ShoppingCartPage(ChromeDriver driver) {
        this.driver = driver;
        driver.get(Strings.MAIN_PAGE_URL);
        PageFactory.initElements(driver, this);
        assert driver.getCurrentUrl().equals(Strings.MAIN_PAGE_URL) : "User is not on main page";
    }

    /**
     * Method clicks Cart Icon to load Shopping Cart page
     * @param
     */
    public void clickCartIcon (){
        assert cartIcon.isDisplayed() : "Cart icon is not present";
        cartIcon.click();
        assert driver.getCurrentUrl().equals(Strings.SHOPPING_CART_PAGE_URL) : "User is not on LOGIN page";
    }

    /**
     * Method clicks "DALJE" button to proceed to checkout
     * @param
     */
    public void clickCheckoutButton() {
        //assert checkoutButton.isDisplayed() : "Checkout button is not present on page";
        checkoutButton.click();
    }

}
