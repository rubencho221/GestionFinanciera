package com.udea.GestionFinanciera.Controllers;

import com.udea.GestionFinanciera.Entities.Employee;
import com.udea.GestionFinanciera.Entities.Enterprise;
import com.udea.GestionFinanciera.Entities.ObjetoRespuesta;
import com.udea.GestionFinanciera.Services.EmployeeServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeServiceI employeeServiceI;

    @GetMapping("/employee")
    public ResponseEntity<List<Employee>> getEmployee() {
        return new ResponseEntity<>(employeeServiceI.getEmployeeAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/employee")
    public ResponseEntity<String> postEmployee(@RequestBody Employee employee) {
        try {
            String mensaje = employeeServiceI.setEmployee(employee);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<Object> getEmployeeById(@RequestParam Long id) {
        try {
            Employee employee = employeeServiceI.getEmployeeById(id);
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/employee/{id}")
    public ResponseEntity<ObjetoRespuesta> pathEnterprise(@RequestBody Employee employee_update, @PathVariable Long id) {
        try {
            Employee employee_bd = employeeServiceI.updateEmployee(employee_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", employee_bd), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEmployee(@PathVariable Long id) {
        try {
            String mensaje = employeeServiceI.deleteEmployee(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje, null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
