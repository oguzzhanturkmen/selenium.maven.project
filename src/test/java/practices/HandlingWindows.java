package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class HandlingWindows {
    public static void main(String[] args) throws InterruptedException {
        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        //Navigate to page
        driver.get("https://www.amazon.com/");

        WebElement imgClickable = driver.findElement(By.cssSelector("img[alt='Health & Personal Care']"));
        action.moveToElement(imgClickable).keyDown(Keys.CONTROL).click().build().perform();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        String parentWindow = iterator.next();
        String childWindow = iterator.next();

         driver.switchTo().window(childWindow);
         Thread.sleep(3000);
         //driver.switchTo().defaultContent(); -->Not working in windows

    }
}
