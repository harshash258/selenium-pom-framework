package pageEvents;

import base.BaseTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.model.Media;
import pojo.BasePOJO;
import utils.EventListener;
import utils.TestDataHolder;

import java.io.IOException;

import static pageObjects.LoginPageObjects.*;
import static utils.Constants.ID;
import static utils.Constants.XPATH;

public class LoginPageEvent {

    EventListener event = new EventListener();
    TestDataHolder testDataHolder = new TestDataHolder();

    public void login() throws IOException {
        BasePOJO basePOJO = testDataHolder.fetchDataFromJSON();
        event.findWebElement(ID, USERNAME).sendKeys(basePOJO.getLoginPOJO().getUsername());
        event.findWebElement(ID, PASSWORD).sendKeys(basePOJO.getLoginPOJO().getPassword());
        event.takeScreenShot("entering credentials");
        event.findWebElement(ID, LOGIN_BUTTON).click();
        event.waitForElement(XPATH, BAGPACK);
    }

    public void addToCart() {

        event.findWebElement(ID, ADD_BAG_TO_CART).click();
        event.takeScreenShot("adding product to cart");
    }
    public void viewCart(){
        event.findWebElement(ID, CART_BUTTON).click();
        event.takeScreenShot("checking cart");
        event.waitForElement(ID, CHECKOUT);
    }
}
