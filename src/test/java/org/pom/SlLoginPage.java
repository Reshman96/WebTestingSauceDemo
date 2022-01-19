package org.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.pom.inventoryPage.SLInventoryPage;

import java.util.List;

public class SlLoginPage extends Page{
    WebDriver driver;
    By username;
    By password;
    By loginButton;
    String[] givenUsernameList;
    String givenPassword;

    public SlLoginPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        driver.get("https://www.saucedemo.com/");
    }

    private String[] getGivenUsernameList() {
        String listofUsernames = driver.findElement(By.id("login_credentials")).getText();
        givenUsernameList = listofUsernames.split("\n");
        return givenUsernameList;
    }
    private String getPassword(){
        givenPassword = driver.findElement(By.className("login_password")).getText();
        givenPassword = givenPassword.split("\n")[1];
        return givenPassword;
    }
    public SLInventoryPage Login(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login-button")).click();
        return new SLInventoryPage(driver);
    }
    public SLInventoryPage StandardUserLogin(){
        return Login(getGivenUsernameList()[1], getPassword());
    }

    public SLInventoryPage LockedOutUserLogin(){
        return Login(getGivenUsernameList()[2], getPassword());
    }

    public SLInventoryPage ProblemUserLogin(){
        return Login(getGivenUsernameList()[3], getPassword());
    }

    public SLInventoryPage PerformanceGlitchUserLogin(){
        return Login(getGivenUsernameList()[4], getPassword());
    }

}
