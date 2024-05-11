package pages;

import driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

public class BookingHome {
    WebDriver driver = Driver.getWebDriver();

    private static final String BOOKING_URL = "https://booking.com";
    private static final String BOOKING_ACCEPT_CONSENTS_BUTTON_XPATH = "//button[@id='onetrust-accept-btn-handler']";
    private static final String CLOSE_GENIUS_POP_UP_XPATH = "//div[@role='dialog']";
    private static final String DISMISS_SIGN_IN_POP_UP_BUTTON_XPATH = "//button[@aria-label='Dismiss sign-in info.']";
    private static final String DESTINATION_INPUT_FIELD_XPATH = "//input[@placeholder='Where are you going?']";
    private static final String CALENDAR_CHECK_IN_XPATH = "//span[text()='Check-in Date']";
    private static final String OCCUPATION_CONFIG_XPATH = "//button[@data-testid='occupancy-config']";
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
    private static final String DESTINATION_DROPDOWN_LONDON_OPTION_XPATH = "//li[@id='autocomplete-result-0']/div/div/div/div[text()='London']";
    private static final String DESTINATION_DROPDOWN_PRAGUE_OPTION_XPATH = "//div[text()='Прага']";
    private static final String SUBMIT_SEARCH_BUTTON_XPATH = "//button[@type='submit']";
    private static final String NOTICE_BANNER_XPATH = "//section/div/div/div/button";
    private static final String FIRST_HOTEL_PHOTO_XPATH = "(//div)[@data-testid='property-card-container'][1]/div/div/a";
    private static final String TENTH_HOTEL = "//h2[contains(.,'Browse the results')]/following-sibling::div[22]";
    private static final String CALENDAR_START_DATE = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    private static final String CALENDAR_END_DATE = "//div[@data-testid='searchbox-datepicker-calendar']/div/div[1]/table/tbody//span[text()='%s']";
    private static final String CURRENCY_PICKER_ICON_XPATH = "//button[@data-testid='header-currency-picker-trigger']";
    private static final String LOCATE_CURRENCY_TOOLTIP_XPATH = "//*[contains(text(),'Select your currency')]";
    private static final String CURRENCY_TOOLTIP_XPATH = "//div[text()='Select your currency']";
    private static final String LANGUAGE_PICKER_ICON_XPATH = "//button[@data-testid='header-language-picker-trigger']";
    private static final String LOCATE_LANGUAGE_TOOLTIP_XPATH = "//*[contains(text(),'Select your language')]";
    private static final String LANGUAGE_TOOLTIP_XPATH = "//div[text()='Select your language']";

    public void openBookingHomePage() {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get(BOOKING_URL);
    }

    public void acceptConsents() {
        driver.findElement(By.xpath(BOOKING_ACCEPT_CONSENTS_BUTTON_XPATH)).click();
    }

    public void closeGeniusPopUp() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement geniusPopUp = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(CLOSE_GENIUS_POP_UP_XPATH)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void dismissSignInPopUp() {
        driver.findElement(By.xpath(DISMISS_SIGN_IN_POP_UP_BUTTON_XPATH)).click();
    }

    public void chooseDestination(String cityName) {
        WebElement destination = driver.findElement(By.xpath(DESTINATION_INPUT_FIELD_XPATH));
        destination.click();
        destination.sendKeys(cityName);
    }

    public void confirmDestinationLondon() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement citySubmit = new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath(DESTINATION_DROPDOWN_LONDON_OPTION_XPATH)));
        citySubmit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void confirmDestinationPrague() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement citySubmit = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath(DESTINATION_DROPDOWN_PRAGUE_OPTION_XPATH)));
        citySubmit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void closeCalendarNotNeeded() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement noticeBanner = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath(NOTICE_BANNER_XPATH)));
        noticeBanner.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void chooseDates(int startInDaysFromNow, int endInDaysFromNow) {
        int calendarStartDate = LocalDate.now().plusDays(startInDaysFromNow).getDayOfMonth();
        int calendarEndDate = LocalDate.now().plusDays(endInDaysFromNow).getDayOfMonth();
        driver.findElement(By.xpath(CALENDAR_CHECK_IN_XPATH)).click();
        driver.findElement(By.xpath(String.format(CALENDAR_START_DATE, calendarStartDate))).click();
        driver.findElement(By.xpath(String.format(CALENDAR_END_DATE, calendarEndDate))).click();
    }

    public void openOccupancyConfig() {
        driver.findElement(By.xpath(OCCUPATION_CONFIG_XPATH)).click();
    }

    public void addNumberOfAdults(int numberOfAdultsToAdd) {
        for (int i = 0; i < numberOfAdultsToAdd; i++) {
            driver.findElement(By.xpath(ADD_ADULTS_XPATH)).click();
        }
    }

    public void addNumberOfRooms(int numberOfRoomsToAdd) {
        for (int j = 0; j < numberOfRoomsToAdd; j++) {
            driver.findElement(By.xpath(ADD_ROOMS_XPATH)).click();
        }
    }

    public void submitOccupancy() {
        driver.findElement(By.xpath(SUBMIT_OCCUPANCY_CHOICE_XPATH)).click();
    }

    public void searchHotels() {
        driver.findElement(By.xpath(SUBMIT_SEARCH_BUTTON_XPATH)).click();
    }

    public void filterByReviewScoreOver6() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(SIDEBAR_PRESENCE_XPATH)));
        WebElement checkbox = driver.findElement(By.xpath(CHECKBOX_SCORE_RATING_6_XPATH));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);
        wait.ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(checkbox));
        checkbox.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(LABEL_SCORE_RATING_CHOSEN_XPATH)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void sortByPropertyRatingHighToLow() {
        driver.findElement(By.xpath(OPEN_SORTERS_DROPDOWN_XPATH)).click();
        driver.findElement(By.xpath(CHOOSE_SORTING_PROPERTY_RATING_LOW_TO_HIGH_XPATH)).click();
    }

    public void sortByPropertyPriceLowest() {
        driver.findElement(By.xpath(OPEN_SORTERS_DROPDOWN_XPATH)).click();
        driver.findElement(By.xpath(CHOOSE_SORTING_PROPERTY_PRICE_LOWEST_XPATH)).click();
    }

    public void viewFirstSortedHotel() {
        driver.findElement(By.xpath(FIRST_HOTEL_PHOTO_XPATH)).click();
    }

    public boolean checkFirstHotelScore() {
        String[] hotelScoreText = driver.findElement(By.xpath(REVIEW_SCORE_FIRST_SORTED_HOTEL)).getText().split("\\s");
        Double hotelScoreNumber = Double.parseDouble(hotelScoreText[2]);
        return false;
    }

    public void findTenthHotel() {
        WebElement tenthHotel = driver.findElement(By.xpath(TENTH_HOTEL));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", tenthHotel);
    }

    public void changeHotelEntityColours() {
        WebElement tenthHotel = driver.findElement(By.xpath(TENTH_HOTEL));
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenthHotel);
        ((JavascriptExecutor) driver).executeScript("arguments[0].style.color = 'red'", tenthHotel);
    }

    public void getCurrencySetting() {
        WebElement currency = driver.findElement(By.xpath(CURRENCY_PICKER_ICON_XPATH));
        Actions currencyActions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait waitCurrencyTooltip = new WebDriverWait(driver, Duration.ofSeconds(20));
        currencyActions.moveToElement(currency);

        waitCurrencyTooltip.ignoring(ClassCastException.class).ignoring(TimeoutException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOCATE_CURRENCY_TOOLTIP_XPATH)));
        currencyActions.perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public boolean checkCurrencySetting(String currencyTooltip) {
        return driver.findElement(By.xpath(CURRENCY_TOOLTIP_XPATH)).getText().equals(currencyTooltip);
    }

    public void getLanguageSetting() {
        WebElement language = driver.findElement(By.xpath(LANGUAGE_PICKER_ICON_XPATH));
        Actions languageActions = new Actions(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait waitLanguageTooltip = new WebDriverWait(driver, Duration.ofSeconds(20));
        languageActions.moveToElement(language);
        waitLanguageTooltip.ignoring(ClassCastException.class).ignoring(TimeoutException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath(LOCATE_LANGUAGE_TOOLTIP_XPATH)));
        languageActions.perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public boolean checkLanguageSetting(String languageTooltip) {
        return driver.findElement(By.xpath(LANGUAGE_TOOLTIP_XPATH)).getText().equals(languageTooltip);

    }
}

