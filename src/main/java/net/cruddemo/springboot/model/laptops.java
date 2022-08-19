package net.cruddemo.springboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@Setter

public class laptops {
    private int id;
    private String laptopName;
}
