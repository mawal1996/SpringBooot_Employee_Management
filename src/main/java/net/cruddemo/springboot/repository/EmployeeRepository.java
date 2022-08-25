package net.cruddemo.springboot.repository;

import net.cruddemo.springboot.dto.CustomDTO;
import net.cruddemo.springboot.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
        //For testing

       /* List<Employee> getAllEmployeeByFindAllMethod();*/

    //jpaRepository takes all crud methods

        //JPQL Query
        @Query("Select e FROM employee e")
        List<Employee> getAllEmplyeeBy();

        //Posi tional Parameter
        //JPQL with index Parametre
        @Query("Select e FROM employee e where e.city=?1")
        List<Employee> getEmployeeByCity(String city);

        @Query("Select e FROM employee e where e.age>?1 and e.city=?2")
        List<Employee> getEployeeByAgeAndCity(Integer age,String city);

        //JPQL with Named Parametre
        @Query("Select e From employee e where e.firstName=:firstName" )
        List<Employee> getEmployeeByExp(String firstName);

        @Query("Select e from employee e where e.firstName=:firstName and e.lastName=:lastName")
        List<Employee> getEmployeeByFirstAndLastName(String firstName,String lastName);

        //Natve Query
        @Query(value = "SELECT * from employees e " , nativeQuery = true)
        List<Employee> getEmployeeByDesignation();

        //Native query with index
        @Query(value = "SELECT * from employees e where e.age>?1 and designation=?2",nativeQuery = true)
         List<Employee> getEmployeeByAgeAndDesignation(Integer age,String designation);

        //Native query with Name
        @Query(value = "Select * from employees e where e.exp=:experience and e.desk_name=:deskId",nativeQuery = true)
         List<Employee> getEmployeeByExpAndDeskNo(Integer experience,String deskId);

        //Finder Method
        List<Employee> findByFirstName(String firstName);

        List<Employee> findByDesignation(String designation);

        List<Employee> findByFirstNameAndCity(String firstName,String city);

        List<Employee> findByFirstNameOrDeskId(String firstName,String deskId);

        //Finder Between Method
        List<Employee> findByAgeBetween(Integer start,Integer end);

        //Finder Lessthan and GreaterThan equal query

        List<Employee> findByAgeGreaterThan(Integer age);

        List<Employee> findByAgeLessThan(Integer age);

        //Finder Like Query
        List<Employee> findByfirstNameLike(String firstName);

        //Custom DTo

        @Query(value = "select e.* from employees e",nativeQuery = true)
        List<Employee> getAllTableEmployee();


        @Query(value = "select e.* from employees e join designation d on d.designation_idd=e.fk_designation_idd where d.desination_details=?1",nativeQuery = true)
        List<Employee> getAllEmployeeByOneToOne(String desigDetails);

        @Query(value = "select e.* from employees e join salary s on e.fk_pay_slip_no=s.pay_slip_no where s.actual>?1",nativeQuery = true)
        List<Employee> getAllEmployeeBySalary(String actual);

        @Query(name ="Employee.findCustomDto" ,nativeQuery = true)
        List<CustomDTO> findCustomDto();

        @Query(value = "select e.* from employees e",nativeQuery = true)
        List<Employee> getEmployeeBySalary();

}












