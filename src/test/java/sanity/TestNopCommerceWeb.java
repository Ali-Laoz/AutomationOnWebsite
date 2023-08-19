package sanity;

import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Description;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;
import workflows.WebFlows;


//https://demo.nopcommerce.com/

@Listeners(utilities.Listeners.class)
public class TestNopCommerceWeb extends CommonOps {

    //This Test verifies the registration process by clicking on the register button,
    // registering a new user, logging in, and checking if the "My Account" button is present.
    @Test(description = "Test01 - Verify Registration")
    @Description("This Test Verifies the Registration method by logging in and checking if there is button named myAccount")
    public void test01_verifyRegistration(){
        UIActions.click(nopCommerceUpperMenu.btn_register);
        WebFlows.register(getData("FirstName"), getData("LastName"), getData("Email"), getData("Password"), getData("Password"));
        UIActions.click(nopCommerceUpperMenu.btn_login);
        WebFlows.login(getData("Email"), getData("Password"));
        Verifications.verifyTextInElement(nopCommerceUpperMenu.btn_myAccount, getData("ValidateAccount"));
    }

    //This Test verifies that the shopping cart is empty by clicking on the shopping cart button,
    // deleting all items from the cart, and checking if the empty cart text is displayed.
    @Test(description = "Test02 - Verify Shopping Cart Empty")
    @Description("This Test verifies that the shopping cart is empty")
    public void test02_verifyIsEmptyShoppingCart(){
        UIActions.click(nopCommerceUpperMenu.btn_shoppingCart);
        WebFlows.deleteAllItemsFromCart();
        Verifications.verifyTextInElement(nopCommerceShoppingCart.text_emptyCart,getData("ExpectedEmptyCartText"));
    }

    //This Test verifies the number of items in the shopping cart after adding some items to it.
    @Test(description = "Test03 -Put And Verify Shopping Cart Items Count")
    @Description("This Test verifies how much items in the shopping cart after put some")
    public void test03_verifyShoppingCartItemsCount(){
        WebFlows.putSomeItemsIntoCart();
        Verifications.verifyIntNumberElement(nopCommerceUpperMenu.btn_shoppingCart_item_count, getData("ExpectedItemsInCart"));
    }

    //This Test verifies the deletion of the last item in the shopping cart.
    @Test(description = "Test04 - Verify Last Item Delete In Cart")
    @Description("This Test verifies the deletion of last item in cart")
    public void test04_verifyLastItemDeletionInCart(){
        WebFlows.putSomeItemsIntoCart();
        UIActions.click(nopCommerceUpperMenu.btn_shoppingCart);
        WebFlows.deleteLastItemFromCart(); //verfiy is in webflow in this case
    }

    //This Test verifies that the currency has changed from dollar to euro by selecting
    // the desired currency from a dropdown and checking if the item price reflects the change.
    @Test(description = "Test05 - Verify Currency Changed!")
    @Description("This Test verifies that the currency changed from dollar to euro")
    public void test05_verifyCurrencyChanged(){
        UIActions.selectDropDownByText(nopCommerceUpperMenu.currencySelector,getData("SelectCurrnecy"));
        Verifications.verifyElementContainsString(nopCommerceHomePage.item_price,getData("ExpectedCurrency"));
    }

    //This Test verifies the presence of a home page icon using the Sikuli tool for visual element verification.
    @Test(description = "Test06 - Verify Home Page Icon")
    @Description("This Test verifies the home page icon using sikuli tool")
    public void test06_verifyHomePageIcon() throws FindFailed {
        Verifications.visualElement(getData("HomePageIconName"));
    }


    //This Test performs a search using keywords provided through a data provider
    // and verifies the search results against an expected text.
    @Test(description = "Test07 - Search Bar",dataProvider = "data-provider-searchKeyword",dataProviderClass = utilities.ManageDDT.class)
    @Description("This Test searched keyword in table using DDT")
    public void test07_searchKeywords(String keyword , String expectedText) {
        WebFlows.SearchAndVerifyKeyword(keyword,expectedText);
    }

}

