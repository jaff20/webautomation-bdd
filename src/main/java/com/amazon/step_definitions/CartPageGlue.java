package com.amazon.step_definitions;

import com.amazon.pages.CartPage;
import com.amazon.pages.ProductPage;
import com.amazon.wrappers.WebActions;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

public class CartPageGlue extends WebActions {

    private Scenario scenario;
    private CartPage cartPage = new CartPage();

    public CartPageGlue() {
        super(driver);

    }


    @Before("@ValidateBasket")
    public void setup(Scenario scenario) throws Exception {
        this.scenario = scenario;

    }

    @After("@ValidateBasket")
    public void quitBrowserHeader() throws Exception
    {
        tearBrowser(scenario);
    }


}
