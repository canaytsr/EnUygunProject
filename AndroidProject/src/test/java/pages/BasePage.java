package pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utility.BaseTest;
public class BasePage extends BaseTest {
    public BasePage(){

        PageFactory.initElements(new AppiumFieldDecorator(Driver), this);
    }

}
