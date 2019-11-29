package com.custApp.model.persistance;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cust_data1")
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	@NotEmpty
	private String name;
	@NotEmpty
	private String address;
	@NotEmpty
	private String phone;
	@NotEmpty
	@Email
	private String email;
	
	@NotNull(message="date can not be null")
	@Past
	@DateTimeFormat(pattern="dd/MM/yyyy")//?
	@Temporal(TemporalType.DATE)
	private Date entryDate;
	private String type;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
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

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(String name, String address, String phone, String email) {

		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}
	
	public Customer() {

	}

	public Customer(int id, String name, String address, String phone, String email) {
	
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
	}

	public Customer(String name, String address, String phone, String email,
			Date entryDate, String type) {

		this.name = name;
		this.address = address;
		this.phone = phone;
		this.email = email;
		this.entryDate = entryDate;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", address=" + address
				+ ", phone=" + phone + ", email=" + email + ", entryDate="
				+ entryDate + "]";
	}
	
}

