package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Step;
import listener.GenericListener;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.validator.routines.EmailValidator;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utility.BaseTest;
import java.net.MalformedURLException;

@Slf4j
@Listeners({GenericListener.class})
public class ValidateHomePageTestNG extends BaseTest {

    @Step("check application header")
    @Test(priority = 1,description = "application header check description")
    public void validateCheckHomePageTitle() {

        //Checking application the header is equal to "Appium Patika Tutorial"
        try {
            Assert.assertEquals(homePage.getAppTitle().getText(), "Appium Patika Tutorial");
        } catch (NoSuchElementException exception) {
            System.out.println
                    ("Page Title element was not found , please check HomePage for this element"
                            + exception.getMessage());
        }

    }

    @Step("check header for description area")
    @Test(priority = 2)
    @Description("title check description")
    public void checkApplicationMainTitle() throws NullPointerException, InterruptedException {

        //Controlling if the element is accessible
        if (!homePage.getAppTitle().isEnabled()) {
            System.out.println("Element not accessible");
        }
        //Checking if the text in the top header of the page is empty
        else if (homePage.getAppTitle().getText().isEmpty()) {
            System.out.println("Header text is empty");
        }
        //Checking if the content of the text is equal to Appium Patika Tutorial
        else {
            Assert.assertEquals(homePage.getAppTitle().getText(), "Appium Patika Tutorial");
        }
    }

    @Step("check email input area")
    @Test(priority = 3)
    @Description("email check description")
    public void checkEmailArea() {

        //set object e-mail address
        homePage.setEmail("username@gmail.com");

        //Controlling if the element is accessible
        if (!homePage.getEmailInputField().isEnabled()) {
            System.out.println("Element not accessible");
        }
        //Checking if the email field text is empty
        else if (homePage.getEmailInputField().getText().isEmpty()) {
            System.out.println("Email area is empty");
        }
        //Checking the email is valid or not
        else if (!EmailValidator.getInstance().isValid(homePage.getEmailInputField().getText())) {
            System.out.println("Email not valid");
        }
        //Checking if the content of the text is equal to username@gmail.com
        else {
            Assert.assertEquals("username@gmail.com", homePage.getEmailInputField().getText());
        }

    }

    @Step("check password input area")
    @Test(priority = 4)
    @Description("password check description")
    public void checkPasswordArea() {

        //set object password value
        homePage.setPassword("password123");

        //Controlling if the element is accessible
        if (!homePage.getPasswordInputField().isEnabled()) {
            System.out.println("Element not accessible");
        }
        //Checking if the email field text is empty
        else if (homePage.getPasswordInputField().getText().isEmpty()) {
            System.out.println("Password area is empty");
        }
        //Checking the email is not include special character
        else if (homePage.getPasswordInputField().getText().contains("[^A-Za-z0-9]")) {
            System.out.println("Password is not include any character");
        }
        //Checking if the content of the text is equal to sizes
        else {
            Assert.assertEquals("password123".length(), homePage.getPasswordInputField().getText().length());
        }

    }

    @Step("check remember me check box")
    @Description("remember me check box check description")
    @Test(priority = 5)

    public void checkRememberMeBox() throws MalformedURLException {
        //Controlling if the element is accessible
        if (!homePage.getRememberMeCheckBox().isEnabled()) {
            System.out.println("Element not accessible");
        }
        //Checking RememberMeCheckBox text is not empty
        else if (homePage.getRememberMeCheckBox().getText().isEmpty()) {
            System.out.println("Remember me check box text is empty");
        }
        //Checking if the content of the text is equal to Beni Hatırla
        else {
            homePage.getRememberMeCheckBox().click();
            Assert.assertEquals("Beni Hatırla", homePage.getRememberMeCheckBox().getText());
            Assert.assertEquals("true", homePage.getRememberMeCheckBox().getAttribute("checkable"));
            Assert.assertEquals("true", homePage.getRememberMeCheckBox().getAttribute("checked"));

        }
    }

    @Step("check signIn button")
    @Test(priority = 6)
    @Description("signIn button check description")
    public void checkSignInButton() throws MalformedURLException {
        //Controlling if the element is accessible
        if (!homePage.getSignInBtn().isEnabled()) {
            System.out.println("Element not accessible");
        }
        //Checking button text is not empty
        else if (homePage.getSignInBtn().getText().isEmpty()) {
            System.out.println("Button text is empty");
        }
        //Checking if the content of the text is equal to Sign In
        else {
            Assert.assertEquals("GIRIŞ YAP", homePage.getSignInBtn().getText());
            homePage.getSignInBtn().click();
        }
    }

    @AfterClass
    public void waiter() throws InterruptedException {
        Thread.sleep(5000);
    }


}
