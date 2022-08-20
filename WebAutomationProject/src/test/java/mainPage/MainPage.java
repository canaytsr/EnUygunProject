package mainPage;

import elements.WebElements;
import model.FlightTicket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.CommonUtils;
import java.time.Duration;
import java.util.List;
public class MainPage {
    FlightTicket flightTicket;
    WebDriver driver;
    WebDriverWait wait;
    WebElements elements;
    CommonUtils utils;
    int count=0;
    public MainPage(WebDriver driver) {//making assignment
        this.driver = driver;
        flightTicket = new FlightTicket();
        elements = new WebElements();
        utils = new CommonUtils(this.driver);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        utils.click(elements.getCookie());

    }
    public void getListForOriginSearch(String origin) {
        //control element is clickable or not
        utils.click(elements.getFlightOriginSearch());
        //sending value to web element search area
        utils.sendKeys(elements.getFlightOriginSearch(), origin);
       //select first elements in the list
        utils.click(elements.getOriginFirstElement());

    }
    public void getListForDestinationSearch(String destination) {
        //control element is clickable or not
        utils.click(elements.getFlightDestinationSearch());
        //sending value to web element search area
        utils.sendKeys(elements.getFlightDestinationSearch(), destination);
        //control element is clickable or not
        utils.waitForElementToBeClickable(elements.getDestinationFirstElement());
        //select first elements in the list
        utils.click(elements.getDestinationFirstElement());
    }
    public void getDatesForOrigin(int departureDay) {
        //clicking origin area
        utils.click(elements.getOriginCalender());
        //control element is clickable or not
        utils.waitForElementToBeClickable(elements.getOriginDates());
        //assign the found elements to the list
        List<WebElement> origin_days = utils.findElements(elements.getOriginDates());
        //select element at departureDay index in the list
        origin_days.get(departureDay).click();

    }
    public void getDateForDestination(int returnDay) {
        //clicking destination area
        utils.click(elements.getDestinationCalender());
        //control element is clickable or not
        utils.waitForElementToBeClickable(elements.getDestinationDates());
        //assign the found elements to the list
        List<WebElement> destination_days = utils.findElements(elements.getDestinationDates());
        //select element at departureDay index in the list
        destination_days.get(returnDay).click();

    }
    public void clickCheckBox(boolean isDirect) {
        //controlling element is clickable or not
        utils.waitForElementToBeClickable(elements.getTransferBox());
        //if direct is true click the checkbox
        if (isDirect == true) {
            utils.click(elements.getTransferBox());
        }

    }
    public void clickButton() {
        //controlling element is clickable or not
        utils.waitForElementToBeClickable(elements.getButton());
        //click buy ticket button
        utils.click(elements.getButton());

    }
    public void selectFlightWithProvider(String provider) {
         //assign the found elements to the list
        List<WebElement> select_depture = utils.findElements(elements.getSelectDepartureFlightList());
        //Selecting the flight for the entered airport name
        for (int i=0;i<select_depture.size();i++){
            if(select_depture.get(i).getText().contains(provider)){
                count =i;
                select_depture.get(i).click();
                break;
            }
        }
    }
    public void selectReturnFlight(int limit) throws IndexOutOfBoundsException{
        //assign the found elements to the list
        List<WebElement> return_flight = utils.findElements(elements.getRadioButtonReturn());
        //finding and selecting which return flight in the same packet to select
        if(limit-1<=return_flight.size())
        {
            return_flight.get(limit-1).click();
        }
        else{
            System.out.println("Check limit value");
        }

    }
    public void clickSelectButton() {
         //controlling element is clickable or not
        utils.waitForElementToBeClickable(elements.getSelectButton());
        //clicking the button
        utils.click(elements.getSelectButton());

    }

}
