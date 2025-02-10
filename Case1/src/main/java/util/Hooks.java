package util;


import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import java.util.Properties;

public class Hooks {

    WebDriver driver;
    Properties properties;
    @Before
    public void before() {
        String browser = "chrome";
        properties = ConfigReader.initialize_Properties();
        driver = DriverFactory.initialize_Driver(browser);
        if (driver == null) {
            throw new RuntimeException("Driver initialization failed! WebDriver instance is null.");
        }
    }

    @BeforeStep
    public void beforeStep() {

    }

    @AfterStep
    public void afterStep() {
    }

    @After
    public void after() {
        driver.close();
        driver.quit();

    }
}
