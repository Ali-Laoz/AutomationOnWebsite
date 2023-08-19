package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {

    // Represents the element to enter the first name
    @FindBy(how = How.CSS, using = "#FirstName")  //# means get by id
    public WebElement txt_firstName;

    // Represents the element to enter the last name
    @FindBy(how = How.CSS, using = "#LastName")
    public WebElement txt_lastName;

    //Represents the element to enter the email
    @FindBy(how = How.CSS, using = "#Email")
    public WebElement txt_email;

    //Represents the element to enter the password
    @FindBy(how = How.CSS, using = "#Password")
    public WebElement txt_password;

    //Represents the element to enter the confirm password
    @FindBy(how = How.CSS, using = "#ConfirmPassword")
    public WebElement txt_confirmPassword;

    //Represents the register button
    @FindBy(how = How.CSS, using = "#register-button")
    public WebElement btn_register;

    // Represents the continue button
    @FindBy(how = How.XPATH, using = "/html/body/div[6]/div[3]/div/div/div/div[2]/div[2]/a")
    public WebElement btn_continue;

    // Represents the element to display error messages or get text
    @FindBy(how = How.CSS, using = "div[class='message-error validation-summary-errors']")
    public WebElement txt_error;
}
