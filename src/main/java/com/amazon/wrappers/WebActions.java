package com.amazon.wrappers;

import com.amazon.utilities.Constants;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;

public abstract class WebActions extends WebWrappers {

    protected static WebDriver driver;
    private static boolean isInit=false;


    //Constructor
    public WebActions(WebDriver driver){

        WebActions.driver=driver;

    }


    //Initializing the Browsers
    protected void setUpBrowser() throws Exception {

        if (!isInit) {

            FileInputStream fs = new FileInputStream(Constants.CONFIG_FILE_PATH);
            Properties config = new Properties();
            config.load(fs);

            if(config.getProperty("os").equalsIgnoreCase(Constants.os)){

                if(config.getProperty("browser").equalsIgnoreCase(Constants.browserChrome)){

                    System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//drivers//chrome//chromedriver");

                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("test-type");
                    options.addArguments("--start-maximized");
                    options.addArguments("--ssl-protocol=any");
                    options.addArguments("--ignore-ssl-error=true");
                    options.addArguments("--disable extensions");
                    options.addArguments("--ignore-certificate-errors");

                    DesiredCapabilities crCapabilities = DesiredCapabilities.chrome();

                    crCapabilities.setCapability("chrome.binary", Constants.CHROME_LOCAL_DRIVER);
                    crCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    crCapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);

                    driver = new ChromeDriver(crCapabilities);

                    }
                }
                else
                    throw new IllegalArgumentException("Browser Type is Undefinied -> Kindly provide the Valid Driver");


                //Identify the Environment
                if(config.getProperty("ENV").equalsIgnoreCase(Constants.PROD)) {
                    //System.out.println("Opening Prod Url->" + config.getProperty("prodURL"));
                    driver.manage().window().maximize();
                    driver.get(config.getProperty("prodURL"));

                }
            }

            isInit=true;

        }


    //Click on the WebElement
    protected void MouseOverClick(final WebDriver driver,
                         final By by,
                         cucumber.api.Scenario scenario){
        try{
            explicitWait(driver,by,scenario);
            final WebElement element = driver.findElement(by);

            explicitWait(driver,by,scenario);

            Actions action = new Actions(driver);
            action.moveToElement(element).click().build().perform();


        } catch(Exception e){
            e.printStackTrace();
        }

    }


    //Logout
    protected void MouseOverLogout(final WebDriver driver,
                                   final By by1,
                                   final By by2,
                                   cucumber.api.Scenario scenario){
        try{

            final WebElement element1 = driver.findElement(by1);
            explicitWait(driver, by1, scenario);
            Actions action = new Actions(driver);
            action.moveToElement(element1).build().perform();

            String os= System.getProperty("os.name");
            if (os.equals("WINDOWS")){
                //Keys.chord(Keys.CONTROL,"a");
                System.out.println("Inside Windows");
            }else {
                explicitWait(driver, by2, scenario);
                Keys.chord(Keys.ARROW_DOWN);
            }

            final WebElement element2 = driver.findElement(by2);
            //explicitWait(driver,by2, scenario);
            action.moveToElement(element2).click().build().perform();

        } catch (Exception e){
            e.printStackTrace();

        }

    }


    //Explicit waiting for action
    protected void explicitWait(final WebDriver driver,
                                final By by,
                                cucumber.api.Scenario scenario){

            waitForElementToClickable(driver, by, Constants.ELEMENTTIMEOUT, scenario);

    }

    //Explicit waiting for an element
    protected void explicitElementWait(final WebDriver driver,
                                       final By by,
                                       cucumber.api.Scenario scenario) {

            waitForElementToLocated(driver, by, Constants.ELEMENTTIMEOUT, scenario);
    }


    //Wait for Element to be Clickable
    private WebElement waitForElementToClickable(final WebDriver driver, final By by,
                                                final int timeOutInSeconds,
                                                cucumber.api.Scenario scenario) {
        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver,Constants.ELEMENTTIMEOUT);
        element = wait.until(ExpectedConditions.elementToBeClickable(by));
        return element;

    }

    private WebElement waitForElementToLocated(final WebDriver driver, final By by,
                                               final int timeoutInSeconds,
                                               cucumber.api.Scenario scenario) {

        WebElement element = null;
        WebDriverWait wait = new WebDriverWait(driver, Constants.ELEMENTTIMEOUT);
        element = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return element;


    }



    //Type Characters
    protected void TypeText(final WebDriver driver,
                            final By by,
                            final String text,
                            cucumber.api.Scenario scenario) {

        final WebElement element = driver.findElement(by);
        element.sendKeys(text.trim());

    }


    //Get the Class Type
    protected boolean isElementAd(final WebDriver driver,
                                  final By by,
                                  cucumber.api.Scenario scenario){

        final WebElement element = driver.findElement(by);
        String isNodeAdType = element.getAttribute("class");

        if(!(isNodeAdType.equals("s-result-item celwidget Adholder"))) {
            return true;
        }
        else {
            return false;
        }
    }


    //Click continue
    protected void Click(final WebDriver driver,
                         final By by,
                         cucumber.api.Scenario scenario) {

        System.out.println("The path to click is ->" + by);
        final WebElement element = driver.findElement(by);
        element.click();
    }

    //Return the Text
    protected String getText(final WebDriver driver,
                             final By by,
                             cucumber.api.Scenario scenario) {

        driver.switchTo().defaultContent();

        final WebElement element = driver.findElement(by);
        return element.getText().trim();
    }

    //Is Element Present
    protected boolean isElementPresent(final WebDriver driver,
                               final By by,
                               cucumber.api.Scenario scenario) {


        final WebElement element = driver.findElement(by);
        return element.isDisplayed();


    }


    //Select the Text
    protected void SelectByIndex(final WebDriver driver,
                                final By by,
                                final int val,
                                cucumber.api.Scenario scenario){

        Select selectText = new Select(driver.findElement(by));
        selectText.selectByIndex(val);
    }


    //Quit the browser
    protected void tearBrowser(cucumber.api.Scenario scenario) throws Exception{

        try{
            driver.close();
            driver.quit();

        } catch (Throwable e) {
            Assert.fail("Not able to close the browser" + String.valueOf(e));

        }
    }


}
