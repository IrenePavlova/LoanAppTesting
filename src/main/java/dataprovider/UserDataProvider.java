package dataprovider;
import org.testng.annotations.DataProvider;

/**
 * Created with Intellij IDEA.
 * User: irene
 * Date:
 * Time:
 * To change this template use File | Settings | File Templates.
 */

public class UserDataProvider {
    @DataProvider (name = "CreateUser")
    public static Object[][] CreateUser() //there are 2 square brackets [] [] after word Object
    {
        return new Object[][] {
                {"Athabasca", "admin", "iyacuk0122", "bsample", "password", ""},
                {"Athabasca", "admin", "iyacuk0122", "", "password", "Mandatory field 'Username' is empty"},
                {"Athabasca", "admin", "iyacuk0122", "bsample", "", "Mandatory field 'Password' is empty" }

        };
    }
}
