import com.google.gson.Gson;
import core.be.PetStoreApi;
import core.be.dto.Category;
import core.be.dto.PetModel;
import core.be.dto.Tag;
import core.utils.UrlBuilder;
import io.restassured.response.Response;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class
PetStoreTestSuite {

    @Test
    public void checkAddNewPetApi() {

        final PetModel requestBody = new PetModel();
        final Tag[] tags = {new Tag (13, "TestTag")};

        requestBody.setId(System.currentTimeMillis());
        requestBody.setCategory(new Category(12, "TestCategory"));
        requestBody.setTags(tags);
        requestBody.setName("petName");
        requestBody.setPhotoUrls(new String[] {"1"});

        final Gson gson = new Gson();
        final String requestBodyString = gson.toJson(requestBody);

        final PetStoreApi petStoreApi = new PetStoreApi();
        final PetModel response = petStoreApi.addNewPet(requestBodyString);
    }

    @Test
    public void checkAddNewPetUsingJson() throws IOException {
        final long id = System.currentTimeMillis();
        final Gson gson = new Gson();

        final String jsonPath = UrlBuilder.getPropertyValue("create.new.pet.json");
        final String addNewPetRequestBody = FileUtils.readFileToString(new File(jsonPath), Charset.defaultCharset());

        final PetModel petModel = gson.fromJson(addNewPetRequestBody, PetModel.class);
        petModel.setId(id);
        final String requestBodyWithDynamicId = gson.toJson(petModel);

        final PetStoreApi petStoreApi = new PetStoreApi();
        final PetModel response = petStoreApi.addNewPet(requestBodyWithDynamicId);
    }

    //not finished
    @Test
    public void checkDeleteNewPetUsingJson() throws IOException {
        final long id = System.currentTimeMillis();
        final Gson gson = new Gson();
        final String jsonPath = UrlBuilder.getPropertyValue("create.new.pet.json");
        final String addNewPetRequestBody = FileUtils.readFileToString(new File(jsonPath), Charset.defaultCharset());

        final PetModel petModel = gson.fromJson(addNewPetRequestBody, PetModel.class);
        petModel.setId(id);
        final String requestBodyWithDynamicId = gson.toJson(petModel);

        final PetStoreApi petStoreApi = new PetStoreApi();
        petStoreApi.addNewPet(requestBodyWithDynamicId);

        petStoreApi.deletePet(id);
    }
}
