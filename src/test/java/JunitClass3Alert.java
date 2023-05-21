import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class JunitClass3Alert {
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
    public void alertHandle() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("alertButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

    }

    @Test
    public void alertHandleWait() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("timerAlertButton")).click();
        Thread.sleep(7000);
        driver.switchTo().alert().accept();

    }

    @Test
    public void dialogBox() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("confirmButton")).click();
        Thread.sleep(1000);
//        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void promptHandle() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        driver.findElement(By.id("promtButton")).click();
        Thread.sleep((1000));
        driver.switchTo().alert().sendKeys("selise digital platfrom");
//        driver.switchTo().alert().accept();
        driver.switchTo().alert().dismiss();
    }

    @Test
    public void selectDate() throws InterruptedException {
        driver.get("https://demoqa.com/date-picker");
        WebElement cle1=driver.findElement(By.id("datePickerMonthYearInput"));
        cle1.sendKeys(Keys.CONTROL + "a");
        cle1.sendKeys(Keys.DELETE);
        cle1.sendKeys("04/29/2050");
        cle1.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        WebElement cle2=driver.findElement(By.id("dateAndTimePickerInput"));
        cle2.sendKeys(Keys.CONTROL + "a");
        cle2.sendKeys(Keys.DELETE);
        cle2.sendKeys("November 19, 2000 18:45 AM");
        cle2.sendKeys(Keys.ENTER);



//        driver.findElement(By.id("datePickerMonthYearInput")).click();
//        driver.findElement(By.id("datePickerMonthYearInput")).clear();
//        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys("04/14/2022");
//        driver.findElement(By.id("datePickerMonthYearInput")).sendKeys(Keys.ENTER)
    }

    @Test
    public void selectDroupdown(){
        driver.get("https://demoqa.com/select-menu");
        Select choose=new Select(driver.findElement(By.id("oldSelectMenu")));
        choose.selectByValue("6");
//        choose.selectByIndex(5);

    }
    @Test
    public void selectMultipleValue(){
        driver.get("https://demoqa.com/select-menu");
        Select choose1=new Select(driver.findElement(By.id("cars")));
        if (choose1.isMultiple()){
            choose1.selectByValue("volvo");
            choose1.selectByValue("Audi");

        }
    }

    @Test
    public void handleMultipleTab() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("tabButton")).click();
        Thread.sleep(3000);

        ArrayList<String> w = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(w.get(1));
        System.out.println("Page title is : " + driver.getTitle());
//        String title=driver.getTitle();
//        System.out.println(title);
        String text=driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);
        Assert.assertEquals(text,"This is a sample page");
        driver.close();
        driver.switchTo().window(w.get(0));
    }

    @Test
    public void handleWindow() throws InterruptedException {
        driver.get("https://demoqa.com/browser-windows");
        driver.findElement(By.id("windowButton")).click();
        String mainwindow =driver.getWindowHandle();
        Set<String> allwindows =driver.getWindowHandles();
        Iterator<String> iterator=allwindows.iterator();

        while (iterator.hasNext()){
            String Childwindow=iterator.next();
            if (!mainwindow.equalsIgnoreCase(Childwindow)){
                driver.switchTo().window(Childwindow);
                String text=driver.findElement(By.id("sampleHeading")).getText();
                System.out.println(text);
                Assert.assertTrue(text.contains("This is a sample page"));
                Thread.sleep(2000);
                driver.close();
            }
        }
    }
    @Test
    public void modalDialog(){
        driver.get("https://demoqa.com/modal-dialogs");
//        WebElement text1=driver.findElement(By.id("showLargeModal"));
//        text1.click();
//        String text2=driver.findElement(By.tagName("p")).getText();
//        System.out.println(text2);
//        driver.findElement(By.id("closeLargeModal")).click();
        WebElement text1=driver.findElement(By.id("showSmallModal"));
        text1.click();
        String text2=driver.findElement(By.className("modal-body")).getText();
        System.out.println(text2);
        driver.findElement(By.id("closeSmallModal")).click();
    }
    @Test
    public void webTables() throws InterruptedException {
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.id("addNewRecordButton")).click();
        Thread.sleep(2000);
        driver.findElement(By.id("firstName")).sendKeys("Selise ");
        driver.findElement(By.id("lastName")).sendKeys("Bangla");
        driver.findElement(By.id("userEmail")).sendKeys("selise@yopmail.com");
        driver.findElement(By.id("age")).sendKeys("25");
        driver.findElement(By.id("salary")).sendKeys("35000");
        driver.findElement(By.id("department")).sendKeys("MDC");
        Thread.sleep(1000);
        driver.findElement(By.id("submit")).click();
        Thread.sleep(1000);

        WebElement table=driver.findElement(By.className("rt-tbody"));
        List<WebElement>allrows=table.findElements(By.className("rt-tr-group"));
        int i=0;
        for (WebElement row:allrows) {
            List<WebElement>cells=row.findElements(By.className("rt-td"));
            for (WebElement cell:cells){
                i++;
                System.out.println("num["+i+"] "+cell.getText());
            }
        }
    }

    @Test
    public void uploadeImage(){
        driver.get("https://demoqa.com/upload-download");
        driver.findElement(By.id("uploadFile")).sendKeys("C:\\Users\\Md Faruk\\Desktop\\Sikuba\\Directory\\1.png");
        String text4=driver.findElement(By.id("uploadedFilePath")).getText();
        Assert.assertTrue(text4.contains("1.png"));
    }

    @Test
    public void iFrames(){
        driver.get("https://demoqa.com/frames");
        driver.switchTo().frame("frame1");
        String t1=driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(t1);
        Assert.assertTrue(t1.contains("This is a sample page"));
        driver.switchTo().defaultContent();
    }


    @After
    public void closeDriver(){
//        driver.close();
//        driver.quit();
    }
}
