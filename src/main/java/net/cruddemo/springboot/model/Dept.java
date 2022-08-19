package net.cruddemo.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.cruddemo.springboot.dto.CustomDTO;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
/*@NamedNativeQueries({@NamedNativeQuery(
        name = "Dept.findDeptDto",
        query ="select e.mobile,e.first_Name,d.dept_name,t.desination_details,s.actual from employees e join dept d on e.fk_dept_id=d.deptid Join designation t on e.fk_designation_idd=t.designation_idd join salary s on e.fk_pay_slip_no=s.pay_slip_no ",
        resultSetMapping = "Mapping.CustomDTO"),
        @NamedNativeQuery(
                name = "Dept.findDeptDto1",
                query ="select e.mobile,e.first_Name,d.dept_name,t.desination_details,s.actual from employees e join dept d on e.fk_dept_id=d.deptid Join designation t on e.fk_designation_idd=t.designation_idd join salary s on e.fk_pay_slip_no=s.pay_slip_no ",
                resultSetMapping = "Mapping.CustomDTO")})

@SqlResultSetMapping(name = "Mapping.CustomDTO",
        classes = @ConstructorResult(targetClass = CustomDTO.class,
                columns = {@ColumnResult(name="first_name" ,type = String.class),
                        @ColumnResult(name="Mobile" ,type = String.class),
                        @ColumnResult(name="dept_name " ,type = String.class),
                        @ColumnResult(name="desination_details" ,type = String.class),
                        @ColumnResult(name="actual " ,type = Long.class)}))*/

@Table(name = "Dept")
public class Dept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="DeptID")
    private long deptId;

    @Column(name = "DeptName")
    private String deptName;

    @Column(name="DeptDetails")
    private String deptDetails;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "dept")
    private Employee employee;
}
