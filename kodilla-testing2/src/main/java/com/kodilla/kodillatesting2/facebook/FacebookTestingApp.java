package com.kodilla.kodillatesting2.facebook;


import com.kodilla.kodillatesting2.config.WebDriverConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class FacebookTestingApp {
    public static void main(String[] args) {
        WebDriver driver = WebDriverConfig.getDriver(WebDriverConfig.CHROME);
        driver.get("https://www.facebook.com/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

//        // Akceptuj cookies (jeśli pojawią się)
//        WebElement acceptCookies = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class, 'x1lliihq') and @role='button']")));
//        acceptCookies.click();
//
//        WebElement closeCookiesSettings = wait.until(ExpectedConditions.elementToBeClickable(
//                By.xpath("//div[contains(@class, 'xjqpnuy') and @aria-label='Zamknij']")));
//                closeCookiesSettings.click();

        // nowe konto
        WebElement createAccountBtn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//a[contains(text(),'Utwórz nowe konto')]")));
        createAccountBtn.click();

        // formularz
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("birthday_day")));

        // dzień
        Select daySelect = new Select(driver.findElement(By.name("birthday_day")));
        daySelect.selectByVisibleText("17");

        // miesiąc
        Select monthSelect = new Select(driver.findElement(By.name("birthday_month")));
        monthSelect.selectByVisibleText("cze");

        // rok
        Select yearSelect = new Select(driver.findElement(By.name("birthday_year")));
        yearSelect.selectByVisibleText("1995");
    }
    }

