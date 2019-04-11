import core.fe.ekatalog.EkatalogFilteredMobilePhonesPage;
import core.fe.ekatalog.EkatalogMainPage;
import core.fe.ekatalog.EkatalogMobilePhonesPage;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class EkatalogTestSuite extends BaseTest {

    @Test
    public void checkFilteringProcessTest() {
        getWebDriver().get("https://ek.ua");
        final EkatalogMainPage ekatalogMainPage = new EkatalogMainPage(getWebDriver());
        ekatalogMainPage.hoverGadgetMenuItem();
        final EkatalogMobilePhonesPage ekatalogMobilePhonesPage = ekatalogMainPage.selectMobilePhonesMenuItem();
        ekatalogMobilePhonesPage.applyFiter();
        final EkatalogFilteredMobilePhonesPage ekatalogFilteredMobilePhonesPage = ekatalogMobilePhonesPage.clickShowMoreItems();
        final List<String> filteredItems = ekatalogFilteredMobilePhonesPage.getFilterItems();
        Assert.assertFalse("There are no items in list", filteredItems.isEmpty());
        filteredItems.forEach(item -> {
            String filterItemText = String.format("Incorrect item displayed! Expected: %s, got: %s", "Apple", item);
            Assert.assertTrue(filterItemText, item.contains("Apple"));
        });
    }
}
