import core.be.SportchekApi;
import io.restassured.response.Response;
import org.junit.Test;
import org.openqa.selenium.Cookie;

import java.util.Map;

public class SportchekTestSuite extends BaseTest {

    @Test
    public void checkAddingItemByApi() {

        final SportchekApi sportchekApi = new SportchekApi();
        final String requestBody = "{\"itemEntries\":[{\"code\":\"331523434\",\"productPictureUrl\":\"//fgl.scene7.com/is/image/FGLSportsLtd/FGL_331523397_01_a\",\"productPageUrl\":\"https://www.sportchek.ca/categories/women/womens-jackets-coats-vests/rain-jackets/product/columbia-womens-arcadia-ii-2l-shell-jacket-331523397.html#331523397=331523434\",\"quantity\":\"1\"}]}";
        final Response response = sportchekApi.addItemToCart(requestBody);
        final Map <String, String> cookies = response.getCookies();

        getWebDriver().get("https://www.sportchek.ca");
        cookies.forEach((key, value) -> getWebDriver().manage().addCookie(new Cookie(key, value)));
        getWebDriver().navigate().refresh();
    }

}
