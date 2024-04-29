package homeworks.waitings;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.event.DocumentEvent;
import javax.swing.text.html.parser.Element;
import java.lang.reflect.Executable;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Optional;

public class BookingParis {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement geniusPopUp = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();

        WebElement destination = driver.findElement(By.xpath("//input[@placeholder='Where are you going?']"));
        destination.click();
        destination.sendKeys("Париж");

        driver.findElement(By.xpath("//span[text()='Check-in Date']")).click();
        driver.findElement(By.xpath("//span[@data-date= '2024-05-03']")).click();
        driver.findElement(By.xpath("//span[@data-date= '2024-05-10']")).click();
        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
        WebElement addPerson = driver.findElement(By.xpath("//*[@id='group_adults']/../div/button[2]"));
        addPerson.click();
        addPerson.click();

        driver.findElement(By.xpath("//*[@id='group_adults']/../following-sibling::div[2]/div/button[2]")).click();
        driver.findElement(By.xpath("//div[@data-testid='occupancy-popup']/button")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='b4b4b2787f']/div[@data-testid='filters-sidebar']/div[7]")));
        WebElement checkbox2 = driver.findElement(By.xpath("//input[@id=':r1g:' and @value='review_score=60']/../label"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox2);
        wait.ignoring(StaleElementReferenceException.class).ignoring(NoSuchElementException.class).until(ExpectedConditions.elementToBeClickable(checkbox2));
        checkbox2.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@data-testid='filter:review_score=60']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();

        driver.findElement(By.xpath("//div[@data-testid='sorters-dropdown']/div/div/div/ul/li[6]")).click();

        String[] hotelScoreText = driver.findElement(By.xpath("(//div[@data-testid='review-score']/div)[1]")).getText().split("\\s");

        Float hotelScoreNumber = Float.parseFloat(hotelScoreText[2]);
        Assert.assertEquals("The rating of the first hotel is not equal to 6", Optional.of(6.0f), hotelScoreNumber);
    }
}
