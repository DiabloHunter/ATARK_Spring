package com.my.atark.entities;


import javax.annotation.processing.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "invoices")
public class Invoice implements Serializable {
    @Id
    @GeneratedValue
    private Integer invoiceId;
    @Column(nullable = false)
    private Long invoiceCode;
    private String userName;
    @Column(nullable = false)
    private Boolean isPaid;
    @Column(nullable = false)
    private InvoiceStatus status;
    private Timestamp date;
    private String invoiceNotes;




    /** Getters */

    public Integer getInvoiceId() {
        return invoiceId;
    }

    public Long getInvoiceCode() {
        return invoiceCode;
    }

    public String getUserName() {
        return userName;
    }

    public Boolean getPaid() {
        return isPaid;
    }

    public InvoiceStatus getStatus() {
        return status;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getInvoiceNotes() {
        return invoiceNotes;
    }


    /** Setters */

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    public void setInvoiceCode(Long invoiceCode) {
        this.invoiceCode = invoiceCode;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    public void setStatus(InvoiceStatus status) {
        this.status = status;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public void setInvoiceNotes(String invoiceNotes) {
        this.invoiceNotes = invoiceNotes;
    }

}
