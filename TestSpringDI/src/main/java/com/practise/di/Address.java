package com.practise.di;

public class Address {
	private String addressLine1, streetno, pin, city, state, country;

	public Address(String addressLine1, String streetno, String pin, String city, String state, String country) {
		super();
		this.addressLine1 = addressLine1;
		this.streetno = streetno;
		this.pin = pin;
		this.city = city;
		this.state = state;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Address [addressLine1=" + addressLine1 + ", streetno=" + streetno + ", pin=" + pin + ", city=" + city
				+ ", state=" + state + ", country=" + country + "]";
	}
}
