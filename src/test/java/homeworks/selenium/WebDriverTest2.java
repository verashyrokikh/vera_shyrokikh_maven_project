package homeworks.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverTest2 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.quit();
    }
}
