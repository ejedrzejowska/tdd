package pl.sda.tddtraining;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

public class CustomerStatistics {

    private Customer[] people = new Customer[]{
            new Customer("Anna", "Nowak   ", 33, "1200"),
            new Customer("Beata", "Kowalska", 22, "1200"),
            new Customer("Marek", " Nowak", 25, "1250"),
            new Customer("Adam", "Twardowski", 33, "1100"),
            new Customer("Monika  ", "Kos", 25, "2500"),
            new Customer("Adam ", "Rudy", 45, "3333"),
            new Customer("Marek", "Rudy", 15, 2210),
            new Customer("Adam", "Madej", 15, 3333)
    };
//1.
    public List<Customer> getPeople() {
        //return Lists.newArrayList(people);
        return Arrays.asList(people);
    }
//2.
    public List<String> getNames() {
        List<String> names = new ArrayList<>();
        for (Customer person : people) {
            names.add(person.getName().trim() + " " + person.getLastName().trim());
        }
        return names;
    }

    public List<String> getPeopleNamesWithStream() {
        return getPeople().stream()
                .map(customer -> customer.getName().trim() + " " + customer.getLastName().trim())
                .collect(Collectors.toList());
    }
//3.
    public Map<Integer, Customer> returnListofCustomerAsMap() {
        Map<Integer, Customer> peopleMap = new HashMap<>();
        for (Customer person : getPeople()) {
            peopleMap.put(person.getId(), person);
        }
        return peopleMap;
    }

    public Map<Integer, Customer> returnListOfCustomerWithStream() {
        return getPeople().stream().collect(toMap(c -> c.getId(), c -> c));    //Collectors.toMap() static import
    }
//4.
    public Map<Integer, List<Customer>> returnCustomerMapBySalary() {
        Map<Integer, List<Customer>> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            if (result.containsKey(person.getSalary())) {
                result.get(person.getSalary()).add(person);
            } else {
                result.put(person.getSalary(), Lists.newArrayList(person));
            }
        }
        result.put(null, Lists.newArrayList());
        return result;
    }

    public Map<Integer, List<Customer>> returnCustomerMapBySalarywithStream() {
        return getPeople().stream().collect(Collectors.groupingBy(c -> c.getSalary()));
    }
//5.
    public Map<Integer, Integer> returnStatisticsWithSalary() {
        HashMap<Integer, Integer> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            if (result.containsKey(person.getSalary())) {
                Integer counter = result.get(person.getSalary()) + 1;
                result.put(person.getSalary(), counter);
            } else {
                result.put(person.getSalary(), 1);
            }
        }
        return result;
    }

    public Map<Integer, Long> returnStatisticsWithSalaryWithStream() {
        return getPeople().stream().collect(groupingBy(c -> c.getSalary(), counting()));
    }
//6.
    public Map<String, Map<Integer, Integer>> returnMapOfMapsWithSalary() {
        HashMap<String, Map<Integer, Integer>> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            String tempPerson = person.getName().trim();
            if (result.containsKey(tempPerson)) {
                Map<Integer, Integer> innerMap = result.get(tempPerson);
                if (innerMap.containsKey(person.getSalary())) {
                    Integer counter = innerMap.get(person.getSalary()) + 1;
                    innerMap.put(person.getSalary(), counter);
                } else {
                    innerMap.put(person.getSalary(), 1);
                }
            } else {
                HashMap<Integer, Integer> innerMap = Maps.newHashMap();
                innerMap.put(person.getSalary(), 1);
                result.put(tempPerson, innerMap);
            }
        }
        return result;
    }

    public Map<String, Map<Integer, Long>> returnMapOfMapsWithSalaryWithStream() {
        return getPeople().stream().collect(
                groupingBy(c -> c.getName().trim(),
                        groupingBy(c -> c.getSalary(), counting())));
    }
//7.
    public Map<String, Integer> returnMapOfSumOfSalaryForName(){
        HashMap<String, Integer> result = Maps.newHashMap();
        for (Customer person : getPeople()) {
            String tempPerson = person.getName().trim();
            if(result.containsKey(tempPerson)){
                int sumOfSalary = result.get(tempPerson);
                result.put(tempPerson, sumOfSalary + person.getSalary());
            } else {
                result.put(tempPerson, person.getSalary());
            }

        }
        return result;
    }

    public Map<String, Integer> returnMapOfSumOfSalaryForNameWithStreams(){
         return getPeople().stream().collect(groupingBy(c -> c.getName().trim(), summingInt(c -> c.getSalary())));
    }
}
