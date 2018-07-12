package com.amazon.pages;

import com.amazon.element.LandingPageElement;
import com.amazon.wrappers.WebActions;
import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Map;


public class LandingPage extends WebActions implements LandingPageElement {

    //Constructor
    public LandingPage(){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Logout
    public void isLogout(cucumber.api.Scenario scenario) {
        MouseOverLogout(driver, SIGNIN_LINK, LOGOUT_LINK, scenario);
    }


    public void is1stMatched(cucumber.api.Scenario scenario) {
        MouseOverClick(driver,TXT_HOVER,scenario);
    }

    public void isClick(cucumber.api.Scenario scenario){
        Click(driver,BUTTON_SEARCH,scenario);
    }

    public void isTypeText(String text, cucumber.api.Scenario scenario){
        TypeText(driver,TXT_SEARCH,text, scenario);
    }


    public void isProductClicked(int nthItem,Scenario scenario) throws InterruptedException {


        //For Ads
        //String elementAd = "//*[@id='result_0']/div/div/div/div";

        //Get the Ads Count
        //int rowAdsCount = driver.findElements(By.xpath(elementAd)).size();

        //For NonAds
        //String elementList = "//div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li";
        String elementList = "//*[@id='result_0']/div/div/div/div/div/div/a";

        //Get the number of Row in table
        int rowCount = driver.findElements(By.xpath(elementList)).size();


        //If no ads then
        //if (rowAdsCount == 0){

            //if(isElementAd(driver, By.xpath(elementList), scenario)) {

                if (rowCount > 1) {

                    //For Select Based Click on the Item
                    //String elementStart = "//div[1]/div[2]/div/div[3]/div[2]/div/div[4]/div[1]/div/ul/li[";
                    //String elementEnd = "]/div/div/div/div[2]/div[1]/div[1]/a/h2";

                    //String nelement = elementStart + (nthItem) + elementEnd;
                    //By element = By.xpath(nelement);

                    By element = By.xpath(elementList);

                    Click(driver, element, scenario);

                //}
            //}
        }

        //isElementAd(driver, By.xpath(elementList), scenario);

        //String elementStart = elementList;
        //By element = By.xpath(elementStart);

        //Click(driver, element, scenario);

    }

}
