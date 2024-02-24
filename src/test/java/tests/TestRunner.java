package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pageEvents.LoginPageEvent;

import java.io.IOException;

public class TestRunner extends BaseTest {
    LoginPageEvent event = new LoginPageEvent();

    @Test
    public void test() throws IOException {
        event.login();
        event.addToCart();
        event.viewCart();
    }
}
