package pl.sda.tddtraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CustomerStatisticsTest {
    private CustomerStatistics customerStatistics = new CustomerStatistics();

    @Test
    void shouldGenerateIdWithProperValue() {

        List<Customer> people = customerStatistics.getPeople();
        int counter = 1;
        for (Customer person : people) {
            Assertions.assertEquals(counter++, person.getId());
        }
    }

    //2.
    @Test
    void shouldReturnProperNames() {
        List<String> peopleNames = customerStatistics.getNames();
        List<String> peopleNamesWithStream = customerStatistics.getPeopleNamesWithStream();
        assertEquals("Marek Rudy", peopleNames.get(6));
        assertEquals("Anna Nowak", peopleNames.get(0));
        assertEquals("Marek Nowak", peopleNamesWithStream.get(2));
    }

    //3.
    @Test
    void shouldGenerateCustomerMap() {
        Map<Integer, Customer> customerMap = customerStatistics.returnListofCustomerAsMap();
        Map<Integer, Customer> customerMapWithStream = customerStatistics.returnListOfCustomerWithStream();

        Assertions.assertEquals("Marek Nowak", customerMap.get(3).printCustomerFullName());
        Assertions.assertEquals("Monika Kos", customerMapWithStream.get(5).printCustomerFullName());
    }

    //4.
    @Test
    void shouldGenerateCustomerMapBySalary() {
        Map<Integer, List<Customer>> customerMapBySalary = customerStatistics.returnCustomerMapBySalary();
        Map<Integer, List<Customer>> customerMapBySalaryWithStream = customerStatistics.returnCustomerMapBySalarywithStream();
        Assertions.assertEquals(2, customerMapBySalary.get(1200).size());
        Assertions.assertEquals(2, customerMapBySalaryWithStream.get(3333).size());
    }

    //5.
    @Test
    void shouldGenerateMapWithSalaryStatistics() {
        Map<Integer, Integer> salaryStatisticMap = customerStatistics.returnStatisticsWithSalary();
        Map<Integer, Long> salaryStatisticMapWithStream = customerStatistics.returnStatisticsWithSalaryWithStream();
        Assertions.assertEquals(2, (int) salaryStatisticMap.get(1200));
        Assertions.assertEquals(2, (long) salaryStatisticMapWithStream.get(3333));
    }

    //6.
    @Test
    void shouldGenerateMapOfNamesAndNumberOfCustomersWithGivenSalary() {
        Map<String, Map<Integer, Integer>> mapOfMapsWithSalary = customerStatistics.returnMapOfMapsWithSalary();
        Map<String, Map<Integer, Long>> mapOfMapsWithSalaryWithStream = customerStatistics.returnMapOfMapsWithSalaryWithStream();
        Assertions.assertEquals(2, (int) mapOfMapsWithSalary.get("Adam").get(3333));
        Assertions.assertEquals(2, (long) mapOfMapsWithSalaryWithStream.get("Adam").get(3333));
    }

    //7.
    @Test
    void shouldGenerateMapOfSumOfSalaries() {
        Map<String, Integer> mapOfSumOfSalaryForName = customerStatistics.returnMapOfSumOfSalaryForName();
        Map<String, Integer> mapOfSumOfSalaryForNameWithStream = customerStatistics.returnMapOfSumOfSalaryForNameWithStreams();
        Assertions.assertEquals(7766, (int) mapOfSumOfSalaryForName.get("Adam"));
        Assertions.assertEquals(7766, (int) mapOfSumOfSalaryForNameWithStream.get("Adam"));
    }
}