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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.List;

public class WriteText {
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
    public void writetextbox(){
        driver.get("https://demoqa.com/text-box");
//        driver.findElement(By.id("userName")).sendKeys("Md Faruk");
//        WebElement txtUsername=driver.findElement(By.id("userName"));
//        WebElement txtUsername=driver.findElement(By.cssSelector("[type=text]"));
//        WebElement txtUsername=driver.findElement(By.cssSelector("[placeholder='Full Name']"));
//        WebElement txtUsername=driver.findElement(By.tagName("input"));
//        txtUsername.sendKeys("Md Faruk 500");
//        WebElement email=driver.findElement(By.id("userEmail"));
//        email.sendKeys("faruk420@yopmail.com");

//        List<WebElement> elements=driver.findElements(By.tagName("input"));
//        elements.get(0).sendKeys("Selise Digital Platfrom");
//        elements.get(1).sendKeys("selise@yopmail.com");

        WebElement txtUsername=driver.findElement(By.id("userName"));
        txtUsername.sendKeys(" Md Faruk 500");
        WebElement email=driver.findElement(By.id("userEmail"));
        email.sendKeys("faruk420@yopmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys(" Dhanmondi 27, Midas Center");
        driver.findElement(By.id("permanentAddress")).sendKeys(" Dhaka-1209, Bangladesh");
        WebElement submit1=driver.findElement(By.id("submit"));
        submit1.click();

//        WebElement txtUsername1=driver.findElement(By.id("userName"));
//        txtUsername1.sendKeys(" Md Faruk 500");
//        WebElement email1=driver.findElement(By.id("userEmail"));
//        email1.sendKeys("faruk420@yopmail.com");
//        Actions actions=new Actions(driver);
//        WebElement submit2=driver.findElement(By.id("submit"));
//        actions.moveToElement(submit2).click().perform();


    }

    @Test
    public void buttonclick(){
        driver.get("https://demoqa.com/buttons");
        List<WebElement> buttons= driver.findElements(By.tagName("button"));
        buttons.get(3).click();
        Actions action=new Actions(driver);
        action.doubleClick(buttons.get(1)).perform();
        action.contextClick(buttons.get(2)).perform();

        String doubleclickmessage=driver.findElement(By.id("doubleClickMessage")).getText();
        String rightclickmessage=driver.findElement(By.id("rightClickMessage")).getText();
        String clickmessage=driver.findElement(By.id("dynamicClickMessage")).getText();

        Assert.assertTrue(doubleclickmessage.contains("You have done a double click"));
        Assert.assertTrue(rightclickmessage.contains("You have done a right click"));
        Assert.assertTrue(clickmessage.contains("You have done a dynamic click"));

    }

    @Test
    public void DragAndDrop() {
        driver.get("https://demoqa.com/droppable/");
        WebElement drag=driver.findElement(By.id("draggable"));
        WebElement drop=driver.findElement(By.id("droppable"));
        Actions action=new Actions(driver);
        action.dragAndDrop(drag,drop).perform();
    }

    @Test
    public void EscButton() throws InterruptedException {
        driver.get("https://demoqa.com/droppable/");
        WebElement drag=driver.findElement(By.id("draggable"));
        Thread.sleep(1000);
        WebElement drop=driver.findElement(By.id("droppable"));
        Thread.sleep(1000);
        Actions action=new Actions(driver);
        action.dragAndDrop(drag,drop).perform();
//        action.sendKeys("\uE00C").perform();
        action.sendKeys(Keys.ESCAPE);

    }

    @Test
    public void selectDate1() throws InterruptedException {
        driver.get("https://demoqa.com/date-picker");
        WebElement cle1 = driver.findElement(By.id("datePickerMonthYearInput"));
        cle1.sendKeys(Keys.CONTROL + "a");
        cle1.sendKeys(Keys.DELETE);
        cle1.sendKeys("04/29/2050");
        cle1.sendKeys(Keys.ENTER);

        Thread.sleep(2000);

        WebElement cle2 = driver.findElement(By.id("dateAndTimePickerInput"));
        cle2.sendKeys(Keys.CONTROL + "a");
        cle2.sendKeys(Keys.DELETE);
        cle2.sendKeys("November 19, 2000 18:45 AM");
        cle2.sendKeys(Keys.ENTER);
    }

    @After
    public void closeDriver(){
//        driver.close();
//        driver.quit();
    }
}
