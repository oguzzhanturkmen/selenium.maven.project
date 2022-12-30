package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class GreenKartPage {
    public static void main(String[] args) {
        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));

        //Products to be added to the card for checking
        String[] productNames = {"Tomato", "Potato", "Apple", "Mango"};
        List productNameList = Arrays.asList(productNames);

        //Navigate to page
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

        //Collect Product Name Elements
        List<WebElement> productNameElements = driver.findElements(By.cssSelector("h4.product-name"));
        List<String> formattedNames = new ArrayList<>();
        for (WebElement element:productNameElements) {
            String[] arr = element.getText().split("-");
            String str = arr[0].trim();
            formattedNames.add(str);
        }

        //Collect AddToCard Buttons
        List<WebElement> addToCardButtonElements = driver.findElements(By.cssSelector("div[class='product-action'] button"));

        //Click AddToCard Button if the name is in the list
        int counter = 0;
        for(int i = 0; i < formattedNames.size(); i++) {
            if(productNameList.contains(formattedNames.get(i))){
                addToCardButtonElements.get(i).click();
                counter++;
            }
            if(counter == productNameList.size()){
                break;
            }
        }

        //Proceeding to checkout
        WebElement addToCardButton = driver.findElement(By.cssSelector("img[alt='Cart']"));
        addToCardButton.click();
        WebElement proceedButton = driver.findElement(By.cssSelector("div[class='action-block'] button"));
        proceedButton.click();

        //
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
        driver.findElement(By.cssSelector("button.promoBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

       /* Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                if(driver.findElement(By.cssSelector("[id='finish'] h4")).isDisplayed()){
                    return driver.findElement(By.cssSelector("[id='finish'] h4"));
                }
                else {
                    return null;
                }
            }
        });
        */



    }
}
