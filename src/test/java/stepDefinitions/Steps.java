package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.FileInputStream;
import java.io.IOException;
import pageObjects.GoogleMapPage;
import java.util.Properties;

public class Steps extends BaseClass {
    @Before
    public void setup() throws IOException {
        log = Logger.getLogger(Steps.class.getName());
        PropertyConfigurator.configure("log4j.properties");
        log.info("Test Message of log");
    }

    public WebDriver driver;
    GoogleMapPage googleMapPage;

    @Given("User open the browser")
    public void user_open_the_browser() throws IOException {
        configProp=new Properties();

        FileInputStream configPropfile=new FileInputStream("config.properties");
        configProp.load(configPropfile);

        System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath_mac"));
        driver = new ChromeDriver();
        googleMapPage = new GoogleMapPage(driver);
        log.info("User Open the browser...");
    }

    @Given("User navigate to Google map page")
    public void user_navigate_to_google_map_page() {
        driver.get(configProp.getProperty("url"));
        driver.manage().window().maximize();
        log.info("User Open the url from browser...");
    }


    @When("User enter destination point {string} and press enter button")
    public void user_enter_destination_point_and_press_enter_button(String mydestination) {
        googleMapPage.setDestination(mydestination);
        log.info("User key in destination...");
    }

    @When("User click on direction")
    public void user_click_on_direction() {
        googleMapPage.ClickOnDirections();
        log.info("User click direction...");
    }

    @When("User enter starting point {string} and press enter button")
    public void user_enter_starting_point_and_press_enter_button(String myStartingPoint) {
        googleMapPage.setStartingPoint(myStartingPoint);
        log.info("User key on starting point...");
    }

    @When("User click on travel mode {string}")
    public void user_click_on_travel_mode(String travelModeType) {
        googleMapPage.ClickOnTravalMode();
        log.info("User key on travel mode...");
    }

    @Then("User can see fastest route option shown takes less than {int} minutes")
    public void user_can_see_fastest_route_option_shown_takes_less_than_minutes(Integer min) {
        Boolean Actual =  googleMapPage.getFastestRouteOption(min);
        Assert.assertEquals(true,Actual);
        log.info("Verify the search results..");

    }


















}
