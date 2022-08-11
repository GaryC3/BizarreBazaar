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
@Table(name="gamelist")
public class GameList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="gameid")
	private int gameid;
	
	@Column(name="title")
	@NotBlank
	private String title;
	
	@Column(name="description")
	private String description;
	
	@Column(name="price")
	@PositiveOrZero
	private double price;
	
	@Column(name="inventory")
	@PositiveOrZero
	private int inventory;
	
	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "genre")
	private Discount discount;
	
	@OneToMany(mappedBy = "gameList")
	@JsonIgnore
	private Set<InvoiceLines> invoiceLines;
	
	@OneToMany(mappedBy = "gameList")
	@JsonIgnore
	private Set<Invoice> invoice;
	
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

	public Set<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoices(Set<Invoice> invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "GameList [gameid=" + gameid + ", title=" + title + ", description=" + description
				+ ", price=" + price + ", inventory=" + inventory + ", discount=" + discount + "]";
	}
	
	
	

}