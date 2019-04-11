package core.be;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class SportchekApi extends AbstractApi {

    private static final String PARTIAL_CART_ENTRY_PATH = "/services/sportchek/cart/entry";

    public Response addItemToCart(final String requestBody) {
        final Response cartResponce = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post(PARTIAL_CART_ENTRY_PATH);
        return cartResponce;
    }

    @Override
    protected String setUpBaseUrl() {
        final String apiBaseUrl = "https://www.sportchek.ca";
        return apiBaseUrl;
    }
}
