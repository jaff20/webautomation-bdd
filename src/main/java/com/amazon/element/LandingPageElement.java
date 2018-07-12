package com.amazon.element;

import org.openqa.selenium.By;

public interface LandingPageElement {

    //Sign - Web Element
    By SIGNIN_LINK = By.xpath("//*[@id='nav-link-accountList']/span[2]");

    //Logout - Web Element
    By LOGOUT_LINK = By.linkText("Sign Out");

    //Search Box - WebElement
    By TXT_SEARCH = By.xpath("//*[@id='twotabsearchtextbox']");

    //First Matched - WebElemet
    By TXT_HOVER = By.xpath("//*[@id='issDiv1']");

    //Search Button - WebElement
    By BUTTON_SEARCH = By.xpath("//*[@id='nav-search']/form/div[2]/div/input");

    //Click
    void isClick(cucumber.api.Scenario scenario);

    //Hover
    void is1stMatched(cucumber.api.Scenario scenario);

    //Type
    void isTypeText(String text, cucumber.api.Scenario scenario);


    //Click the Search Item
    void isProductClicked(int n, cucumber.api.Scenario scenario) throws Exception;


}
