package techproedturkish01.techproedturkish01.api;


/*
 {
    "firstname": "Jim",
    "lastname": "Ericsson",
    "totalprice": 562,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2019-04-10",
        "checkout": "2020-02-23"
    },
    "additionalneeds": "Breakfast"
}
 */
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trpojo1 {

@SerializedName("firstname")
@Expose
private String firstname;
@SerializedName("lastname")
@Expose
private String lastname;
@SerializedName("totalprice")
@Expose
private Integer totalprice;
@SerializedName("depositpaid")
@Expose
private Boolean depositpaid;
@SerializedName("bookingdates")
@Expose
private Trpojo11 trpojo11;
@SerializedName("additionalneeds")
@Expose
private String additionalneeds;

public String getFirstname() {
return firstname;
}

public void setFirstname(String firstname) {
this.firstname = firstname;
}

public String getLastname() {
return lastname;
}

public Trpojo11 getTrpojo11() {
	return trpojo11;
}

public void setTrpojo11(Trpojo11 trpojo11) {
	this.trpojo11 = trpojo11;
}

public void setLastname(String lastname) {
this.lastname = lastname;
}

public Integer getTotalprice() {
return totalprice;
}

public void setTotalprice(Integer totalprice) {
this.totalprice = totalprice;
}

public Boolean getDepositpaid() {
return depositpaid;
}

public void setDepositpaid(Boolean depositpaid) {
this.depositpaid = depositpaid;
}



public String getAdditionalneeds() {
return additionalneeds;
}

public void setAdditionalneeds(String additionalneeds) {
this.additionalneeds = additionalneeds;
}

public Trpojo1(String firstname, String lastname, Integer totalprice, Boolean depositpaid, Trpojo11 bookingdates,
		String additionalneeds) {
	
	this.firstname = firstname;
	this.lastname = lastname;
	this.totalprice = totalprice;
	this.depositpaid = depositpaid;
	this.trpojo11 = trpojo11;
	this.additionalneeds = additionalneeds;
}

public Trpojo1() {
	
}

@Override
public String toString() {
	return "Trpojo1 [firstname=" + firstname + ", lastname=" + lastname + ", totalprice=" + totalprice
			+ ", depositpaid=" + depositpaid + ", trpojo11=" + trpojo11 + ", additionalneeds=" + additionalneeds
			+ "]";
}

}