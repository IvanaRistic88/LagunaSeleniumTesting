package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    ChromeDriver driver = null;

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver , this);
    }

    public void sleep() {
        try {
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void print(String s) {
        System.out.println(s);
    }


}
