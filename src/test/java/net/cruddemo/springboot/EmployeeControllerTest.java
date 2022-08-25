package net.cruddemo.springboot;

import net.cruddemo.springboot.controller.EmployeeControleer;
import net.cruddemo.springboot.dto.CustomDTO;
import net.cruddemo.springboot.dto.EmpDTO;
import net.cruddemo.springboot.mapper.EmployeeMapper;
import net.cruddemo.springboot.model.Dept;
import net.cruddemo.springboot.model.Designation;
import net.cruddemo.springboot.model.Employee;
import net.cruddemo.springboot.dto.CustomDTO;
import net.cruddemo.springboot.model.Salary;
import net.cruddemo.springboot.repository.EmployeeRepository;
import net.cruddemo.springboot.service.EmpService;
import org.junit.jupiter.api.Test;

import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class EmployeeControllerTest {


    private EmpService empService=mock(EmpService.class);
    private final EmployeeMapper employeeMapper = mock(EmployeeMapper.class);

    private final EmployeeRepository employeeRepository=mock(EmployeeRepository.class);

    private EmployeeControleer employeeControleer=new EmployeeControleer(empService,employeeMapper,employeeRepository);

    @Test
    public void getEmployeeByDesignationTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEmployeeByDesignation()).thenReturn(List.of(employee));
        List<Employee> employeeList=employeeControleer.getEmployeeByDesignation();
        assertEquals(1,employeeList.size());
       /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getempbycityTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEmployeeByCity("Pune")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getEmployeeByCity("Pune");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getEmployeeByExpTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEmployeeByExp("Pradnya")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getEmployeeByExp("Pradnya");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getEmployeeByFirstAndLastNameTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEmployeeByFirstAndLastName("Pradnya","Mawal")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getEmployeeByFirstAndLastName("Pradnya","Mawal");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getEployeeByAgeAndCityTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEployeeByAgeAndCity(21,"Pune")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getEployeeByAgeAndCity(21,"Pune");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }


    @Test
    public void getEmployeeByAgeAndDesignationTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEmployeeByAgeAndDesignation(21,"Level1")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getEmployeeByAgeAndDesignation(21,"Level1");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getEmployeeByExpAndDeskNoTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEmployeeByExpAndDeskNo(2,"c21")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getEmployeeByExpAndDeskNo(2,"c21");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void findByFirstNameTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.findByFirstName("Pradnya")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.findByFirstName("Pradnya");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }


    @Test
    public void findByFirstNameAndCityTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.findByFirstNameAndCity("Pradnya","Pune")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.findByFirstNameAndCity("Pradnya","Pune");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void findByFirstNameOrDeskIdTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.findByFirstNameOrDeskId("Pradnya","c21")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.findByFirstNameOrDeskId("Pradnya","c21");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void findByAgeBetweenTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.findByAgeBetween(20,21)).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.findByAgeBetween(20,21);
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void findByAgeGreaterThanTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.findByAgeGreaterThan(20)).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.findByAgeGreaterThan(20);
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void findByAgeLessThanTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.findByAgeLessThan(24)).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.findByAgeLessThan(24);
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getAllEmployeeByOneToOneTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getAllEmployeeByOneToOne("Level1")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getAllEmployeeByOneToOne("Level1");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getAllEmployeeBySalaryTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getAllEmployeeBySalary("20000")).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getAllEmployeeBySalary("20000");
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getAllTableEmployeeTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getAllTableEmployee()).thenReturn(List.of(employee));
        ResponseEntity<List<Employee>> employeeList=  employeeControleer.getAllTableEmployee();
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void findCustomDtoTest(){
        CustomDTO customDTO=new CustomDTO("98765432789","Pradnya","Admin","Level1",40000);
        when(empService.findCustomDto()).thenReturn((List.of(customDTO)));
        ResponseEntity<List<CustomDTO>> employeeList=  employeeControleer.findCustomDto();
        assertEquals(1,employeeList.getBody().size());
        /* assertEquals("Pradnya",employeeList.get(1));*/
    }

    @Test
    public void getEmployeeBySalaryTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEmployeeBySalary()).thenReturn(List.of(employee));
        List<Employee> employeeList=  employeeControleer.getEmployeeBySalary();
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEmployeeByEqualsMethodTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(empService.getEmployeeByEqualsMethod()).thenReturn(List.of(employee));
        List<Employee> employeeList=  employeeControleer.getEmployeeByEqualsMethod();
        assertEquals(1,employeeList.size());
    }

    @Test
    public void createEmployeeTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeControleer.createEmployee(employee)).thenReturn(employee);
        Employee employeeList= employeeControleer.createEmployee(employee);
        assertEquals("Pradnya",employeeList.getFirstName());
        assertEquals("Mawal",employeeList.getLastName());
        assertEquals("Pune",employeeList.getCity());

    }

    @Test
    public void deleteEmployeeTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        employeeControleer.deleteEmployee(employee);
        verify(employeeRepository,times(1)).delete(employee);
    }

    @Test
    public void getEmployeeByIdTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        long id=3;
        when(employeeControleer.getEmployeeById(3)).thenReturn((ResponseEntity<Employee>) List.of(employee));
        List<Employee> employeeList= (List<Employee>) employeeControleer.getEmployeeById(3);
        assertEquals(1,employeeList.size());
    }



}
