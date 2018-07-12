package com.amazon.element;

import org.openqa.selenium.By;

public interface ProductPageElement {

    //Product Title - WebElement
    By LBL_PRODUCTTEXT = By.xpath("//*[@id='productTitle']");

    //Product Price - WebElement
    By LBL_PRODUCTPRICE = By.xpath("//*[@id='priceblock_ourprice']");

    //Product Quantity - WebElement
    By BTN_PRODUCTQTY = By.xpath("//*[@id='quantity']");

    //Add to Cart - WebElement
    By BTN_ADD2CART = By.xpath("//*[@id='add-to-cart-button']");

    //Get the Text for a field - WebElement
    String isCompareProductName(String text, cucumber.api.Scenario scenario);

    //Get the Price for a Field - WebElement
    String isGetPrice(cucumber.api.Scenario scenario);

}
