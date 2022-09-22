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

    public int BuscarCantidadElementosTabla () {
        boolean isVacio = false;
        int A=1;
        WebElement Resultado;
        List list;
        int cantidad =0;
        do {
            list = driver.findElements(By.xpath("//body/div[@id='app']/div[1]/div[1]/div[2]/div[2]/div[2]/div[3]/div[1]/div[2]/div["+A+"]/div[1]/div[7]/div[1]/span[2]/*[1]"));
            isVacio = list.isEmpty();
            A++;
            cantidad += list.size();
        } while (!isVacio);
        return cantidad;

    }

    public WebElement Eliminar(){
        int cantElementosTabla = 4;
        Random claseRandom = new Random(); // Esto crea una instancia de la Clase Random
        int random = claseRandom.nextInt(cantElementosTabla);
        System.out.println(random);
        return driver.findElement(By.xpath("//*[@id=\"delete-record-"+random+"\"]"));
    }
}
