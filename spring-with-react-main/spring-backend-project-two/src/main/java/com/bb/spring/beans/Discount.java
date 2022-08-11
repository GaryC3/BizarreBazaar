package com.bb.spring.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="discount")
public class Discount {
	
	@Id
	@Column(name="genre")
	@javax.validation.constraints.NotNull
	private String genre;
	
	@Column(name="discount")
	@javax.validation.constraints.PositiveOrZero
	private double discount;

	@OneToMany(mappedBy = "discount")
	@JsonIgnore
	private Set<GameList> games;
	
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

	public Set<GameList> getGames() {
		return games;
	}

	public void setGames(Set<GameList> games) {
		this.games = games;
	}

	@Override
	public String toString() {
		return "Discount [genre=" + genre + ", discount=" + discount + "]";
	}
	
	

}
