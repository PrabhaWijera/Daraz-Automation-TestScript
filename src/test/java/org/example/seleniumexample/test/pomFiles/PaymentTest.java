package org.example.seleniumexample.test.pomFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class PaymentTest {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver"); // Update with the path to chromedriver

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.daraz.pk/cart");

        // Proceed to checkout
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='checkout-button']")));
        checkoutButton.click();

        // Wait for checkout page to load
        WebElement paymentMethod = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@value='card']")));
        paymentMethod.click();

        // Enter payment details
        WebElement cardNumberField = driver.findElement(By.id("card-number"));
        cardNumberField.sendKeys("4111111111111111");

        WebElement expiryDateField = driver.findElement(By.id("expiry-date"));
        expiryDateField.sendKeys("12/25");

        WebElement cvvField = driver.findElement(By.id("cvv"));
        cvvField.sendKeys("123");

        // Submit the payment
        WebElement submitPaymentButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitPaymentButton.click();

        // Verify payment success
        WebElement confirmationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".confirmation-message")));
        if (confirmationMessage.isDisplayed()) {
            System.out.println("Payment Test Passed!");
        } else {
            System.out.println("Payment Test Failed!");
        }

        driver.quit();
    }
}
