package testMethods;

import drivers.DriverType;
import drivers.Drivers;
import mainPage.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GetTicketTest {

    MainPage mainPage;
    Drivers driver;
    private final String origin = "İstan";
    private final String destination ="amster";
    private final int departureDay = 11;
    private final int returnDay = 7;
    private final boolean returnIsClick = true;
    private final String provider ="Türk Hava Yolları";
    private final String provider2 ="Pegasus";
    String url = "https://www.enuygun.com/ucak-bileti/";

    @BeforeClass
    public void setup(){//making assignment
        Path resourceDirectory = Paths.get("src", "test", "resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        driver = new Drivers();//create new driver
        driver.SetDriver(DriverType.CHROME, absolutePath);//set driver type to chrome
        driver.Maximized();//maximized page
        driver.GetHomePage(url);//set driver url
        mainPage = new MainPage(driver.returnPage());
    }

    @Test(priority = 1)
    public void searchKeywordForOrigin() {
        //sending origin key value
        mainPage.getListForOriginSearch(origin);

    }

    @Test(priority = 2)
    public void searchKeywordForDestination()  {
        //sending destination key value
        mainPage.getListForDestinationSearch(destination);

    }
    @Test(priority = 3)
    public void selectDatesForOrigin() {
        //selecting departure day
        mainPage.getDatesForOrigin(departureDay);

    }
    @Test(priority = 4)
    public void selectDateForDestination()  {
        //selecting return day
        mainPage.getDateForDestination(returnDay);

    }
    @Test(priority = 5)
    public void clickDirect()  {
        //controlling check box
        mainPage.clickCheckBox(returnIsClick);

    }
    @Test(priority = 6)
    public void clickBuyTicket()  {
        //clicking buy ticket button
        mainPage.clickButton();

    }
    @Test(priority = 7)
    public void selectFlight()  {
        //selecting flight by using provider value
        mainPage.selectFlightWithProvider(provider2);

    }
    @Test(priority = 8)
    public void selectReturnFlight()  {
        //select return flight by list element by index number
        mainPage.selectReturnFlight(1);

    }
    @Test(priority = 9)
    public void clickSelectButton()  {
        //clicking select button
        mainPage.clickSelectButton();

    }
}
