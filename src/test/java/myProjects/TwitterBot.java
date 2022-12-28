package myProjects;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class TwitterBot {
    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        //Go  to twitter login page
        driver.get("https://twitter.com/i/flow/login?input_flow_data=%7B%22requested_variant%22%3A%22eyJsYW5nIjoidHIifQ%3D%3D%22%7D");
        Thread.sleep(3000);
        //Login
        WebElement loginBox = driver.findElement(By.xpath("//input[@name='text']"));
        loginBox.sendKeys("Atlanta1A");
        driver.findElement(By.xpath("//*[@id='layers']/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div/div/div/div[6]")).click();
        Thread.sleep(3000);
        driver.manage().window().maximize();

        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("asdasd123");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='layers']/div/div/div/div/div/div/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div[1]/div/div/div")).click();
        Thread.sleep(3000);

        //Find account
        driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/div/div/form/div[1]/div/div/div/label/div[2]/div/input")).sendKeys("elonmusk");
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div[2]/div/div[2]/div/div/div/div[1]/div/div/div/form/div[1]/div/div/div/label/div[2]/div/input")).sendKeys(Keys.ENTER);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div[1]/div/div[1]/div[1]/div[2]/nav/div/div[2]/div/div[3]/a/div/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='react-root']/div/div/div[2]/main/div/div/div/div[1]/div/div[3]/div/section/div/div/div[1]/div/div/div/div/div[2]/div[1]/div[1]/div/div[1]/a/div/div[1]/span/span")).click();
        Thread.sleep(3000);

        //Collect tweets
        List<WebElement> list = new ArrayList<>();
        LinkedHashSet<WebElement> set = new LinkedHashSet<>();
        LinkedHashSet<String> strSet = new LinkedHashSet<>();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        File file = new File("tweets1.txt");
        PrintWriter output = new PrintWriter(file);
        int x = 0;
        for (int i = 0; i < 300; i++) {
            System.out.println(i);

            try {
                set.addAll(driver.findElements(By.xpath("//div[@data-testid='tweetText']")));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (WebElement element : set
            ) {
                strSet.add(element.getText());
                x++;
            }
            set.clear();
            js.executeScript("window.scrollBy(0,document.body.scrollHeight / 2.4)");
            Thread.sleep(5000);
        }
        System.out.println(x);
        int y = 0;
        for (String s : strSet
        ) {

            output.println(y + "--)" + s);
            y++;
        }
        System.out.println(y);
    }

}









