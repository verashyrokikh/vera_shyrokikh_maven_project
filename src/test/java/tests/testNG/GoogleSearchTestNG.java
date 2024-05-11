package tests.testNG;

import driver.Driver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import pages.GoogleHome;
import pages.W3SchoolJavaPage;

public class GoogleSearchTestNG {
    W3SchoolJavaPage w3SchoolJavaPage = new W3SchoolJavaPage();
    GoogleHome googleHome = new GoogleHome();

    @BeforeClass

    public void openW3SchoolPage() {
        w3SchoolJavaPage.openW3SchoolJavaPage();
        w3SchoolJavaPage.closeConsents();
    }

    @Test
    public void searchTheWord(){
        w3SchoolJavaPage.copyHeaderWord();
        googleHome.openGooglePage();
        googleHome.closePopUp();
        googleHome.pasteWordAndExecuteSearch();
        googleHome.checkSearchResults("Tutorial");
        Assert.assertTrue(googleHome.checkSearchResults("Tutorial"), "Not all results have searched word");

    }
    @AfterClass
    public void closeBrowser() {
        Driver.killDriver();
    }

}
