package com.udea.GestionFinanciera.Services;

import com.udea.GestionFinanciera.Entities.Enterprise;
import com.udea.GestionFinanciera.Entities.Transaction;
import com.udea.GestionFinanciera.Repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService implements TransactionServiceI {

    @Autowired
    private TransactionRepository repository;

    @Override
    public Transaction getTransactionByIdEnterprise(Enterprise enterprise) {

        return null;
    }
}
