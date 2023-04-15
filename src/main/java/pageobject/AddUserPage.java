package pageobject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
public class AddUserPage {
    // this is a constructor
    public AddUserPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
    //LOCATORS

    //Text field 'Username'
    @FindBy(how = How.NAME, using = "Username")
    private WebElement userName;

    //Text field 'Password'
    @FindBy(how = How.NAME, using = "Password")
    private WebElement userPassword;

    //Button 'Save'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div[2]/div/div/table/tbody/tr/td[1]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonSave;

    //Button 'Cancel'
    @FindBy(how = How.XPATH, using = "//div[5]/div/div[2]/div/div/table/tbody/tr/td[2]/table/tbody/tr/td[2]/em/button")
    private WebElement buttonCancel;

    //Button 'OK' to close warning message
    @FindBy(how = How.XPATH, using = "//div[2]/div/div/div/div/div/table/tbody/tr/td/table/tbody/tr/td[2]")
    private WebElement buttonOK;

    //METHODS

    public AddUserPage setUsername (WebDriver driver, String username ) {
        //Enter username
        userName.sendKeys(username);
        return this;
    }
    public AddUserPage setPassword (WebDriver driver, String password ) {
        //Enter password
        userPassword.sendKeys(password);
        return this;
    }
    public AddUserPage clickSaveButton (WebDriver driver) {
        //Click Save button
        buttonSave.click();
        return this;
    }
    public AddUserPage clickCancelButton (WebDriver driver) {
        //Click Cancel button
        buttonCancel.click();
        return this;
    }
    public AddUserPage clickOKButton (WebDriver driver) {
        //Click OK  button on warning message pop up
        buttonOK.click();
        return this;
    }
}
