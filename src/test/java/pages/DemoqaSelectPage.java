package pages;

import driver.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DemoqaSelectPage {
    WebDriver driver = Driver.getWebDriver();
    private static String demoqaUrl = "https://demoqa.com/select-menu";
    private static String oldStyleSelectMenuId = "oldSelectMenu";
    private static String oldStyleSelectMenuOption = "//select[@id='oldSelectMenu']/option[3]";
    private static String standardMultiSelectId = "cars";
    private static String standardMultiSelectOption = "//select[@id='cars']/option[4]";


    public void openSelectMenuPage() {
        driver.get(demoqaUrl);
    }

    public void checkOldStyleSelectMenu() {
        WebElement selectStyle = driver.findElement(By.id(oldStyleSelectMenuId));
        Select selectStyleOption = new Select(selectStyle);
        selectStyleOption.selectByValue(String.valueOf(oldStyleSelectMenuOption));
    }

    public boolean selectedOldStyleOptionIsPresent() {
        return driver.findElement(By.xpath(oldStyleSelectMenuOption)).isDisplayed();
    }

    public void checkStandardMultiSelectOption() {
        WebElement selectCar = driver.findElement(By.id(standardMultiSelectId));
        Select selectCarOption = new Select(selectCar);
        selectCarOption.selectByValue(standardMultiSelectOption);
    }

    public boolean selectedMultiSelectOptionIsPresent() {
        return driver.findElement(By.xpath(standardMultiSelectOption)).isDisplayed();
    }
}
