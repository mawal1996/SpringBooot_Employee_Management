package net.cruddemo.springboot;


import java.util.List;

import net.cruddemo.springboot.model.Dept;
import net.cruddemo.springboot.model.Designation;
import net.cruddemo.springboot.model.Employee;
import net.cruddemo.springboot.model.Salary;
import net.cruddemo.springboot.repository.EmployeeRepository;
import net.cruddemo.springboot.service.EmpService;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
/*import org.mockito.Captor;
import org.mockito.Mockito;*/


public class EmployeeServiceTest {

    private final EmployeeRepository employeeRepository = mock(EmployeeRepository.class);
   /* private final ModelMapper modelMapper = mock(ModelMapper.class);*/

    private final EmpService empService =new EmpService(employeeRepository);

    /*@Captor
    private ArgumentCaptor<Employee> employeeArgumentCaptor;*/

  /*  @Captor
    private ArgumentCaptor<List<Employee>> argumentCaptor;

*/
    //private Employee employee;

    /*@BeforeAll
    public  void addDataTest(){
        Employee employee=Employee.builder()
                .id(1L)
                .age(21)
                .city("Pune")
                .designation("Level1")
                .deskId("c21")
                .emailId("p@gmail.com")
                .experience(2)
                .firstName("Pradnya")
                .lastName("Mawal")
                .mobileNo("876432124")
                .stat("Maharashtra")
                .build();
    }*/

   /* @DisplayName("Junit test for getAllEmployees method")
    @Test
    public void giveEmployeesList_WhenGetAllEmployess_thenReturnEmployessList(){
        Employee employee1=Employee.builder()
                .id(1L)
                .age(21)
                .city("Pune")
                .designation("Level1")
                .deskId("c21")
                .emailId("p@gmail.com")
                .experience(2)
                .firstName("Pradnya")
                .lastName("Mawal")
                .mobileNo("876432124")
                .stat("Maharashtra")
                .build();

        when(employeeRepository.getAllEmployeeByFindAllMethod()).thenReturn(List.of(employee1));

        List<Employee> employeeList=  empService.getAllEmployeeByFindAllMethod();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
        verify(employeeRepository,times(1)).getAllEmployeeByFindAllMethod();
        verify(employeeRepository,times(0)).findByfirstNameLike(anyString());
    }*/

    @Test
    public void findByFirstNameAndCityTest(){
        Employee employee=new Employee();
        when(employeeRepository.findByFirstNameAndCity("Pradnya","Pune")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.findByFirstNameAndCity("Pradnya","Pune");
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEmployeeByCityTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        String city="Pune";
        when(employeeRepository.getEmployeeByCity(city)).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByCity(city);
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEmployeeByCityTestUsingArgumentCaptor(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.getEmployeeByCity(anyString())).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByCity(anyString());
        assertEquals(1,employeeList.size());

        ArgumentCaptor<Employee> argumentCaptor=ArgumentCaptor.forClass(Employee.class);
        verify(employeeRepository).getEmployeeByCity(String.valueOf(argumentCaptor.capture()));
        List<Employee> captured=  argumentCaptor.getAllValues();


        assertEquals(1,captured.size());
       /* assertEquals("Pradnya",captured.get(1));*/
    }
    @Test
    public void getEmployeeByExpTestUsingArgumentCaptor(){
        ArgumentCaptor<Employee> argumentCaptor=ArgumentCaptor.forClass(Employee.class);
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        String first_name="Pradnya";
        when(employeeRepository.getEmployeeByExp(first_name)).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByExp(first_name);
        verify(employeeRepository).getEmployeeByExp(String.valueOf(argumentCaptor.capture()));
        List<Employee> employeeList1=argumentCaptor.getAllValues();
        assertEquals(1,employeeList1.size());
    }

    @Test
    public void getEmployeeByDesignationTest(){
       /* Employee employee=new Employee();*/
        Employee employee=Employee.builder()
                .id(1L)
                .age(21)
                .city("Pune")
                .designation("Level1")
                .deskId("c21")
                .emailId("p@gmail.com")
                .experience(2)
                .firstName("Pradnya")
                .lastName("Mawal")
                .mobileNo("876432124")
                .stat("Maharashtra")
                .build();

        when(employeeRepository.getEmployeeByDesignation()).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByDesignation();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEmployeeByDesignationIsNotTest(){
         Employee employee=new Employee();


        when(employeeRepository.getEmployeeByDesignation()).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByDesignation();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }


    @Test
    public void findByFirstName(){
       empService.findByFirstName(anyString());
       verify(employeeRepository).findByFirstName(anyString());
    }

  //We used assertion  for predict the actual value and expected value

    @Test
    public void getEmployeeBySalaryGreaterThanTest(){
        Salary salary=new Salary(1,10000,500000,30000,new Employee());
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),salary,new Dept());
        when(employeeRepository.getEmployeeBySalary()).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeBySalary();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEmployeeBySalaryLessThanTest(){
        Salary salary=new Salary(1,10000,20000,30000,new Employee());
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),salary,new Dept());
        when(employeeRepository.getEmployeeBySalary()).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeBySalary();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(0);
        assertEquals(0,employeeList.size());
    }

    @Test
    public void getEmployeeBySalaryEqualToTest(){
        Salary salary=new Salary(1,400000,20000,30000,new Employee());
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),salary,new Dept());
        when(employeeRepository.getEmployeeBySalary()).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeBySalary();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(0);
        assertEquals(0,employeeList.size());
    }
    @Test
    public void getEmployeeByEqualsMethodTest_equalToAdmin(){
        Dept dept=new Dept(1,"Admin","Administration",new Employee());
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),dept);
        when(employeeRepository.getEmployeeBySalary()).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByEqualsMethod();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEmployeeByEqualsMethodTest_NotequalToAdmin(){
        Dept dept=new Dept(1,"Security","Administration",new Employee());
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),dept);
        when(employeeRepository.getEmployeeBySalary()).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByEqualsMethod();
        assertThat(employeeList).isNotNull();
        assertThat(employeeList.size()).isEqualTo(0);
        assertEquals(0,employeeList.size());
    }

    @Test
    public void findByFirstNameOrDeskIdTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.findByFirstNameOrDeskId("Pradnya","c21")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.findByFirstNameOrDeskId("Pradnya","c21");

    }

    @Test
    public void findByAgeBetweenTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.findByAgeBetween(20,24)).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.findByAgeBetween(20,24);
        assertThat(employeeList.size()).isGreaterThan(0);
        assertEquals(1,employeeList.size());

    }

    @Test
    public void findByAgeGreaterThanTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.findByAgeGreaterThan(20)).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.findByAgeGreaterThan(20);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void findByAgeLessThanTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.findByAgeLessThan(25)).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.findByAgeLessThan(25);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void findByfirstNameLikeTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.findByfirstNameLike("Pradnya")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.findByfirstNameLike("Pradnya");
        assertThat(employeeList.size()).isGreaterThan(0);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getAllEmployeeByOneToOneTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.getAllEmployeeByOneToOne("Level1")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getAllEmployeeByOneToOne("Level1");
        assertThat(employeeList.size()).isGreaterThan(0);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getAllEmployeeBySalaryTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.getAllEmployeeBySalary("40000")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getAllEmployeeBySalary("40000");
        assertThat(employeeList.size()).isGreaterThan(0);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getAllTableEmployeeTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.getAllTableEmployee()).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getAllTableEmployee();
        assertThat(employeeList.size()).isGreaterThan(0);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }


    @Test
    public void getAllTableEmployeeTest1(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.getEmployeeByFirstAndLastName("Pradnya","Mawal")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByFirstAndLastName("Pradnya","Mawal");
        assertThat(employeeList.size()).isGreaterThan(0);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEployeeByAgeAndCityTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.getEployeeByAgeAndCity(21,"Pune")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEployeeByAgeAndCity(21,"Pune");
        assertThat(employeeList.size()).isGreaterThan(0);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEmployeeByAgeAndDesignationTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.getEmployeeByAgeAndDesignation(21,"Level1")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByAgeAndDesignation(21,"Level1");
        assertThat(employeeList.size()).isGreaterThan(0);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }

    @Test
    public void getEmployeeByExpAndDeskNoTest(){
        Employee employee=new Employee(11,"Pradnya","Mawal","p@gmail.com","Level1",2,21,"Pune","Maharashtra","C21","8446872910",new Designation(),new Salary(),new Dept());
        when(employeeRepository.getEmployeeByExpAndDeskNo(2,"c21")).thenReturn(List.of(employee));
        List<Employee> employeeList=empService.getEmployeeByExpAndDeskNo(2,"c21");
        assertThat(employeeList.size()).isGreaterThan(0);
        assertThat(employeeList.size()).isEqualTo(1);
        assertEquals(1,employeeList.size());
    }


    @Test
    public void testSumTwoPositiveNumber(){
        int sum = empService.sum(4, 6);
        assertEquals(10,sum);
    }

    @Test
    public void testSumTwoNegativeNumber() {
        int sum = empService.sum(-3, -5);
        assertEquals(-8,sum);
    }

    @Test
    public void testSumPositiveNegativeNum() {
        int sum = empService.sum(2, -5);
        assertEquals(-3,sum);
    }
}

