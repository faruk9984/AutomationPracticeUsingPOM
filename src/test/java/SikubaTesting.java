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

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class SikubaTesting {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        ChromeOptions ops=new ChromeOptions();
        ops.addArguments("--headed");
//        ops.addArguments("--headless");
        driver=new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @Test
    public void getTitle() throws InterruptedException {
        driver.get("http://misterloo.seliselocal.com/login");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("Welcome to MisterLoo",title);
        WebElement username=driver.findElement(By.xpath("//*[@id=\"mat-input-0\"]"));
        WebElement password=driver.findElement(By.xpath("//*[@id=\"mat-input-1\"]"));
        WebElement login=driver.findElement(By.xpath("//*[@id=\"login-form\"]/div[1]/form/button/span"));
        username.sendKeys("admin@selise.ch");
        password.sendKeys("1qazZAQ!");
        login.click();
        Thread.sleep(8000);


    }
    @After
    public void closeDriver(){
        driver.close();
//        driver.quit();
    }
}
