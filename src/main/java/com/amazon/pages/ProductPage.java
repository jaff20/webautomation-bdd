package com.amazon.pages;

import com.amazon.element.ProductPageElement;
import com.amazon.wrappers.WebActions;
import cucumber.api.Scenario;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class ProductPage extends WebActions implements ProductPageElement {

    //private String tempText;     //Product Name;
    //private String tempPrice;    //Price;

    //Constructor
    public ProductPage(){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    //Get Product Text
    public String isCompareProductName(String text, cucumber.api.Scenario scenario) {
        String tempStr = getText(driver, LBL_PRODUCTTEXT,scenario).toLowerCase();
        String tempText = tempStr.toLowerCase();

        //System.out.println("The Product Name From Page Is -> " + tempStr);
        System.out.println("The Product Name Store is -> " + tempText);

        Assert.assertTrue(tempStr.matches("(.*)([a-z])(.*)"));

        return tempText;

    }

    //Get the Price
    public String isGetPrice(cucumber.api.Scenario scenario) {

        String tempPrice = getText(driver, LBL_PRODUCTPRICE, scenario);

        System.out.println("The Price is ->" + tempPrice);
        Assert.assertTrue(tempPrice.matches("^\\$(\\d{1,3}(\\,\\d{3})*|(\\d+))(\\.\\d{2})?$"));

        return tempPrice;

    }

    //Select the Index Price
    public void isSelectQty(int indexVal, cucumber.api.Scenario scenario) {

        SelectByIndex(driver,BTN_PRODUCTQTY,indexVal-1,scenario);

    }

    //Add to Card
    public void isAdd2Cart(cucumber.api.Scenario scenario) {

        Click(driver,BTN_ADD2CART,scenario);

    }

}
