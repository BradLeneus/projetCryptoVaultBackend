package com.example.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.Key;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class InteractWalletTest {
    private final WebDriver driver = new FirefoxDriver();


    @BeforeEach

    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "./data/geckodriver.exe");



    }

    @Test
    public void testAddAndRemoveCrypto(){

        driver.get("http://localhost/login");

        WebElement username = driver.findElement(By.id("firstname"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));

        username.sendKeys("sam");
        password.sendKeys("brad");
        loginButton.click();

        driver.get("http://localhost/Wallet");
        WebElement buttonSwap = driver.findElement(By.id("changeDisplay"));
        buttonSwap.click();
        WebElement buttonAdd = driver.findElement(By.id("1"));
        WebElement buttonAdd2 = driver.findElement(By.id("2"));

        WebElement qty = driver.findElement(By.id("input1"));
        WebElement qty2 = driver.findElement(By.id("input2"));

        qty.sendKeys("1");
        qty2.sendKeys("-2");

        buttonAdd.click();
        buttonAdd2.click();

        buttonSwap.click();

        WebElement qtyBtc = driver.findElement(By.id("qty1"));
        WebElement qtyEth = driver.findElement(By.id("qty2"));

        assertEquals("2.0000", qtyBtc.getText());
        assertEquals("8.0000", qtyEth.getText());


    }


}