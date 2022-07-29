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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Invoice")
public class Invoice {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Invoice_Id")
	private int invoice_id;
	
	@Column(name="Title")
	private String title;
	
	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "Title")
	private GameList game;

	@OneToMany(mappedBy = "invoice")
	@JsonIgnore
	private Set<InvoiceLines> invoiceLines;
	
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
	

	public GameList getGame() {
		return game;
	}

	public void setGame(GameList game) {
		this.game = game;
	}

	public Set<InvoiceLines> getInvoiceLines() {
		return invoiceLines;
	}

	public void setInvoiceLines(Set<InvoiceLines> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	@Override
	public String toString() {
		return "Invoice [invoice_id=" + invoice_id + ", title=" + title + ", game=" + game + "]";
	}
	
	

}
