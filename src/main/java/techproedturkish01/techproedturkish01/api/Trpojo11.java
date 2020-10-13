package techproedturkish01.techproedturkish01.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Trpojo11 {

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

public Trpojo11(String checkin, String checkout) {

	this.checkin = checkin;
	this.checkout = checkout;
}

public Trpojo11() {
	
}

@Override
public String toString() {
	return "Trpojo11 [checkin=" + checkin + ", checkout=" + checkout + "]";
}

}
