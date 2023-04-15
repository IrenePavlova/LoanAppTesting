package dataprovider;
import org.testng.annotations.DataProvider;

/**
 * Created with IntelliJ IDEA.
 * User: Irene
 * Date: 04/11/23
 * Time: 12:53 PM
 * To change this template use File | Settings | File Templates.
 */


public class CustomerDataProvider {
    @DataProvider (name = "CreateCustomer")
    public static Object[][] CreateCustomer() {
        return  new  Object[][] {
                {"Athabasca", "admin", "iyacuk0122", "Brad", "Pitt", ""},
                {"Athabasca", "admin", "iyacuk0122", "", "Pitt", "Mandatory field 'First Name' is empty"},
                {"Athabasca", "admin", "iyacuk0122", "Brad", "", "Mandatory field 'Last Name' is empty"}
        };
    }



}
