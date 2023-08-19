package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.sikuli.script.Screen;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

public class CommonOps extends Base{

    public static String getData (String nodeName) {
        File fXmlFile;
        DocumentBuilderFactory dbFactory;
        DocumentBuilder dBuilder;
        Document doc = null;
        try {
            fXmlFile = new File("./Configuration/DataConfig.xml");  // Reads the XML file for data configuration
            dbFactory = DocumentBuilderFactory.newInstance();
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        finally {
            return doc.getElementsByTagName(nodeName).item(0).getTextContent();  // Retrieves the data value based on the provided node name
        }
    }

    public static void initBrowser(String browserType){
        if(browserType.equalsIgnoreCase("chrome")){
            driver=initChromeDriver();  // Initializes the Chrome driver
        } else if (browserType.equalsIgnoreCase("firefox")) {
            driver=initFirefoxDriver();  // Initializes the Firefox driver
        }
        else if (browserType.equalsIgnoreCase("ie")) {
            driver=initIEDriver();  // Initializes the Internet Explorer driver
        }
        else{
            throw new RuntimeException("Invalid browser type");
        }

        long timeOut=Long.parseLong(getData("Timeout"));  // Retrieves the timeout value from the data configuration
        String url=getData("Url");  // Retrieves the URL value from the data configuration

        driver.manage().window().maximize();  // Maximizes the browser window
        driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);  // Sets the implicit wait time
        driver.get(url);  // Navigates to the specified URL
        wait=new WebDriverWait(driver,timeOut);  // Initializes the WebDriverWait instance
        ManagePages.initNopCommerce();  // Initializes the page objects for the nopCommerce application
        action=new Actions(driver);  // Initializes the Actions instance for mouse and keyboard actions
    }

    public static WebDriver initChromeDriver(){
        WebDriverManager.chromedriver().setup();  // Sets up the ChromeDriver executable
        WebDriver driver = new ChromeDriver();  // Initializes the Chrome driver
        return driver;
    }

    public static WebDriver initFirefoxDriver(){
        WebDriverManager.firefoxdriver().setup();  // Sets up the FirefoxDriver executable
        WebDriver driver = new FirefoxDriver();  // Initializes the Firefox driver
        return driver;
    }

    public static WebDriver initIEDriver(){
        WebDriverManager.iedriver().setup();  // Sets up the InternetExplorerDriver executable
        WebDriver driver = new InternetExplorerDriver();  // Initializes the Internet Explorer driver
        return driver;
    }

    @BeforeClass
    public void startSession() {
        String platform=getData("PlatformName");  // Retrieves the platform name from the data configuration
        String browser=getData("BrowserName");  // Retrieves the browser name from the data configuration

        if(platform.equalsIgnoreCase("web")){
            initBrowser(browser);  // Initializes the browser based on the platform and browser name
        }
//        else if(platform.equalsIgnoreCase("mobile")){
//            initMobile();
//        }
        else{
            throw new RuntimeException("Invalid platform name");
        }

        softAssert=new SoftAssert();  // Initializes the SoftAssert instance for soft assertions
        screen=new Screen();  // Initializes the Screen instance for capturing screenshots
    }

    @AfterClass
    public void endSession(){
        driver.quit();  // Quits the browser session
    }

    @AfterMethod
    public void afterMethod(){
        driver.get("https://demo.nopcommerce.com/");  // Navigates to a specific URL after each test method
    }

    @BeforeMethod
    public void beforeMethod(Method method){
        try {
            MonteScreenRecorder.startRecord(method.getName());  // Starts recording the test method using MonteScreenRecorder
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}