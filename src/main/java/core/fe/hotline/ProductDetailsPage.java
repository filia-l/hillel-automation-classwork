package core.fe.hotline;

import core.AbstractPage;
import lombok.Data;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Data
public class ProductDetailsPage extends AbstractPage {

    @FindBy(xpath = "//h1[@datatype='card-title']")
    private WebElement phoneNameLabel;

    @FindBy(xpath = "//span[@data-add-to-cart]")
    private WebElement buyNowButton;

    private String phoneName;

    public ProductDetailsPage(final WebDriver driver) {
        super(driver);
    }

    public ShoppingCartPage clickBuyNowButton() {
        phoneName = phoneNameLabel.getText().trim();
        buyNowButton.click();
        return new ShoppingCartPage(driver);
    }

}
