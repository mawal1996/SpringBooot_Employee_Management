package net.cruddemo.springboot;

import net.cruddemo.springboot.model.Dept;
import net.cruddemo.springboot.model.Designation;
import net.cruddemo.springboot.model.Employee;
import net.cruddemo.springboot.model.Salary;
import net.cruddemo.springboot.repository.EmployeeRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class EmployeeRepositoryTest {


       private final EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
         List<Employee> employeeList;
        @BeforeEach
        public void iniTtestMethod(){
                employeeList= Arrays.asList(new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept()));
                employeeRepository.saveAll(employeeList);
        }

        @AfterEach
        public void destroyMethod(){
                employeeRepository.deleteAll();
        }

        @Test
        public void getAllTableEmployeeTest(){
               // Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
                when(employeeRepository.getAllEmplyeeBy()).thenReturn(employeeList);
                List<Employee> employeeList1=employeeRepository.getAllEmplyeeBy();
                assertThat(employeeList1).isNotNull();
                assertThat(employeeList1.size()).isEqualTo(1);
                assertEquals(1,employeeList.size());
        }

        @Test
        public void getEmployeeByCitytest(){
            Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
            String city="Pune";
            when(employeeRepository.getEmployeeByCity("Mumbai")).thenReturn(List.of(employee));
            List<Employee> employeeList=employeeRepository.getEmployeeByCity("Mumbai");
            assertEquals(1,employeeList.size());
        }



}


