package lesson_12_junit_5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FactorialTest {
    private Factorial factorial;
    @DisplayName("Вычисление факториала")
    @ParameterizedTest
   @CsvSource({"1,-1", "1,0", "1,1", "120,5"})

    @BeforeEach
    void setUp(){
     factorial = new Factorial();
    }
    @Test
    void getFactorialWithPositiveNumber(){
       long result = Factorial.getFactorial(5);
        Assertions.assertEquals(120,result);
    }
    @Test
    void getFactorialWithZero(){
       long result = Factorial.getFactorial(0);
        Assertions.assertEquals(1,result);
    }
   @Test
    void getFactorialNegativNumber(){
        Assertions.assertThrows(IllegalArgumentException.class, () ->Factorial.getFactorial(-4));

    }
}
