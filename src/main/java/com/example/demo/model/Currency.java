package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CURRENCY_CONV")
public class Currency {

	private long id;
	private String country;    
	private String conversionfactor;
	

	public Currency() {

	}

	public Currency(String firstName, String lastName) {
		this.country = country;
		this.conversionfactor = conversionfactor;

	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	@Column
	public String getConversionfactor() {
		return conversionfactor;
	}

	public void setConversionfactor(String conversionfactor) {
		this.conversionfactor = conversionfactor;
	}
	 @Override
		public String toString() {
			return "Currency [id=" + id + ", country=" + country + ", conversionfactor=" + conversionfactor + "]";
		}

}