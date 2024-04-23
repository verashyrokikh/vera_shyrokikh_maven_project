package homeworks.waitings;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.LocalDate;

public class BookingParis {
    private static int calendarStartDate = LocalDate.now().plusDays(3).getDayOfMonth();
    private static int calendarEndtDate = LocalDate.now().plusDays(10).getDayOfMonth();

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://booking.com");
        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement geniusPopUp = new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();

        WebElement destination = driver.findElement(By.xpath("//input[@placeholder='Where are you going?']"));
        destination.click();
        destination.sendKeys("Париж");

        driver.findElement(By.xpath("//span[text()='Check-in Date']")).click();
//        driver.findElement(calendarStartDate).click();
//        driver.findElement(calendarEndtDate).click();
        driver.findElement(By.xpath("//button[@data-testid='occupancy-config']")).click();
        WebElement addPerson = driver.findElement(By.xpath("//*[@id='group_adults']/../div/button[2]"));
        addPerson.click();
        addPerson.click();

        driver.findElement(By.xpath("//*[@id='group_adults']/../following-sibling::div[2]/div/button[2]")).click();
        driver.findElement(By.xpath("//div[@data-testid='occupancy-popup']/button")).click();
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        try {
            WebElement checkbox = driver.findElement(By.xpath("//div[@data-testid='filters-group' and @id='filter_group_review_score_:r1e:']/div[10]"));
            //label/span[2]/span/*

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkbox);

            wait.until(ExpectedConditions.elementToBeClickable(checkbox));
            checkbox.click();
            wait.until(ExpectedConditions.elementToBeSelected(checkbox));
        } catch (NoSuchElementException e){
            System.out.println("An error");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
        driver.findElement(By.xpath("//div[@data-testid='sorters-dropdown']/div/div/div/ul/li[6]")).click();
    }
}
