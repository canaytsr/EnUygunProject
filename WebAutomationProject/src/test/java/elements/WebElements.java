package elements;

import lombok.Data;
import org.openqa.selenium.By;
@Data
public class WebElements {//Finding all web elements

    private By cookie = By.xpath("//*[@id='CookieAlert']/button");
    private By flightOriginSearch = By.id("OriginInput");
    private By flightDestinationSearch = By.id("DestinationInput");
    private By originFirstElement = By.id("react-autowhatever-OriginInput-section-0-item-0");
    private By destinationFirstElement = By.id("react-autowhatever-DestinationInput-section-0-item-0");
    private By originDates = By.xpath("//*[@aria-disabled= 'false']");
    private By destinationDates = By.xpath("//*[@aria-disabled= 'false']");
    private By originCalender = By.id("DepartureDate");
    private By destinationCalender = By.id("ReturnDate");
    private By oneWay = By.id("oneWayCheckbox");
    private By transferBox = By.id("transitFilter");
    private By traveler = By.xpath("//*[@class='default-btn block passenger-select-button']");
    private By adultPlus = By.xpath("//*[@data-testid='passengerCountIncrease-0']");
    private By adultMinus = By.xpath("//*[@data-testid='passengerCountDecrease-0']");
    private By childPlus = By.xpath("//*[@data-testid='passengerCountIncrease-1']");
    private By childMinus = By.xpath("//*[@data-testid='passengerCountDecrease-1']");
    private By babyPlus = By.xpath("//*[@data-testid='passengerCountIncrease-2']");
    private By babyMinus = By.xpath("//*[@data-testid='passengerCountDecrease-2']");
    private By oldPlus = By.xpath("//*[@data-testid='passengerCountIncrease-3']");
    private By oldMinus = By.xpath("//*[@data-testid='passengerCountDecrease-3']");
    private By studentPlus = By.xpath("//*[@data-testid='passengerCountIncrease-4']");
    private By studentMinus = By.xpath("//*[@data-testid='passengerCountDecrease-4']");
    private By buttonOk = By.xpath("//*[@data-testid='okButtonMulti']");
    private By otelBox = By.xpath("//*/ul[@role='listbox']/li");
    private By economy = By.xpath("//*[@data-testid='cabinClassButton-0']");
    private By premium = By.xpath("//*[@data-testid='cabinClassButton-1']");
    private By business = By.xpath("//*[@data-testid='cabinClassButton-2']");
    private By button = By.xpath("//*[@class='primary-btn block']");
    private By selectDepartureFlightList = By.xpath("//*[@class='roundTrip departure']");
    private By selectReturnFlightList = By.xpath("//*[@class='roundTrip return']");
    private By select = By.xpath("//*[@class='roundTrip return active']");
    private By radioButtonReturn = By.xpath("//*[@class='roundTrip return active']//div[2]//div[1]//*[@class='flight-summary-radio']");
    private By selectButton = By.id("tooltipTarget_0");
}
