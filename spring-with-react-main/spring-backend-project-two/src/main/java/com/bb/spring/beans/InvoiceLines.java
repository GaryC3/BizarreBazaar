package com.bb.spring.beans;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="InvoiceLines")
public class InvoiceLines {
	
	@Id
	@Column(name ="UserId")
	private int user_id;
	
	@Column(name ="line_id")
	private int line_id;
	
	@Column(name="Invoice_Id")
	private int invoice_id;
	
	@Column(name ="Title")
	private String title;
	
	@Column(name="Price")
	private double price;

	public InvoiceLines() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InvoiceLines(int user_id, int line_id, int invoice_id, String title, double price) {
		super();
		this.user_id = user_id;
		this.line_id = line_id;
		this.invoice_id = invoice_id;
		this.title = title;
		this.price = price;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getLine_id() {
		return line_id;
	}

	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}

	public int getInvoice_id() {
		return invoice_id;
	}

	public void setInvoice_id(int invoice_id) {
		this.invoice_id = invoice_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "InvoiceLines [user_id=" + user_id + ", line_id=" + line_id + ", invoice_id=" + invoice_id + ", title="
				+ title + ", price=" + price + "]";
	}
	
	
	
	

}