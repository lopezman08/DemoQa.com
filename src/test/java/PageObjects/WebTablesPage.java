package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class WebTablesPage {

    private static WebDriver driver;

    public WebTablesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//*[@id=\"addNewRecordButton\"]")
    public WebElement BTNAdd;

    @FindBy(xpath = "//input[@id='firstName']")
    public WebElement TXTFirstName;

    @FindBy(xpath = "//input[@id='lastName']")
    public WebElement TXTLastName;

    @FindBy(xpath = "//input[@id='userEmail']")
    public WebElement TXTEmail;

    @FindBy(xpath = "//input[@id='age']")
    public WebElement TXTAge;

    @FindBy(xpath = "//input[@id='salary']")
    public WebElement TXTSalary;

    @FindBy(xpath = "//input[@id='department']")
    public WebElement TXTDepartment;

    @FindBy(xpath = "//button[@id='submit']")
    public WebElement BTNSubmit;

    public int GetCountElementsTable() {
        List<WebElement> list_Al = driver.findElements(By.xpath("//span[contains(@id,'delete-record')]"));
        return list_Al.size();
    }

    public WebElement Delete(){
        int cantElementsTable = GetCountElementsTable();
        int random = (int)(Math.random()*cantElementsTable+1);
        return driver.findElement(By.xpath("//*[@id=\"delete-record-"+random+"\"]"));
    }

    public WebElement FindText(String text){
        return driver.findElement(By.xpath("//div[text()='"+text+"']"));
    }
}
