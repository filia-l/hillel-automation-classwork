import core.fe.booking.BookingAirtickestPage;
import core.fe.booking.BookingComMainPage;
import org.junit.Assert;
import org.junit.Test;

public class BookingComTestSuite extends BaseTest {


    @Test
    public void checkAirTicketsWindoe() {
        getWebDriver().get("https://www.booking.com/");
        BookingComMainPage bookingMainPage = new BookingComMainPage(getWebDriver());
        BookingAirtickestPage airTicketsPage = bookingMainPage.clickAirTicketsButton();

        String expectedTitle = "Найдите авиабилеты на Booking.com";
        Assert.assertEquals(expectedTitle, airTicketsPage.getPageTitle());
    }
}
