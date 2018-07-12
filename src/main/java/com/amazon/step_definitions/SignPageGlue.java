package com.amazon.step_definitions;

import com.amazon.pages.HomePage;
import com.amazon.pages.SignPage;
import com.amazon.wrappers.WebActions;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;


public class SignPageGlue extends WebActions {

    private Scenario scenario;
    private HomePage homePage = new HomePage();
    private SignPage signPage = new SignPage();

    public SignPageGlue(){
        super(driver);
    }


    @Before("@IncorrectLogin")
    public void setup(Scenario scenario) throws Exception {
        this.scenario = scenario;

    }



    @After("@IncorrectLogin")
    public void quitBrowserHeader() throws Exception
    {
        tearBrowser(scenario);
    }

    @Then("^Click on the login link$")
    public void click_login_link(){
        homePage.isMouseOverClick(scenario);

    }

    @And("^Provide incorrect username and validate error$")
    public void i_enter_incorrect_username(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (int i=0; i<data.size(); i++) {
            signPage.isTypeTextUser(data.get(i).get("username"), scenario);
            signPage.isContinue(scenario);
            signPage.isGetLabelError(data.get(i).get("error"), scenario);
        }
    }


    @And("^Provide incorrect password and validate error$")
    public void i_enter_incorrect_password(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (int i=0; i<data.size(); i++) {
            signPage.isTypeTextUser(data.get(i).get("username"), scenario);
            signPage.isContinue(scenario);
            signPage.isTypeTextPwd(data.get(i).get("password"), scenario);
            signPage.isSignIn(scenario);
            signPage.isGetLabelError(data.get(i).get("error"), scenario);
        }

    }


    @And("^Provide correct username/password, Validate Home Page Header$")
    public void i_enter_correct_details(DataTable dataTable) {

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (int i=0; i<data.size(); i++) {
            signPage.isTypeTextUser(data.get(i).get("username"), scenario);
            signPage.isContinue(scenario);
            signPage.isTypeTextPwd(data.get(i).get("password"), scenario);
            signPage.isSignIn(scenario);
            homePage.isTitle(data.get(i).get("title"),scenario);
        }

    }

}
