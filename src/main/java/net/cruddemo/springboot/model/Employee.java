package net.cruddemo.springboot.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import net.cruddemo.springboot.dto.CustomDTO;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor

@Entity(name="employee")

@NamedNativeQuery(
        name = "Employee.findCustomDto",
        query ="select e.mobile,e.first_Name,d.dept_name,t.desination_details,s.actual from employees e join dept d on e.fk_dept_id=d.deptid Join designation t on e.fk_designation_idd=t.designation_idd join salary s on e.fk_pay_slip_no=s.pay_slip_no ",
        resultSetMapping = "Mapping.CustomDTO")
@SqlResultSetMapping(name = "Mapping.CustomDTO",
                     classes = @ConstructorResult(targetClass = CustomDTO.class,
                                                    columns = {@ColumnResult(name="first_name" ,type = String.class),
                                                               @ColumnResult(name="Mobile" ,type = String.class),
                                                               @ColumnResult(name="dept_name " ,type = String.class),
                                                               @ColumnResult(name="desination_details" ,type = String.class),
                                                               @ColumnResult(name="actual " ,type = Long.class)}))


@Table(name="employees")
public class Employee {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email_id")
    private String emailId;

    @Column(name="designation")
   /* @ManyToOne(fetch = FetchType.EAGER,optional = false)
    @JoinColumn(name = "designation")*/
    private String designation;

    @Column(name="exp")
    private Integer experience;

    @Column(name = "age")
    private Integer age;

    @Column(name = "city")
    private String city;

    @Column(name = "State")
    private String stat;

    @Column(name="Desk_Name")
    private String deskId;

    @Column(name="Mobile")
    private String mobileNo;

    @JsonIgnore
    @JoinColumn(name = "fk_Designation_Idd")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Designation designation1;

    @JsonIgnore
    @JoinColumn(name = "fk_paySlipNo")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Salary salary;

    @JsonIgnore
    @JoinColumn(name="fk_deptId")
    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Dept dept;

}
