package org.example.pages;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By cartItemName = By.className("inventory_item_name");
    private By checkoutButton = By.id("checkout");

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public String getCartItemName() {
        return driver.findElement(cartItemName).getText();
    }

    public void clickCheckout() {
        waitUtils.jsClick(checkoutButton);
    }
}