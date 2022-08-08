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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Invoice_Id")
	private int invoice_id;
	
//	@OneToMany(mappedBy = "invoice")
//	@JsonIgnore
//	private Set<InvoiceLines> invoiceLines;
	
	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "id")
	private UserList userList;
	
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
	
//	@Column(name="Inventory")
//	@PositiveOrZero
//	private int inventory;
	
	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "Genre")
	private Discount discount;
	
//	@OneToMany(mappedBy = "game")
//	@JsonIgnore
//	private Set<Invoice> invoices;
	
	public Invoice() {
		super();
	}

	public Invoice(int invoice_id, UserList userList, int gameid, @NotBlank String title, String description,
			@PositiveOrZero double price, Discount discount) {
		super();
		this.invoice_id = invoice_id;
		this.userList = userList;
		this.gameid = gameid;
		this.title = title;
		this.description = description;
		this.price = price;
		this.discount = discount;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public UserList getUserList() {
		return userList;
	}

	public void setUserList(UserList userList) {
		this.userList = userList;
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

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", gameid=" + gameid + ", title=" + title + ", description="
				+ description + ", price=" + price + "]";
	}
	
		
		
	

}
