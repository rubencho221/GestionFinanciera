package com.udea.GestionFinanciera.Services;

import com.udea.GestionFinanciera.Entities.Enterprise;

import java.util.List;

public interface EnterpriseServiceI {

    public List<Enterprise> getEnterpriseAll();
    public String setEnterprise(Enterprise enterprise);
    public Enterprise getEnterpriseById(Long id) throws Exception;
    public Enterprise updateEnterprise(Enterprise enterprise, Long id) throws Exception;
    public String deleteEnterprise(Long id);
}
