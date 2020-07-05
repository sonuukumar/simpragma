package com.simpragma.trades.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")
public class Stock {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int id;
	@Column
	public String type;
	@Column
	public int shares;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid", referencedColumnName = "id")
	public User user;
	@Column
	public String symbol;
	@Column
	public double price;
	@Column
	public String timestamp;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getShares() {
		return shares;
	}
	public void setShares(int shares) {
		this.shares = shares;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}
