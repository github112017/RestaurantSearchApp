package com.sumahat.foodzone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="payment_status_def")
public class PaymentStatusDef {

	@Id
	@Column(name="payment_status")
	private String paymentStatus;
	
	@Column(name="payment_status_desc")
	private String paymentStatusDesc;

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public String getPaymentStatusDesc() {
		return paymentStatusDesc;
	}

	public void setPaymentStatusDesc(String paymentStatusDesc) {
		this.paymentStatusDesc = paymentStatusDesc;
	}
	
	
	
	
}
