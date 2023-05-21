package TestRunner;

import Base.Setup;
import Pages.PurchaseProductPage;
import io.qameta.allure.Allure;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.io.IOException;

public class ProductPruchaseTestRunner extends Setup {
    @Test(priority = 5, groups = "Purchase")
    public void searchProduct() throws InterruptedException, IOException, ParseException {
        driver.get("https://automationexercise.com/");
        PurchaseProductPage PurchaseProductPage=new PurchaseProductPage(driver);
        PurchaseProductPage.doLogin();
        PurchaseProductPage.searchProduct();
        Allure.description("user can search products");
    }
}
