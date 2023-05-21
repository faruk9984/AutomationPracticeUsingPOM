import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;


public class Junit4 {
    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver.exe");
        ChromeOptions ops = new ChromeOptions();
        ops.addArguments("--headed");
        driver = new ChromeDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    @Test
    public void mouseHober(){
        driver.get("https://green.edu.bd/");
        Actions actions=new Actions(driver);
        WebElement hover=driver.findElement(By.xpath("//header/nav[@id='primary-navbar']/div[1]/ul[1]/li[1]/a[1]"));
//        List<WebElement> hover1=driver.findElements(By.xpath("//header/nav[@id='primary-navbar']/div[1]/ul[1]/li[1]/a[1]"));
//        actions.moveToElement(hover1.get(2)).perform();
//        WebElement hover=driver.findElement(By.linkText("ABOUT US"));
        actions.moveToElement(hover).perform();

    }
    @Test
    public void keyboardEvent() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement searchElement=driver.findElement(By.name("q"));
        Actions actions=new Actions(driver);
//        actions.moveToElement(searchElement).perform();
//        actions.keyDown(Keys.SHIFT).perform();
//        actions.sendKeys("Selenium Webdriver");
//        actions.keyUp(Keys.SHIFT).perform();
//        actions.doubleClick(searchElement).perform();
//        actions.contextClick(searchElement).perform();


//        actions.moveToElement(searchElement)
//                .keyDown(Keys.SHIFT)
//                .sendKeys("Selenium Webdriver")
//                .keyUp(Keys.SHIFT)
//                .doubleClick(searchElement)
//                .contextClick(searchElement).perform();

        actions.moveToElement(searchElement).click().keyDown(Keys.SHIFT).sendKeys("Hello Selise").keyUp(Keys.SHIFT).doubleClick(searchElement).contextClick(searchElement).build().perform();

        Thread.sleep(5000);

    }
    @Test
    public void takeScreenShort() throws IOException {
        driver.get("https://demoqa.com/");
        File screenshortFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String filePath="./src/test/resources/screenshort/" + time + ".png";
        File DestFile=new File(filePath);
        FileUtils.copyFile(screenshortFile,DestFile);


    }


    @Test
    public void readExcelFile() throws IOException{
        String filePath = "./src/test/resources";
        Utils.readFromExcel(filePath,"Book2.xls","Sheet1");
    }



    @After
    public void closeDriver(){
//        driver.close();
//        driver.quit();
    }
}
