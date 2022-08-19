package net.cruddemo.springboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomDTO {

    private String mobileNo;
    private String firstName;
    private String deptName;
    private String desigDetails;
    private long actual;


}
