package net.cruddemo.springboot.controller;

import lombok.RequiredArgsConstructor;
import net.cruddemo.springboot.dto.CustomDTO;
import net.cruddemo.springboot.dto.EmpDTO;
import net.cruddemo.springboot.exception.ResourceNotFoundException;
import net.cruddemo.springboot.mapper.EmployeeMapper;
import net.cruddemo.springboot.model.Employee;
import net.cruddemo.springboot.repository.EmployeeRepository;

import net.cruddemo.springboot.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/p1/employees")
@RequiredArgsConstructor
public class EmployeeControleer {

   private final EmpService empService;

   private final EmployeeMapper employeeMapper;


   /* @GetMapping("/empdetails")
     public List<EmpDTO>  getAllEmployee() {
      return empService.getAllEmployee();
     }*/

    @GetMapping("/empdetailsby")
    public List<Employee> getAllEmplyeeBy(){
        return empService.getAllEmplyeeBy();
    }

    @GetMapping("/getempbycity/{city}")
    public ResponseEntity<List<Employee>> getEmployeeByCity(@PathVariable String city){
        List<Employee> employee=empService.getEmployeeByCity(city);
        return ResponseEntity.ok(employee);
    }

    @GetMapping("/getempbydesignation")
    public List<Employee> getEmployeeByDesignation(){
        return empService.getEmployeeByDesignation();
    }

    //JPQL with Named Parametre
    @GetMapping("/getEmployeeByExp/{firstName}")
    public ResponseEntity<List<Employee>> getEmployeeByExp(@PathVariable String firstName){
        List<Employee> employees=empService.getEmployeeByExp(firstName);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("getEmployeeByFirstAndLastName/{firstName}/{lastName}")
    public ResponseEntity<List<Employee>> getEmployeeByFirstAndLastName(@PathVariable("firstName") String firstName,@PathVariable("lastName") String lastName){
        List<Employee> employees=empService.getEmployeeByFirstAndLastName(firstName,lastName);
        System.out.println(employees);
        return ResponseEntity.ok(employees);
    }

    //JPQL with index Parametre
    @GetMapping("getEployeeByAgeAndCity/{age}/{city}")
    public ResponseEntity<List<Employee>> getEployeeByAgeAndCity(@PathVariable("age") Integer age,@PathVariable("city") String city){
        List<Employee> employees=empService.getEployeeByAgeAndCity(age,city);
        return ResponseEntity.ok(employees);
    }

    //Native query with index
    @GetMapping("getEmployeeByAgeAndDesignation/{age}/{designation}")
    public ResponseEntity<List<Employee>> getEmployeeByAgeAndDesignation(@PathVariable("age") Integer age,@PathVariable("designation") String designation){
        List<Employee> employees=empService.getEmployeeByAgeAndDesignation(age,designation);
        return ResponseEntity.ok(employees);
    }

    //Native query with Name
    @GetMapping("getEmployeeByExpAndDeskNo/{experience}/{deskId}")
    public ResponseEntity<List<Employee>> getEmployeeByExpAndDeskNo(@PathVariable("experience") Integer experience,@PathVariable("deskId") String deskId){
        List<Employee> employees=empService.getEmployeeByExpAndDeskNo(experience,deskId);
        return ResponseEntity.ok(employees);
    }
    //Finder Method using single object
    @GetMapping("findByFirstName/{firstName}")
    public ResponseEntity<List<Employee>> findByFirstName(@PathVariable String firstName){
        List<Employee> employees=empService.findByFirstName(firstName);
        return ResponseEntity.ok(employees);
   }

   @GetMapping("findByDesignation/{designation}")
    public ResponseEntity<List<Employee>> findByDesignation(@PathVariable String designation){
        List<Employee> employees=empService.findByDesignation(designation);
        return ResponseEntity.ok(employees);
    }

    //Finder Methods using Multiple Object
    //AND Operator
    @GetMapping("findByFirstNameAndCity/{firstNameandcity}")
    public ResponseEntity<List<Employee>> findByFirstNameAndCity(@RequestParam String firstName,String city){
        List<Employee> employees=empService.findByFirstNameAndCity(firstName,city);
        return ResponseEntity.ok(employees);
    }

    //OR Operator
    @GetMapping("findByFirstNameOrDeskId/{firstNameordeskId}")
    public ResponseEntity<List<Employee>> findByFirstNameOrDeskId(@RequestParam String firstName,String deskId){
        List<Employee> employees=empService.findByFirstNameOrDeskId(firstName,deskId);
        return ResponseEntity.ok(employees);
    }

    //Finder by Between Query
    @GetMapping("findByAgeBetween/{age}")
    public ResponseEntity<List<Employee>> findByAgeBetween(@RequestParam Integer start,@RequestParam Integer end){
        List<Employee> employees=empService.findByAgeBetween(start,end);
        return ResponseEntity.ok(employees);
    }

    //Finder By Greater than query
    @GetMapping("findByAgeGreaterThan/greaterthan")
    public ResponseEntity<List<Employee>> findByAgeGreaterThan(@RequestParam Integer age){
        List<Employee> employees= empService.findByAgeGreaterThan(age);
        return ResponseEntity.ok(employees);
    }
    //Finder By Less than  query
    @GetMapping("findByAgeLessThan/lessthan")
    public ResponseEntity<List<Employee>> findByAgeLessThan(@RequestParam Integer age){
        List<Employee> employees= empService.findByAgeLessThan(age);
        return ResponseEntity.ok(employees);
    }

    //Finder Method by Like query
    @GetMapping("findByfirstNameLike/firstName")
    public ResponseEntity<List<Employee>> findByfirstNameLike(@RequestParam String firstName){
        List<Employee> employees=empService.findByfirstNameLike("%"+firstName+"%");
        return ResponseEntity.ok(employees);
    }
    @Autowired
    private EmployeeRepository employeeRepository;

   /* @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }*/

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    //build get employee by id REST API
    @GetMapping("{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable long id){
        Employee employee =employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not eist with id:" +id));
        return ResponseEntity.ok(employee);

    }

    //build update employee REST API
    @PutMapping("{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
        Employee updateEmployee =employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id" + id));
        updateEmployee.setFirstName(employeeDetails.getFirstName());
        updateEmployee.setLastName(employeeDetails.getLastName());
        updateEmployee.setEmailId(employeeDetails.getEmailId());
        updateEmployee.setCity(employeeDetails.getCity());
        updateEmployee.setAge(employeeDetails.getAge());
        employeeRepository.save(updateEmployee);
        return ResponseEntity.ok(updateEmployee);
    }

    //build delete employee REST API
    @DeleteMapping("{id}")
    public  ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
        Employee employee = employeeRepository.findById(id).orElseThrow(() ->new ResourceNotFoundException("Employee not exist with id" + id));

        employeeRepository.delete(employee);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

    //Map Struct(Models to DTo)
   /* @Autowired*/


    @PostMapping("/postbymapstruct")
    public ResponseEntity<Employee> save(@RequestBody EmpDTO empDTO){
        return new ResponseEntity<>(employeeRepository.save(employeeMapper.dtoTOModel(empDTO)),HttpStatus.CREATED);
    }


    @GetMapping("/findbystructmap")
    public ResponseEntity<List<EmpDTO>> findAll(){
        return new ResponseEntity<>(employeeMapper.modelsTODto(employeeRepository.findAll()),HttpStatus.OK);
    }

    @DeleteMapping("/deletbystructmap/{id}")
    public ResponseEntity<Void> deletebyid(@PathVariable(value = "id") Long id){
       EmpDTO empDTO=employeeMapper.modelTODto(employeeRepository.findById(id).get());
       employeeRepository.deleteById(empDTO.getId());
       return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

   //Custom DTO

   /* @GetMapping("/getAllCustomDto")
    public List<CustomDTO> getAllCustomDto(){
        return empService.getAllCustomDto();
    }*/

    @PostMapping("/saveEmployeeWithDesignation")
    public ResponseEntity<String> saveEmployeeWithDesignation(@RequestBody List<Employee> employees){
        employeeRepository.saveAll(employees);
        return ResponseEntity.ok("saved");
    }

    @GetMapping("/getAllEmployeeByOneToOne/{desigDetails}")
    public ResponseEntity<List<Employee>> getAllEmployeeByOneToOne(@PathVariable(value = "desigDetails") String desigDetails){
        List<Employee> employees=empService.getAllEmployeeByOneToOne(desigDetails);
        return ResponseEntity.ok(employees);
    }

    @GetMapping("/getAllEmployeeBySalary/{actual}")
    public ResponseEntity<List<Employee>> getAllEmployeeBySalary(@PathVariable(value = "actual") String actual){
        System.out.println("actual"+actual);
        List<Employee> employees=empService.getAllEmployeeBySalary(actual);
        return ResponseEntity.ok(employees);
    }


    @GetMapping("/getAllTableEmployee")
    public ResponseEntity<List<Employee>> getAllTableEmployee(){
        List<Employee> employees=empService.getAllTableEmployee();
        return ResponseEntity.ok(employees);
    }

   /* @GetMapping("/getAllTableEmployee1")
    public ResponseEntity<List<CustomDTO>> getAllTableEmployee1(){
        List<CustomDTO> employees=empService.getAllTableEmployee1();
        return ResponseEntity.ok(employees);
    }*/

    @GetMapping("/findCustomDto")
    public  ResponseEntity<List<CustomDTO>> findCustomDto(){
        List<CustomDTO> customDTOS =empService.findCustomDto();
        return ResponseEntity.ok(customDTOS);
    }


   /* //For testing Purpose
    @GetMapping("/getAllEmployeeByFindAllMethod")
    public List<Employee> getAllEmployeeByFindAllMethod(){
      return employeeRepository.findAll();
    }*/

    @GetMapping("/getEmployeeBySalary")
    public List<Employee> getEmployeeBySalary(){
        return empService.getEmployeeBySalary();
    }

    @GetMapping("/getEmployeeByEqualsMethod")
    public List<Employee> getEmployeeByEqualsMethod(){
        return empService.getEmployeeByEqualsMethod();
    }



}
