package tests.testNG;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
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
        googleHome.pastWordAndExecuteSearch();
        googleHome.checkSearchResults();

    }


}
