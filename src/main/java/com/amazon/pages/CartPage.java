package com.amazon.pages;

import com.amazon.element.CartElement;
import com.amazon.wrappers.WebActions;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;
public class CartPage extends WebActions implements CartElement {

    //Constructor
    public CartPage(){
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Click on the Cart
    public void isCartClick(cucumber.api.Scenario scenario){
        Click(driver,BUTTON_CART,scenario);

    }

    //Get Cart Count
    public void getCartCount(String count, cucumber.api.Scenario scenario){

        String tempTxt = getText(driver, BUTTON_CARTCOUNT, scenario);
        System.out.println("The value of Count is -> "+ tempTxt);

        Assert.assertTrue(count.equals(tempTxt));
    }


    //Get Cart Product Title
    public void isGetProdText(String text, cucumber.api.Scenario scenario) {

        String tempTxt = getText(driver, LBL_PRODUCTNAME, scenario);
        System.out.println("The Product from Page is ->" + tempTxt);
        System.out.println("The Product to compare is -> " + text);

        Assert.assertTrue(text.equalsIgnoreCase(tempTxt));

    }


    //Is Product Present
    public void isProductVisible(String text, cucumber.api.Scenario scenario) {
        isElementPresent(driver, LBL_PRODUCTNAME, scenario);

    }



    //Get Cart Price
    public void isGetPrice(String text, cucumber.api.Scenario scenario){

        String tempPrice = getText(driver, LBL_PRODUCTPRICE, scenario);
        System.out.println("The Price from Price is ->" + tempPrice);
        System.out.println("The Price to compare is -> " + text);

        Assert.assertTrue(text.equalsIgnoreCase(tempPrice));

    }



}
