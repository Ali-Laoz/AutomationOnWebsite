package utilities;

import org.openqa.selenium.support.PageFactory;
import pageObjects.nopCommerce.*;

public class ManagePages extends Base{

    //initNopCommerce method is which initializes various page objects
    // in the nopCommerce application using the PageFactory class.
    public static void initNopCommerce(){
        nopCommerceUpperMenu= PageFactory.initElements(driver, UpperMenuPage.class);
        nopCommerceShoppingCart=PageFactory.initElements(driver,ShoppingCartPage.class);
        nopCommerceHomePage =PageFactory.initElements(driver, HomePage.class);
        nopCommerceSearchedKeyword=PageFactory.initElements(driver,SearchedKeyword.class);
        nopCommerceRegisterPage=PageFactory.initElements(driver,RegisterPage.class);
        nopCommerceLoginPage=PageFactory.initElements(driver,LoginPage.class);
    }
}
