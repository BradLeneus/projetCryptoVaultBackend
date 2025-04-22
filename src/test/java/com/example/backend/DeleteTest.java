package com.example.backend;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.awt.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DeleteTest {
    private final WebDriver driver = new FirefoxDriver();


    @BeforeEach

    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "./data/geckodriver.exe");



    }

    @Test
    public void delete(){
        testLoginForm("boss", "123");
        driver.get("http://localhost/customersList");

        List<WebElement> deleteButton =  driver.findElements(By.className("btnDelete"));
        int numBfr = deleteButton.size();
        deleteButton.get(0).click();

        deleteButton =  driver.findElements(By.className("btnDelete"));
        int numAfter = deleteButton.size();

        assertTrue(numBfr > numAfter);


    }
    public void testLoginForm(String usernameParent, String passwordParent){
        driver.get("http://localhost/login");

        WebElement username = driver.findElement(By.id("firstname"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));

        username.sendKeys(usernameParent);
        password.sendKeys(passwordParent);
        loginButton.click();

        String loginOk = "http://localhost/customersList";
        assertEquals(loginOk, driver.getCurrentUrl());
    }


}
