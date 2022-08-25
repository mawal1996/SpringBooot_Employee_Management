/*
package net.cruddemo.springboot;

import net.cruddemo.springboot.model.Employee;
import net.cruddemo.springboot.repository.EmployeeRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmployeeRepositoryTest {

    @Autowired
    private EmployeeRepository employeeRepository;

   */
/* @Test
    public void saveEmployeeTest(){
        Employee employee=Employee.builder().firstName("Hrishi").lastName("Mawal").age(21).emailId("h@gmail.com")
                .city("Germany").experience(2).mobileNo("9730526378"). build();

            employeeRepository.save(employee);

        Assertions.assertThat(employee.getId()).isGreaterThan(1);

    }*//*


    @Test
    @Order(1)
    public void getListOfEmployeesTest() {
        List<Employee> employees = employeeRepository.findAll();
        Assertions.assertThat(employees.size()).isGreaterThan(0);
    }



}
*/
