package core.fe.hotline;

import core.AbstractPage;
import core.BaseUrl;
import org.openqa.selenium.WebDriver;

@BaseUrl(value = "https://hotline.ua")
public class HotlineMainPage extends AbstractPage {

    public HotlineMainPage(final WebDriver driver) {
        super(driver);
    }
}
