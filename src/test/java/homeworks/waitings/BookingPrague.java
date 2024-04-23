package homeworks.waitings;

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
        WebElement geniusPopUp = new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();

        WebElement destination = driver.findElement(By.xpath("//input[@placeholder='Where are you going?']"));
        destination.click();
        destination.sendKeys("Прага");

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement citySubmit = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(By.xpath("//li[@id='autocomplete-result-0']/div/div/div/div[text()='Прага']")));
        citySubmit.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@type='submit']")).click();

//      Actions to close calendar
//        WebElement calendar = driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']/.."));
//
//        Actions calendarActions = new Actions(driver);
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        WebDriverWait waitCalendarCloses = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        calendarActions.moveToElement(calendar);
//        calendarActions.click();
//
//        waitCalendarCloses.ignoring(ClassCastException.class).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='searchbox-datepicker-calendar']")));
//        calendarActions.perform();

//        Close using calendar locator
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//        WebDriverWait calendarClose = new WebDriverWait(driver, Duration.ofSeconds(50));
//        driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']")).click();
//
//        calendarClose.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@data-testid='searchbox-datepicker-calendar']")));
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//
//      click somewhere on the page
//        driver.findElement(By.xpath("//div[@data-capla-component-boundary='b-search-web-searchresults/SearchResultsDesktop']")).click();

//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
//
//        WebElement calendar = driver.findElement(By.xpath("//div[@data-testid='searchbox-dates-container']/../.."));
//        WebDriverWait calendarClose = new WebDriverWait(driver, Duration.ofSeconds(20));
//        ((JavascriptExecutor)driver).executeScript("arguments[0].click();", calendar);
//
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
//        WebElement filter = calendarClose.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")));
////        driver.findElement(By.xpath("//button[@data-testid='sorters-dropdown-trigger']")).click();
//        filter.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait calendarClose = new WebDriverWait(driver, Duration.ofSeconds(50));
        calendarClose.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@data-testid='sorters-dropdown']/div/div/div/ul/li[3]"))).click();
        //driver.findElement(By.xpath("//div[@data-testid='sorters-dropdown']/div/div/div/ul/li[3]")).click();

        driver.findElement(By.xpath("(//div)[@data-testid='property-card-container'][1]/div/div/a")).click();

        ArrayList<String> openTabs= new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openTabs.getLast());

//        String[] hotelScore = driver.findElement(By.xpath()).getText().split("",2);
//        double hotelScoreNumber =Double.parseDouble(hotelScore[1]);
//        Assert.assertTrue("First hotel score value is less than 8", hotelScoreNumber>8);

    }
}
