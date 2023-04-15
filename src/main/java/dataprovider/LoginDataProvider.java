package dataprovider;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;

public class LoginDataProvider {
    @DataProvider (name = "Login")
    public static Object[][] CreateCustomer() {
        return  new  Object[][] {
                {new FirefoxDriver(), "Athabasca", "admin", "iyacuk0122"},
        };
    }
}
