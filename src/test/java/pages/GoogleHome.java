package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GoogleHome {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = LogManager.getLogger(GoogleHome.class);
    private static final String GOOGLE_URL = "https:google.com";
    private static final String TEXT_AREA_FIELD_XPATH = "//textarea[@class='gLFyf']";
    private static final String SEARCH_LIST_HEADER_XPATH = "//h3";

    public void openGooglePage() {
        driver.navigate().to(GOOGLE_URL);
        LOGGER.info("Google page is opened");
    }

    public void closePopUp() {
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        LOGGER.info("Pop-up is closed");
    }

    public void pasteWordAndExecuteSearch() {
        WebElement searchField = driver.findElement(By.xpath(TEXT_AREA_FIELD_XPATH));

        Actions past = new Actions(driver);
        past
                .click(searchField)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build().perform();
        LOGGER.info("The word is pasted and searched");
    }

    public boolean checkSearchResults(String searchedWord) {
        List<WebElement> searchResults = driver.findElements(By.xpath(SEARCH_LIST_HEADER_XPATH));
        String searchName = searchedWord;

        for (WebElement resultField : searchResults) {
            if (resultField.getText().contains(searchName)) {
                System.out.println("Search result is correct");
            } else {
                System.out.println("Search result doesn't have the word or it is written differently");
            }
        }
        LOGGER.info("Search results checked");
        return false;
    }
}
