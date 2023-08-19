package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage {

    //1 jewelry category
    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[2]/ul[1]/li[6]/a")
    public WebElement clickable_category_Jewelry01;

    //2 button add to cart of Flower Girl Bracelet
    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[2]/div/div[2]/div[3]/div[2]/button[1]")
    public WebElement btn_add_to_cart_Flower_Girl_Bracelet;


    //3 books category
    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[2]/ul[1]/li[5]/a")
    public WebElement clickable_category_books09;


    //4 button add to cart of Fahrenheit 451 by Ray Bradbury book
    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")
    public WebElement item_book_10;


    //5 electronics category
    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[2]/ul[1]/li[2]/a")
    public WebElement clickable_category_electronics11;


    //6 Camera & photo sub-electronics
    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[1]/div/div[1]/div/div/a/img")
    public WebElement clickable_category_sub_electronics12;

    //7 button add to cart of Nikon D5500 DSLR
    @FindBy(how = How.XPATH,using = "/html/body/div[6]/div[3]/div/div[3]/div/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div[3]/div[2]/button[1]")
    public WebElement click_on_camera_to_choose13;

    //8 button add to cart of Nikon D5500 DSLR choose color(black)
    @FindBy(how = How.XPATH,using = "//*[@id=\"add-to-cart-button-14\"]")
    public WebElement add_to_card_camera14;

    //9 choose 1 price from some prices
    @FindBy(how = How.CSS,using = "span[class='price actual-price']")
    public WebElement item_price;


    //10 the search bar
    @FindBy(how = How.ID,using = "small-searchterms")
    public WebElement SearchBar;

    //11 search bar button
    @FindBy(how = How.CSS,using = "button[class='button-1 search-box-button']")
    public WebElement btn_SearchBar;

}
