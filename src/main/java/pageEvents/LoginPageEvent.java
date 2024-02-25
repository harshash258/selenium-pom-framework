package pageEvents;

import pojo.BasePOJO;
import utils.EventListener;
import utils.TestDataHolder;

import java.io.IOException;

import static pageObjects.LoginPageObjects.*;
import static utils.Constants.ID;
import static utils.Constants.XPATH;

public class LoginPageEvent {

    EventListener element = new EventListener();
    TestDataHolder testDataHolder = new TestDataHolder();

    public void login() throws IOException {
        BasePOJO basePOJO = testDataHolder.fetchDataFromJSON();
        element.findWebElement(ID, USERNAME).sendKeys(basePOJO.getLoginPOJO().getUsername());
        element.findWebElement(ID, PASSWORD).sendKeys(basePOJO.getLoginPOJO().getPassword());
        element.findWebElement(ID, LOGIN_BUTTON).click();
        element.waitForElement(XPATH, BAGPACK);
    }

    public void addToCart(){
        element.findWebElement(ID, ADD_BAG_TO_CART).click();
    }
    public void viewCart(){
        element.findWebElement(ID, CART_BUTTON).click();
        element.waitForElement(ID, CHECKOUT);
    }
}
