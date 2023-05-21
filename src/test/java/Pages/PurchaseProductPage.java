package Pages;

import Pages.LoginPage;
import Utils.Utillls;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;

public class PurchaseProductPage {
    @FindBy(linkText = "Products")
    WebElement clicktext;
    @FindBy(id = "search_product")
    WebElement txtsearch;
    @FindBy(id = "submit_search")
    WebElement txtsearchsubmit;

    WebDriver driver;

    public PurchaseProductPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public void doLogin() throws InterruptedException, IOException, ParseException {
        LoginPage Loginpage=new LoginPage(driver);
        Utillls utills = new Utillls();
        utills.readData(utills.getLatestUser()-1);
        Loginpage.doLogin(utills.getEmail(),utills.getPassword());
    }

    public void searchProduct(){
        txtsearch.sendKeys("Dress");
        txtsearchsubmit.click();
    }

}
