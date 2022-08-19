package net.cruddemo.springboot.repository;

import net.cruddemo.springboot.model.Salary;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("salary")
@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {
}
