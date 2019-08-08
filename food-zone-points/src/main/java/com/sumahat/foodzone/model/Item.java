package com.sumahat.foodzone.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Entity
@Table(name="item")
public class Item{
	
	private static Logger log =LoggerFactory.getLogger(Item.class);
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	@Column(name="item_id")
	private Long id;
	
	@Column(name="item_cuisine")
	private String style;
	
	@Column(name="item_type")
	private String type;
	
	@Column(name="item_name")
	private String name;
	
	@Column(name="item_cost")
    private BigDecimal cost;
	
	@ManyToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="restaurant_id")
	private Restaurant restaurant;
    
	@Column(name="item_servings")
	private Integer servings;
    
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Item() {
		super();
	}
	public Item(String style, String type, String name, BigDecimal cost,Restaurant res, Integer servings) {
		super();
		this.style = style;
		this.type = type;
		this.name = name;
		this.cost = cost;
		this.restaurant=res;
		this.servings=servings;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public BigDecimal getCost() {
		return cost;
	}
	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}
	public Integer getServings() {
		return servings;
	}
	public void setServings(Integer servings) {
		this.servings = servings;
	}


	
	
	
    
    
    

}
