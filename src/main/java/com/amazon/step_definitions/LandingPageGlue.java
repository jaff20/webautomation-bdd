package com.amazon.step_definitions;

import com.amazon.pages.CartPage;
import com.amazon.pages.LandingPage;
import com.amazon.pages.ProductPage;
import com.amazon.wrappers.WebActions;
import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import javax.xml.ws.soap.Addressing;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class LandingPageGlue extends WebActions{

    private Scenario scenario;
    private LandingPage landingPage = new LandingPage();
    private ProductPage productPage = new ProductPage();
    private CartPage cartPage = new CartPage();

    public String tempProd;
    public String tempPrice;

    //Storing the product name
    private Hashtable<String, String> prodName = new Hashtable<>();


    public LandingPageGlue(){
        super(driver);
    }

    @Before("@Add1stProduct")
    public void setup(Scenario scenario) throws Exception {
        this.scenario = scenario;

    }


    @Then("^Search for product$")
    public void search_product(DataTable productName) {

        List<Map<String, String>> data;
        data = productName.asMaps(String.class, String.class);

        for (int i = 0; i < data.size(); i++) {
            landingPage.isTypeText(data.get(i).get("productName"), scenario);
            prodName.put("prodName", data.get(i).get("productName"));       //Storing the product for verification
        }

        landingPage.is1stMatched(scenario);

    }

    @And("^click on (.*) and move to product page$")
    public void click_product(int n) throws Exception {

        System.out.println("The Item to Click is -> " + n);
        landingPage.isProductClicked(n,scenario);

    }

    @Then("^capture product name, price and add (.*) quantity to basket$")
    public void compare_productname_price_add_quantity(int qty) {

        tempProd = productPage.isCompareProductName(prodName.get("prodName"),scenario);
        tempPrice = productPage.isGetPrice(scenario);     //Need to fix

        productPage.isSelectQty(qty,scenario);
        prodName.put("quantity", String.valueOf(qty));

        productPage.isAdd2Cart(scenario);

    }


    @And("^validate product added into basket on product page$")
    public void validate_basket(){
        cartPage.isCartClick(scenario);
        cartPage.getCartCount(prodName.get("quantity"),scenario);

    }


    @And("^validate product price and name on basket page$")
    public void validate_product(){

        cartPage.isGetPrice(tempPrice,scenario);
        cartPage.isGetProdText(tempProd,scenario);

    }

    @And("^validate product in basket is present or not")
    public void validate_relogin() {
        cartPage.isCartClick(scenario);
        cartPage.getCartCount(prodName.get("quantity"),scenario);
        cartPage.isProductVisible(tempProd,scenario);

    }



    @And("^Logout$")
    public void i_signout(){
        landingPage.isLogout(scenario);

    }



}

