import core.fe.google.GoogleMainPage;
import core.fe.google.GoogleSearchResultsPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GoogleTestSuite extends BaseTest {

    @Test
    public void checkGoogleMainPageTest() {
        getWebDriver().get("https://www.google.com");
        String title = getWebDriver().getTitle();
        Assert.assertEquals("Incorrect title","Google", title);
    }

    @Test
    public void checkGoogleSearchTest() {
        getWebDriver().get("https://www.google.com");
        WebElement searchInput = getWebDriver().findElement(By.xpath("//input[@name='q']"));
        searchInput.sendKeys("hillel", Keys.ENTER);
        List<WebElement> searchResultLinks = getWebDriver().findElements(By.xpath("//div[@class='rc']//h3")); // "//cite/../../h3"
        Assert.assertFalse("No links displayed", searchResultLinks.isEmpty());

        for(WebElement searchLink : searchResultLinks) {
            String text = searchLink.getText().toLowerCase();
            String failedTestMessage = String.format("There is incorrect link text in link [%s]", text);
            Assert.assertTrue(failedTestMessage, text.contains("hillel"));
        }
    }

    @Test
    public void checkGoogleSearchTestUsingOop() {
        getWebDriver().get("https://www.google.com");
        final GoogleMainPage mainPage = new GoogleMainPage(getWebDriver());
        final GoogleSearchResultsPage searchResultPage = mainPage.searchFor("hillel");
        final List<String> searchResults = searchResultPage.getSearchResultsItems();
        searchResults.forEach(item -> {
            String failedTestMessage = String.format("There is incorrect link text in link [%s]", item);
            Assert.assertTrue(failedTestMessage, item.toLowerCase().contains("hillel"));
        });
    }
}
