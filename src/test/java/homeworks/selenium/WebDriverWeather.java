package homeworks.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WebDriverWeather {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://google.com");
        driver.findElement(By.xpath("//button[@id='L2AGLb']")).click();
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).click();
        driver.findElement(By.xpath("//textarea[@class='gLFyf']")).sendKeys("погода минск");
       // driver.findElement(By.xpath("//textarea[@class='gLFyf']")).submit();
        driver.findElement(By.xpath("//ul[@role='listbox']/li[1]/div")).click();
        driver.findElement(By.xpath("//div[@class='wob_df wob_ds']"));
        System.out.println(driver.findElement(By.xpath("//*[name()='text' and contains(@aria-label, '8°Celsius pirmdiena, 12:00')][2]")).getAttribute("aria-label"));
    }
}
