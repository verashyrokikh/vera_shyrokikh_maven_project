package pages;

import driver.Driver;
import org.openqa.selenium.WebDriver;

public class BookingHome {
    WebDriver driver = Driver.getWebDriver();

    private static final String BOOKING_URL = "https://booking.com";
    private static  final String BOOKING_ACCEPT_CONSENTS_BUTTON_XPATH = "//button[@id='onetrust-accept-btn-handler']";
    private static final String CLOSE_GENIUS_POP_UP_XPATH = "//div[@role='dialog']";
    private static final String DISMISS_SIGN_IN_POP_UP_BUTTON_XPATH = "//button[@aria-label='Dismiss sign-in info.']";
    private static final String DESTINATION_INPUT_FIELD_XPATH = "//input[@placeholder='Where are you going?']";
    private static final String DESTINATION_DROPDOWN_FIRST_OPTION_XPATH = "//li[@id='autocomplete-result-0']/div/div/div/div[text()='London']";
    private static final String SUBMIT_SEARCH_BUTTON_XPATH = "//button[@type='submit']";
    private static final String TENTH_HOTEL = "//h2[contains(.,'Browse the results')]/following-sibling::div[22]";
}
