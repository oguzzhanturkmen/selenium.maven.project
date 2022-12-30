package practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class FlightBookingPage {
    public static void main(String[] args) {
        //Set-up
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oguzz\\workspace\\selenium.project\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //Navigate to page
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        //Find web elements in the page
        WebElement fromBox = driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT"));
        WebElement toBox = driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT"));
        WebElement departDateBox = driver.findElement(By.id("ctl00_mainContent_view_date1"));
        WebElement returnDateBox = driver.findElement(By.id("ctl00_mainContent_view_date2"));
        WebElement passengersBox = driver.findElement(By.id("divpaxinfo"));
        WebElement currencyBox = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        WebElement searchButton = driver.findElement(By.id("ctl00_mainContent_btn_FindFlights"));
        WebElement oneWayRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0"));
        WebElement roundTripRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1"));
        WebElement multicityRadioButton = driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_2"));
        WebElement autoSuggestionBox = driver.findElement(By.id("autosuggest"));

        //Select "USD" in currency menu
        Select select = new Select(currencyBox);
        select.selectByVisibleText("USD");

        //Add 4 adults from passengers box
        passengersBox.click();
        WebElement incrementAdultButton = driver.findElement(By.id("hrefIncAdt"));
        for (int i = 0; i < 3; i++) {
            incrementAdultButton.click();
        }

        //Fill the "from" and "to" boxes
        fromBox.click();
        driver.findElement(By.xpath("//a[@value='BLR']")).click();
        driver.findElement(By.xpath("(//a[@value='MAA'])[2]")).click();

        //Write "ind" in autosuggestive box and collect the suggestions
        autoSuggestionBox.sendKeys("ind");
        List<WebElement> suggestionElements = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));
        for (WebElement element : suggestionElements) {
            System.out.println(element.getText());
            if (element.getText().equals("India")) {
                element.click();
            }
        }

        //Click if a checkbox appears named "student"
        List<WebElement> checkBoxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement element : checkBoxes) {
            if (element.getAttribute("id").contains("Student")) {
                element.click();
            }
        }

        //Select current day on calendar
        departDateBox.click();
        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        //Check if returnDate box enabled when roundTripButton selected
        roundTripRadioButton.click();
        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")){
            Assert.assertTrue(true);
            System.out.println("ReturnDate Enabled");

        }
        else{
            Assert.assertTrue(false,"ReturnDate disabled");
        }


    }
}
