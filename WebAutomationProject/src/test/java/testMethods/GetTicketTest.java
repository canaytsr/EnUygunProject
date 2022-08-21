package testMethods;

import drivers.DriverType;
import drivers.Drivers;
import io.qameta.allure.Description;
//import io.qameta.allure.Story;
import listeners.TestListener;
import mainPage.MainPage;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import java.nio.file.Path;
import java.nio.file.Paths;

@Listeners({TestListener.class})
public class GetTicketTest {
    MainPage mainPage;
    Drivers driver;
    private final String origin = "İstan";
    private final String destination ="amster";
    private final int departureDay = 10;
    private final int returnDay = 5;
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

    @Test(priority = 1,description = "select keyword value in the origin list")
   // @Story("send true keyword")
    @Description("click origin search area and send key value")
    public void searchKeywordForOrigin() {
        //sending origin key value
        mainPage.getListForOriginSearch(origin);

    }

    @Test(priority = 2,description = "select keyword value in the destination list")
  //  @Story("send true keyword")
  //  @Description("click destination search area and send key value")
    public void searchKeywordForDestination()  {
        //sending destination key value
        mainPage.getListForDestinationSearch(destination);

    }
    @Test(priority = 3,description ="select date for using departure day value")
   // @Story("select date for departure day")
   // @Description("click calendar area for departure day and select true value")
    public void selectDatesForOrigin() {
        //selecting departure day
        mainPage.getDatesForOrigin(departureDay);

    }
    @Test(priority = 4,description = "select date for using return day value")
   // @Story("select date for return day")
    //@Description("click calendar area for return day and select true value")
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
        mainPage.selectFlightWithProvider(provider);

    }
    @Test(priority = 8)
    public void selectReturnFlight()  {
        //select return flight list element
        mainPage.selectReturnFlight();

    }
    @Test(priority = 9)
    public void clickSelectButton()  {
        //clicking select button
        mainPage.clickSelectButton();

    }
}
