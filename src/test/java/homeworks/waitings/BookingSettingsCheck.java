package homeworks.waitings;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BookingSettingsCheck {

    private static final String BOOKING_URL = "https://booking.com";
    private static String bookingAcceptConsentsButton = "//button[@id='onetrust-accept-btn-handler']";
    private static String geniusPopUp = "//div[@role='dialog']";
    private static String currencyPickerIcon = "//button[@data-testid='header-currency-picker-trigger']";
    private static String currencyTooltip = "//div[text()='Select your currency']";
    private static String languagePickerIcon = "//button[@data-testid='header-language-picker-trigger']";
    private static String languageTooltip = "//div[text()='Select your language']";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://booking.com");

        driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebElement geniusPopUp = new WebDriverWait(driver, Duration.ofSeconds(1000)).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@role='dialog']")));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.findElement(By.xpath("//button[@aria-label='Dismiss sign-in info.']")).click();

        WebElement currency = driver.findElement(By.xpath("//button[@data-testid='header-currency-picker-trigger']"));

        Actions currencyActions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait waitCurrencyTooltip = new WebDriverWait(driver, Duration.ofSeconds(10));

        currencyActions.moveToElement(currency);

        waitCurrencyTooltip.ignoring(ClassCastException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Select your currency')]")));
        currencyActions.perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement currencyTooltip = driver.findElement(By.xpath("//div[text()='Select your currency']"));

        Assert.assertEquals("Tooltip 'currency' is not correct", "Select your currency", currencyTooltip.getText());

        WebElement language = driver.findElement(By.xpath("//button[@data-testid='header-language-picker-trigger']"));

        Actions languageActions = new Actions(driver);

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait waitLanguageTooltip = new WebDriverWait(driver, Duration.ofSeconds(10));

        languageActions.moveToElement(language);

        waitLanguageTooltip.ignoring(ClassCastException.class).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[contains(text(),'Select your language')]")));
        languageActions.perform();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        WebElement languageTooltip = driver.findElement(By.xpath("//div[text()='Select your language']"));

        Assert.assertEquals("Tooltip 'language' is not correct", "Select your language", languageTooltip.getText());

    }
}
