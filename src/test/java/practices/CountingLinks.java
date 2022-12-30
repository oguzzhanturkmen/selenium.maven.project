package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CountingLinks {
    public static void main(String[] args) {
        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        Actions action = new Actions(driver);

        //Navigate to page
        driver.get("https://jqueryui.com/droppable/");

        System.out.println(driver.findElements(By.tagName("a")).size());
        List<WebElement> links = driver.findElements(By.tagName("a"));

        for (int i = 0; i < links.size(); i++) {
            action.moveToElement(links.get(i)).keyDown(Keys.CONTROL).click().build().perform();
        }
        Set<String > windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();
        for (int i = 0; i < windows.size(); i++) {
            driver.switchTo().window(iterator.next());
            System.out.println(driver.getTitle());
        }

    }
}
