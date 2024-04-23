package homeworks.waitings;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class BookingLondon {


    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement geniusPopUp = new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();

        WebElement destinationLondon = driver.findElement(By.xpath("//input[@placeholder='Where are you going?']"));
        destinationLondon.click();
        destinationLondon.sendKeys("London");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement citySubmit = new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='autocomplete-result-0']/div/div/div/div[text()='London']")));
        citySubmit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //driver.findElement(By.xpath("//div[@data-testid='autocomplete-results']/div/ul/li[1]")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement tenthHotel = driver.findElement(By.xpath("//h2[contains(.,'Browse the results')]/following-sibling::div[22]"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true)", tenthHotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'green'", tenthHotel);
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.color = 'red'", tenthHotel);

        byte[] asBytes = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(Path.of("test.png"), asBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}