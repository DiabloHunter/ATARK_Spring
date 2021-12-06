/*
package com.my.atark.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;


@Entity
@Table(name = "invoices")
public class Payment implements Serializable {
    @Id
    @GeneratedValue
    private Integer paymentId;
    @Column(nullable = false)
    @OneToOne(targetEntity = Invoice.class, mappedBy = "invoiceCode", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Long invoiceCode;
    @Column(nullable = false)
    @OneToOne(targetEntity = Product.class, mappedBy = "productCode", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private String productCode;
    @Column(nullable = false)
    private Double quantity;
    @Column(nullable = false)
    private Double paymentValue;
    @Column(nullable = false)
    @OneToOne(targetEntity = InvoiceStatuses.class, mappedBy = "invoiceStatus", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private InvoiceStatuses statusId;
    private String paymentNotes;

    public Payment() {
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public Long getOrderCode() {
        return invoiceCode;
    }

    public String getProductCode() {
        return productCode;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getPaymentValue() {
        return paymentValue;
    }

    public InvoiceStatus getStatusId() {
        return statusId;
    }

    public String getPaymentNotes() {
        return paymentNotes;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public void setOrderCode(Long orderCode) {
        this.invoiceCode = orderCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public void setPaymentValue(Double paymentValue) {
        this.paymentValue = paymentValue;
    }

    public void setStatusId(InvoiceStatus statusId) {
        this.statusId = statusId;
    }

    public void setPaymentNotes(String paymentNotes) {
        this.paymentNotes = paymentNotes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Payment)) return false;

        Payment payment = (Payment) o;

        if (paymentId != null ? !paymentId.equals(payment.paymentId) : payment.paymentId != null) return false;
        return invoiceCode.equals(payment.invoiceCode);
    }

    @Override
    public int hashCode() {
        int result = paymentId != null ? paymentId.hashCode() : 0;
        result = 31 * result + invoiceCode.hashCode();
        return result;
    }

}
*/
