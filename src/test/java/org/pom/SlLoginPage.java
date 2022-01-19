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
        driver.get("https://www.saucedemo.com/");
    }

    private void getUsernames(){
        givenUsernameList = driver.findElements(By.id("login_credentials"));
    }
    private String getPassword(){
        givenPassword = driver.findElement(By.className("login_password")).getText();
        return givenPassword;
    }
    public SLInventoryPage Login(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();

        return new SLInventoryPage(driver);
    }
    public void StandardUserLogin(){
        Login(givenUsernameList.get(0).toString(), givenPassword);
    }
    public void LockedOutUserLogin(){
        Login(givenUsernameList.get(1).toString(), givenPassword);
    }
    public void ProblemUserLogin(){
        Login(givenUsernameList.get(2).toString(), givenPassword);
    }
    public void PerformanceGlitchUserLogin(){
        Login(givenUsernameList.get(3).toString(), givenPassword);
    }
}
