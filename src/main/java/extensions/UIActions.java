package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import utilities.CommonOps;

import java.util.concurrent.TimeUnit;

public class UIActions extends CommonOps {

    //steps

    //This method waits for an element to be clickable and then clicks on it.
    @Step("Click On Element")
    public static void click(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        elem.click();
    }

    //This method waits for an element to be visible and then updates its text by sending the provided text as input.
    @Step("Update Text Element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    //This method waits for an element to be visible and then
    // updates its text character by character with a delay of 500 milliseconds between each character,
    //that is simulates human typing speed
    @Step("Update Text Element")
    public static void updateTextHuman(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        for(char ch:text.toCharArray())
        {
            Uninterruptibles.sleepUninterruptibly(500, TimeUnit.MILLISECONDS);
            elem.sendKeys(ch + "");
        }
    }

    //This method waits for a dropdown element to be visible, creates a Select object,
    // and selects the option with the provided visible text.
    @Step("Update DropDown Element")
    public static void selectDropDownByText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.selectByVisibleText(text);
    }

    //This method waits for a dropdown element to be visible,
    // creates a Select object, and deselects the option with the provided visible text
    @Step("Update DropDown Element")
    public static void updateDropDown(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Select dropDown = new Select(elem);
        dropDown.deselectByVisibleText(text);
    }

    //This method performs a mouse hover action by moving the mouse
    // to the first element and then to the second element before clicking on it.
    @Step("Mouse Hover Element")
    public static void mouseHover(WebElement elem1 ,WebElement elem2){
        action.moveToElement(elem1).moveToElement(elem2).click().build().perform();
    }

}
