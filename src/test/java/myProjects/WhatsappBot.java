package myProjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class WhatsappBot {
    public static void main(String[] args) throws InterruptedException {

        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        driver.get("https://web.whatsapp.com/");

        Thread.sleep(20000);

        driver.findElement(By.xpath("//*[@id=\"pane-side\"]/div[1]/div/div/div[1]/div/div/div/div[2]/div[1]/div[1]/span")).click();
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p")).sendKeys("DENEME\n");

        for (int i = 0; i < 10000; i++) {
            driver.findElement(By.xpath("//*[@id=\"main\"]/footer/div[1]/div/span[2]/div/div[2]/div[1]/div/div[1]/p")).sendKeys("DENEME\n");

        }

    }
}
