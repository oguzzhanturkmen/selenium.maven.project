package smartBear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

import static org.example.LoginPageTest.login;

public class OrderTest_05 {
    public static void main(String[] args) throws InterruptedException {
        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        //Login and navigate to order page
        login(driver , "Tester" , "test");
        Thread.sleep(1000);
        driver.findElement(By.linkText("Order")).click();

        //Find elements on the page
        WebElement productBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct"));
        WebElement quantityBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity"));
        WebElement pricePerUnitBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtUnitPrice"));
        WebElement discountBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtDiscount"));
        WebElement totalBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal"));
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));

        WebElement customerNameBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName"));
        WebElement streetBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2"));
        WebElement cityBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3"));
        WebElement stateBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4"));
        WebElement zipBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5"));

        WebElement visaRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
        WebElement masterCardRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
        WebElement americanExpressRadioButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));
        WebElement cardNumberBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6"));
        WebElement expireDateBox = driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1"));
        WebElement processButton = driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton"));
        WebElement resetButton = driver.findElement(By.xpath("//input[@value='Reset']"));

        //LogOut
        driver.findElement(By.id("ctl00_logout")).click();
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        System.out.println("Test passed");


    }
}
