package org.example.pages;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By firstNameField = By.id("first-name");
    private By lastNameField = By.id("last-name");
    private By postalCodeField = By.id("postal-code");
    private By continueButton = By.id("continue");
    private By finishButton = By.id("finish");
    private By confirmationMessage = By.className("complete-header");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public void enterShippingInfo(String firstName, String lastName, String postalCode) {
        waitUtils.waitForVisibility(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(postalCodeField).sendKeys(postalCode);
    }

    public void clickContinue() {
        waitUtils.jsClick(continueButton);
    }

    public void clickFinish() {
        waitUtils.jsClick(finishButton);
    }

    public String getConfirmationMessage() {
        return waitUtils.waitForVisibility(confirmationMessage).getText();
    }
}