package core.fe.google;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class GoogleSearchResultsPage {

    @FindBys({
            @FindBy(xpath = "//div[@class='rc']//h3")
    })
    private List<WebElement> searchResultLinks;

    private WebDriver driver;

    public GoogleSearchResultsPage(final WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<String> getSearchResultsItems() {
        return searchResultLinks.stream()
                .map(element -> element.getText())
                .collect(Collectors.toList());
    }
}
