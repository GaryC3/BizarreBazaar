package com.bb.spring.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="invoicelines")
public class InvoiceLines {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="line_id")
	private int line_id;
	
	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "gameid")
	private GameList gameList;

	@ManyToOne // DO NOT use Eager unless you 100% ALWAYS need the child record
	@JoinColumn(name = "id")
	private UserList userList;

	
	public InvoiceLines() {
		super();
	}


	public InvoiceLines(int line_id, GameList gameList, UserList userList) {
		super();
		this.line_id = line_id;
		this.gameList = gameList;
		this.userList = userList;
	}


	public int getLine_id() {
		return line_id;
	}


	public void setLine_id(int line_id) {
		this.line_id = line_id;
	}


	public GameList getGameList() {
		return gameList;
	}


	public void setGameList(GameList gameList) {
		this.gameList = gameList;
	}


	public UserList getUserList() {
		return userList;
	}


	public void setUserList(UserList userList) {
		this.userList = userList;
	}


	@Override
	public String toString() {
		return "InvoiceLines [line_id=" + line_id + "]";
	}

	

	
	
	
	

}
