package homeworks.waitings;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class BookingPrague {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement geniusPopUp = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();

        WebElement destination = driver.findElement(By.xpath("//input[@placeholder='Where are you going?']"));
        destination.click();
        destination.sendKeys("Прага");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement citySubmit = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Прага']")));
        citySubmit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement noticeBanner = new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.xpath("//section/div/div/div/button")));
        noticeBanner.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//div[@data-testid='sorters-dropdown']/div/div/div/ul/li[3]")).click();
        driver.findElement(By.xpath("(//div)[@data-testid='property-card-container'][1]/div/div/a")).click();

        ArrayList<String> openTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openTabs.getLast());

        String[] hotelScoreText = driver.findElement(By.xpath("//div[@data-testid='review-score-right-component']/div[1]")).getText().split("\\s");

        double hotelScoreNumber = Double.parseDouble(hotelScoreText[2]);
        Assert.assertTrue("Highest rating is below 8", hotelScoreNumber > 8);

    }
}
