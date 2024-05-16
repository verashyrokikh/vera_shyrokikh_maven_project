package pages;

import driver.Driver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DemoqaSelectPage {
    WebDriver driver = Driver.getWebDriver();
    private static final Logger LOGGER = LogManager.getLogger(DemoqaSelectPage.class);

    private static final String  DEMOQA_URL = "https://demoqa.com/select-menu";
    private static final String OLD_STYLE_SELECT_MENU_ID = "oldSelectMenu";
    private static String OLD_STYLE_SELECT_MENU_OPTION_XPATH = "//select[@id='oldSelectMenu']/option[3]";
    private static String STANDARD_MULTI_SELECT_ID = "cars";
    private static String STANDARD_MULTI_SELECT_OPTION_XPATH = "//select[@id='cars']/option[4]";


    public void openSelectMenuPage() {
        driver.get(DEMOQA_URL);
        LOGGER.info("Demoqa page is opened");
    }

    public void checkOldStyleSelectMenu() {
        WebElement selectStyle = driver.findElement(By.id(OLD_STYLE_SELECT_MENU_ID));
        Select selectStyleOption = new Select(selectStyle);
        selectStyleOption.selectByValue(String.valueOf(OLD_STYLE_SELECT_MENU_OPTION_XPATH));
        LOGGER.info("Old Style Select is checked");
    }

    public boolean selectedOldStyleOptionIsPresent() {
        return driver.findElement(By.xpath(OLD_STYLE_SELECT_MENU_OPTION_XPATH)).isDisplayed();
    }

    public void checkStandardMultiSelectOption() {
        WebElement selectCar = driver.findElement(By.id(STANDARD_MULTI_SELECT_ID));
        Select selectCarOption = new Select(selectCar);
        selectCarOption.selectByValue(STANDARD_MULTI_SELECT_OPTION_XPATH);
        LOGGER.info("Standard Multi Select is checked");
    }

    public boolean selectedMultiSelectOptionIsPresent() {
        return driver.findElement(By.xpath(STANDARD_MULTI_SELECT_OPTION_XPATH)).isDisplayed();
    }
}
