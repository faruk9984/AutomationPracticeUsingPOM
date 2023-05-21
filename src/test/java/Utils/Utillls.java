package Utils;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utillls {
//    WebDriver driver;
//
//    public Utillls(WebDriver driver){
//        this.driver=driver;
//        PageFactory.initElements(driver,this);
//    }

    String fileName="./src/test/resources/customer.json";
    public String email;
    public String password;
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public void saveData(String name,String email, String password) throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(new FileReader(fileName));
        JSONObject customerObj=new JSONObject();

        customerObj.put("name",name);
        customerObj.put("email",email);
        customerObj.put("password",password);

        JSONArray jsonArray=(JSONArray) obj;
        jsonArray.add(customerObj);

        FileWriter file=new FileWriter(fileName);
        file.write(jsonArray.toJSONString());
        file.flush();
        file.close();
//        cerate jsonarray and save the name,email,password data.
    }

    public void readData(int pos) throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray=(JSONArray) obj;
        JSONObject customerObj=(JSONObject) jsonArray.get(pos);

        String email=(String) customerObj.get("email");
        String password=(String) customerObj.get("password");

        setEmail(email);
        setPassword(password);
    }

    public int getLatestUser() throws IOException, ParseException {
        JSONParser jsonParser=new JSONParser();
        Object obj=jsonParser.parse(new FileReader(fileName));
        JSONArray jsonArray=(JSONArray) obj;
        return jsonArray.size();
    }

    public static int genarateRandomId(int max, int min){
        int id=(int)(Math.random()*(max-min)+min);
        return id;
    }

    public void takeScreenShort(WebDriver driver) throws IOException {
        File screenshortaFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String time=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss-aa").format(new Date());
        String fileWithFath="./src/test/resources/screenshort" + time + ".png";
        File DestFile=new File(fileWithFath);
        FileUtils.copyFile(screenshortaFile,DestFile);
    }

}