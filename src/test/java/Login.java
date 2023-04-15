import dataprovider.LoginDataProvider;
import org.checkerframework.checker.units.qual.Temperature;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.LoginPage;

import java.util.concurrent.TimeUnit;

public class Login {
    @Test(dataProvider = "Login", dataProviderClass = LoginDataProvider.class)
    public static void LMSLogin(WebDriver driver, String branch, String branchAdmin, String branchPassword) {

        //Set Firefox binary path for the driver
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C://Program Files/Mozilla Firefox/firefox.exe");

        //Create Objects required for this test
        LoginPage loginPage = new LoginPage (driver);
        //And now use this to visit LMS Logon page
        driver.get("https://dev-hitekschool.com/lms/loans/2108");
        //Set browser window size
        driver.manage().window().setSize(new Dimension(900,800));
        //Read the title of the page and put it into results
        System.out.println("Page title is: " + driver.getTitle());
        //Enter branch name
        loginPage.setBranchName(driver, branch);
        //Enter branch admin username
        loginPage.setBranchAdminUsername(driver, branchAdmin);
        // Enter branch admin password
        loginPage.setBranchAdminPassword(driver, branchPassword);
        //Click Login button
        loginPage.clickLoginButton(driver);
        //Wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // Read the title of the page and output it into results - need it for debug purpose
        System.out.println("actual: Page title is: " + driver.getTitle());
        System.out.println("expected: " + "Loan Management System - '" + branch + "' branch");
        //Verify the title of the page
        Assert.assertEquals(driver.getTitle(), "Loan Management System - '" + branch + "' branch");
        //Wait for 5 sec (using exception handler)
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
