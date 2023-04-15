package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage (WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    //LOCATORS

    //Button 'Users'
    @FindBy(how = How.ID, using = "ext-gen185")
    private WebElement buttonUsers;

    //Button 'Customers'
    @FindBy(how = How.ID, using = "ext-gen192")
    private WebElement buttonCustomers;

    //METHODS

    public HomePage clickUsersButton (WebDriver driver) {
        //Click 'Users' button
        buttonUsers.click();
        return this;
    }
    public HomePage clickCustomersButton (WebDriver driver) {
        //Click 'Customers' button
        buttonCustomers.click();
        return this;
    }
}
