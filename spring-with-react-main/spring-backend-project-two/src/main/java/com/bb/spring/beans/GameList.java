package com.bb.spring.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.executable.ValidateOnExecution;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="GameList")
public class GameList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="GameId")
	private int gameid;
	
	@Column(name="Title")
	@NotBlank
	private String title;
	
	@Column(name="Description")
	private String description;
	
	@Column(name="Price")
	@PositiveOrZero
	private double price;
	
	@Column(name="Inventory")
	@PositiveOrZero
	private int inventory;
	
	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "Genre")
	private Discount discount;
	
	@OneToMany(mappedBy = "game")
	@JsonIgnore
	private Set<Invoice> invoices;
	
	public GameList() {
		super();
	}

	public GameList(int gameid, String title, String genre, String description, double price, int inventory) {
		super();
		this.gameid = gameid;
		this.title = title;
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
	

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	public Set<Invoice> getInvoices() {
		return invoices;
	}

	public void setInvoices(Set<Invoice> invoices) {
		this.invoices = invoices;
	}

	@Override
	public String toString() {
		return "GameList [gameid=" + gameid + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", inventory=" + inventory + ", discount=" + discount + "]";
	}
	
	
	

}