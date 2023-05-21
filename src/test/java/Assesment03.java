import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Assesment03 {

    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions();
        ops.addArguments("--headed");
        driver=new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void getTitle1() throws InterruptedException {
        driver.get("https://automationtesting.co.uk/dropdown.html");
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        WebDriverWait elemwait = new WebDriverWait(driver,Duration.ofSeconds(30));
        elemwait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cars")));
        Select choose=new Select(driver.findElement(By.id("cars")));
        choose.selectByValue("honda");

    }
    @After
    public void closeDriver(){
//        driver.close();
//       driver.quit();
    }
}
