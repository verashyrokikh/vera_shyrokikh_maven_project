package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookingHotelPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = LogManager.getLogger(BookingHotelPage.class);
    private static final String HOTEL_SCORE_RATING_XPATH = "//div[@data-testid='review-score-right-component']/div[1]";

    public boolean checkHotelScore(double ratingToBe){
        String[] hotelScoreText = driver.findElement(By.xpath(HOTEL_SCORE_RATING_XPATH)).getText().split("\\s");
        double hotelScoreNumber = Double.parseDouble(hotelScoreText[2]);
        return hotelScoreNumber >= ratingToBe;
    }
}
