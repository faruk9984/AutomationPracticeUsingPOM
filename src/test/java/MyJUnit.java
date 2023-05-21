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

public class MyJUnit {
    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
        ChromeOptions ops=new ChromeOptions();
        ops.addArguments("--headed");
        driver=new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void getTitle(){
        driver.get("https://demoqa.com/");
        String title=driver.getTitle();
        System.out.println(title);
        Assert.assertEquals("ToolsQA",title);
    }
    @Test
    public void checkIfImageExists(){
        driver.get("https://demoqa.com/");
//        WebElement image1=driver.findElement(By.cssSelector("img"));
//        Assert.assertTrue(String.valueOf(image1.isDisplayed()),true);
        WebElement image2=driver.findElement(By.xpath("//header/a[1]/img[1]"));
        Assert.assertTrue(String.valueOf(image2.isDisplayed()),true);

    }
    @After
    public void closeDriver(){
        driver.close();
//        driver.quit();
    }
}
