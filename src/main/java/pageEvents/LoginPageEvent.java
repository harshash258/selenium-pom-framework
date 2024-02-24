package pageEvents;

import pojo.BasePOJO;
import utils.FetchElement;
import utils.TestDataHolder;

import java.io.IOException;

import static pageObjects.LoginPageObjects.*;

public class LoginPageEvent {

    FetchElement element = new FetchElement();
    TestDataHolder testDataHolder = new TestDataHolder();

    public void login() throws IOException {
        BasePOJO basePOJO = testDataHolder.fetchDataFromJSON();
        element.findWebElement("id", USERNAME).sendKeys(basePOJO.getLoginPOJO().getUsername());
        element.findWebElement("id", PASSWORD).sendKeys(basePOJO.getLoginPOJO().getPassword());
        element.findWebElement("id", LOGIN_BUTTON).click();
        element.waitForElement("xpath", BAGPACK);
    }

    public void addToCart(){
        element.findWebElement("id", ADD_BAG_TO_CART).click();
    }
    public void viewCart(){
        element.findWebElement("id", CART_BUTTON).click();
        element.waitForElement("id", CHECKOUT);
    }
}
