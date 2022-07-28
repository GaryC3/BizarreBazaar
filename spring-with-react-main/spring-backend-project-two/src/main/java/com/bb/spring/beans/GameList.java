package com.bb.spring.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="GameList")
public class GameList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GameId")
	private int gameid;
	
	@Column(name="Title")
	private String title;
	
	@Column(name="Genre")
	private String genre;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Price")
	private double price;
	
	@Column(name="Inventory")
	private int inventory;

	public GameList() {
		super();
	}

	public GameList(int gameid, String title, String genre, String description, double price, int inventory) {
		super();
		this.gameid = gameid;
		this.title = title;
		this.genre = genre;
		this.description = description;
		this.price = price;
		this.inventory = inventory;
	}

	public int getGameid() {
		return gameid;
	}

	public void setGameid(int gameid) {
		this.gameid = gameid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInventory() {
		return inventory;
	}

	public void setInventory(int inventory) {
		this.inventory = inventory;
	}

	@Override
	public String toString() {
		return "GameList [gameid=" + gameid + ", title=" + title + ", genre=" + genre + ", description=" + description
				+ ", price=" + price + ", inventory=" + inventory + "]";
	}
	
	
	

}