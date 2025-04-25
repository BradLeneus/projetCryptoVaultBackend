package com.example.backend;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginTest {
    private final WebDriver driver = new FirefoxDriver();


    @BeforeEach

    public void setUp(){
        System.setProperty("webdriver.gecko.driver", "./data/geckodriver.exe");



    }

    @Test
    public void testSignUpAndFromLoginToWallet(){
        driver.get("http://localhost/SignUp");
        String usernameToSend = "totqw";
        String passwordToSend = "tata";
        WebElement username = driver.findElement(By.id("firstname"));
        WebElement password = driver.findElement(By.id("lastname"));
        WebElement email = driver.findElement(By.id("email"));
        WebElement signUpBtn = driver.findElement(By.id("btnSignUp"));

        username.sendKeys(usernameToSend);
        password.sendKeys(passwordToSend);
        email.sendKeys("sasd@gmail.nz");
        signUpBtn.click();

        String SignUpOk = "http://localhost/Login";
        assertEquals(SignUpOk, driver.getCurrentUrl());
        testLoginForm();
    }

    public void testLoginForm() {
        driver.get("http://localhost/login");

        WebElement username = driver.findElement(By.id("firstname"));
        WebElement password = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("btnLogin"));

        username.sendKeys("totqw");
        password.sendKeys("tata");
        loginButton.click();

        String loginOk = "http://localhost/Wallet";
        String current = driver.getCurrentUrl();
        assertEquals(loginOk, current);
    }
}