package tests.testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BaseTest;
import pages.DemoqaSelectPage;

public class DemoqaSelectTestNG {
    DemoqaSelectPage demoqaSelectPage = new DemoqaSelectPage();
    BaseTest baseTest = new BaseTest();

    @BeforeClass

    public void openDemoqaSelectPage() {
        demoqaSelectPage.openSelectMenuPage();
    }

    @Test
    public void checkOldStyleSelect() {
        demoqaSelectPage.checkOldStyleSelectMenu();
        Assert.assertEquals(demoqaSelectPage.selectedOldStyleOptionIsPresent(), "Green", "Selected option is not correct!");
    }

    @Test
    public void checkMultiSelect() {
        demoqaSelectPage.checkStandardMultiSelectOption();
        Assert.assertEquals(demoqaSelectPage.selectedMultiSelectOptionIsPresent(), "Audi", "Selected option is not correct!");
    }

}
