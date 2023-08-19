package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ShoppingCartPage {
    //--our project------------
    //This represents the element that displays a message when the cart is empty.
    @FindBy(how = How.CLASS_NAME,using = "no-data")
    public WebElement text_emptyCart;


    //This represents a list of elements that can be clicked to remove items from the cart.
    @FindBy(how = How.CSS,using = "td[class='remove-from-cart']")
    public List<WebElement> list_elements_deletable_button;

    //This represents a list of elements that have a unique identifier for each item in the cart.
    // This can be used to identify and remove specific items from the cart.
    @FindBy(how = How.CSS,using = "input[name='removefromcart']")
    public List<WebElement> list_elements_deletable_id;

    //list_elements_product_names`: This represents a list of elements that display the names of the products in the cart.
    @FindBy(how = How.CSS,using = "a[class='product-name']")
    public List<WebElement> list_elements_product_names;


    // This represents the main table element that contains all the items in the cart.
    @FindBy(how = How.CSS,using = "table[class='cart']")
    public WebElement the_cart;





}
