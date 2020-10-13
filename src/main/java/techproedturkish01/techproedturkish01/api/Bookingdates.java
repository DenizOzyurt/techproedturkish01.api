package techproedturkish01.techproedturkish01.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Bookingdates {

	
	/*
		POJO: Plain Old Java Object
		      We will create Pojo Classes by using our Json Format then
		      we will create objects from Pojo Classes and use them in test scripts
		      
		POJO Classes have 1)private variables 2)getter() and setter() 3)Constructor with all parameters
		                  4)Constructor without parameter 5)toString()      
	*/


@SerializedName("checkin")
@Expose
private String checkin;
@SerializedName("checkout")
@Expose
private String checkout;

public String getCheckin() {
return checkin;
}

public void setCheckin(String checkin) {
this.checkin = checkin;
}

public String getCheckout() {
return checkout;
}

public void setCheckout(String checkout) {
this.checkout = checkout;
}

public Bookingdates(String checkin, String checkout) {
	this.checkin = checkin;
	this.checkout = checkout;
}

public Bookingdates() {
	
}

@Override
public String toString() {
	return "Bookingdates [checkin=" + checkin + ", checkout=" + checkout + "]";
}


}
