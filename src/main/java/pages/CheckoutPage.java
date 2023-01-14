package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;

public class CheckoutPage extends BasePage{

    //Looking for web elements

    @FindBy( xpath = "//input[@id='ime-k']")
    WebElement imeKupcaInput;

    @FindBy( xpath = "//*[@class='selectize-input']")
    WebElement drzavaSelect;

    @FindBy ( xpath =  "//input[@id='ulica-pomoc']")
    WebElement ulicaInput;

    @FindBy ( xpath =  "//input[ @id ='broj-k']")
    WebElement brojKuceInput;

    @FindBy ( xpath = "//input[@id= 'mesto-regular']")
    WebElement mestoInput;

    @FindBy ( xpath = "//input[@id = 'telefon-k']")
    WebElement telefonInput;

    @FindBy ( xpath = "//input[@id = 'email-k']")
    WebElement emailInput;

    @FindBy ( xpath = "//a[@id = 'nastaviDalje']")
    WebElement korpaDaljeButton;

    @FindBy ( xpath = "//div[@id = 'korpa-dalje']/a")
    WebElement placanjeDaljeButton;

//    @FindBy ( xpath = "//*[@id='kupovina-licni-podaci']/div[4]/label")
//    WebElement usloviKupovineCheckbox;

    @FindBy ( xpath = "//input[@id='potvrda']")
    WebElement usloviKupovineCheckbox;

    @FindBy ( xpath = "//*[@id='kupovina-licni-podaci']/div[5]/label")
    WebElement troskoviCheckbox;

    //Chrome driver
    public ChromeDriver driver = null;

    //Constructor
    public CheckoutPage(ChromeDriver driver) {

       super(driver);
       this.driver = driver;
    }

    public void buyerDetails(){
        driver.findElement(By.xpath("//*[@id='gdpr-box']/div/div[2]/a")).click();
        imeKupcaInput.sendKeys(Strings.NAME_OF_BUYER);
        //Select drzavaSpisak = new Select(drzavaSelect);
        //drzavaSelect.click();
        sleep();
        driver.findElement(By.xpath("//*[@id='kupovina-licni-podaci']/div[4]/div[2]/div[1]/div[1]")).click();
        sleep();
        driver.findElement(By.xpath("//*[@id='kupovina-licni-podaci']/div[4]/div[2]/div[1]/div[2]")).click();
        ulicaInput.sendKeys(Strings.STREET_ADDRESS);
        brojKuceInput.sendKeys(Strings.STREET_NUMBER);
        sleep();

        mestoInput.sendKeys(Strings.POSTCODE_CITY);
        telefonInput.sendKeys(Strings.PHONE);
        emailInput.sendKeys(Strings.EMAIL);

        korpaDaljeButton.click();
    }

    public void paymentMethod(){
        driver.findElement(By.xpath("//*[@id='kupovina-licni-podaci']/div[2]/div[3]/div[1]/label")).click();
        placanjeDaljeButton.click();
    }

    public void confirmBuy(){
        WebElement element = driver.findElement(By.xpath("//input[@id='potvrda']"));
        JavascriptExecutor js =(JavascriptExecutor)driver;
        js.executeScript("arguments[0].click();", element);
        troskoviCheckbox.click();

        placanjeDaljeButton.click();

    }
}
