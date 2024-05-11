package tests.JUnit;

import driver.Driver;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.BookingHome;
import pages.BookingHotelPage;


public class BookingJUnit {
    BookingHome bookingHome = new BookingHome();
    BookingHotelPage bookingHotelPage = new BookingHotelPage();

    @Before
    public void openBookingPage() {
        bookingHome.openBookingHomePage();
        bookingHome.acceptConsents();
        bookingHome.closeGeniusPopUp();
        bookingHome.dismissSignInPopUp();
    }

    @Test
    public void testLondon() {
        bookingHome.chooseDestination("London");
        bookingHome.confirmDestinationLondon();
        bookingHome.searchHotels();
        bookingHome.closeCalendarNotNeeded();
        bookingHome.findTenthHotel();
        bookingHome.changeHotelEntityColours();
        Driver.makeScreenShot();
    }

    @Test
    public void testPrague() {
        bookingHome.chooseDestination("Прага");
        bookingHome.confirmDestinationPrague();
        bookingHome.searchHotels();
        bookingHome.closeCalendarNotNeeded();
        bookingHome.sortByPropertyPriceLowest();
        bookingHome.viewFirstSortedHotel();
        Driver.goToLastTab();
        bookingHotelPage.checkHotelScore(8.0);
        Assert.assertTrue("Highest rating is below 8", bookingHotelPage.checkHotelScore(8.0));
    }

    @Test
    public void testParis() {
        bookingHome.chooseDestination("Paris");
        bookingHome.chooseDates(3, 10);
        bookingHome.openOccupancyConfig();
        bookingHome.addNumberOfAdults(2);
        bookingHome.addNumberOfRooms(1);
        bookingHome.submitOccupancy();
        bookingHome.searchHotels();
        bookingHome.filterByReviewScoreOver6();
        bookingHome.sortByPropertyRatingHighToLow();
        bookingHome.checkFirstHotelScore();
        Assert.assertEquals("The rating of the first hotel is not equal to 6", "6.0", bookingHome.checkFirstHotelScore());
    }

    @Test
    public void testCurrencyAndLanguage() {
        bookingHome.getCurrencySetting();
        bookingHome.checkCurrencySetting("Select your currency");
        Assert.assertTrue("Tooltip 'currency' is not 'Select your currency'", bookingHome.checkCurrencySetting("Select your currency"));
        bookingHome.getLanguageSetting();
        bookingHome.checkLanguageSetting("Select your language");
        Assert.assertTrue("Tooltip 'language' is not 'Select your language'", bookingHome.checkLanguageSetting("Select your language"));
    }

    @After
    public void closeBrowser() {
        Driver.killDriver();
    }

}
