package Test;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class TestBase {

    protected WebDriver driver;
    protected String URLBase;

    @Before
    public void SetUp() {
        String navigator = "chrome";
        String DriverPath ="src/test/resources/";

        switch (navigator){
            case "firefox":
                System.setProperty("webdriver.chrome.driver", DriverPath+ "geckodriver.exe");
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", DriverPath+"chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--incognito");
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                driver = new ChromeDriver();
                break;
            default:
                break;
        }
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}
