package smartBear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

import static org.example.LoginPageTest.login;

public class OrderTest_02 {
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

        //Enter numbers as customer name, fill other boxes correctly --> Expected result : "Customer name can not include numbers message"
        Thread.sleep(3000);
        resetButton.click();
        quantityBox.clear();
        quantityBox.sendKeys("100");
        discountBox.clear();
        discountBox.sendKeys("20");
        calculateButton.click();

        customerNameBox.sendKeys("12334234234");
        streetBox.sendKeys("1119");
        cityBox.sendKeys("İstanbul");
        zipBox.sendKeys("3400");

        masterCardRadioButton.click();
        cardNumberBox.sendKeys("1234456132145648");
        expireDateBox.sendKeys("04/30");
        processButton.click();
        Thread.sleep(1000);

        String text = driver.findElement(By.xpath("//*[@id='ctl00_MainContent_fmwOrder']/tbody/tr/td/div/strong")).getText();
        System.out.println("--------CASE_04-------");
        if (text.equalsIgnoreCase("New order has been successfully added.")){
            System.out.println("Test failed, username cant include numbers ---FAILED");
        }
        else {
            System.out.println("Test passed");
        }
        System.out.println();




    }
}
