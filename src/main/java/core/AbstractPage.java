package core;

import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    public AbstractPage(final WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean waitForJsToLoad() {
        final String loadJsScript = "return document.readyState";
        final String loadJQueryScript = "return JQuery.active";

        ExpectedCondition<Boolean> jsLoad = driver ->
                ((JavascriptExecutor)driver).executeScript(loadJsScript).equals("complete");

        ExpectedCondition<Boolean> jQueryLoad = driver ->
                ((JavascriptExecutor)driver).executeScript(loadJQueryScript).equals("0");

        return wait.until(jsLoad) && wait.until(jQueryLoad);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}
