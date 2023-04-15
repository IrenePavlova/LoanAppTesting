package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/**
 * Created with IntelliJ IDEA.
 * User: Irene
 * Date:
 * Time: 7:02 PM
 * To change this template use File | Settings | File Templates.
 */
public class LoginPage {
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //LOCATORS

    //Text field 'Branch Name'
    @FindBy(how = How.NAME, using = "j_branch")
    private WebElement branchName;

    //Text field 'Branch Admin Username'
    @FindBy(how = How.NAME, using = "j_username")
    private WebElement branchAdminUsername;

    //Text field 'Branch Password'
    @FindBy(how = How.NAME, using = "j_password")
    private WebElement branchAdminPassword;

    //Button 'Login'
    @FindBy(how = How.ID, using = "ext-gen38")
    private WebElement buttonLogin;

    //METHODS

    public LoginPage setBranchName(WebDriver driver, String branch) {

        //Enter branch
        branchName.sendKeys(branch);
        return this;
    }
    public LoginPage setBranchAdminUsername (WebDriver driver, String branchAdmin) {

        //Enter username
        branchAdminUsername.sendKeys(branchAdmin);
        return this;
    }
    public LoginPage setBranchAdminPassword (WebDriver driver, String branchPassword) {

        //Enter password
        branchAdminPassword.sendKeys(branchPassword);
        return this;
    }

    public LoginPage clickLoginButton (WebDriver driver) {

        //Click 'Login' button
        buttonLogin.click();
        return this;
    }
}
