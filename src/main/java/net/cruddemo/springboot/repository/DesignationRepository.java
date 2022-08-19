package net.cruddemo.springboot.repository;

import net.cruddemo.springboot.model.Designation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Qualifier("designation")
@Repository
public interface DesignationRepository extends JpaRepository<Designation,Long> {
}
