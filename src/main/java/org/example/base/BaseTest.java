package org.example.base;

import org.example.utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.initDriver("chrome");
        driver.get("https://www.saucedemo.com");
    }

    @AfterMethod
    public void tearDown() {
        DriverFactory.quitDriver();
    }
}