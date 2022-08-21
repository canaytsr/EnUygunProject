package utility;

import devices.DeviceFarm;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pages.HomePage;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.InvalidPathException;

import static com.thoughtworks.selenium.Wait.DEFAULT_TIMEOUT;

public class BaseTest {
    public static AppiumDriver<?> Driver;
    public static WebDriverWait wait;
    public static HomePage homePage;
    String oreo;
    DesiredCapabilities capabilities;

    public BaseTest() {
        //set android oreo value
        this.oreo = DeviceFarm.ANDROID_OREO.path;
    }

    @BeforeSuite
    public void configAppiumDriver() {
        //create capabilities object
        this.capabilities = new DesiredCapabilities();

        //controlling oreo path is valid or not
        try {
            this.capabilities = utility.DeviceFarmUtility.pathDesiredCapabilities(this.oreo);
        } catch (InvalidPathException exception) {
            System.out.println("Please add correct path , this path is not working" + exception.getMessage());
        }

        //controlling apk file path is valid or not
        try {
            File appDir = new File("src/test/resources/apps");
            File app = new File(appDir, "patikaappium.apk");
            this.capabilities.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
        } catch (WebDriverException exception) {
            System.out.println("Please add apk , was not find file APK or APK path" + exception.getMessage());
        }

        //controlling appium url remote path is valid or not
        try {
            Driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), this.capabilities);
        } catch (MalformedURLException exception) {
            System.out.println("Please set correct remote url hub :\t" + exception.getMessage());
        }
        wait = new WebDriverWait(Driver, DEFAULT_TIMEOUT);
    }

    @BeforeTest
    public void createPages() {
        //create main page
        homePage = new HomePage();
    }

    @AfterSuite
    public void tearDown() {
        //close driver
        if (Driver != null) {
            Driver.quit();
        }
    }
}
