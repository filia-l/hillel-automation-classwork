package core.fe.ekatalog;

import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EkatalogMobilePhonesPage extends AbstractPage {

    @FindBy(xpath = "//label[./a[text()='Apple']]")
    private WebElement filterCheckBox;

    @FindBy(xpath = "//*[@class='show-models']")
    private WebElement showMoreItems;

    public EkatalogMobilePhonesPage(final WebDriver driver) {
        super(driver);
    }

    public void applyFiter() {
        filterCheckBox.click();
    }

    public EkatalogFilteredMobilePhonesPage clickShowMoreItems() {
        wait.until(ExpectedConditions.visibilityOf(showMoreItems));
        showMoreItems.click();
        return new EkatalogFilteredMobilePhonesPage(driver);
    }
}
