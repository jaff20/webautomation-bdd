package com.amazon.element;

import org.openqa.selenium.By;

public interface CartElement {

    //Cart Element - WebElement
    By BUTTON_CART = By.xpath("//*[@id='nav-cart']");

    //Cart Count = WebElement
    By BUTTON_CARTCOUNT = By.xpath("//*[@id='nav-cart-count']");

    //Cart Product Element and Price - WebElement
    By LBL_PRODUCTNAME = By.xpath("//SPAN[@class='a-size-medium sc-product-title a-text-bold']");
    By LBL_PRODUCTPRICE = By.xpath("//*[@id='activeCartViewForm']/div[2]/div/div[4]/div/div[2]/p/span");

    //Is Product present
    void isProductVisible(String text, cucumber.api.Scenario scenario) throws Exception;


    //Click
    void isCartClick(cucumber.api.Scenario scenario);

    //getCart Count
    void getCartCount(String text, cucumber.api.Scenario scenario) throws Exception;

    //Get Text
    void isGetProdText(String text, cucumber.api.Scenario scenario) throws Exception;
    void isGetPrice(String text, cucumber.api.Scenario scenario) throws Exception;

}
