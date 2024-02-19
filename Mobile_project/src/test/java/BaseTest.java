import io.appium.java_client.android.AndroidDriver;
import org.example.SetupDriver;

import java.net.MalformedURLException;

public class BaseTest {
    protected AndroidDriver driver = SetupDriver.setUp();
    protected CalculationMethods calculationMethods = new CalculationMethods();

    public BaseTest() throws MalformedURLException, InterruptedException {
    }
}
