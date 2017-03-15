public class Customer {
	private String name, email, age, os, comments;

	public Customer(String name, String email, String age, String os, String comments) {
		super();
		this.name = name;
		this.email = email;
		this.age = age;
		this.os = os;
		this.comments = comments;
	}

	public String toString() {
		return "Name: " + name + "\nEmail Address: " + email + "\nAge: " + age
				+ "\nOperating Systems: " + os + "\nComments: " + comments + "\n";
	}
}
