package com.udea.GestionFinanciera.Services;

import com.udea.GestionFinanciera.Entities.Enterprise;
import com.udea.GestionFinanciera.Entities.Transaction;

public interface TransactionServiceI {

    public Transaction getTransactionByIdEnterprise(Enterprise enterprise);
}
