package smartBear;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

import static org.example.LoginPageTest.login;

public class ListOfAllOrdersTest {
    public static void main(String[] args) throws InterruptedException {

        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();

        //Login
        login(driver , "Tester" , "test");
        Thread.sleep(1000);

        /*CheckBoxTest
        -Click checkboxes and check if they are working.
         */
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl06_OrderSelector")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl08_OrderSelector")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl09_OrderSelector")).click();
        Thread.sleep(1000);
        System.out.println("Checkboxes checked");

        //Click "check all" button and check whether all boxes are ticked
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        Thread.sleep(1000);
        System.out.println("Clicked \"check all \" button.");

        //Click "uncheck all" button and check whether all boxes are empty
        driver.findElement(By.id("ctl00_MainContent_btnUncheckAll")).click();
        Thread.sleep(1000);
        System.out.println("Clicked \"uncheck all \" button.");

        //Check two boxes and click delete button to delete them.
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl02_OrderSelector")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_orderGrid_ctl06_OrderSelector")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$btnDelete']")).click();
        Thread.sleep(1000);
        System.out.println("Checked boxes and clicked delete button");

        /*Click edit button and change the name
          Check whether name is changed or not.*/
        driver.findElement(By.xpath("//input[@alt='Edit']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).clear();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Oguzhan Türkmen");
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_UpdateButton")).click();
        Thread.sleep(1000);
        String name = driver.findElement(By.xpath("//table[@class='SampleTable']/tbody/tr[2]/td[2]")).getText();
        Assert.assertEquals(name , "Oguzhan Türkmen");
        System.out.println("Name changed successfully");

        //Check all boxes and delete all records
        driver.findElement(By.id("ctl00_MainContent_btnCheckAll")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$btnDelete']")).click();
        Thread.sleep(1000);
        System.out.println("Clicked delete button to delete all items");

        //Log out from system
        driver.findElement(By.id("ctl00_logout")).click();
        Thread.sleep(1000);
        Assert.assertEquals(driver.getTitle(),"Web Orders Login");
        System.out.println("Logged out sucessfully");
        Thread.sleep(3000);

        driver.quit();
    }
}
