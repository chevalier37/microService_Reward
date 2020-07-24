package com.tourguide.model;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

public class UserPreferences {

	private int attractionProximity = Integer.MAX_VALUE;
	private CurrencyUnit currency = Monetary.getCurrency("USD");

	private int tripDuration = 1;
	private int ticketQuantity = 1;
	private int numberOfAdults = 1;
	private int numberOfChildren = 0;
	/*
	 * private int tripDuration; private int ticketQuantity; private int
	 * numberOfAdults; private int numberOfChildren;
	 */

	public UserPreferences() {
	}

	/*
	 * public UserPreferences(int tripDuration, int ticketQuantity, int
	 * numberOfAdults, int numberOfChildren) { this.tripDuration = tripDuration;
	 * this.ticketQuantity = ticketQuantity; this.numberOfAdults = numberOfAdults;
	 * this.numberOfChildren = numberOfChildren; }
	 */

	public void setAttractionProximity(int attractionProximity) {
		this.attractionProximity = attractionProximity;
	}

	public int getAttractionProximity() {
		return attractionProximity;
	}

	public int getTripDuration() {
		return tripDuration;
	}

	public void setTripDuration(int tripDuration) {
		this.tripDuration = tripDuration;
	}

	public int getTicketQuantity() {
		return ticketQuantity;
	}

	public void setTicketQuantity(int ticketQuantity) {
		this.ticketQuantity = ticketQuantity;
	}

	public int getNumberOfAdults() {
		return numberOfAdults;
	}

	public void setNumberOfAdults(int numberOfAdults) {
		this.numberOfAdults = numberOfAdults;
	}

	public int getNumberOfChildren() {
		return numberOfChildren;
	}

	public void setNumberOfChildren(int numberOfChildren) {
		this.numberOfChildren = numberOfChildren;
	}

}
