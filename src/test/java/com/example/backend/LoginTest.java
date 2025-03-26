package com.example.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private WebDriver driver = new FirefoxDriver();


    @BeforeEach

    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "./data/geckodriver.exe");
        


    }
    @Test
    public void testLoginForm(){
        driver.get("http://localhost/login");

        WebElement username = driver.findElement(By.id("firstname"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));

        username.sendKeys("sam");
        password.sendKeys("brad");
        loginButton.click();

        String loginOk = "http://localhost/Wallet/1";
        assertEquals(driver.getCurrentUrl(), loginOk);
    }
}