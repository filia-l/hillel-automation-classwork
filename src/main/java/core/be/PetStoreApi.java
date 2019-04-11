package core.be;

import core.be.dto.PetModel;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class PetStoreApi extends AbstractApi {

        private static final String ADD_NEW_PET_PARTIAL_LINK = "v2/pet";

        public PetModel addNewPet(final String petBody) {
            return RestAssured.given()
                    .contentType(ContentType.JSON)
                    .body(petBody)
                    .post(ADD_NEW_PET_PARTIAL_LINK)
                    .as(PetModel.class);
        }

        public void deletePet(final long petId) {
            RestAssured.given()
                .contentType(ContentType.JSON)
                .delete(ADD_NEW_PET_PARTIAL_LINK + "/" + petId);
        }

    public Response getPet(final long petId) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .get(ADD_NEW_PET_PARTIAL_LINK + "/" + petId)
                .as(Response.class);
    }

    @Override
    protected String setUpBaseUrl() {
        final String apiBaseUrl = "https://petstore.swagger.io/";
        return apiBaseUrl;
    }
}
