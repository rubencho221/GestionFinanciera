package com.udea.GestionFinanciera.Services;

import com.udea.GestionFinanciera.Entities.Employee;
import com.udea.GestionFinanciera.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService implements EmployeeServiceI {

    @Autowired
    private EmployeeRepository repository;


    @Override
    public List<Employee> getEmployeeAll() {
        return repository.findAll();
    }

    @Override
    public String setEmployee(Employee employee) {
        repository.save(employee);
        return "Employee creado exitosamente";
    }

    @Override
    public Employee getEmployeeById(Long id) throws Exception {
        Optional<Employee> employeeBd = repository.findById(id);
        if (employeeBd.isPresent()) {
            return employeeBd.get();
        }
        throw new Exception("Employee NO existe");
    }

    @Override
    public Employee updateEmployee(Employee employee_update, Long id) throws Exception {
        Employee employeeBd = getEmployeeById(id);
        if (employee_update.getEmail() != null && !employee_update.getEmail().equals("")) {
            employeeBd.setEmail(employee_update.getEmail());
        }
        if (employee_update.getUpdateAt() != null && !employee_update.getUpdateAt().equals("")) {
            employeeBd.setUpdateAt(employee_update.getUpdateAt());
        }
        return repository.save(employee_update);
    }

    @Override
    public String deleteEmployee(Long id) {
        repository.deleteById(id);
        return "Employee eliminado exitosamente";
    }
}
