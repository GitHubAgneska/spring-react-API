package com.wst.clients;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Client {

    private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
    private String address;
    
    private Client() {}

    public Client(String firstName, String lastName, String address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
    }
    
    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Client client = (Client) o;
		return Objects.equals(id, client.id) &&
			Objects.equals(firstName, client.firstName) &&
			Objects.equals(lastName, client.lastName) &&
			Objects.equals(address, client.address);
	}
	
    @Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, address);
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

	public String getAddress() {
		return address;
    }
    
    public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Client{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", address='" + address + '\'' +
			'}';
	}
    


    
}