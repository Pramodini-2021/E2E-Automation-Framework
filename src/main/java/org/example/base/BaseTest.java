package org.example.base;

import org.example.utils.ConfigReader;
import org.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver(ConfigReader.get("browser"));
        driver.get(ConfigReader.get("url"));
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}