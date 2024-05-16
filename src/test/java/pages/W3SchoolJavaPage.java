package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class W3SchoolJavaPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = LogManager.getLogger(W3SchoolJavaPage.class);
    private static final String W_SCHOOL_URL = "https://www.w3schools.com/java/";
    private static final String W3SCHOOL_ACCEPT_CONCENT_BUTTON_XPATH = "//div[@id='accept-choices']";
    private static final String WORD_TO_COPY_XPATH = "//div[@id='main']/h1/span[contains(text(), 'Tutorial')]";

    public void openW3SchoolJavaPage() {
        driver.get(W_SCHOOL_URL);
        LOGGER.info("W3School page is opened");
    }

    public void closeConsents() {
        driver.findElement(By.xpath(W3SCHOOL_ACCEPT_CONCENT_BUTTON_XPATH)).click();
        LOGGER.info("Consents are closed");
    }

    public void copyHeaderWord() {
        WebElement copyTutorial = driver.findElement(By.xpath(WORD_TO_COPY_XPATH));
        Actions make = new Actions(driver);

        make
                .doubleClick(copyTutorial)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
        LOGGER.info("Searched word is copied");
    }
}
