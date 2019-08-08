package com.sumahat.foodzone.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
    
	@Column(name="user_name")
	private String Name;
    
    @Column(name="user_email")
	private String email;
    
    @Column(name="user_mobile")
	private String mobile;
	
    @Column(name="user_address")
    private String address;
    
    @Column(name="user_city")
	private String city;
	
    @Column(name="user_pincode")
	private String pincode;
	
    @OneToMany
    @JoinColumn(name="user_id")
	List<Order> orders;
	
    
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	
	
	
}
