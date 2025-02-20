package org.example.seleniumexample.test.pomFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PickItemsAddToCartTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // Update with the path to chromedriver

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.daraz.pk");

        // Search for a product
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("smartphone");
        searchBox.submit();

        // Wait for results to load
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".item:first-child")));
        firstProduct.click();

        // Wait for product page to load
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='add-to-cart-button']")));
        addToCartButton.click();

        // Verify item added to cart
        WebElement cartIcon = driver.findElement(By.xpath("//a[@href='/cart']"));
        cartIcon.click();

        WebElement cartItem = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-item")));
        if (cartItem.isDisplayed()) {
            System.out.println("Item Added to Cart Test Passed!");
        } else {
            System.out.println("Item Added to Cart Test Failed!");
        }

        driver.quit();
    }
}
