package core.fe.ekatalog;

import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class EkatalogMainPage extends AbstractPage {

    @FindBy(xpath = "//a[text()='Гаджеты']")
    private WebElement gadgetMenuItem;

    @FindBy(xpath = "//a[contains(text(), 'Мобильные')]")
    private WebElement mobilePhones;

    public EkatalogMainPage(final WebDriver driver) {
        super(driver);
    }

    public void hoverGadgetMenuItem() {
        actions.moveToElement(gadgetMenuItem);
    }

    public EkatalogMobilePhonesPage selectMobilePhonesMenuItem() {
        wait.until(ExpectedConditions.visibilityOf(mobilePhones));
        mobilePhones.click();
        return new EkatalogMobilePhonesPage(driver);
    }
}
