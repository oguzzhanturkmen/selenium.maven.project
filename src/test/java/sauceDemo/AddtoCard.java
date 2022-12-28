package sauceDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class AddtoCard {
    public static void main(String[] args) throws InterruptedException {

        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();


        //Navigate to url and login
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);

        WebElement userNameBox = driver.findElement(By.id("user-name"));
        WebElement passwordBox = driver.findElement(By.id("password"));
        WebElement loginButton = driver.findElement(By.id("login-button"));

        userNameBox.sendKeys("standard_user");
        passwordBox.sendKeys("secret_sauce");
        loginButton.click();


        //Collect product names in "ProductNames list"
        List<WebElement> productList = driver.findElements(By.id("//div[@class='inventory_item_name']"));
        ArrayList<String> productNames = new ArrayList<>();
        for (WebElement element: productList) {
            productNames.add(element.getText());
        }


        //Add all products to the card
        List<WebElement> buttonLink = driver.findElements(By.xpath("//button[text()='Add to cart']"));
        for (WebElement button: buttonLink) {
            button.click();
        }


        //Navigate to shoppingCard page
        WebElement shoppingCard = driver.findElement(By.id("shopping_cart_container"));
        shoppingCard.click();


        //Collect product names from addToCard page in "shoppingProductNames" list
        List<WebElement> shoppingProducts = driver.findElements(By.xpath("//div[@class=\"inventory_item_name\"]"));
        ArrayList<String> shoppingProductNames = new ArrayList<>();
        for (WebElement element: shoppingProducts) {
            shoppingProductNames.add(element.getText());
        }
        Assert.assertEquals(checkProducts( productNames , shoppingProductNames ), true);
        System.out.println("Test Passed!");


        driver.quit();

    }


    //Check each name lists
    private static boolean checkProducts(ArrayList<String> productNames, ArrayList<String> shoppingProductNames) {

        for (String name: productNames) {
            if(!shoppingProductNames.contains(name)){
                return false;
            }
        }
        return true;
    }


}
