package com.entity;

import java.security.SecureRandom;

import javax.persistence.Embeddable;

@Embeddable

public class FlightTicket {
	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();

	private String randomString(int len){
	   StringBuilder sb = new StringBuilder(len);
	   for(int i = 0; i < len; i++)
	      sb.append(AB.charAt(rnd.nextInt(AB.length())));
	   return sb.toString();
	}
	
	private String flight_ticket = randomString(20);
	
	public FlightTicket() {
	
	}

	public String getFlight_ticket() {
		return flight_ticket;
	}

	public void setFlight_ticket(String flight_ticket) {
		this.flight_ticket = flight_ticket;
	}


}
