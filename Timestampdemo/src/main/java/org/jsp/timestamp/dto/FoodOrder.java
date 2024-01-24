package org.jsp.timestamp.dto;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class FoodOrder {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String food_item;
	private String Location;
	private double cost;
	@CreationTimestamp
	private LocalDateTime order_time;
	@UpdateTimestamp
	private LocalDateTime delivery_time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFood_item() {
		return food_item;
	}
	public void setFood_item(String food_item) {
		this.food_item = food_item;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public LocalDateTime getOrder_time() {
		return order_time;
	}
	public void setOrder_time(LocalDateTime order_time) {
		this.order_time = order_time;
	}
	public LocalDateTime getDelivery_time() {
		return delivery_time;
	}
	public void setDelivery_time(LocalDateTime delivery_time) {
		this.delivery_time = delivery_time;
	}
	
}
