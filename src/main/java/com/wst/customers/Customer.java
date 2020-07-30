package com.wst.customers;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Customer {

    private @Id @GeneratedValue Long id;
	private String firstName;
	private String lastName;
	private String address;
	
	private @Version @JsonIgnore Long version;

	// a manager can have multiple customers
	private @ManyToOne Manager manager;
	

    // private Customer() {}

    public Customer(String firstName, String lastName, String address, Manager manager) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.manager = manager;
    }
    
    @Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Customer customer = (Customer) o;
		return Objects.equals(id, customer.id) &&
			Objects.equals(firstName, customer.firstName) &&
			Objects.equals(lastName, customer.lastName) &&
			Objects.equals(address, customer.address) &&
			Objects.equals(version, customer.version) &&
			Objects.equals(manager, customer.manager);
	}
	
    @Override
	public int hashCode() {
		return Objects.hash(id, firstName, lastName, address, version, manager);
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
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	@Override
	public String toString() {
		return "Customer{" +
			"id=" + id +
			", firstName='" + firstName + '\'' +
			", lastName='" + lastName + '\'' +
			", address='" + address + '\'' +
			", version=" + version +
			", manager=" + manager +
			'}';
	}
    
}