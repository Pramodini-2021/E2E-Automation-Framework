package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;

    // Locators
    private By pageTitle = By.className("title");
    private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By shoppingCartIcon = By.className("shopping_cart_link");
    private By shoppingCartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public boolean isPageDisplayed() {
        return driver.findElement(pageTitle).isDisplayed();
    }

    public void addBackpackToCart() {
        driver.findElement(addToCartBackpack).click();
    }

    public void goToCart() {
        driver.findElement(shoppingCartIcon).click();
    }

    public String getCartItemCount() {
        return driver.findElement(shoppingCartBadge).getText();
    }
}