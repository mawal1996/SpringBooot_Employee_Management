package net.cruddemo.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Salary")
public class Salary {

    @Id
    @Column(name = "PaySlipNo")
    private long paySlipNo;

    @Column(name="CTC")
    private long ctc;

    @Column(name = "Actual")
    private long actual;

    @Column(name="Bonus")
    private long Bonus;

    @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "salary")
    private Employee employee;

}
