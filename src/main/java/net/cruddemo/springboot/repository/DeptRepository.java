package net.cruddemo.springboot.repository;

import net.cruddemo.springboot.dto.CustomDTO;
import net.cruddemo.springboot.model.Dept;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Qualifier("dept")
@Repository
public interface DeptRepository extends JpaRepository<Dept,Long> {


}
