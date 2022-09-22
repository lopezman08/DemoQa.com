package Test;

import PageObjects.ElementsPage;
import PageObjects.HomePage;
import PageObjects.WebTablesPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;


public class TestBrowsing extends TestBase {

    //PageObjects que vamos a usar en este grupo de pruebas.
    private String URLBase = "https://demoqa.com/";
    public HomePage homePage;
    public ElementsPage elementsPage;
    public WebTablesPage webTablesPage;
    public ReadExcelFile readExcelFile;

    @Before
    public void setup(){
        driver.get(URLBase);
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        webTablesPage = new WebTablesPage(driver);
        readExcelFile = new ReadExcelFile();
    }

    @Test
    public void Mi_Test_Case() throws IOException {

        String filepath = "C:\\Users\\oscar.lopez\\Documents\\AutomationToolsQA.xlsx";
        String texto = "Kierra";

        String writeFirstName = readExcelFile.getCellValue(filepath,"Data 1", 0,0);
        String writeLastName = readExcelFile.getCellValue(filepath,"Data 1", 0,1);
        String writeEmail = readExcelFile.getCellValue(filepath,"Data 1", 0,2);
        String writeAge = readExcelFile.getCellValue(filepath,"Data 1", 0,3);
        String writeSalary = readExcelFile.getCellValue(filepath,"Data 1", 0,4);
        String writeDepartment = readExcelFile.getCellValue(filepath,"Data 1", 0,5);

        JavascriptExecutor ex = (JavascriptExecutor) driver;
        ex.executeScript("arguments[0].click();", homePage.BTNElements);
        ex.executeScript("arguments[0].click();", elementsPage.BTNWebTables);
        ex.executeScript("arguments[0].click();", webTablesPage.BTNAdd);

        webTablesPage.TXTFirstName.sendKeys(writeFirstName);
        webTablesPage.TXTLastName.sendKeys(writeLastName);
        webTablesPage.TXTEmail.sendKeys(writeEmail);
        webTablesPage.TXTAge.sendKeys(writeAge);
        webTablesPage.TXTSalary.sendKeys(writeSalary);
        webTablesPage.TXTDepartment.sendKeys(writeDepartment);
        webTablesPage.BTNSubmit.click();
        ex.executeScript("arguments[0].click();", webTablesPage.Eliminar());

    }

    @After
    public void afterEndTest() {

    }

}
