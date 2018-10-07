package pl.sda.tddtraining;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {

    @Test
    void shouldNotPrintNullIfCustomerFullNameContainsNull() {
        Customer nullNameCustomer = new Customer(null, "Nullowski", 38, 2000);
        Customer nullLastNameCustomer = new Customer("Nienull", null, 38, 2000);
        Assertions.assertEquals("Nullowski", nullNameCustomer.getLastName());
    }
}