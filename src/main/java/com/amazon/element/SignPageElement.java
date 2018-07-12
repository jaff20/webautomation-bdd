package com.amazon.element;

import org.openqa.selenium.By;

public interface SignPageElement {

    //Email - Web Element
    By TXT_EMAIL = By.xpath("//*[@id='ap_email']");

    //Password - Web Element
    By TXT_PASSWORD = By.xpath("//*[@id='ap_password']");

    //Continue - WebElement
    By BUTTON_LINK = By.xpath("//*[@id='continue']");

    //SignIn - WebElement
    By BUTTON_SIGNIN = By.xpath("//*[@id='signInSubmit']");

    //Error message- Web Element
    By LABEL_ERROR = By.xpath("//*[@id='auth-error-message-box']/div/div/ul/li");

    //Type Text and Continue
    void isTypeTextUser(String text, cucumber.api.Scenario scenario);
    void isTypeTextPwd(String text, cucumber.api.Scenario scenario);
    void isContinue(cucumber.api.Scenario scenario);
    void isSignIn(cucumber.api.Scenario scenario);

}
