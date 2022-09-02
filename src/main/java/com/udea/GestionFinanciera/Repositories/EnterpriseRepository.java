package com.udea.GestionFinanciera.Repositories;

import com.udea.GestionFinanciera.Entities.Enterprise;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface EnterpriseRepository extends JpaRepository<Enterprise, Long> {

    /*@Modifying
    @Query("UPDATE Enterprise e SET e.name = :name, e.document = :document, e.phone = :phone, e.address = :address, e.updatedAt =:updatedAt WHERE e.id = :id ")
    public int update(String name, String document, String phone, String address, Date updatedAt, Long id);*/
}
