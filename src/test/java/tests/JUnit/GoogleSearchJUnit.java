package tests.JUnit;

import org.junit.Before;
import org.junit.Test;
import pages.GoogleHome;
import pages.W3SchoolJavaPage;

public class GoogleSearchJUnit {
    W3SchoolJavaPage w3SchoolJavaPage = new W3SchoolJavaPage();
    GoogleHome googleHome = new GoogleHome();

    @Before

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
        googleHome.checkSearchResults();
    }
}
