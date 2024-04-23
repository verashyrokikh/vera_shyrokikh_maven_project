package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class GoogleHome {
    WebDriver driver = Driver.getWebDriver();
    private static final String GOOGLE_URL = "https:google.com";
    private static String textAreaField = "//textarea[@class='gLFyf']";
    private static String searchListHeader = "//h3";

    public void openGooglePage() {
        driver.navigate().to(GOOGLE_URL);
    }

    public void closePopUp() {
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
    }

    public void pastWordAndExecuteSearch() {
        WebElement searchField = driver.findElement(By.xpath(textAreaField));

        Actions past = new Actions(driver);
        past
                .click(searchField)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build().perform();
    }

    public void checkSearchResults() {
        List<WebElement> searchResults = driver.findElements(By.xpath(searchListHeader));
        String searchName = "Tutorial";

        for (WebElement resultField : searchResults) {
            if (resultField.getText().contains(searchName)) {
                System.out.println("Search result is correct");
            } else {
                System.out.println("Search result doesn't have the word or it is written differently");
            }
        }
    }
}
