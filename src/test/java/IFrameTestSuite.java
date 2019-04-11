import core.fe.iframe.SiteWithIFrameMainPage;
import org.junit.Assert;
import org.junit.Test;

public class IFrameTestSuite extends BaseTest {

    @Test
    public void checkIFrameTest() {
        getWebDriver().get("https://jsfiddle.net/westonruter/6mSuK");
        final SiteWithIFrameMainPage iFrameMainPage = new SiteWithIFrameMainPage(getWebDriver());
        iFrameMainPage.searchWikiFor("Bitcoin");
        final String searchWikiResult = iFrameMainPage.getWikiSearchTitleText();

        Assert.assertEquals("Incorrect search result displayed","Bitcoin", searchWikiResult );
    }
}
