import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Project02 {

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
            driver.get("https://demoqa.com/automation-practice-form");
            String title=driver.findElement(By.xpath("//h5[normalize-space()='Student Registration Form']")).getText();
            System.out.println("title: "+title);

            driver.findElement(By.id("firstName")).sendKeys("Selise");
            driver.findElement(By.id("lastName")).sendKeys("Dhaka");
            Thread.sleep(1000);
            driver.findElement(By.id("userEmail")).sendKeys("faruk@yopmail.ccom");
            Thread.sleep(1000);

            driver.findElement(By.xpath("//label[normalize-space()='Female']")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("userNumber")).sendKeys("1625456598");
            Thread.sleep(1000);

            WebElement cle1=driver.findElement(By.id("dateOfBirthInput"));
            cle1.sendKeys(Keys.CONTROL + "a");
            cle1.sendKeys(Keys.SPACE);
            cle1.sendKeys("12 Nov 2022");
            cle1.sendKeys(Keys.ENTER);

            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#subjectsInput"))).sendKeys("English");
            Thread.sleep(3000);
            new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#subjectsInput"))).sendKeys("Computer Science");
            Thread.sleep(3000);


            driver.findElement(By.xpath("//label[normalize-space()='Sports']")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//label[normalize-space()='Music']")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("currentAddress")).sendKeys("Dhaka, Dhanmondhi-27, Midas Center");
            Thread.sleep(1000);

            WebElement pic=driver.findElement(By.id("uploadPicture"));
            File file =new File("pic1.jpg");
            System.out.println(file.getAbsolutePath());
            pic.sendKeys(file.getAbsolutePath());
            Thread.sleep(2000);


//            Select choose= new Select(driver.findElement(By.xpath("//div[contains(@class,'css-1wy0on6')]")));
//            choose.selectByValue("Uttar Pradesh");


        }

        @After
        public void closeDriver(){
//        driver.close();
//        driver.quit();
        }
    }


