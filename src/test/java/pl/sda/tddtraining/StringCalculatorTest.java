package pl.sda.tddtraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.IllegalFormatException;

import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
    @Test
    void shouldReturnZeroOnEmptyString(){
        String testString = "";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldReturnInputStringAsInt() {
        String testString = "2";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(2, result);
    }

    @Test
    void shouldReturnZeroOnBlank() {
        String testString = " ";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldReturnNumberOnWhiteSpace() {
        String testString = "1 ";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(1, result);
    }

    @Test
    void shouldReturnZeroOnNull() {
        String testString = null;
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(0, result);
    }

    @Test
    void shouldReturnSumOnTw0Numbers() {
        String testString = "1,2";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(3, result);
    }

    @Test
    void shouldReturnNumberWhenOneNumberIsMissing() {
        String testString = "1,";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(1, result);
    }
//2.
    @Test
    void shouldReturnSumOnAllNumbers() {
        String testString = "1,2, 4";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(7, result);
    }
//3.
    @Test
    void shouldReturnSumOnAllNumbersWithNewLinesAsSeparator() {
        String testString = "1,2, 4\n 1,2";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(10, result);
    }
//4.
    @Test
    void shouldReturnSumOnAllNumbersWithDifferentDelimiters() {
        String testString = "//;\n1;2";
        int result = StringCalculator.adding(testString);
        Assertions.assertEquals(3, result);
    }
//5.
    @Test(expected = IllegalFormatException.class)
    void shouldThrowAnIllegalArgumentException() {
        String testString = "-2, 1";
        StringCalculator.adding(testString);
    }
}