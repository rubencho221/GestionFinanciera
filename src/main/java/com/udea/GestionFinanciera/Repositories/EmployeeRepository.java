package com.udea.GestionFinanciera.Repositories;

import com.udea.GestionFinanciera.Entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    /*@Modifying
    @Query("UPDATE Employee e SET e.email = :email, e.updatedAt = :updatedAt WHERE e.id = :id")
    public int update(String email, Date updatedAt, Long id);*/
}
