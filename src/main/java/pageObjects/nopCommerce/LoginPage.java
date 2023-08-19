package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

    //This is a WebElement representing an input field with the name attribute set to "Email
    @FindBy(how = How.NAME,using = "Email")
    public WebElement txt_username;

    //This is a WebElement representing an input field with the name attribute set to "Password
    @FindBy(how = How.NAME,using = "Password")
    public WebElement txt_password;

    //This is a WebElement representing a button with the class attribute set to "button-1 login-button
    @FindBy(how = How.CSS,using = "button[class='button-1 login-button']")
    public WebElement btn_login;

}
