package com.bb.spring.beans;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="userlist")
public class UserList {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="first_name")
	@NotBlank
	private String name;
	
	@Column(name="last_name")
	@NotBlank
	private String last_name;
	
	@Column(name="email")
	@Email
	private String email;
	
	@Column(name="password")
	private String password;
	
	@OneToMany(mappedBy = "userList")
	@JsonIgnore
	private Set<InvoiceLines> invoiceLines;
	
	@OneToMany(mappedBy = "userList")
	@JsonIgnore
	private Set<Invoice> invoice;
	
	public UserList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserList(int id, @NotBlank String first_name, @NotBlank String last_name, @Email String email,
			String password, Set<InvoiceLines> invoiceLines, Set<Invoice> invoice) {
		super();
		this.id = id;
		this.name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.password = password;
		this.invoiceLines = invoiceLines;
		this.invoice = invoice;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String first_name) {
		this.name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<InvoiceLines> getInvoiceLines() {
		return invoiceLines;
	}

	public void setInvoiceLines(Set<InvoiceLines> invoiceLines) {
		this.invoiceLines = invoiceLines;
	}

	public Set<Invoice> getInvoice() {
		return invoice;
	}

	public void setInvoice(Set<Invoice> invoice) {
		this.invoice = invoice;
	}

	@Override
	public String toString() {
		return "UserList [id=" + id + ", first_name=" + name + ", last_name=" + last_name + ", email=" + email
				+ ", password=" + password + ", invoiceLines=" + invoiceLines + ", invoice=" + invoice + "]";
	}

	

}
