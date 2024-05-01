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
    private static final String CALENDAR_CHECK_IN_XPATH = "//span[text()='Check-in Date']";
    private static final String OCCUPATION_CONFIG_XPATH ="//button[@data-testid='occupancy-config']";
    private static final String ADD_ADULTS_XPATH = "//*[@id='group_adults']/../div/button[2]";
    private static final String ADD_ROOMS_XPATH = "//*[@id='group_adults']/../following-sibling::div[2]/div/button[2]";
    private static final String SUBMIT_OCCUPANCY_CHOICE_XPATH = "//div[@data-testid='occupancy-popup']/button";
    private static final String SIDEBAR_PRESENCE_XPATH = "//div[@class='b4b4b2787f']/div[@data-testid='filters-sidebar']/div[7]";
    private static final String CHECKBOX_SCORE_RATING_6_XPATH = "//input[@id=':r1g:' and @value='review_score=60']/../label";
    private static final String LABEL_SCORE_RATING_CHOSEN_XPATH = "//label[@data-testid='filter:review_score=60']";
    private static final String OPEN_SORTERS_DROPDOWN_XPATH = "//button[@data-testid='sorters-dropdown-trigger']";
    private static final String CHOOSE_SORTING_PROPERTY_RATING_LOW_TO_HIGH_XPATH = "//div[@data-testid='sorters-dropdown']/div/div/div/ul/li[6]";
    private static final String CHOOSE_SORTING_PROPERTY_PRICE_LOWEST_XPATH = "//div[@data-testid='sorters-dropdown']/div/div/div/ul/li[3]";
    private static final String REVIEW_SCORE_FIRST_SORTED_HOTEL = "(//div[@data-testid='review-score']/div)[1]";
    private static final String DESTINATION_DROPDOWN_FIRST_OPTION_XPATH = "//li[@id='autocomplete-result-0']/div/div/div/div[text()='London']";
    private static final String DESTINATION_DROPDOWN_PRAGUE_OPTION_XPATH = "//div[text()='Прага']";
    private static final String SUBMIT_SEARCH_BUTTON_XPATH = "//button[@type='submit']";
    private static final String NOTICE_BANNER_XPATH = "//section/div/div/div/button";
    private static final String FIRST_HOTEL_PHOTO_XPATH = "(//div)[@data-testid='property-card-container'][1]/div/div/a";
    private static final String TENTH_HOTEL = "//h2[contains(.,'Browse the results')]/following-sibling::div[22]";
    private static String calendarStartDate = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    private static String calendarEndDate = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    private static final String CURRENCY_PICKER_ICON_XPATH = "//button[@data-testid='header-currency-picker-trigger']";
    private static final String CURRENCY_TOOLTIP_XPATH = "//div[text()='Select your currency']";
    private static final String LANGUAGE_PICKER_ICON_XPATH = "//button[@data-testid='header-language-picker-trigger']";
    private static final String LANGUAGE_TOOLTIP_XPATH = "//div[text()='Select your language']";
}
