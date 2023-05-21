import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class Assessment04 {

    WebDriver driver;
    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","./src/test/resources/geckodriver.exe");
        FirefoxOptions ops=new FirefoxOptions();
        ops.addArguments("--headed");
        driver=new FirefoxDriver(ops);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test
    public void getTitle1() throws InterruptedException {
 /*
        using get() to open a webpage
        driver.get("https://demoqa.com/text-box");
 */

 /*
        get the title of the webpage
        driver.get("https://demoqa.com/text-box");
        String title=driver.getTitle();
        System.out.println(title);
 */

 /*     Find an element by xpath and click it
        driver.get("https://demoqa.com/buttons");
        driver.findElement(By.xpath("//button[normalize-space()='Click Me']")).click();
 */

 /*
        click a button using Selenium.
        driver.get("https://www.google.com/");
        driver.findElement(By.name("q")).sendKeys("Selenium");
        Thread.sleep(1000);
        driver.findElement(By.name("btnK")).click();
 */

 /*     Selenium clear method
        driver.get("https://www.google.com/");
        WebElement clear1=driver.findElement(By.name("q"));
        clear1.sendKeys("Selenium");
        Thread.sleep(1000);
        clear1.clear();
 */

 /*      isDisplayed() method in Selenium
        driver.get("https://www.google.com/");
        WebElement element=driver.findElement(By.name("q"));
        boolean isDisplayed=element.isDisplayed();
        System.out.println("the elementt is: "+ isDisplayed);
 */

 /*      getAttribute() method in Selenium
        driver.get("https://demoqa.com/text-box");
        WebElement element=driver.findElement(By.id("userName"));
        String name=element.getAttribute("id");
        System.out.println("Element name: " +name);
 */

/*      submit() in selenium
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("123456");
        driver.findElement(By.name("login")).submit();
*/

/*        getCssValue() in selenium
        driver.get("https://testkru.com/Elements/Buttons");
        WebElement element=driver.findElement(By.id("leftClickButtonLabel"));
        System.out.println("Value of font-weight css property: "+ element.getCssValue("font-weight"));
        System.out.println("Value of font-weight css property: "+ element.getCssValue("color"));
*/

/*      isEnabled() in selenium
        driver.get("http://www.gmail.com");
        Boolean Display = driver.findElement(By.id("identifierId")).isEnabled();
        System.out.println("the elementt is: "+ Display);
*/

        driver.get("https://www.google.com/");
        WebElement searchBox = driver. findElement(By.name("q"));
        System.out.println("Size of the box is: " + searchBox.getSize());


    }
    @After
    public void closeDriver(){
//        driver.close();
//       driver.quit();
    }
}
