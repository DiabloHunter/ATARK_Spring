package com.my.atark.entities;

import javax.persistence.*;

@Entity
@Table(name = "invoice_status")
public class InvoiceStatuses {
    @Id
    @GeneratedValue
    private Integer statusId;
    @Column(nullable = false)
    private String statusDescription;
}
