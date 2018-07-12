package com.amazon.wrappers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public abstract class WebWrappers {

    //Set the Browser
    protected abstract void setUpBrowser() throws Exception;


    //Quit the Browser
    protected abstract void tearBrowser(cucumber.api.Scenario scenario) throws Exception;


    //Click on the WebElement - Login
    protected abstract void MouseOverClick(final WebDriver driver,
                                           final By by,
                                           cucumber.api.Scenario scenario
    ) throws Exception;


    //Click on the WebElement - Logout
    protected abstract void MouseOverLogout(final WebDriver driver,
                                            final By by1,
                                            final By by2,
                                            cucumber.api.Scenario scenario
    ) throws Exception;



    //Explicit wait for the Element
    protected abstract void explicitWait(final WebDriver driver,
                                            final By by,
                                            cucumber.api.Scenario scenario
                                        ) throws Exception;


    //Type Characters
    protected abstract void TypeText(final WebDriver driver,
                                        final By by,
                                        final String text,
                                        cucumber.api.Scenario scenario
                                        ) throws Exception;


    //Return the Text
    protected abstract String getText(final WebDriver driver,
                                              final By by,
                                              cucumber.api.Scenario scenario
                                              ) throws Exception;


    //Select by Text
    protected abstract void SelectByIndex(final WebDriver driver,
                                            final By by,
                                            final int indexVal,
                                            cucumber.api.Scenario scenario
                                            ) throws Exception;


    //Is Web Element Present
    protected abstract boolean isElementPresent(final WebDriver driver,
                                            final By by,
                                            cucumber.api.Scenario scenario);



}
