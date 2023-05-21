package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Utils.Utillls;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;

public class LoginTestRunner extends Setup {
    @Test(priority = 2, groups = "login_smoke")
    public void userLogin() throws InterruptedException, IOException, ParseException {
        LoginPage Loginpage=new LoginPage(driver);
        driver.get("https://automationexercise.com/");
        Utillls utills = new Utillls();
//        utills.readData(3);
        utills.readData(utills.getLatestUser()-1);
        String name=Loginpage.doLogin(utills.getEmail(),utills.getPassword());
        System.out.println(name);
//        Assert.assertEquals(name,"Md Faruk");
//        Assert.assertTrue(name.contains("Md Faruk"), String.valueOf(true));
        Assert.assertTrue(Loginpage.btnlogout.isDisplayed(), String.valueOf(true));
        Thread.sleep(5000);
        Loginpage.btnlogout.click();
        Allure.description("user can login successfully");
    }


    @Test(priority = 3,enabled = false)
    public void invalidUserLogin1() throws IOException, ParseException, InterruptedException {
        driver.get("https://automationexercise.com/");
        LoginPage Loginpage=new LoginPage(driver);
        String name=Loginpage.doLoginWithValidEmailandWrongPassword("faruk15-9984@diu.edu.bd","123456");
        System.out.println(name);
        Assert.assertTrue(name.contains("Your email or password is incorrect!"));
    }
    @Test(priority = 4,enabled = false)
    public void invalidUserLogin2() throws IOException, ParseException, InterruptedException {
//        driver.get("https://automationexercise.com/");
        LoginPage Loginpage=new LoginPage(driver);
        String name=Loginpage.doLoginWithInvalidEmailandValidPassword("faruk9984@diu.edu.bd","12345678");
        System.out.println(name);
        Assert.assertTrue(name.contains("Your email or password is incorrect!"));
//        Assert.assertTrue(name.contains("hijibiji"));
    }

    @Test(priority = 5,enabled = false)
    public void userLogin1() throws InterruptedException, IOException, ParseException {
        driver.get("https://automationexercise.com/");
        LoginPage Loginpage=new LoginPage(driver);
        String name=Loginpage.doLogin1("faruk15-9984@diu.edu.bd","12345678");
        System.out.println(name);
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(name.contains("Md Faruk8"), String.valueOf(true));
        softAssert.assertTrue(Loginpage.btnlogout.isDisplayed(), String.valueOf(true));
        softAssert.assertAll();
//        Thread.sleep(5000);
//        Loginpage.btnlogout.click();
    }
}