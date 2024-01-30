package lesson_12_testng;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FactorialTest {
    @DataProvider(name = "positivNumbers")
    public Object[][] positivNumbers() {
        return new Object[][]{
                {5, 120},
                {1, 1},
                {10, 3628800},
                {0, 1}
        };
    }

    @Test(description = "Проверка на положительное число", priority = 1, dataProvider = "positivNumbers")
    void getFactorialWithPositiveNumber(long n, long expected) {
        long result = Factorial.getFactorial(n);
        Assert.assertEquals(result, expected, "Factorial of " + n + " should be " + expected);
    }

    @Test(description = "Проверка на 0", priority = 2, dataProvider = "positivNumbers")
    void getFactorialWithZero(long n, long expected) {
        long result = Factorial.getFactorial(n);
        Assert.assertEquals(result, expected);
    }

    @DataProvider(name = "invalidNumbers")
    public Object[][] invalidNumbers() {
        return new Object[][]{
                {-1},
                {-5},
                {-10}
        };
    }

    @Test(description = "Проверка на отрицательное число", priority = 3, dataProvider = "invalidNumbers",
            expectedExceptions = IllegalArgumentException.class, expectedExceptionsMessageRegExp = "Факториал отрицательного числа не существует")
    void getFactorialNegativNumber(long n) {
        Factorial.getFactorial(n);
    }
}