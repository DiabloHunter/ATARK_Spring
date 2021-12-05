package com.my.atark.controller;

import com.my.atark.domain.Invoice;
import com.my.atark.domain.Payment;
import com.my.atark.domain.Product;
import com.my.atark.exceptions.InvalidValueException;
import com.my.atark.exceptions.ProductServiceException;
import com.my.atark.service.IInvoiceServ;
import com.my.atark.service.IPaymentServ;
import com.my.atark.service.IProductServ;
import com.my.atark.service.ServiceFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;


@RestController
@RequestMapping(path = "api/payments")
public class PaymentController {

    @PostMapping
    public void addPayment(@RequestBody Payment payment) {
        IPaymentServ serv = ServiceFactory.getPaymentService();
        serv.addPayment(payment);
    }

}
