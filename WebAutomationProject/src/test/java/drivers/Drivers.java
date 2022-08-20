package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import java.time.Duration;

public class Drivers {

    DriverType type;
    String url;
    WebDriver driver;
    boolean isButton = false;

    public void SetDriver(DriverType type, String absolutePath) {//control and assign driver properties
        this.type = type;
        if (type.equals(DriverType.CHROME))//controlling driver type and crate driver
        {
            System.out.println("-----chrome-----");
            System.setProperty("webdriver.chrome.driver", absolutePath + "/binary/chromedriver.exe");
            this.driver = new ChromeDriver();
        } else if (type.equals(DriverType.FIREFOX)) {
            System.out.println("------firefox-----");
            System.setProperty("webdriver.gecko.driver", absolutePath + "/binary/geckodriver.exe");
            this.driver = new FirefoxDriver();
        } else {
            System.out.println("invalid Driver Type");
        }

    }

    public WebDriver returnPage() {//return driver
        return this.driver;

    }

    public void GetHomePage(String url) {//get main page
        this.url = url;
        this.driver.get(url);

    }

    public void waitPage(int second) {//driver wait value assigning
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(second));

    }

    public void Maximized() {//maximize the page
        this.driver.manage().window().maximize();

    }

    public void closeDriver() {//close the driver
        this.driver.quit();
        System.out.println("driver closed");

    }

}
