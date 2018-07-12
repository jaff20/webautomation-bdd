package com.amazon.pages;

import com.amazon.element.SignPageElement;
import com.amazon.wrappers.WebActions;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class SignPage extends WebActions implements SignPageElement{


    //Constructor
    public SignPage(){
        super(driver);
        PageFactory.initElements(driver,this);

    }


    //Type Text
    public void isTypeTextUser(String text, cucumber.api.Scenario scenario) {
        TypeText(driver,TXT_EMAIL,text,scenario);

    }


    //Type Text
    public void isTypeTextPwd(String text, cucumber.api.Scenario scenario) {
        TypeText(driver,TXT_PASSWORD,text,scenario);

    }


    //Click Continue
    public void isContinue(cucumber.api.Scenario scenario) {
        Click(driver,BUTTON_LINK,scenario);

    }

    //Click Submit
    public void isSignIn(cucumber.api.Scenario scenario) {
        Click(driver,BUTTON_SIGNIN,scenario);

    }


    //Error
    public void isGetLabelError(String text, cucumber.api.Scenario scenario) {
        String str = getText(driver,LABEL_ERROR,scenario);
        Assert.assertTrue(str.contains(text));

    }


}
