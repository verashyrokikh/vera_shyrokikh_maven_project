package homeworks.waitings;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class GoogleSearch {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://www.w3schools.com/java/");
        driver.findElement(By.xpath("//div[@id='accept-choices']")).click();

        WebElement copyTutorial = driver.findElement(By.xpath("//div[@id='main']/h1/span[contains(text(), 'Tutorial')]"));
        Actions make = new Actions(driver);

        make
                .doubleClick(copyTutorial)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("c").clickAndHold()
                .keyUp(Keys.LEFT_CONTROL)
                .build().perform();

        try {
            driver.navigate().to("https:google.com");
        } catch (ClassCastException e) {
            System.out.println("An error here");
        }
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();

        WebElement searchField = driver.findElement(By.xpath("//textarea[@class='gLFyf']"));

        Actions past = new Actions(driver);
        past
                .click(searchField)
                .keyDown(Keys.LEFT_CONTROL)
                .sendKeys("v")
                .keyUp(Keys.LEFT_CONTROL)
                .sendKeys(Keys.ENTER)
                .build().perform();

        List<WebElement> searchResults = driver.findElements(By.xpath("//h3"));

        String searchName = "Tutorial";

        for (WebElement resultField : searchResults) {
            if (resultField.getText().contains(searchName)) {
                System.out.println("Search result is correct");
            } else {
                System.out.println("Search result doesn't have the word or it is written differently");
            }
        }

        //  Assert.assertEquals("Assert message", );
    }
}
