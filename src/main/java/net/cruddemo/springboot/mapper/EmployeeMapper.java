package net.cruddemo.springboot.mapper;

import net.cruddemo.springboot.dto.EmpDTO;
import net.cruddemo.springboot.model.Employee;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;
import java.util.UUID;
/*import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;*/

@Mapper(componentModel = "spring",imports = UUID.class) //To create the springboot omponent here we used componentModel
                                                         // & for java expression used  UUID.class
public interface EmployeeMapper {


    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);//to get generated implemented class/or acess it we create this

   /* @Mapping(source = "employee.stat",target = "state",defaultValue = "Maharashtra")*/
   /* @Mapping(target = "deskId" ,expression = "java(UUID.randomUUID().toString())") //Used to convert java Expression
    @Mapping(source = "employee.laptops",target="laptopsList")*/ //To converts datatypes

    EmpDTO modelTODto(Employee employee);

   /* @Mapping(source = "employee.stat",target = "state",defaultValue = "Maharashtra")
    @Mapping(target = "deskId" ,expression = "java(UUID.randomUUID().toString())")
    @Mapping(source = "employee.laptops",target="laptopsList")*/

    List<EmpDTO> modelsTODto(List<Employee> employee);

   /*@InheritConfiguration  //(Insted of writing same code we can use InheritConfiguration (Means here we are doing
   exact opposite things of modelsTODto so we can used InheritConfiguration)*/

    @InheritConfiguration
    Employee dtoTOModel(EmpDTO empDTO);
}
