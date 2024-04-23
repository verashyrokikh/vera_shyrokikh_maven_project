package tests.JUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pages.DemoqaSelectPage;

public class DemoqaSelectJUnit {
    DemoqaSelectPage demoqaSelectPage = new DemoqaSelectPage();

    @Before

    public void openDemoqaSelectPage() {
        demoqaSelectPage.openSelectMenuPage();
    }

    @Test
    public void checkOldStyleSelect() {
        demoqaSelectPage.checkOldStyleSelectMenu();
        Assert.assertEquals("Selected option is not correct!", "Green", demoqaSelectPage.selectedOldStyleOptionIsPresent());
    }

    @Test
    public void checkMultiSelect() {
        demoqaSelectPage.checkStandardMultiSelectOption();
        Assert.assertEquals("Selected option is not correct!", "Audi", demoqaSelectPage.selectedMultiSelectOptionIsPresent());
    }

}
