package com.example.demo.model;

public class ResponseStatus {
	
	private String status;
	private String errmsg;
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public ResponseStatus(String status,String errmsg){
		this.status=status;
		this.errmsg = errmsg;
		
	}

}
