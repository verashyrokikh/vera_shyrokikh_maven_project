package pages;


import driver.Driver;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.time.Duration;

public class BaseTest extends Driver {
    @BeforeClass
    public static void initDriver(){
        driver = Driver.getWebDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void closeDriver(){
        driver.quit();
    }
}
