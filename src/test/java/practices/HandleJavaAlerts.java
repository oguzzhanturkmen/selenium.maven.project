package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class HandleJavaAlerts {
    public static void main(String[] args) throws InterruptedException {
        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //Navigate to page
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        //Alert
        driver.findElement(By.id("alertbtn")).click();
        Thread.sleep(3000);
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

    }
}
