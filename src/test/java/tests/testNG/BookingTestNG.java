package tests.testNG;

import driver.Driver;
import org.testng.annotations.AfterClass;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BookingHome;
import pages.BookingHotelPage;

public class BookingTestNG {
    BookingHome bookingHome = new BookingHome();
    BookingHotelPage bookingHotelPage = new BookingHotelPage();

    @Test
    public void testLondon() {
        bookingHome.openBookingHomePage();
        bookingHome.acceptConsents();
        bookingHome.closeGeniusPopUp();
        bookingHome.dismissSignInPopUp();
        bookingHome.chooseDestination("London");
        bookingHome.confirmDestinationLondon();
        bookingHome.searchHotels();
        bookingHome.closeCalendarNotNeeded();
        bookingHome.findTenthHotel();
        bookingHome.changeHotelEntityColours();
        Driver.makeScreenShot();
        Driver.killDriver();
    }

    @Test
    public void testPrague() {
        bookingHome.openBookingHomePage();
        bookingHome.acceptConsents();
        bookingHome.closeGeniusPopUp();
        bookingHome.dismissSignInPopUp();
        bookingHome.chooseDestination("Прага");
        bookingHome.confirmDestinationPrague();
        bookingHome.searchHotels();
        bookingHome.closeCalendarNotNeeded();
        bookingHome.sortByPropertyPriceLowest();
        bookingHome.viewFirstSortedHotel();
        Driver.goToLastTab();
        bookingHotelPage.checkHotelScore(8.0);
        Assert.assertTrue(bookingHotelPage.checkHotelScore(8.0), "Highest rating is below 8");
        Driver.killDriver();
    }

    @Test
    public void testParis() {
        bookingHome.openBookingHomePage();
        bookingHome.acceptConsents();
        bookingHome.closeGeniusPopUp();
        bookingHome.dismissSignInPopUp();
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
        Assert.assertEquals("6.0", bookingHome.checkFirstHotelScore(),"The rating of the first hotel is not equal to 6");
        Driver.killDriver();
    }

    @Test
    public void testCurrencyAndLanguage() {
        bookingHome.openBookingHomePage();
        bookingHome.acceptConsents();
        bookingHome.closeGeniusPopUp();
        bookingHome.dismissSignInPopUp();
        bookingHome.getCurrencySetting();
        bookingHome.checkCurrencySetting("Select your currency");
        Assert.assertTrue(bookingHome.checkCurrencySetting("Select your currency"), "Tooltip 'currency' is not 'Select your currency'");
        bookingHome.getLanguageSetting();
        bookingHome.checkLanguageSetting("Select your language");
        Assert.assertTrue(bookingHome.checkLanguageSetting("Select your language"), "Tooltip 'language' is not 'Select your language'");
        Driver.killDriver();
    }

//    @AfterClass
//    public void closeBrowser() {
//        Driver.killDriver();
//    }
}
