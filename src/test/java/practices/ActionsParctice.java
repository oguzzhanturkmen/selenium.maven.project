package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class ActionsParctice {
    public static void main(String[] args) throws InterruptedException {
        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        //Navigate to page
        driver.get("https://www.amazon.com/");

        //Move to element with mouse
        WebElement menuBox = driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(menuBox).build().perform();
        Thread.sleep(3000);

        //Search with holding "shift"
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        action.moveToElement(searchBox).click().keyDown(Keys.SHIFT).sendKeys("oguz").build().perform();
    }
}
