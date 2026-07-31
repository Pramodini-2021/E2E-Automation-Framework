package org.example.pages;

import org.example.utils.WaitUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    private WebDriver driver;
    private WaitUtils waitUtils;

    private By pageTitle = By.className("title");
    private By addToCartBackpack = By.id("add-to-cart-sauce-labs-backpack");
    private By shoppingCartIcon = By.className("shopping_cart_link");
    private By shoppingCartBadge = By.className("shopping_cart_badge");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
        this.waitUtils = new WaitUtils(driver);
    }

    public boolean isPageDisplayed() {
        return waitUtils.waitForVisibility(pageTitle).isDisplayed();
    }

    public void addBackpackToCart() {
        waitUtils.waitForClickable(addToCartBackpack).click();
    }

    public void goToCart() {
        waitUtils.jsClick(shoppingCartIcon);
    }

    public String getCartItemCount() {
        return waitUtils.waitForVisibility(shoppingCartBadge).getText();
    }
}