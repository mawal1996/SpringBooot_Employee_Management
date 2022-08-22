package net.cruddemo.springboot.service;


import lombok.RequiredArgsConstructor;
import net.cruddemo.springboot.dto.CustomDTO;
import net.cruddemo.springboot.model.Employee;
import net.cruddemo.springboot.repository.EmployeeRepository;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service("empService")
@RequiredArgsConstructor
public class EmpService {

    private final  EmployeeRepository employeeRepository;


    public List<Employee> getAllEmplyeeBy(){
        return employeeRepository.getAllEmplyeeBy();
    }

    public List<Employee> getEmployeeByCity(String city){

        return employeeRepository.getEmployeeByCity(city);
    }

    public List<Employee> getEmployeeByDesignation(){

        return employeeRepository.getEmployeeByDesignation();
    }

    public List<Employee> getEmployeeByExp(String firstName){

        return employeeRepository.getEmployeeByExp(firstName);
    }

    public List<Employee> getEmployeeByFirstAndLastName(String firstName,String lastName){
        return employeeRepository.getEmployeeByFirstAndLastName(firstName,lastName);
    }

    public List<Employee> getEployeeByAgeAndCity(Integer age,String city){
        return employeeRepository.getEployeeByAgeAndCity(age,city);

    }
    public List<Employee> getEmployeeByAgeAndDesignation(Integer age,String designation){
        return employeeRepository.getEmployeeByAgeAndDesignation(age,designation);
    }

    public List<Employee> getEmployeeByExpAndDeskNo(Integer experience,String deskId){
        return employeeRepository.getEmployeeByExpAndDeskNo(experience,deskId);
    }

    //Model Mapper

   /* public List<EmpDTO> getAllEmployee(){
         return employeeRepository.findAll().stream().map(this::converEntityToDto).collect(Collectors.toList());

    }*/

   /* private EmpDTO converEntityToDto(Employee employee){
        EmpDTO empDTO=modelMapper.map(Employee.class,EmpDTO.class);

       *//* EmpDTO empDTO = new EmpDTO();*//*
        *//*empDTO.setId(employee.getId());
        empDTO.setFirstName(employee.getFirstName());
        empDTO.setDesignation(employee.getDesignation());
        empDTO.setExperience(employee.getExperience());
        empDTO.setEmailId(employee.getEmailId());
*//*
        return empDTO;
    }*/

    //Finder Method
     public List<Employee> findByFirstName(String firstName){

        return  employeeRepository.findByFirstName(firstName);
    }

   public List<Employee> findByDesignation(String designation){
        List<Employee> emp= employeeRepository.findByDesignation(designation);
        System.out.println("The  employee data will be :"+emp);
        return emp;
    }

    public List<Employee> findByFirstNameAndCity(String firstName,String city){
        return employeeRepository.findByFirstNameAndCity(firstName,city);
    }

    public List<Employee> findByFirstNameOrDeskId(String firstName,String deskId){
        return employeeRepository.findByFirstNameOrDeskId(firstName,deskId);
    }

   public List<Employee> findByAgeBetween(Integer start,Integer end){
        return employeeRepository.findByAgeBetween(start, end);
   }

   public List<Employee> findByAgeGreaterThan(Integer age){
        return employeeRepository.findByAgeGreaterThan(age);
   }

   public List<Employee> findByAgeLessThan(Integer age){
        return employeeRepository.findByAgeLessThan(age);
    }

    public List<Employee> findByfirstNameLike(String firstName){
        return employeeRepository.findByfirstNameLike(firstName);
    }


    //Custome dto

   /*public List<CustomDTO> getAllCustomDto(){
        return employeeRepository.findAll().stream().map(this::convertEntityToDtoCustom).collect(Collectors.toList());

    }*/

    /*private CustomDTO convertEntityToDtoCustom(Employee employee){
        CustomDTO customDTO=modelMapper.map(Employee.class,CustomDTO.class);
        return customDTO;
    }*/

    public List<Employee> getAllEmployeeByOneToOne(String desigDetails){
        return employeeRepository.getAllEmployeeByOneToOne(desigDetails);
    }

    public List<Employee> getAllEmployeeBySalary(String actual){
         List<Employee> ems=employeeRepository.getAllEmployeeBySalary(actual);
         System.out.println("Data that is fetched is"+ems.toString());
         return ems;

    }

    public List<Employee> getAllTableEmployee(){
        return employeeRepository.getAllTableEmployee();
    }


    /*public List<CustomDTO> getAllTableEmployee1(){
        return employeeRepository1.getAllTableEmployee1();
    }*/

    public  List<CustomDTO> findCustomDto(){
        return employeeRepository.findCustomDto();
    }

   /* //For testing Purpose
     public List<Employee> getAllEmployeeByFindAllMethod(){
        return employeeRepository.getAllEmployeeByFindAllMethod();
    }*/

   public List<Employee> getEmployeeBySalary(){
       List<Employee> employeeList=employeeRepository.getEmployeeBySalary().stream().filter(e -> e.getSalary().getActual() >400000)
                .collect(Collectors.toList());
        return employeeList;
        //TO do
        //write java logic to filter employee list whoes salary is greater than
    }

    public List<Employee> getEmployeeByEqualsMethod(){
       List<Employee> employeeList=employeeRepository.getEmployeeBySalary().stream().filter(e-> e.getDept().getDeptName().equals("Admin"))
               .collect(Collectors.toList());
       return employeeList;
    }
    public int sum (int a,int b){
        return a+b;
    }
}
