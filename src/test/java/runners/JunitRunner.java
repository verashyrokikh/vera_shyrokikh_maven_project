package runners;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tests.JUnit.BookingJUnit;
import tests.JUnit.DemoqaSelectJUnit;
import tests.JUnit.GoogleSearchJUnit;

public class JunitRunner {
    @RunWith(Suite.class)
    @Suite.SuiteClasses({BookingJUnit.class, DemoqaSelectJUnit.class, GoogleSearchJUnit.class})

    public class JUnitSuite{

    }
}
