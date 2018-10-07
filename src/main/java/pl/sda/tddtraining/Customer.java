package pl.sda.tddtraining;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;

@Getter
@Setter

public class Customer {


    private final String name;
    private final String lastName;
    private final Integer age;
    private final Integer salary;
    private final int id;
    @Setter(value = AccessLevel.PRIVATE)
    private static int count = 0;

    public Customer(String name, String lastName, int age, String salary) {
        this(name, lastName, age, Integer.valueOf(salary));
    }

    public Customer(String name, String lastName, int age, int salary) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.salary = salary;
        this.id = ++count;
    }

    public String printCustomerFullName() {
//        String tempName = getName();
//        if(tempName == null){
//            tempName = "";
//        }
        String name = getName();
        String lastName = getLastName();
        return (name != null ? name : "").trim() + " " + (lastName != null ? lastName : "").trim();
    }

    public String printNameWithStringUtils() {
        return StringUtils.defaultIfBlank(getName(), "").trim()
                + (StringUtils.isBlank(getName()) ? "": " ")
                + StringUtils.defaultIfBlank(getLastName(), "").trim();
    }

}
