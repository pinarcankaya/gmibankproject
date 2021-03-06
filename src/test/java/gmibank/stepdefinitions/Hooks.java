package gmibank.stepdefinitions;

import gmibank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    protected RequestSpecification spec01;

    @Before
    public void setup01() {
        // Spec for API
        spec01 = new RequestSpecBuilder().
                setBaseUri("https://**************").
                build();
    }

    @After
    public void tearDown(Scenario scenario) {
        final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
        if (scenario.isFailed()) {
            scenario.embed(screenshot, "image/png");
        }
//        Driver.closeDriver();
    }


}
