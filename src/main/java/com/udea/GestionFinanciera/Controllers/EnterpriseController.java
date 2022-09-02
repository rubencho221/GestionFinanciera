package com.udea.GestionFinanciera.Controllers;

import com.udea.GestionFinanciera.Entities.Enterprise;
import com.udea.GestionFinanciera.Entities.ObjetoRespuesta;
import com.udea.GestionFinanciera.Services.EnterpriseServiceI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class EnterpriseController {

    @Autowired
    private EnterpriseServiceI enterpriseServiceI;

    @GetMapping("/enterprise")
    public ResponseEntity<List<Enterprise>> getEnterpriseAll() {
        return new ResponseEntity<>(enterpriseServiceI.getEnterpriseAll(), HttpStatus.ACCEPTED);
    }

    @PostMapping("/enterprise")
    public ResponseEntity<String> postEnterprise(@RequestBody Enterprise enterprise) {
        try {
            String mensaje = enterpriseServiceI.setEnterprise(enterprise);
            return new ResponseEntity<>(mensaje, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/enterprise/{id}")
    public ResponseEntity<Object> getEnterpriseById(@RequestParam Long id) {
        try {
            Enterprise enterprise = enterpriseServiceI.getEnterpriseById(id);
            return new ResponseEntity<>(enterprise, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/enterprise/{id}")
    public ResponseEntity<ObjetoRespuesta> pathEnterprise(@RequestBody Enterprise enterprise_update, @PathVariable Long id) {
        try {
            Enterprise enterprise_bd = enterpriseServiceI.updateEnterprise(enterprise_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa", enterprise_bd), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/enterprise/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteEnterprise(@PathVariable Long id) {
        try {
            String mensaje = enterpriseServiceI.deleteEnterprise(id);
            return new ResponseEntity<>(new ObjetoRespuesta(mensaje, null), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(), null), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
