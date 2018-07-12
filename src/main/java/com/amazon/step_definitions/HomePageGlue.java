package com.amazon.step_definitions;

import com.amazon.pages.HomePage;
import com.amazon.wrappers.WebActions;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class HomePageGlue extends WebActions {

    private Scenario scenario;


    public HomePageGlue(){
        super(driver);
    }


    @Before("@Header")
    public void setupHeader(Scenario scenario) throws Exception {
        this.scenario = scenario;

    }


    @Given("^IsTest Runnable (.*)$")
    public void isTestRunnable(String RunMode){

        if(RunMode.trim().equalsIgnoreCase("N"))
            throw new PendingException("Skipping the Test as the Run mode of the Data is Set to N");

    }


    @When("^Launch www.amazon.com page and validate PageHeader")
    public void startBrowser(DataTable title){

        HomePage homePage = new HomePage();

        try{
            setUpBrowser();

        } catch (Exception e){
            Assert.fail("Test Failed - Not able to setup the browser");

        }

        List<Map<String, String>> data = title.asMaps(String.class, String.class);
        for(int i=0;i<data.size();i++)
            homePage.isTitle(data.get(i).get("Title"),scenario);
    }


    @After("@Header")
    public void quitBrowserHeader() throws Exception
    {
        tearBrowser(scenario);
    }



}
