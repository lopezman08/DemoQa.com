package Test;

import PageObjects.*;
import PageObjects.ElementsPage;
import PageObjects.HomePage;
import PageObjects.WebTablesPage;
import PageObjects.WidgetsPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import org.apache.log4j.Logger;

import java.io.IOException;
import static org.junit.Assert.assertEquals;

public class TestBrowsing extends TestBase {

    private String URLBase = "https://demoqa.com/";
    public HomePage homePage;
    public ElementsPage elementsPage;
    public WidgetsPage widgetsPage;
    public WebTablesPage webTablesPage;
    public ReadExcelFile readExcelFile;
    public  AlertsFrameWindowsPage alertsFrameWindowsPage;
    public AlertsPage alertsPage;
    public String filepath = "src/test/resources/AutomationToolsQA.xlsx";
    public JavascriptExecutor ex;
    private static final Logger LOGGER = Logger.getLogger(TestBrowsing.class);

    @Before
    public void setup(){
        driver.get(URLBase);
        homePage = new HomePage(driver);
        elementsPage = new ElementsPage(driver);
        webTablesPage = new WebTablesPage(driver);
        widgetsPage = new WidgetsPage(driver);
        readExcelFile = new ReadExcelFile();
        alertsFrameWindowsPage = new AlertsFrameWindowsPage(driver);
        alertsPage = new AlertsPage(driver);
        ex = (JavascriptExecutor) driver;
    }

    @Test
    public void AddElement() throws IOException {

        String writeFirstName = readExcelFile.getCellValue(filepath,"Data 1", 0,0);
        String writeLastName = readExcelFile.getCellValue(filepath,"Data 1", 0,1);
        String writeEmail = readExcelFile.getCellValue(filepath,"Data 1", 0,2);
        String writeAge = readExcelFile.getCellValue(filepath,"Data 1", 0,3);
        String writeSalary = readExcelFile.getCellValue(filepath,"Data 1", 0,4);
        String writeDepartment = readExcelFile.getCellValue(filepath,"Data 1", 0,5);

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
        assertEquals(writeFirstName, webTablesPage.FindText(writeFirstName).getText());

        int countElements = webTablesPage.GetCountElementsTable();
        ex.executeScript("arguments[0].click();", webTablesPage.Delete());
        assertEquals(countElements-1,webTablesPage.GetCountElementsTable());

    }

    @Test
    public void SelectDate() throws IOException {

        ex.executeScript("arguments[0].click();", homePage.BTNWidgets);
        ex.executeScript("arguments[0].click();", widgetsPage.BTNWebDatePicker);

        widgetsPage.INPDate.click();
        widgetsPage.SLCMonth.click();
        widgetsPage.SelectDate();

        widgetsPage.SLCDateTime.click();
        widgetsPage.SLCMonthTime.click();
        ex.executeScript("arguments[0].click();", widgetsPage.SLCYearDateTime);
        widgetsPage.SelectDateTime();

    }


    @Test
    public void AlertControl() throws IOException {


        Duration duration = Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, duration);

        ex.executeScript("arguments[0].click();", homePage.BTNAlertsFrameWindows);
        ex.executeScript("arguments[0].click();", alertsFrameWindowsPage.BTNAlerts);

        ex.executeScript("arguments[0].click();", alertsPage.BTNClickMeAlert);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        ex.executeScript("arguments[0].click();", alertsPage.BTNClickMeTimerAlert);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert();
        alert.accept();

        ex.executeScript("arguments[0].click();", alertsPage.BTNClickMeConfirmAlert);
        driver.switchTo().alert();
        alert.accept();

        String txtConfirmAlert = readExcelFile.getCellValue(filepath,"Data 3", 0,0);
        String txtConfirmAlertOK = readExcelFile.getCellValue(filepath,"Data 3", 0,1);
        assertEquals(txtConfirmAlert + txtConfirmAlertOK, alertsPage.TXTConfirmAlert.getText());

        String writeTextAlert = readExcelFile.getCellValue(filepath,"Data 3", 1,0);
        String confirmTextPromptAlert = readExcelFile.getCellValue(filepath,"Data 3", 2,0);
        ex.executeScript("arguments[0].click();", alertsPage.BTNClickMePromptAlert);
        driver.switchTo().alert();
        alert.sendKeys(writeTextAlert);
        alert.accept();
        assertEquals(confirmTextPromptAlert + " " + writeTextAlert, alertsPage.TXTConfirmPromptAlert.getText());
        LOGGER.info("Ejecución exitosa");

    }

    @After
    public void afterEndTest() {

    }

}
