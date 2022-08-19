package net.cruddemo.springboot.dto;

import lombok.Data;
import net.cruddemo.springboot.model.laptops;

import java.util.List;

@Data
public class EmpDTO {

    private long id;
    private String firstName;
    private String emailId;
    private String designation;
    private String experience;
    private String  state;
    private String deskId;

    /*private List<laptops> laptopsList;*/

}



