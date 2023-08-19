package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class UpperMenuPage {
    //--our project------------

    //This represents the button to access the user's account.
    @FindBy(how = How.ID,using = "customerCurrency")
    public WebElement currencySelector;

    // This represents the element that allows the user to select their preferred currency.
    @FindBy(how = How.CLASS_NAME,using = "ico-account")
    public WebElement btn_myAccount;

    //This represents the button to register a new account.
    @FindBy(how = How.CLASS_NAME,using = "ico-register")
    public WebElement btn_register;

    //This represents the button to login to an existing account.
    @FindBy(how = How.CLASS_NAME,using = "ico-login")
    public WebElement btn_login;

    //This represents the button to access the user's wishlist.
    @FindBy(how = How.CLASS_NAME,using = "wishlist-label")
    public WebElement btn_wishlist;

    //This represents the button to access the shopping cart
    @FindBy(how = How.CLASS_NAME,using = "cart-label")
    public WebElement btn_shoppingCart;

    //This represents the element that displays the count of items in the shopping cart
    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[1]/div[1]/div[2]/div[1]/ul/li[4]/a/span[2]")
    public WebElement btn_shoppingCart_item_count;



}
