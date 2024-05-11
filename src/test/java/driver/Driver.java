package driver;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class Driver {

    public static WebDriver driver;
    protected static Config config = Optional.ofNullable(System.getProperty("CONFIG")).isEmpty() ?
            Config.CHROME : Config.valueOf(System.getProperty("CONFIG"));

    public static WebDriver getDriver() {
        if (null == driver) {
            driver = getWebDriver();
        }
        return driver;
    }
    public static WebDriver getWebDriver() {

        return switch (config) {
            case EDGE -> getEdgeDriver();
            case FF -> getFFDriver();
            default -> getChromeDriver();
        };
    }

    private static WebDriver getEdgeDriver() {
        return new EdgeDriver();
    }

    private static WebDriver getFFDriver() {
        return new FirefoxDriver();
    }

    private static WebDriver getChromeDriver() {
        ChromeOptions caps = new ChromeOptions();
        caps.addArguments("start-maximized");
        caps.addArguments("disable-infobars");
        caps.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));
        return new ChromeDriver(caps);
    }

    public static void makeScreenShot(){
        byte[] asBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        try {
            Files.write(Path.of("test.png"), asBytes);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void goToLastTab(){
        ArrayList<String> openTabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(openTabs.getLast());
    }

}
