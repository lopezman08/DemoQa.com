package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsPage {

    private static WebDriver driver;

    public AlertsPage(WebDriver driver) {
        this.driver = AlertsPage.driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//button[@id='alertButton']")
    public WebElement BTNClickMeAlert;

    @FindBy(xpath = "//button[@id='timerAlertButton']")
    public WebElement BTNClickMeTimerAlert;

    @FindBy(xpath = "//button[@id='confirmButton']")
    public WebElement BTNClickMeConfirmAlert;

    @FindBy(xpath = "//span[@id='confirmResult']")
    public WebElement TXTConfirmAlert;

    @FindBy(xpath = "//button[@id='promtButton']")
    public WebElement BTNClickMePromptAlert;

    @FindBy(xpath = "//span[@id='promptResult']")
    public WebElement TXTConfirmPromptAlert;

}
