package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HandlingFrames {
    public static void main(String[] args) {


        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        driver.get("https://jqueryui.com/droppable/");

        WebElement iFrame = driver.findElement(By.cssSelector("iframe.demo-frame"));
        driver.switchTo().frame(iFrame);
        driver.findElement(By.id("draggable")).click();
        Actions action = new Actions(driver);
        WebElement sourceElement = driver.findElement(By.id("draggable"));
        WebElement targetElement = driver.findElement(By.id("droppable"));
        action.dragAndDrop(sourceElement,targetElement).build().perform();

    }
}
