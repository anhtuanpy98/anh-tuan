package org.o7planning.model;

public class Account {
	private String username, password, query, method;
	
	public Account() {
		
	}

	

	public Account(String username, String password, String query, String method) {
		super();
		this.username = username;
		this.password = password;
		this.query = query;
		this.method = method;
	}



	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}



	public String getMethod() {
		return method;
	}



	public void setMethod(String method) {
		this.method = method;
	}
	
	
	
	

}
