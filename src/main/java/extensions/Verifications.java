package extensions;

import com.google.common.util.concurrent.Uninterruptibles;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.sikuli.script.FindFailed;
import org.testng.Assert;
import utilities.CommonOps;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Verifications extends CommonOps {

    //This method verifies that the text in a WebElement matches the expected text using `Assert.assertEquals()`.
    @Step("Verify Text In Element")
    public static void verifyTextInElement(WebElement elem, String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        Assert.assertEquals(elem.getText(), expected);
    }

    //This method verifies that the provided element text matches the expected text using `Assert.assertEquals()`.
    @Step("Verify Text In Element With String")
    public static void VerifyTextInElementWithString(String elementText,String expected){

        Assert.assertEquals(elementText,expected);
    }


    //This method verifies that the text in a WebElement contains the expected text by checking
    // if the expected text is present in the WebElement's text using `Assert.assertTrue()`.
    @Step("Verify Elements Text Contains The Expected Text")
    public static void verifyElementContainsString(WebElement elem,String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));

        String strTestSymbol=elem.getText();
        boolean isSymbolPresented=false;

        if(strTestSymbol.contains(expected)){
            isSymbolPresented=true;
        }
        Assert.assertTrue(isSymbolPresented,"Not Contians the text you want:"+expected);
    }


    //This method verifies that an item has been deleted by iterating through a list
    // of elements and checking if any element's value attribute matches the provided search string using `Assert.assertFalse()`.
    @Step("Verify Item Deleteion")
    public static void verifyItemDeletion(List<WebElement> elementList , String searchString) {

        boolean foundElementAfterDelete=false;

        for(WebElement element:elementList)
        {
            if(element.getAttribute("value").equals(searchString)){
                foundElementAfterDelete=true;
            }
        }
        Assert.assertFalse(foundElementAfterDelete);

    }

    //This method verifies that the text in a WebElement contains only numbers
    // and matches the expected number by extracting the numbers from the WebElement's text
    // and comparing them to the expected number using `Assert.assertEquals()`.
    @Step("Verify number(int) In Element")
    public static void verifyIntNumberElement(WebElement elem,String expected){
        wait.until(ExpectedConditions.visibilityOf(elem));
        String str= elem.getText();

        String numberOnly= str.replaceAll("[^0-9]", "");

        Assert.assertEquals(numberOnly,expected);
    }


    //This method verifies the number of elements in a list matches the expected number using `Assert.assertEquals()`.
    @Step("Verify Number Of Elements")
    public static void numberOfElements(List<WebElement> elems , int expected){
        wait.until(ExpectedConditions.visibilityOf(elems.get(elems.size()-1)));
        Assert.assertEquals(elems.size(),expected);
    }

    //This method verifies the visibility of multiple elements in a list using
    // a soft assertion. It checks if each element is displayed and collects all
    // failures before asserting them using `softAssert.assertAll()`.
    @Step("Verify Visibility Of Elements (Soft-Assertion)")
    public static void visibilityOfElements(List<WebElement> elems){
        for(WebElement elem:elems){
            softAssert.assertTrue(elem.isDisplayed(),"Sorry" + elem.getText()+" not displayed");
        }
        softAssert.assertAll("Some elements were not displayed");
    }


    //This method verifies the presence of an element visually by comparing
    // it to an expected image using the Sikuli tool's `screen.find()` method.
    @Step("Verify Element Visually")
    public static void visualElement(String expectedImageName) throws FindFailed {
        try {
            screen.find(getData("ImageRepo")+expectedImageName+".PNG");
        }
        catch (FindFailed findFailed){
            System.out.println("Error Comparing Image File:"+findFailed);
            Assert.fail("Error Comparing Image File: "+findFailed);
        }
    }

    //This method verifies the existence of elements in a list by checking
    // if the size of the list is greater than 0 using `Assert.assertTrue()`.
    @Step("Verify Element Displayed")
    public static void existanceOfElement(List<WebElement> elements){
        Assert.assertTrue(elements.size()>0);
    }

    //This method verifies the non-existence of elements in a list by
    // checking if the size of the list is not greater than 0 using `Assert.assertFalse()`.
    @Step("Verify Element Not Displayed")
    public static void nonExistanceOfElement(List<WebElement> elements){
        Assert.assertFalse(elements.size()>0);
    }

}
