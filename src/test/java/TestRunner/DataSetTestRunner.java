package TestRunner;

import Pages.Dataset;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DataSetTestRunner {
    @Test(dataProvider = "data-provider", dataProviderClass = Dataset.class)
    public void RunTest(int a, int b, int sum){
        Assert.assertEquals(a+b,sum);
    }
}
