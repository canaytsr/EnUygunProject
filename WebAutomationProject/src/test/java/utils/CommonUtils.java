package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.TestException;
import java.time.Duration;
import java.util.List;
public class CommonUtils {
    WebDriver driver;
    WebDriverWait wait;
    public CommonUtils(WebDriver driver) {
        this.driver=driver;
        this.wait=new WebDriverWait(this.driver, Duration.ofSeconds(10));

    }

    public WebElement findElement(By elementName) {//find and return element by using element By value
        wait.until(ExpectedConditions.elementToBeClickable(elementName));
        return driver.findElement(elementName);
    }

    public List<WebElement> findElements(By elementName) {//find and return elements by using element By value
        wait.until(ExpectedConditions.visibilityOfElementLocated(elementName));
        return driver.findElements(elementName);
    }

    public void click(By elementName) {//click element by using element By value
        WebElement element = findElement(elementName);
        waitForElementToBeClickable(elementName);
        try {
            element.click();
        } catch (Exception e) {
            throw new TestException(String.format("The following element is not clickable: [%s]", elementName));
        }
    }

    public void sendKeys(By elementName, String value) {//find and assign elements by using element By value
        WebElement element = findElement(elementName);
        clearField(element);
        try {
            element.sendKeys(value);
        } catch (Exception e) {
            throw new TestException(String.format("Error in sending [%s] to the following element: [%s]", value, elementName.toString()));
        }
    }

    public void clearField(WebElement element) {//clear element text field by using element By value
        try {
            element.clear();
            waitForElementTextToBeEmpty(element);
        } catch (Exception e) {
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }
    }

    public void waitForElementTextToBeEmpty(WebElement element) {//control the text area empty or not
        String text;
        try {
            text = element.getText();
            int maxRetries = 10;
            int retry = 0;
            while ((text.length() >= 1) || (retry < maxRetries)) {
                retry++;
                text = element.getText();
            }
        } catch (Exception e) {
            System.out.print(String.format("The following element could not be cleared: [%s]", element.getText()));
        }

    }

   public void waitForElementToBeClickable(By elementName) {//Controlling the element is visible or not by using By value
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(50));
            wait.until(ExpectedConditions.elementToBeClickable(elementName));
        } catch (Exception e) {
            throw new TestException("The following element is not clickable: " + elementName);
        }
    }


}