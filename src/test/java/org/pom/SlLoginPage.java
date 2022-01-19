package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SlLoginPage extends Page{
    WebDriver driver;
    By username;
    By password;
    By loginButton;
    List<WebElement> givenUsernameList;
    String givenPassword;

    public SlLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
    }

    private void getUsernames(){
        givenUsernameList = driver.findElements(By.id("login_credentials"));
    }
    private String getPassword(){
        givenPassword = driver.findElement(By.className("login_password")).getText();
        return givenPassword;
    }
    private SLInventoryPage Login(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        return new SLInventoryPage(driver);
    }




}
