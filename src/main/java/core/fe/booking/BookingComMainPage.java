package core.fe.booking;

import core.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Set;

public class BookingComMainPage extends AbstractPage {

    @FindBy(xpath = "//input[@type='search']")
    private WebElement searchDestinationField;

    @FindBy(xpath = "//div[@class='xp__dates-inner']")
    private WebElement selectDatesField;

    @FindBy(xpath = "//a[@data-ga-track='click|Product Expansion|flights|kayak (index)']")
    private WebElement airTicketsButton;

    //@FindBy(xpath = "//div[@class='bui-calendar__month'][contains(text(), 'Март')]/..//td")
    //private WebElement se;

    @FindBy(xpath = "//*[@id='xp__guests__toggle']")
    private WebElement detailsField;

    public List<WebElement> getDatesWithinMonth(String month) {
        return driver.findElements(By.xpath("//div[@class='bui-calendar__month'][contains(text(), ' " +month+ " ')]/..//td"));
    }

    public BookingComMainPage(final WebDriver driver) {
        super(driver);
    }

    public void selectDate(String month, String dateToSelect) {
        getDatesWithinMonth(month)
                .stream()
                .filter(date -> date.getText().equals(dateToSelect))
                .forEach(WebElement::click);
    }

    public BookingAirtickestPage clickAirTicketsButton() {
        airTicketsButton.click();
        final String currentWindowHandle = driver.getWindowHandle();
        final Set<String> windowHandles = driver.getWindowHandles();
        for(final String handle : windowHandles) {
            if(!currentWindowHandle.equals(handle)) {
                driver.switchTo().window(handle);
            }
        }
        return new BookingAirtickestPage(driver);
    }
}
