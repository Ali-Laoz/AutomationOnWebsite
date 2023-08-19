package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution){
        // TODO Auto-generated method stub
        System.out.println("------------- Starting Execution --------------");  // Prints a message indicating the start of test execution
    }

    public void onFinish(ITestContext execution){
        // TODO Auto-generated method stub
        System.out.println("------------- Ending Execution --------------");  // Prints a message indicating the end of test execution
    }

    public void onTestStart(ITestResult test){
        // TODO Auto-generated method stub
        System.out.println("-------------Starting Test:"+test.getName()+ "-----------------");  // Prints a message indicating the start of a test
    }

    public void onTestSuccess(ITestResult test){
        // TODO Auto-generated method stub
        System.out.println("-------------Test:"+test.getName()+ "Passed-----------------");  // Prints a message indicating that a test has passed

        //Stop Recording File
        try {
            MonteScreenRecorder.stopRecord();  // Stops the recording of the test method using MonteScreenRecorder
        } catch (Exception e) {
            e.printStackTrace();
        }
        //Delete Recorded File
        File file = new File("./test-recordings/" + test.getName() + ".avi");  // Deletes the recorded video file for the test
        if(file.delete()){
            System.out.println("File Deleted Successfully");
        }
        else {
            System.out.println("Failed to Delete File");
        }
    }

    public void onTestFailure(ITestResult test){
        // TODO Auto-generated method stub
        System.out.println("-------------Test:"+test.getName()+ "Failed-----------------");  // Prints a message indicating that a test has failed
        try {
            MonteScreenRecorder.stopRecord();  // Stops the recording of the test method using MonteScreenRecorder
        } catch (Exception e) {
            e.printStackTrace();
        }
        saveScreenshot();  // Saves a screenshot of the page
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        // TODO implement this
    }

    public void onTestSkipped(ITestResult test){
        // TODO Auto-generated method stub
        System.out.println("------------- Skipping Test:"+test.getName()+ "-----------------");  // Prints a message indicating that a test has been skipped
    }


    @Attachment(value = "Page Screen-Shot", type = "image/png")
    public byte[]  saveScreenshot() {
        System.out.println("taking screenshot!");  // Prints a message indicating that a screenshot is being taken
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);  // Takes a screenshot of the page
    }
}


