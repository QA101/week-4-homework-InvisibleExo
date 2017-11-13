
public class SchoolDic {

	String lastName;
	String firstName;
	String role;
	String classes1;
	String classes2;
	String classes3;
	String classes4;
	String classes5;
	
	// For teachers: use " " if classes to teach are less than 5 different types, or maybe keep to determine time of day....
	public SchoolDic (String lastName, String firstName, String role, 
						String classes1, String classes2, String classes3, String classes4, String classes5) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.role = role;
		this.classes1 = classes1;
		this.classes2 = classes2;
		this.classes3 = classes3;
		this.classes4 = classes4;
		this.classes5 = classes5;
	}
	
	public String toString() {
		return(firstName + " " +lastName);
	}
	
	public String detail() {
		return("Name: " + lastName + ", " + firstName + ": " + role + ". \n"
				+ " Classes: " + classes1 + " " + classes2 + " " + classes3 + " " + classes4 + " " + classes5);
	}
	
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
}
