package pageObjects.nopCommerce;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

//This page is what appears after the search
public class SearchedKeyword {

    //getting this WebElement for its text this text is the appears after the search is typed
    @FindBy(how = How.ID,using = "q")
    public WebElement searchedKeyword;
}
