package techproedturkish01.techproedturkish01.api;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TestPojo2 {


	/*
		POJO: Plain Old Java Object
		      We will create Pojo Classes by using our Json Format then
		      we will create objects from Pojo Classes and use them in test scripts
		      
		POJO Classes have 1)private variables 2)getter() and setter() 3)Constructor with all parameters
		                  4)Constructor without parameter 5)toString()      
	*/

@SerializedName("name")
@Expose
private String name;
@SerializedName("salary")
@Expose
private String salary;
@SerializedName("age")
@Expose
private String age;
@SerializedName("status")
@Expose
private String status;
@SerializedName("message")
@Expose
private String message;


public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getSalary() {
return salary;
}

public void setSalary(String salary) {
this.salary = salary;
}

public String getAge() {
return age;
}

public void setAge(String age) {
this.age = age;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}

public TestPojo2(String name, String salary, String age) {

	this.name = name;
	this.salary = salary;
	this.age = age;
}

public TestPojo2() {
	
}

@Override
public String toString() {
	return "TestPojo2 [name=" + name + ", salary=" + salary + ", age=" + age + "]";
}

}
