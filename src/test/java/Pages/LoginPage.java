package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
    @FindBy(linkText = "Signup / Login")
    WebElement btnlogin;
    @FindBy(name = "email")
    WebElement txtemail;
    @FindBy(name = "password")
    WebElement txtpassword;
    @FindBy(css = "[type='submit']")
    WebElement btnsubmit;
    @FindBy(linkText = "Logout")
    public
    WebElement btnlogout;
    @FindBy(xpath = "//b[normalize-space()='faruk']")
    WebElement compareusername;

    @FindBy(xpath = "//p[normalize-space()='Your email or password is incorrect!']")
    WebElement lblAuthoError;


    @FindBy(css = "[placeholder='Name']")
    WebElement txtnamereg;
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    WebElement txtemailreg;
    @FindBy(xpath = "//button[normalize-space()='Signup']")
    WebElement btnsinupsubmit;


    @FindBy(id = "id_gender1")
    WebElement title;
    @FindBy(id = "password")
    WebElement passwoord;
    @FindBy(id = "days")
    WebElement dobdays;
    @FindBy(id = "months")
    WebElement dobmonths;
    @FindBy(id = "years")
    WebElement dobyears;

    @FindBy(id = "first_name")
    WebElement firstname;
    @FindBy(id = "last_name")
    WebElement lastname;
    @FindBy(id = "company")
    WebElement companyname;
    @FindBy(id = "address1")
    WebElement address;
    @FindBy(id = "address2")
    WebElement address2;
    @FindBy(id = "country")
    WebElement countryname;
    @FindBy(id = "state")
    WebElement statename;
    @FindBy(id = "city")
    WebElement cityname;
    @FindBy(id = "zipcode")
    WebElement zipcodee;
    @FindBy(id = "mobile_number")
    WebElement mobilenumber;
    @FindBy(css = "[type='submit']")
    WebElement submitbtn;
    @FindBy(linkText = "Continue")
    WebElement Continuebutton;

    //    List<WebElement> compareusername; for multiple value jonno
    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void doRegistation(String name,String email,String password) throws InterruptedException {
        btnlogin.click();
        txtnamereg.sendKeys(name);
        txtemailreg.sendKeys(email);
        btnsinupsubmit.click();

        Thread.sleep(5000);
        title.click();
        Thread.sleep(2000);
        passwoord.sendKeys(password);

        Thread.sleep(1000);
        Select date=new Select(dobdays);
        date.selectByValue("12");
        Thread.sleep(1000);
        Select month=new Select(dobmonths);
        month.selectByValue("11");
        Thread.sleep(1000);
        Select year=new Select(dobyears);
        year.selectByValue("1997");

        Thread.sleep(3000);
        firstname.sendKeys("Md");
        Thread.sleep(1000);
        lastname.sendKeys("Faruk");
        Thread.sleep(1000);
        companyname.sendKeys("Selise Bangladesh");
        Thread.sleep(1000);
        address.sendKeys("Dhanmondi-27, Dhaka, Bangladesh");
        Thread.sleep(1000);
        address2.sendKeys("Midas Center - 1209");

        Thread.sleep(3000);
        Select country=new Select(countryname);
        country.selectByValue("Australia");
        Thread.sleep(1000);
        statename.sendKeys("Dhaka");
        cityname.sendKeys("Dhanmondi");
        zipcodee.sendKeys("1209");
        mobilenumber.sendKeys("01628607988");

        Thread.sleep(1000);
        submitbtn.click();
        Thread.sleep(5000);
        Continuebutton.click();
        Thread.sleep(3000);
        btnlogout.click();
        Thread.sleep(2000);
    }

    public String doLogin(String email, String Password) throws InterruptedException {
        btnlogin.click();
//        txtemail.sendKeys("faruk15-9984@diu.edu.bd");
//        txtpassword.sendKeys("12345678");
        txtemail.sendKeys(email);
        txtpassword.sendKeys(Password);
        Thread.sleep(1000);
        btnsubmit.click();
//        btnlogout.isDisplayed();
        return compareusername.getText();
//        return compareusername.get(1).getText();

    }

    public String doLoginWithValidEmailandWrongPassword(String email, String Password) throws InterruptedException {
        btnlogin.click();
        txtemail.sendKeys(email);
        txtpassword.sendKeys(Password);
        Thread.sleep(1000);
        btnsubmit.click();
        return lblAuthoError.getText();
    }
    public String doLoginWithInvalidEmailandValidPassword(String email, String Password) throws InterruptedException {
        Thread.sleep(2000);
        btnlogin.click();
        txtemail.sendKeys(email);
        txtpassword.sendKeys(Password);
        Thread.sleep(1000);
        btnsubmit.click();
        return lblAuthoError.getText();
    }


    public String doLogin1(String email, String Password) throws InterruptedException {
        btnlogin.click();
        txtemail.sendKeys(email);
        txtpassword.sendKeys(Password);
        Thread.sleep(1000);
        btnsubmit.click();
        return compareusername.getText();
    }

}