package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private static WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div/div[1]/div/div[1]")
    public WebElement BTNElements;
    @FindBy(xpath = "//*[@id='app']/div/div/div[2]/div/div[4]")
    public WebElement BTNWidgets;

    @FindBy(xpath = "//body/div[@id='app']/div[1]/div[1]/div[2]/div[1]/div[3]")
    public WebElement BTNAlertsFrameWindows;


}
