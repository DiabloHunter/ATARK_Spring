package com.my.atark.controller;


import com.my.atark.domain.Invoice;
import com.my.atark.domain.Product;
import com.my.atark.exceptions.ProductServiceException;
import com.my.atark.service.IInvoiceServ;
import com.my.atark.service.IProductServ;
import com.my.atark.service.ServiceFactory;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping(path = "api/invoices")
public class InvoiceController {

    @GetMapping(path = "allInvoices")
    public List<Invoice> allInvoices() {
        IInvoiceServ invoiceServ = ServiceFactory.getInvoiceService();
        List<Invoice> result = invoiceServ.findAllInvoices();
        return result;
    }

    @GetMapping(path = "allInvoices/from={from}&offset={offset}")
    public  List<Invoice> invoiceOffset(@PathVariable("from") String from, @PathVariable("offset") String offset) {
        IInvoiceServ invoiceServ = ServiceFactory.getInvoiceService();
        List<Invoice> result = invoiceServ.findInvoices(Integer.parseInt(from),Integer.parseInt(offset));
        return result;
    }

    @GetMapping(path = "{user}")
    public List<Invoice> invoiceByUser(@PathVariable("user") String user) {
        IInvoiceServ invoiceServ = ServiceFactory.getInvoiceService();
        List<Invoice> result = invoiceServ.findInvoicesByUser(user);
        return result;
    }

    @GetMapping(path = "filter={filter}")
    public List<Invoice> filterInvoices(@PathVariable("filter") String sort) {
        IInvoiceServ serv = ServiceFactory.getInvoiceService();
        List<Invoice> invoices = new LinkedList<>();
        if (sort.equals("all"))
            invoices = serv.findAllInvoices();
        if (sort.equals("new"))
            invoices = serv.findNewInvoices();
        if (sort.equals("cancelled"))
            invoices = serv.findCancelledInvoices();
        if (sort.equals("closed"))
            invoices = serv.findFinishedInvoices();
        return invoices;
    }

   /* findInvoiceByOrderNumber*/



    @PostMapping
    public void addInvoice(@RequestBody  Invoice invoice) {
        IInvoiceServ invoiceServ = ServiceFactory.getInvoiceService();
        invoiceServ.addInvoice(invoice);
    }

    @PutMapping(path = "{code}")
    public void updateInvoice() {
        IInvoiceServ invoiceServ = ServiceFactory.getInvoiceService();
        Invoice invoice = new Invoice();
        invoiceServ.updateInvoice(invoice);
    }

    @DeleteMapping(path = "{code}")
    public void deleteInvoice(@PathVariable("code") String code) {
        IInvoiceServ invoiceServ = ServiceFactory.getInvoiceService();
        invoiceServ.deleteInvoice(Long.parseLong(code));
    }
}
