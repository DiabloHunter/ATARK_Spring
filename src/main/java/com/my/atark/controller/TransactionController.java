package com.my.atark.controller;


import com.my.atark.domain.Product;
import com.my.atark.domain.Transaction;
import com.my.atark.domain.TransactionType;
import com.my.atark.exceptions.ProductServiceException;
import com.my.atark.exceptions.TransactionServiceException;
import com.my.atark.service.IProductServ;
import com.my.atark.service.ITransactionServ;
import com.my.atark.service.ServiceFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "api/transactions")
public class TransactionController {

    @GetMapping(path = "allTransactions")
    public List<Transaction> allTransaction() {
        List<Transaction> result = null;
        try {
            ITransactionServ transactionServ = ServiceFactory.getTransactionService();
            result = transactionServ.findAllTransactions();
        }
        catch (TransactionServiceException e) {
            e.printStackTrace();
        }
        return result;
    }

    @GetMapping(path = "type={type}")
    public List<Transaction> allTransactionByType(@PathVariable("type") String type) {
        ITransactionServ serv = ServiceFactory.getTransactionService();
        List<Transaction> transactions = new LinkedList<>();
        if (type.equals("all")) {
            try {
                transactions = serv.findAllTransactions();
            } catch (TransactionServiceException e) {
                e.printStackTrace();
            }
        }
        try {
            if (type.equals("payment"))
                transactions = serv.findAllTransactionsByType(TransactionType.PAYMENT);
            if (type.equals("refund"))
                transactions = serv.findAllTransactionsByType(TransactionType.REFUND);
        } catch (TransactionServiceException e) {
            e.printStackTrace();
        }
        return transactions;
    }
}
