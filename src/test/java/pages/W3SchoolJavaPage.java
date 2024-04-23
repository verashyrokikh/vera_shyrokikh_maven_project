package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class W3SchoolJavaPage {
    WebDriver driver = Driver.getWebDriver();
    private static final String W_SCHOOL_URL = "https://www.w3schools.com/java/";
    private static String wSchoolAcceptConsentsButton = "//div[@id='accept-choices']";
    private static String copiedWordTutorial = "//div[@id='main']/h1/span[contains(text(), 'Tutorial')]";

    public void openW3SchoolJavaPage() {
        driver.get(W_SCHOOL_URL);
    }

    public void closeConsents() {
        driver.findElement(By.xpath(wSchoolAcceptConsentsButton)).click();
    }

    public void copyHeaderWord() {
        WebElement copyTutorial = driver.findElement(By.xpath(copiedWordTutorial));
        Actions make = new Actions(driver);

        make
                .doubleClick(copyTutorial)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();
    }
}
