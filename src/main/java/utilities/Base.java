package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.asserts.SoftAssert;
import pageObjects.nopCommerce.*;

public class Base {
    // Represents the WebDriver instance for browser automation
    protected static WebDriver driver;

    // Represents the WebDriverWait instance for waiting for elements
    protected static WebDriverWait wait;
    // Represents the Actions instance for performing mouse and keyboard actions
    protected static Actions action;
    // Represents the SoftAssert instance for soft assertions
    public static SoftAssert softAssert;
    // Represents the Screen instance for capturing screenshots
    protected static Screen screen;

    //------------Pages Objects-----------
    // Represents the Page Object for the upper menu page
    protected static UpperMenuPage nopCommerceUpperMenu;

    // Represents the Page Object for the shopping cart page
    protected static ShoppingCartPage nopCommerceShoppingCart;
    // Represents the Page Object for the home page
    protected static HomePage nopCommerceHomePage;
    // Represents the Page Object for the searched keyword page
    protected static SearchedKeyword nopCommerceSearchedKeyword;
    // Represents the Page Object for the register page
    protected static RegisterPage nopCommerceRegisterPage;
    // Represents the Page Object for the login page
    protected static LoginPage nopCommerceLoginPage;



}
