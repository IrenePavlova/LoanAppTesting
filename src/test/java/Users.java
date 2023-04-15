import dataprovider.UserDataProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import pageobject.AddUserPage;
import pageobject.HomePage;
import pageobject.UsersPage;

public class Users {

    @Test(dataProvider = "CreateUser", dataProviderClass = UserDataProvider.class)
    // @Parameters(value = {"branch", "branchAdmin", "branchPassword", "user", "password"})

    public void AddUser(String branch, String branchAdmin, String branchPassword, String user, String password, String warning) {
        //Set Gecko.driver property to interact to Firefox browser
        System.setProperty("webdriver.gecko.driver", "C://Program Files/Selenium/Firefox driver/geckodriver.exe");

        //Create a new instance of Firefox driver
        WebDriver driver = new FirefoxDriver();

        //Create Objects required for this test
        Login login = new Login();
        HomePage homePage = new HomePage(driver);
        UsersPage usersPage = new UsersPage(driver);
        AddUserPage addUserPage = new AddUserPage(driver);

        //Login to LMS - using LMSLogin method of class Login method to re-use Firefox browser already opened
        login.LMSLogin(driver, branch, branchAdmin, branchPassword);

        //try to wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click button 'Users'
        homePage.clickUsersButton(driver);

        //Click button 'Actions'
        usersPage.clickActionsButton(driver);

        //try to wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //Click 'Add User' link
        usersPage.clickAddUserLink(driver);

        //Enter username
        addUserPage.setUsername(driver, user);

        //Enter password
        addUserPage.setPassword(driver, password);

        //Click button 'Save'
        addUserPage.clickSaveButton(driver);

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

            //Click 'Ok' button to close the pop up
            addUserPage.clickOKButton(driver);

            // Click button 'Cancel'
            addUserPage.clickCancelButton(driver);

        } else {

            //Verify results by parsing HTML page and making sure it contain just created username
            WebElement body = driver.findElement(By.tagName("body"));
            boolean ret = body.getText().contains(user);
            System.out.println("User created: " + ret);


        }

        //Click button 'Logout'
        usersPage.clickLogoutButton(driver);

        //try to wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Close the browser
        driver.close();

    }
}
