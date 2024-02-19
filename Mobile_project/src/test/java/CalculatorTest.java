import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import java.net.MalformedURLException;

public class CalculatorTest extends BaseTest {

    public CalculatorTest() throws MalformedURLException, InterruptedException {
    }
    @Test
    public void testCal() throws Exception {

        Assertions.assertEquals(calculationMethods.sum(), "6");
        Assertions.assertEquals(calculationMethods.subtraction(), "4");
        Assertions.assertEquals(calculationMethods.multiplication(), "32");
        Assertions.assertEquals(calculationMethods.division(), "2");
    }

}