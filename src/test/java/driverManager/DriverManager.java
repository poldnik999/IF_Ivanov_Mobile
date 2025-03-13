package driverManager;

import config.ConfigLoader;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.net.URL;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    protected AndroidDriver driver;
    private static ConfigLoader prop = new ConfigLoader();

    @BeforeEach
    protected void setUp() throws Exception {
        UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();

        uiAutomator2Options.setCapability("platformName",   prop.getProperty("platform.name"));
        uiAutomator2Options.setCapability("deviceName",     prop.getProperty("device.name"));
        uiAutomator2Options.setCapability("automationName", prop.getProperty("automation.name"));
        uiAutomator2Options.setCapability("appPackage",     prop.getProperty("app.package"));
        uiAutomator2Options.setCapability("appActivity",    prop.getProperty("app.activity"));

        driver = new AndroidDriver(new URL(prop.getProperty("appium.url")), uiAutomator2Options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterEach
    protected void tearDown() {
        driver.quit();
    }
}
