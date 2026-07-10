package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;

    // Locators
    private By cartItemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }
}
