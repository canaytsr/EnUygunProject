package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import lombok.Data;
@Data
public class HomePage extends BasePage {

    @AndroidFindBy(id = "com.appium.patika:id/Title")
    private MobileElement appTitle;

    @AndroidFindBy(id = "com.appium.patika:id/signUpPageTitle")
    private MobileElement pageTitle;
    @AndroidFindBy(id = "com.appium.patika:id/signInEmailTextInput")
    private MobileElement emailInputField;
    @AndroidFindBy(id = "com.appium.patika:id/signInPasswordTextInput")
    private MobileElement passwordInputField;

    @AndroidFindBy(id = "com.appium.patika:id/signInButton")
    private MobileElement signInBtn;

    @AndroidFindBy(id = "com.appium.patika:id/saveLoginCheckBox")
    private MobileElement rememberMeCheckBox;

    @AndroidFindBy(id = "com.appium.patika:id/signUpBtn")
    public static MobileElement signUpBtn;

    @AndroidFindBy(id = "com.appium.patika:id/signInEmailTitle")
    private MobileElement userNameTitle;

    @AndroidFindBy(id = "com.appium.patika:id/SignInPasswordTitle")
    private MobileElement passwordTitle;

    public void setEmail(String email){//set and send email value
        this.emailInputField.sendKeys(email);

    }
    public void setPassword(String password){//set and send password value
        this.passwordInputField.sendKeys(password);

    }

}
