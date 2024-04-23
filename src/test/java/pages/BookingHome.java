package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class BookingHome {
    WebDriver driver = Driver.getDriver();

    private static final String BOOKING_URL = "https://booking.com";
    private static  String bookingAcceptConsentsButton = "//button[@id='onetrust-accept-btn-handler']";
    private static String geniusPopUp = "//div[@role='dialog']";
    private static String dismissSignInPopUpButton = "//button[@aria-label='Dismiss sign-in info.']";
    private static String destinationInputField = "//input[@placeholder='Where are you going?']";
    private static String destinationLondon = "London";
    private static String destinationDropdownFirstOption = "//li[@id='autocomplete-result-0']/div/div/div/div[text()='London']";
    private static String submitSearchButton = "//button[@type='submit']";
    private static String tenthHotel = "//h2[contains(.,'Browse the results')]/following-sibling::div[22]";
}
