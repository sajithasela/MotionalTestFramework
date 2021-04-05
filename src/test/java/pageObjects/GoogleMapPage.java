package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.FileReaders.DataTypeConvertor;
import java.util.concurrent.TimeUnit;

public class GoogleMapPage {

    WebDriver driver;
    static Logger log = Logger.getLogger(GoogleMapPage.class.getName());

    public GoogleMapPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "searchboxinput")
    WebElement To;

    @FindBy(xpath="//input[@placeholder='Choose starting point, or click on the map...']")
    WebElement From;

    @FindBy(xpath="//button[@jsaction='pane.placeActions.directions']")
    WebElement Directions;

    @FindBy(xpath="//img[@data-tooltip='Driving']")
    WebElement DrivingMode;

    public void setDestination(String myDestinetion){
        To.sendKeys(myDestinetion);
        To.sendKeys(Keys.ENTER);
    }

    public void setStartingPoint(String from){
        From.sendKeys(from);
    }

    public void ClickOnTravalMode(){
        DrivingMode.click();
    }

    public void ClickOnDirections(){
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        Directions.click();
    }

    /* Get FastestRoute

           Logic : Read and get the first values from the search result set, then
                   looking for the keyword "Fastest route" or "Best route" which time lessthan 20 min
     */

    public Boolean getFastestRouteOption(int time){
        String routeDetails = "";
        int i=0;
        Boolean assertion = false;

            //Get Time Details
            String timeXpath = "//div[@id='section-directions-trip-" + i + "']//span[contains(., 'min')]";
            String rawTime = driver.findElement(By.xpath(timeXpath)).getText();
            int travalTime =  DataTypeConvertor.getTimeinMinutes(rawTime);
            log.info("Time Details :" + rawTime);

            //Get Traffic Details
            String trafficXpath = "//div[@id='section-directions-trip-" + i + "']//span[@class='renderable-component-text renderable-component-text-not-line']";
            String trafficDetails = driver.findElement(By.xpath(trafficXpath)).getText();
            log.info("Route Details :" + trafficDetails);

            // Get Route Details
            String routeXpath = "//h1[@id='section-directions-trip-title-" + i + "" + "']";
            routeDetails = driver.findElement(By.xpath(routeXpath)).getText();
            log.info("Traffic Details :" + routeDetails);


            /*Fastest route option shown takes less than 20 minutes
                trafficDetails.contains("Fastest route") || trafficDetails.contains("Best route") < Based on the investigation always rerun
                First record as the Fastest route. */
            if (travalTime < time && trafficDetails.contains("Fastest route") || trafficDetails.contains("Best route")) {
                assertion=true;
            }

        log.info("assertion Value :" + assertion);
        return assertion;
    }

}
