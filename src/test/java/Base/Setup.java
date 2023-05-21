package Base;

import Utils.Utillls;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITest;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.time.Duration;

public class Setup {
    public WebDriver driver;
    @BeforeTest(groups = {"signup_smoke","login_smoke","Purchase"})
    public void setup(){
//        System.setProperty("webdriver.chrome.driver","./src/test/resources/chromedriver.exe");
////        ChromeOptions ops=new ChromeOptions();
////        ops.addArguments("--headed");
//        driver=new ChromeDriver(ops);
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterMethod(groups = {"signup_smoke","login_smoke","Purchase"})
    public void takeScreenshort(ITestResult result)throws IOException {
        if (ITestResult.FAILURE==result.getStatus()){
            try {
                Utillls util=new Utillls();
                util.takeScreenShort(driver);
            }
            catch (Exception exception){
                System.out.println(exception.toString());
            }
        }
    }

    @AfterTest(groups = {"signup_smoke","login_smoke","Purchase"})
    public void closeDriver(){
//        driver.close();
//        driver.quit();
    }
}