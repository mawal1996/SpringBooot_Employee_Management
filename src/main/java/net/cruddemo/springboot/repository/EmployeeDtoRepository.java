package net.cruddemo.springboot.repository;

import net.cruddemo.springboot.model.EmployeeDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("employeedt")
@Repository
public interface EmployeeDtoRepository extends JpaRepository<EmployeeDto,Long> {
}
