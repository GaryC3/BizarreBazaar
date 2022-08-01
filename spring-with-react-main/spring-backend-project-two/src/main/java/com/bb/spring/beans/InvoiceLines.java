package com.bb.spring.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
	
	@Column(name ="Title")
	private String title;
	
	@Column(name="Price")
	private double price;
	
	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "Invoice_Id")
	private Invoice invoice;

	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "id")
	private UserList userList;
	
	public InvoiceLines() {
		super();
	}

	public InvoiceLines(int user_id, int line_id, int invoice_id, String title, double price) {
		super();
		this.user_id = user_id;
		this.line_id = line_id;
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
	

	public Invoice getInvoice() {
		return invoice;
	}

	public void setInvoice(Invoice invoice) {
		this.invoice = invoice;
	}

	public UserList getUserList() {
		return userList;
	}

	public void setUserList(UserList userList) {
		this.userList = userList;
	}

	@Override
	public String toString() {
		return "InvoiceLines [user_id=" + user_id + ", line_id=" + line_id + ", title="
				+ title + ", price=" + price + ", invoice=" + invoice + ", userList=" + userList + "]";
	}
	
	
	
	

}
