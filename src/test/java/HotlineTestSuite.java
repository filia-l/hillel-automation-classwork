import core.fe.hotline.ProductDetailsPage;
import core.fe.hotline.ShoppingCartPage;
import core.utils.UrlBuilder;
import org.junit.Assert;
import org.junit.Test;

public class HotlineTestSuite extends BaseTest {

    @Test
    public void checkShoppingCartTest() {
        final String partialItemUrl = "mobile-mobilnye-telefony-i-smartfony/apple-iphone-x-64gb-space-gray/";
        //final String fullItemUrl = UrlBuilder.buildUrl(HotlineMainPage.class, partialItemUrl);
        final String fullPropertiesUrl = UrlBuilder.buildUrlUsingProperties("hotline.base.url", partialItemUrl);
        getWebDriver().get(fullPropertiesUrl);
        final ProductDetailsPage productDetailsPage = new ProductDetailsPage(getWebDriver());
        final ShoppingCartPage shoppingCartPage = productDetailsPage.clickBuyNowButton();

        Assert.assertEquals("There is incorrect item added to cart", productDetailsPage.getPhoneName().toLowerCase(), shoppingCartPage.getProductText().toLowerCase());
    }
}
