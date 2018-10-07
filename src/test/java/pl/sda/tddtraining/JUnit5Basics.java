package pl.sda.tddtraining;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.sda.tddtraining.Calculator;

import java.util.ArrayList;
import java.util.List;

public class JUnit5Basics {
    private static Calculator calculator;

    @BeforeAll
    public static void testBeforeAll(){
        calculator = new Calculator();
    }

    @Test
    public void firstTest(){
        int num1 = 3;
        int num2 = 6;

        assert 9 == calculator.add(num1, num2);
    }

    @Test
    public void firstJUnitTest(){
        int num1 = 2;
        int num2 = 3;

        Assertions.assertEquals(5, calculator.add(num1, num2));

    }

    @Test
    void assertions() {
        List<String> legacyPeople = new ArrayList<String>();
        legacyPeople.add("Adam Nowak");
        legacyPeople.add("Jan Kowalski");

        ArrayList<String> people = Lists.newArrayList("Adam Nowak", "Jan Kowalski");
        Assertions.assertNotNull(people);
        Assertions.assertSame(people, people); // ==
        Assertions.assertNotSame(legacyPeople, people); // ==
        Assertions.assertLinesMatch(legacyPeople, people);
        Assertions.assertArrayEquals(new int[]{1, 2, 3}, new int[]{1, 2, 3});

    }
}
