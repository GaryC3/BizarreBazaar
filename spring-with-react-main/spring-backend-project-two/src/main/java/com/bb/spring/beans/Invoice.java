package com.bb.spring.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Invoice_Id")
	private int invoice_id;
	
	@Column(name="Title")
	private String title;

	public Invoice() {
		super();
	}

	public Invoice(int invoice_id, String title) {
		super();
		this.invoice_id = invoice_id;
		this.title = title;
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

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", title=" + title + "]";
	}
	
	

}
