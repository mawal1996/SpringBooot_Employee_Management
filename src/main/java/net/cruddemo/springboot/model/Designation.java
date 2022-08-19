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
@Table(name = "Designation")
public class Designation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="Designation_Idd")
    private long desigId;

    @Column(name="Desination_Details")
    private String desigDetails;

   @OneToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL,mappedBy = "designation1")
    private Employee employee;
}
