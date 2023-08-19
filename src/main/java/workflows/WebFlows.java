package workflows;

import com.google.common.util.concurrent.Uninterruptibles;
import extensions.UIActions;
import extensions.Verifications;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class WebFlows extends CommonOps {

    //Not needed commnets here is this class

    @Step("Step-Filling Information Into Registration Field")
    public static void register(String fName, String lName, String email, String pass, String conPass){
        UIActions.updateText(nopCommerceRegisterPage.txt_firstName, fName);
        UIActions.updateText(nopCommerceRegisterPage.txt_lastName, lName);
        UIActions.updateText(nopCommerceRegisterPage.txt_email, email);
        UIActions.updateText(nopCommerceRegisterPage.txt_password, pass);
        UIActions.updateText(nopCommerceRegisterPage.txt_confirmPassword, conPass);
        Uninterruptibles.sleepUninterruptibly(2, TimeUnit.SECONDS);
        UIActions.click(nopCommerceRegisterPage.btn_register);
        try {
            String errorMsg=nopCommerceRegisterPage.txt_error.getText();
            if(errorMsg.equals("The specified email already exists")){
                return;
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
        UIActions.click(nopCommerceRegisterPage.btn_continue);
    }

    @Step("Step-Login To The Account By Username And Password")
    public static void login (String userName, String password){
        UIActions.updateText(nopCommerceLoginPage.txt_username, userName);
        UIActions.updateText(nopCommerceLoginPage.txt_password, password);
        UIActions.click(nopCommerceLoginPage.btn_login);
    }




    @Step("Step-Delete Last Item From Cart And Verify Deletion")
    public static void deleteLastItemFromCart() {
        List<WebElement> elementsToDelete=nopCommerceShoppingCart.list_elements_deletable_button;
        List<WebElement> elementsToDeleteId=nopCommerceShoppingCart.list_elements_deletable_id;

        String elementBefroeDeleteId=elementsToDeleteId.get(elementsToDeleteId.size()-1).getAttribute("value");

        UIActions.click( elementsToDelete.get(elementsToDelete.size()-1));


        List<WebElement> elementsAfterDeleteId=nopCommerceShoppingCart.list_elements_deletable_id;


        Verifications.verifyItemDeletion(elementsAfterDeleteId,elementBefroeDeleteId);
    }

    @Step("Step-Deleting All The Items")
    public static void deleteAllItemsFromCart() {
        Uninterruptibles.sleepUninterruptibly(3,TimeUnit.SECONDS);
        List<WebElement> elementsToDelete=nopCommerceShoppingCart.list_elements_deletable_button;

        for(int i=elementsToDelete.size()-1;i>=0;i--){
            UIActions.click(elementsToDelete.get(i));
        }
    }

    @Step("Step-Put Some Items Into Cart")
    public static void putSomeItemsIntoCart(){

        UIActions.click(nopCommerceHomePage.clickable_category_Jewelry01);
        UIActions.click(nopCommerceHomePage.btn_add_to_cart_Flower_Girl_Bracelet);
        UIActions.click(nopCommerceHomePage.clickable_category_books09);
        UIActions.click(nopCommerceHomePage.item_book_10);
        UIActions.click(nopCommerceHomePage.clickable_category_electronics11);
        UIActions.click(nopCommerceHomePage.clickable_category_sub_electronics12);
        UIActions.click(nopCommerceHomePage.click_on_camera_to_choose13);
        UIActions.click(nopCommerceHomePage.add_to_card_camera14);
    }

    @Step("Business Flow:Search And Verify Keyword")
    public static void SearchAndVerifyKeyword(String keyword,String expectedText){
        UIActions.updateText(nopCommerceHomePage.SearchBar,keyword);
        UIActions.click(nopCommerceHomePage.btn_SearchBar);
        String actual=nopCommerceSearchedKeyword.searchedKeyword.getAttribute("value");
        Verifications.VerifyTextInElementWithString(actual,expectedText);
    }

}
