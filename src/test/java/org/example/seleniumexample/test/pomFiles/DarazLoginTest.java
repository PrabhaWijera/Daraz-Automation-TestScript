package org.example.seleniumexample.test.pomFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class DarazLoginTest {
    public static void main(String[] args) {


        WebDriver driver = new ChromeDriver();
        driver.get("https://www.daraz.lk/#?");

        // Initialize WebDriverWait with a maximum wait time of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait for and click on the login button
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='anonLogin']")));
        loginButton.click();

        //wait for modal

        WebElement loginmodal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='index_module_loginFromWrapper__deb6dcb9']")));
        WebElement loginmodalTabTelNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='index_module_loginType__ff031001 index_module_actived__ff031001']")));
        loginmodalTabTelNumber.click();
        // Wait for the submit tel number

        WebElement inputTelNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //input[@placeholder='කරුණාකර ඔබගේ දුරකථන අංකය ඇතුලත් කරන්න']")));
        inputTelNumber.sendKeys("+760368019");

        //clickt eh send button get otp

        WebElement submitTelNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='iweb-button-mask']")));

        submitTelNumber.click();

        WebElement otpmodal = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='index_module_verifyOTPWrapperContent__ff4df96a']")));



        WebElement inputOtpNo1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //div[contains(@class,'iweb-passcode-input-cell-container')]//div[1]")));
        inputOtpNo1.sendKeys("2");

        WebElement inputOtpNo2 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'iweb-passcode-input-cell-container')]//div[2]")));
        inputOtpNo2.sendKeys("8");


        WebElement inputOtpNo3 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'iweb-passcode-input-cell-container')]//div[3]")));
        inputOtpNo3.sendKeys("1");


        WebElement inputOtpNo4 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //div[contains(@class,'iweb-passcode-input-cell-container')]//div[4]")));
        inputOtpNo4.sendKeys("7");


        WebElement inputOtpNo5 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(" //div[contains(@class,'iweb-passcode-input-cell-container')]//div[5]")));
        inputOtpNo5.sendKeys("1");

        WebElement inputOtpNo6 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class,'iweb-passcode-input-cell-container')]//div[6]")));
        inputOtpNo6.sendKeys("7");

        // Wait for the account link to become visible (indicating successful login)
        WebElement accountLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='myAccountTrigger']")));

        // Verify if the account link is displayed to confirm login success
        if (accountLink.isDisplayed()) {
            System.out.println("Login Test Passed!");
        } else {
            System.out.println("Login Test Failed!");
        }

        // Quit the driver after the test is done

    }
}
