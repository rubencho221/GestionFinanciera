package com.udea.GestionFinanciera.Services;

import com.udea.GestionFinanciera.Entities.Enterprise;
import com.udea.GestionFinanciera.Repositories.EnterpriseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnterpriseService implements EnterpriseServiceI {

    @Autowired
    private EnterpriseRepository repository;

    @Override
    public List<Enterprise> getEnterpriseAll() {
        return repository.findAll();
    }

    @Override
    public String setEnterprise(Enterprise enterprise) {
        repository.save(enterprise);
        return "Enterprise creada exitosamente";
}

    @Override
    public Enterprise getEnterpriseById(Long id) throws Exception {
        Optional<Enterprise> enterpriseBd = repository.findById(id);
        if (enterpriseBd.isPresent()){
            return enterpriseBd.get();
        }
        throw new Exception("Enterprise NO existe");
    }

    @Override
    public Enterprise updateEnterprise(Enterprise enterprise_update, Long id) throws Exception {
        Enterprise enterpriseBd = getEnterpriseById(id);
        if (enterprise_update.getName() != null && !enterprise_update.getName().equals("")){
            enterpriseBd.setName(enterprise_update.getName());
        }
        if (enterprise_update.getDocument() != null && !enterprise_update.getDocument().equals("")){
            enterpriseBd.setDocument(enterprise_update.getDocument());
        }
        if (enterprise_update.getAddress() != null && !enterprise_update.getAddress().equals("")){
            enterpriseBd.setAddress(enterprise_update.getAddress());
        }
        if (enterprise_update.getPhone() != null && !enterprise_update.getPhone().equals("")){
            enterpriseBd.setPhone(enterprise_update.getPhone());
        }
        if (enterprise_update.getUpdatedAt() != null && !enterprise_update.getUpdatedAt().equals("")){
            enterpriseBd.setUpdatedAt(enterprise_update.getUpdatedAt());
        }
        return repository.save(enterpriseBd);
    }

    @Override
    public String deleteEnterprise(Long id) {
        repository.deleteById(id);
        return "Enterprise eliminada exitosamente";
    }
}
