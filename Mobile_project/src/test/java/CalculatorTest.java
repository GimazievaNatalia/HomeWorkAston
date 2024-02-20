import io.qameta.allure.Owner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.*;
import java.net.MalformedURLException;

public class CalculatorTest extends BaseTest {

    public CalculatorTest() throws MalformedURLException, InterruptedException {
    }
    @Step
    @Owner(value = "Gimazieva Natalia")
    @DisplayName("проверка функций калькулятора")
    @Test
    public void testCal() {

        Assertions.assertEquals(calculationMethods.sum(), "6");
        Assertions.assertEquals(calculationMethods.subtraction(), "4");
        Assertions.assertEquals(calculationMethods.multiplication(), "32");
        Assertions.assertEquals(calculationMethods.division(), "2");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}