package com.bb.spring.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Discount")
public class Discount {
	
	@Id
	@Column(name="Genre")
	private String genre;
	
	@Column(name="Discount")
	private double discount;

	public Discount() {
		super();
	}

	public Discount(String genre, double discount) {
		super();
		this.genre = genre;
		this.discount = discount;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Discount [genre=" + genre + ", discount=" + discount + "]";
	}
	
	

}
