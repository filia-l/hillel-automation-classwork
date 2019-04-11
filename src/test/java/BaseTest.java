import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver webDriver;

    public WebDriver getWebDriver() {
        return webDriver;
    }

    @Before
    public void driverSetUp() {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.manage().window().maximize();
    }

    @After
    public void driverTearDown() {
        webDriver.close();
        webDriver.quit();
    }
}
