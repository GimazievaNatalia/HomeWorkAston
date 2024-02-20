
import org.example.SetupDriver;
import org.openqa.selenium.By;

public class CalculationMethods extends SetupDriver {
    private final By button2 = By.id("com.google.android.calculator:id/digit_2");
    private final By button4 = By.id("com.google.android.calculator:id/digit_4");
    private final By buttonPlus = By.id("com.google.android.calculator:id/op_add");
    private final By buttonEquals = By.id("com.google.android.calculator:id/eq");
    private final By lblresult = By.id("com.google.android.calculator:id/result_final");
    private final By buttonMinus = By.id("com.google.android.calculator:id/op_sub");
    private final By buttonMultiplication = By.id("com.google.android.calculator:id/op_mul");
    private final By buttonDivision = By.id("com.google.android.calculator:id/op_div");
    private final By button8 = By.id("com.google.android.calculator:id/digit_8");

    public String sum() {

        driver.findElement(button2).click();
        driver.findElement(buttonPlus).click();
        driver.findElement(button4).click();
        driver.findElement(buttonEquals).click();
        String resultSum = driver.findElement(lblresult).getText();
        return resultSum;
    }

    public String subtraction() {
        driver.findElement(button8).click();
        driver.findElement(buttonMinus).click();
        driver.findElement(button4).click();
        driver.findElement(buttonEquals).click();
        String resultSubstraction = driver.findElement(lblresult).getText();
        return resultSubstraction;
    }

    public String multiplication() {
        driver.findElement(button4).click();
        driver.findElement(buttonMultiplication).click();
        driver.findElement(button8).click();
        driver.findElement(buttonEquals).click();
        String resultMultiplication = driver.findElement(lblresult).getText();
        return resultMultiplication;
    }

    public String division() {
        driver.findElement(button8).click();
        driver.findElement(buttonDivision).click();
        driver.findElement(button4).click();
        driver.findElement(buttonEquals).click();
        String resultDivision = driver.findElement(lblresult).getText();
        return resultDivision;
    }
}