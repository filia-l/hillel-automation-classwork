package core.fe.ekatalog;

import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;

import java.util.List;
import java.util.stream.Collectors;

public class EkatalogFilteredMobilePhonesPage extends AbstractPage {

    @FindBys({
            @FindBy(xpath = "//span[@class='u']")
    })
    private List<WebElement> filteredItems;

    public EkatalogFilteredMobilePhonesPage(final WebDriver driver) {
        super(driver);
    }

    public List<String> getFilterItems() {
        return filteredItems
                .stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
}
