package com.amazon.element;

import cucumber.api.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public interface HomePageElement {

    //Page Title
    void isTitle(String text, cucumber.api.Scenario scenario);

    //Mouse Over Click
    void isMouseOverClick(cucumber.api.Scenario scenario);

    //SignIn - Web Element
    By BUTTON_LINK = By.linkText("Sign in");




}
