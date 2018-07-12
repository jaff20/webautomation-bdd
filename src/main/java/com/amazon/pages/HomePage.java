package com.amazon.pages;

import com.amazon.element.HomePageElement;
import com.amazon.wrappers.WebActions;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebActions implements HomePageElement {

    //Constructor
    public HomePage(){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    //Validating the Page Header
    public void isTitle(String text, cucumber.api.Scenario scenario) {
        String title = driver.getTitle();
        Assert.assertTrue(title.contains(text));
    }

    //Mouse Hover
    public void isMouseOverClick(cucumber.api.Scenario scenario) {
        MouseOverClick(driver, BUTTON_LINK, scenario);
    }




}
