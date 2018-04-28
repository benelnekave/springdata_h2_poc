package com.ben.springdata_h2_poc.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
@Table(name = "customer")
@Entity
public class Customer {
	@JsonProperty
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
	 
    @JsonProperty
    @Column(name = "firstname")
    private String firstName;
    
    @JsonProperty
    @Column(name = "lastname")
    private String lastName;
    
    protected Customer() {}
    
    public Customer(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
    }
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


    @Override
    public String toString() {
        return String.format(
                "Customer[id=%d, firstName='%s', lastName='%s']",
                id, firstName, lastName);
    }

}
