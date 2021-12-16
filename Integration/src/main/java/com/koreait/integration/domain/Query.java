package com.koreait.integration.domain;

public class Query {
	
	private String column;
	private String query;
	
	public Query() {
		// TODO Auto-generated constructor stub
	}

	public Query(String column, String query) {
		super();
		this.column = column;
		this.query = query;
	}

	public String getColumn() {
		return column;
	}

	public void setColumn(String column) {
		this.column = column;
	}

	public String getQuery() {
		return query;
	}

	public void setQuery(String query) {
		this.query = query;
	}
	
	
	
	
}
