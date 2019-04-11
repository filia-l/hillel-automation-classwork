package core.fe.hotline;

import core.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends AbstractPage {

    @FindBy(xpath = "//a[@class='italic']")
    private WebElement addedProduct;

    public ShoppingCartPage(final WebDriver driver) {
        super(driver);
    }

    public String getProductText() {
        return addedProduct.getText().trim();
    }
}
