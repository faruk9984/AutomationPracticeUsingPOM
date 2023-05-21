package TestRunner;

import Base.Setup;
import Pages.LoginPage;
import Utils.Utillls;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupTestRunner extends Setup {
    @Test(priority = 1, groups = "signup_smoke")
    public void userRegistation() throws InterruptedException, IOException, ParseException {
        driver.get("https://automationexercise.com/");
        LoginPage LoginPage=new LoginPage(driver);
//        Random random = new Random();
//        String email = "test" + random.nextInt(10000) + "@example.com";
//        int id=(int)(Math.random()*(1000-1)+1);
        int id= Utillls.genarateRandomId(1000,10);
        String name="faruk";
        String email="user"+id+"@test.com";
        String password="faruk"+id+"11";
        LoginPage.doRegistation(name, email, password);

        Utillls utills = new Utillls();
        utills.saveData(name,email,password);

    }

//    @Test(priority = 2)
//    public void userLogin() throws InterruptedException, IOException, ParseException {
//        Pages.LoginPage Loginpage=new Pages.LoginPage(driver);
//        driver.get("https://automationexercise.com/");
//        Utils.Utillls utills = new Utils.Utillls(driver);
////        utills.readData(3);
//        utills.readData(utills.getLatestUser()-1);
//        String name=Loginpage.doLogin(utills.getEmail(),utills.getPassword());
//        System.out.println(name);
////        Assert.assertEquals(name,"Md Faruk");
////        Assert.assertTrue(name.contains("Md Faruk"), String.valueOf(true));
//        Assert.assertTrue(Loginpage.btnlogout.isDisplayed(), String.valueOf(true));
//        Thread.sleep(5000);
//        Loginpage.btnlogout.click();
//    }

}
