package com.sumahat.foodzone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="packer")
public class Packer {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="packer_id")
	private Long id;
	
	@Column(name="packer_name")
	private String Name;
	
	@Column(name="packer_email")
	private String emailId;

	@Column(name="packer_mobile")
	private String mobile;
	
	@Column(name="packer_capacity")
	private Integer capacity;
	
	@Column(name="is_active")
	private String isActive;
	
	@Column(name="rating")
	private Integer rating;
	
	@OneToMany(mappedBy = "packer")
	List<PackerAssignedOrder> assignedOrders;
	
	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public Long getId() {
		return id;
	}

	public List<PackerAssignedOrder> getAssignedOrders() {
		return assignedOrders;
	}

	public void setAssignedOrders(List<PackerAssignedOrder> assignedOrders) {
		this.assignedOrders = assignedOrders;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		emailId = emailId;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String isActive() {
		return isActive;
	}

	public void setActive(String isActive) {
		this.isActive = isActive;
	}
	
	
	
	
	
}
