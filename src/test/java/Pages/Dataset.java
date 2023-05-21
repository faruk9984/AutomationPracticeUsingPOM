package Pages;

import org.testng.annotations.DataProvider;

public class Dataset {
    @DataProvider(name = "data-provider")
    public Object[][] setData(){
        return new Object[][] {
                {10,10,20},
                {6,8,14},
                {9,6,15},
        };
    }
}
