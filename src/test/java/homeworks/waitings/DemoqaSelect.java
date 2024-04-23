package homeworks.waitings;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class DemoqaSelect {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://demoqa.com/select-menu");

        WebElement selectStyle = driver.findElement(By.id("oldSelectMenu"));

        Select selectStyleOption = new Select(selectStyle);
        selectStyleOption.selectByValue("2");

        WebElement selectCar = driver.findElement(By.id("cars"));

        Select selectCarOption = new Select(selectCar);
        selectCarOption.selectByValue("audi");
    }
}
