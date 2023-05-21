import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class SikubaTest01 {
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
    public void sikubalogin() throws InterruptedException {
        driver.get("http://sikuba.seliselocal.com/login");
        driver.findElement(By.id("inputLogin")).sendKeys("shugu@yopmail.com");
        List<WebElement>eleent=driver.findElements(By.tagName("input"));
        eleent.get(1).sendKeys("1qazZAQ!");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(),'Login')]")).click();
//        List<WebElement>eleent1=driver.findElements(By.tagName("span"));
//        eleent1.get(7).click();

        driver.findElement(By.xpath("//span[contains(text(),'Add Customer')]")).click();

        driver.findElement(By.cssSelector("[type=button]")).sendKeys("C:/Users/Md Faruk/Desktop/Sikuba/Directory/1.png");
        WebElement firstname=driver.findElement(By.cssSelector("[placeholder='First Name']"));
        firstname.sendKeys("Selise");
        WebElement lastname=driver.findElement(By.cssSelector("[placeholder='Last Name']"));
        lastname.sendKeys("Bangladesh");


    }


    @After
    public void closeDriver(){
        driver.close();
//        driver.quit();
    }
}
