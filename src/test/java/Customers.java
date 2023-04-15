import dataprovider.CustomerDataProvider;
import dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Customers {

    @Test(dataProvider = "CreateCustomer", dataProviderClass = CustomerDataProvider.class)
    //@Parameters(value = {"branch", "branchAdmin", "branchPassword", "firstName", "lastName"})
    public void AddCustomer (String branch, String branchAdmin, String branchPassword, String firstName, String lastName, String warning) {

        //Set Gecko.driver property to interact to Firefox browser
        System.setProperty("webdriver.gecko.driver", "C://Program Files/Selenium/Firefox driver/geckodriver.exe");
        //Create a new instance of Firefox driver
        WebDriver driver = new FirefoxDriver();
        //Create an instance of class Login to use its LMSLogin method in our Add Customer scenario
        Login login = new Login();
        //Login to LMS - using LMSLogin method of class Login and passing 'driver' argument to the method to re-use Firefox browser already opened
        login.LMSLogin(driver, branch, branchAdmin, branchPassword);
        //try to wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Find button 'Customers' by its id
        WebElement element = driver.findElement(By.id("ext-gen192"));
        //Click button 'Users'
        element.click();
        // Find button 'Actions' by its xpath
        element = driver.findElement(By.xpath("//td[1]/table/tbody/tr/td[2]/em/button"));
        //Click button 'Actions'
        element.click();
        //try to wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Find menu item 'Add Customer'
        element = driver.findElement(By.linkText("Add Customer"));
        //Click menu item 'Add Customer'
        element.click();
        //Find the text input element 'Fist Name' by its name
        element = driver.findElement(By.name("FirstName"));
        //Enter First Name
        element.sendKeys(firstName);
        //Find the text input element 'Last Name' by its name
        element = driver.findElement(By.name("LastName"));
        //Enter Last Name
        element.sendKeys(lastName);
        //Find button 'Save' by its xpath
        element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[5]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button"));
        //Click button 'Save'
        element.click();
        //Try to wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (warning != "") {
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(warning);
            System.out.println("Warning: " + ret);

            // find button OK by xpath and click it to close pop up
            driver.findElement(By.xpath("/html/body/div[7]/div[2]/div[2]/div/div/div/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button")).click();

            // Find button 'Cancel' by its xpath
            element = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/div/div/div[5]/div/div/div/div[2]/div[2]/div/div[1]/div/div/div/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button"));

            // Click button 'Cancel'
            element.click();

        } else {

            //Verify results by parsing HTML page and making sure it contain just created customer
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(lastName);
            System.out.println("Customer created: " + ret);


        }


        //Find button 'Logout' by its xpath
        element = driver.findElement(By.xpath("//div[5]/div/div/div/div[2]/div[1]/div/div/div[1]/div/table/tbody/tr/td[5]/table/tbody/tr/td[2]/em/button"));
        //Click button 'Logout'
        element.click();
        //Try to wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // close the browser
        driver.close();
    }
}
