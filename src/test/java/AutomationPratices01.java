import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class AutomationPratices01 {
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
    public void apb() throws InterruptedException {
        driver.get("https://cosmocode.io/automation-practice/");
        String a1=driver.findElement(By.xpath("//h1[contains(text(),'Automation Practice | Beginner')]")).getText();
        System.out.println("Name: "+ a1);

        driver.findElement(By.id("firstname")).sendKeys("Selise");
        driver.findElement(By.className("lastname")).sendKeys("Bangladesh");
        Thread.sleep(5000);
//        driver.findElement(By.xpath("//input[@value='Male']")).click();
        List<WebElement>radiobutton=driver.findElements(By.tagName("input"));
        radiobutton.get(3).click();

        Thread.sleep(1000);
        driver.findElement(By.name("language_java")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("language_vbs")).click();
        Thread.sleep(1000);
        driver.findElement(By.name("language_python")).click();
        Thread.sleep(1000);


        Select c1=new Select(driver.findElement(By.name("age")));
        c1.selectByValue("20 to 29");
        Thread.sleep(1000);
        driver.findElement(By.name("submit")).click();

    }

    @After
    public void closeDriver(){
//        driver.close();
//        driver.quit();
    }
}
