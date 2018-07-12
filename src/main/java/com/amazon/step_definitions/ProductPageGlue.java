package com.amazon.step_definitions;

import com.amazon.pages.LandingPage;
import com.amazon.pages.ProductPage;
import com.amazon.wrappers.WebActions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Then;

public class ProductPageGlue extends WebActions {

    private Scenario scenario;

    LandingPage landingPage = new LandingPage();
    ProductPage productPage = new ProductPage();

    public ProductPageGlue() {
        super(driver);

    }

    @Before("@AddQuantity")
    public void setup(Scenario scenario) throws Exception {
        this.scenario = scenario;

    }


    @After("@Add1stProduct")
    public void quitBrowserHeader() throws Exception
    {
        tearBrowser(scenario);
    }


}
