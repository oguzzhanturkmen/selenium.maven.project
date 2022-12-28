package org.example;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class LoginPageTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

        /*
        1)Go to URL
        2)Enter the right username and wrong password
        3)Click login
        -->Expected result : "Invalid login or password"
        -Username = Tester
        -Password = test123
         */
        //Test_01
        login(driver , "Tester" , "test123");
        String message = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(message , "Invalid Login or Password.");
        System.out.println("Test_01 PASSED");
        Thread.sleep(1000);

        /*
        1)Go to URL
        2)Enter the wrong username and right password
        3)Click login
        -->Expected result : "Invalid login or password"
        -Username = Tester123
        -Password = test
         */
        //Test_02
        login(driver , "Tester123" , "test");
        message = driver.findElement(By.id("ctl00_MainContent_status")).getText();
        Assert.assertEquals(message , "Invalid Login or Password.");
        System.out.println("Test_02 PASSED");
        Thread.sleep(1000);

        /*
        1)Go to URL
        2)Enter the right username and right password
        3)Click login
        -->Expected result : Title = "Web Orders"
        -Username = Tester
        -Password = test
         */
        //Test_03
        login(driver , "Tester" , "test");
        Thread.sleep(2000);
        message = driver.getTitle();
        Assert.assertEquals(message , "Web Orders");
        System.out.println("Test_03 PASSED");
        Thread.sleep(2000);
        driver.quit();

        System.out.println("All tests are passed");

    }
    public static void login(WebDriver driver , String username , String password){
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete12%2fWebOrders%2fDefault.aspx");
        WebElement loginUserBox = driver.findElement(By.id("ctl00_MainContent_username"));
        WebElement passwordBox = driver.findElement(By.id("ctl00_MainContent_password"));
        WebElement submitButton = driver.findElement(By.id("ctl00_MainContent_login_button"));
        loginUserBox.sendKeys(username);
        passwordBox.sendKeys(password);
        submitButton.click();


    }
}
