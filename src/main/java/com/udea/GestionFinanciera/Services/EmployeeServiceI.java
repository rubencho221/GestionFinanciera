package com.udea.GestionFinanciera.Services;

import com.udea.GestionFinanciera.Entities.Employee;
import com.udea.GestionFinanciera.Entities.Enterprise;

import java.util.List;

public interface EmployeeServiceI {

    public List<Employee> getEmployeeAll();
    public String setEmployee(Employee employee);
    public Employee getEmployeeById(Long id) throws Exception;
    public Employee updateEmployee(Employee employee, Long id) throws Exception;
    public String deleteEmployee(Long id);


}
