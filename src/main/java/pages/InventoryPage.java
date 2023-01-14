package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

public class InventoryPage extends BasePage{

    //Selektor
    @FindBy(xpath = "//div [contains(@class,'knjiga')]")
    WebElement prvaKnjigaNaSpisku;

    //Konstruktor
    public InventoryPage(ChromeDriver driver) {
        super(driver);
        driver.get(Strings.INVENTORY_PAGE_URL);
        assert driver.getCurrentUrl().equals(Strings.INVENTORY_PAGE_URL) : "User is not on Inventory page";
    }

    //Proveravam da li sam na Inventory stranici - da li postoji knjiga i klickem na nju
    public void clickPrvaKnjigaNaSpisku() {
        assert prvaKnjigaNaSpisku.isDisplayed() : "There are no books on page";
        prvaKnjigaNaSpisku.click();
    }
}
