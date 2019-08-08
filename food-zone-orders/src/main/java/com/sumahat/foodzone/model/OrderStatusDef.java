package com.sumahat.foodzone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="order_status_def")
public class OrderStatusDef {
	
	@Id
	@Column(name="order_status")
	private String orderStatus;
	
	@Column(name="order_status_desc")
	private String orderStatusDesc;

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getOrderStatusDesc() {
		return orderStatusDesc;
	}

	public void setOrderStatusDesc(String orderStatusDesc) {
		this.orderStatusDesc = orderStatusDesc;
	}
	
	
	

}
