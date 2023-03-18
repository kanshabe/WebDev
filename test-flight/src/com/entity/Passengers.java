package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="passengers")

public class Passengers {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
	protected int id;
	
	 @Column(name="first_Name")
	private String firstName;
	 
	 @Column(name="last_Name")
	private String lastName;
	 
	 @Column(name="age")
	private int age;
	 
	 @Column(name="gender")
	private String gender;
	
	 	 
	 @Embedded
		private FlightTicket flightTicket;
		
		@ManyToOne(cascade = {CascadeType.ALL}, fetch=FetchType.LAZY)
	    @JoinColumn(name = "flight_id")
	    private Flight flight;
	 


	public Passengers(String firstName, String lastName, int age, String gender) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		
		
	}

	public Passengers(int id, String firstName, String lastName, int age, String gender) {
	    super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		
	}
	
	public FlightTicket getFlightTicket() {
		return flightTicket;
	}

	public void setFlightTicket(FlightTicket flightTicket) {
		this.flightTicket = flightTicket;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	
	
	public Flight getFlight() {
		return flight;
	}


	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Passengers [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", gender=" + gender  + ", flightTicket=" + flightTicket
				+ ", flight=" + flight + "]";
	}
	
	
}
