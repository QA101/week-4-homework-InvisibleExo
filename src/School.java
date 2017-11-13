import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class School {
	
	//Variables for this class
	ArrayList<Book> catalog = new ArrayList<Book>();
	//ArrayList for students reports, teachers and principle
	//(Should mention student current class session)
	ArrayList<SchoolDic> population = new ArrayList<SchoolDic>();
	//ArrayList for books checked out by the people from school
	HashMap<SchoolDic, ArrayList<Book>> checkOut = new HashMap<>();


	int numStudents = 0;
	int numPrinciple = 0;
	int numTeachers = 0;
	String schoolName;
	final static int MAX_STUDENT = 2000;
	final static int MAX_PRINCIPLE = 2;
	final static int MAX_TEACHER = 200;
	String classSession;
	//Military hours
	double startTime;
	double endClassTime;
	double endTime;
	//Could I make a local library using a global Object?
	Library lib;
	
	Scanner console = new Scanner(System.in);

	/**
	 * Start the execution of your program here.
	 * 
	 * --------------INSTRUCTIONS----------------
	 * 1. The main method should create a school, add books to its catalog, and print all the books in its catalog. Tony: Check
	 * Use the library class for reference.
	 * 
	 * 2. After printing the books, the program should add students and print the total number of student.
	 * 
	 * 3. Finally, the program should call other methods that you design and print anything that makes sense for a school.
	 * Tony: Sticking to check out of books for anyone from the school, add or remove people from the list of school, and searching up specific 
	 * person or book.
	 * If Possible (And if all other homework is done): future designs to implement Scanner class for input inside a method with a while loop for greater flexibility with input.
	 * Find ways to have multiple methods pass arguements to the more simple methods to help reduce line and structure general conditions to find info, (may mean some more info needs to be more specific.)
	 * 
	 * Thoughts:
	 * Schools have books, students, teachers, principles, classes.
	 * Add students, remove students, add teachers, open the school, close the school.
	 * 
	 * ----------------CHALLENGE:----------------
	 * 
	 * Can a school have a library? How would this be represented within the school?
	 * 
	 */
	public static void main(String args[]) {
		//TODO create a school (similar to the library) Tony: Check
		//Local Library for the school containing data of the main library class.
		Library bHSLib = new Library();
		School bHS = new School("Bellingham High", bHSLib, "2017-2018", 9, 15, 19);
		
		System.out.println("Good morning, a reminder to everyone that class always starts at " + bHS.startTime + " and ends at "
							+ bHS.endClassTime + ". \nAlthough, the school will remain open for students till " + bHS.endTime + ".\n");
		
		System.out.println("New Books have been added to catalog: ");
		
		//TODO Print the toString method in school. Such as, school.toString() Tony: Check
		bHS.importPortionMainLibrary(bHSLib, 2, 4);
		bHS.addBookCatalog("The Hobbit", 388, "Fantasy", "J. R. R. Tolkien");
		bHS.addBookCatalog("Star Wars: The Last Command", 478, "Sci-fi", "Timothy Zhan");
		bHS.addBookCatalog("Earth Seed", 506, "Sci-fi", "Octavia Butler");
		bHS.addBookCatalog("Halo: Crytum", 398, "Sci-fi", "Greg Bear");
		
		System.out.println("Books catalog for " + bHS.schoolName + " are: ");
		System.out.println(bHS.toString());
		System.out.println("Details: " );
		System.out.println(bHS.toStringDetail());
		
		
		//TODO Print any other variables that make sense for a school. Be creative.
		//Adding Students.
		bHS.AddSingleStudent("Lawrence", "Tony", "Jap1", "English3", "Algebra2", "Strength", "World-Hist");
		bHS.AddSingleStudent("Fry", "Philip", "PopCluture", "English3", "Geomentry", "Yoga", "World-Hist");
		bHS.AddSingleStudent("Smith", "Morty", "Spanish1", "English2", "Geomentry", "Track", "US-Hist");
		bHS.AddSingleStudent("Smith", "Summer", "Spanish1", "English1", "Geomentry", "Yoga", "PopCluture");
		bHS.AddSingleStudent("Smith", "Morty Jr", "Jap3", "English3", "Geomentry", "Chemistry", "World-Hist");
		bHS.AddSingleStudent("Paris", "Tom", "French2", "English2", "Algebra1", "Strength", "Flight-Lessons");
		bHS.AddSingleStudent("Janeway", "Katherine", "Italian2", "English3", "Algebra2", "Art2", "World-Hist");
		
	
		System.out.print("Total students for " + bHS.schoolName + " is: ");
		System.out.println(bHS.getStudents());
		System.out.println(bHS.toStringStudentDic());
		
		
		//Adding Teachers.
		bHS.AddSingleTeacher("Veratu", "Coach", "Track", "PE", "Strength", " ", " ");
		bHS.AddSingleTeacher("Mansfield", "Robert", "Hist", "US-Hist", "World-Hist", "CitizenShip", "Economics");
		bHS.AddSingleTeacher("Pickle", "Monson", "Chemistry", "Physics", "Math2", "Algebra2", "Calculus");
		bHS.AddSingleTeacher("Pewtersmiht", "Alex", "Anatomy", "English2", "British-Literature", "Nursing", " ");
		
		System.out.println("Total number of teachers for " + bHS.schoolName + " is: " + bHS.getTeacher());
		System.out.println(bHS.toStringTeacherDic());
		
		//Looking for specific person
		System.out.println("Looking up name:");
		System.out.println(bHS.getSpecific("Vader"));
		System.out.println("What about this one:");
		System.out.println(bHS.getSpecific("Smith"));
		
		//Looking for specific book and status for being checked out
		System.out.println("Looking specified book named \"Children of Dune\":");
		System.out.println(bHS.getSpecificBook("Children of Dune"));
		System.out.println("Looking specified book named \"Halo\":");
		System.out.println(bHS.getSpecificBook("Halo") + "\n");
		
		//Removing a single student by last name then first name
		System.out.println("Now removing a student from the school");
		bHS.removeSingleStudent("Lawrence", "Tony");
		System.out.println(bHS.getStudents());
		System.out.println(bHS.toStringStudentDic() + "\n");
		
		//Checkout for books.
		System.out.println("Now a someone will checkout a book:");
		bHS.checkOutBook("Mansfield", "Robert", "Earth Seed");
		System.out.println(bHS.getCheckOut());
		bHS.checkOutBook("Mansfield", "Robert", "The Hobbit");
		System.out.println(bHS.getCheckOut() + "\n");
		
		//Return any books checked 
		System.out.println("Now returning a book.");
		bHS.returnBooks("Mansfield", "Robert", "Earth Seed");
		System.out.println("Now this person has: " );
		System.out.println(bHS.getCheckOut() + "\n");
		
		
		//Should someone check a book that is already checkout 
		System.out.println("Another person is checking out a book.");
		bHS.checkOutBook("Paris", "Tom", "The Hobbit");
		System.out.println(bHS.getCheckOut() + "\n");
		
		
		
	
		
		
	}
	
	/**
	 * Constructs a school.
	 * this.name refers to the global variable for the class. String name is the name we pass in when building the school
	 * @param name
	 */
	public School(String schoolName, Library lib, String classSession, double startTime, double endClassTime, double endTime) {
		this.schoolName= schoolName;
		this.lib = lib;
		this.classSession = classSession;
		this.startTime = startTime;
		this.endClassTime = endClassTime;
		this.endTime = endTime;
		
	}
	
	public String getSchoolName() {
		return schoolName;
	}

	/**
	 * Write a method to return a list of all books at the school
	 */
	//Non static method to add books to school class.
	public void addBookCatalog(String title, int pages, String genre, String author) {
		catalog.add(new Book(title, pages, genre, author, true));
	}
	//Add all books from the Library Class
	public void importMainLibrary(Library lib) {
		catalog.addAll(lib.catalog);
	}
	//Add only portions from the Library Class
	public void importPortionMainLibrary(Library lib, int start, int end) {
		catalog.addAll(lib.catalog.subList(start, end));
	}
	//Print book titles in the school library catalog.
	public String toString() {
		//TODO Write a method to return a list of all books at the school
		String returnString = "";
		for(Book b : catalog) {
			returnString += b + "\n";
		}
		return returnString;
	}
	//Print book details in the school library catalog.
	public String toStringDetail() {
		//TODO Write a method to return a list of all books at the school
		String returnString = "";
		for(Book b : catalog) {
			returnString += b.Details() + "\n";
		}
		return returnString;
	}
	/**
	 * adds a single student to the school
	 */
	//Add student name using the SchoolDic Class
	public void AddSingleStudent(String lastName, String firstName, String class1, String class2, String class3, String class4, String class5) {
		numStudents++;
		SchoolDic d = (new SchoolDic(lastName, firstName, "Student", class1, class2, class3, class4, class5));
		population.add(d);
		if (numStudents > MAX_STUDENT) {
			numStudents--;
			population.remove(d);
			System.out.println("Student population is at full capacity.");
		}
	}
	// add a single teacher
	public void AddSingleTeacher(String lastName, String firstName, String class1, String class2, String class3, String class4, String class5) {
		numTeachers++;
		SchoolDic d = (new SchoolDic(lastName, firstName, "Teacher", class1, class2, class3, class4, class5));
		population.add(d);
		if (numTeachers > MAX_TEACHER) {
			numTeachers--;
			population.remove(d);
			System.out.println("We have a full teacher staff already.");
		}
	}
	
	// add a principle
	public void AddSinglePrinciple(String lastName, String firstName, String class1, String class2, String class3, String class4, String class5) {
		numPrinciple++;
		SchoolDic d = new SchoolDic(lastName, firstName, "Principle", class1, class2, class3, class4, class5);
		population.add(d);
		if (numPrinciple > MAX_PRINCIPLE) {
			numPrinciple--;
			population.remove(d);
			System.out.println("We have a full priniciple staff already.");
		}
	}
	
	/**
	 * removes a single student from the school
	 */
	//Removing a student in ArrayList.
	public void removeSingleStudent(String lastName, String firstName) {
		if(numStudents > 0) {
			for(int i = 0;i < population.size(); i++ ) {
				SchoolDic d = population.get(i);
				if (d.firstName.equals(firstName) && d.lastName.equals(lastName)) {
					population.remove(d);
					i--;
					numStudents--;
				}
			}
		}
	}
	
	
	public void removeSingleTeacher(String lastName, String firstName) {
		if(numTeachers > 0) {
			for(int i = 0;i < population.size(); i++ ) {
				SchoolDic d = population.get(i);
				if (d.firstName.equals(firstName) && d.lastName.equals(lastName)) {
					population.remove(d);
					i--;
					numTeachers--;
				}
			}
		}
	}
	
	public void removeSinglePrinciple(String lastName, String firstName) {
		if(numPrinciple > 0) {
			for(int i = 0;i < population.size(); i++ ) {
				SchoolDic d = population.get(i);
				if (d.firstName.equals(firstName) && d.lastName.equals(lastName)) {
					population.remove(d);
					i--;
					numPrinciple--;
				}
			}
		}
	}
	
	/**
	 * method to return number of students
	 * 
	 * @return number of students in the school
	 */
	public int getStudents() {
		return numStudents;
	}
	public int getTeacher() {
		return numTeachers;
	}
	public int getPrinciple() {
		return numPrinciple;
	}
	
	public HashMap<SchoolDic, ArrayList<Book>> getCheckOut() {
		return checkOut;
	}
	//(Could be included somewhere in the current design, but drawing a blank....)
	public void setCheckOut(HashMap<SchoolDic, ArrayList<Book>> checkOut) {
		this.checkOut = checkOut;
	}
	//Print list of students at their disignated school
	public String toStringStudentDic() {
		String returnString = "";
		for(SchoolDic d : population) {
			if (d.role.contains("Student")) {
				returnString += d.detail() + "\n";
			}
		}
		return returnString;
	}
	//Print list of teachers at their disignated school
	public String toStringTeacherDic() {
		String returnString = "";
		for(SchoolDic d : population) {
			if (d.role.contains("Teacher")) {
				returnString += d.detail() + "\n";
			}
		}
		return returnString;
	}
	//Print list of principles at their disignated school
		public String toStringPrinicpleDic() {
			String returnString = "";
			for(SchoolDic d : population) {
				if (d.role.contains("Principle")) {
					returnString += d.detail() + "\n";
				}
			}
			return returnString;
		}
		
	//Retrieving specified person from population list either first name or last name
		public String getSpecific(String name) {
			String returnString = "";
			System.out.println(name);
			int match = 0;
			for(int i = 0; i < population.size(); i++) {
				SchoolDic d = population.get(i);
				if (d.firstName.equals(name) || d.lastName.equals(name) ) {
					returnString += d.detail() + "\n";
					match++;
				}
			}
			if (match <= 0) {
				System.out.println("That person doesn't go to this school");
			}
			return returnString;
		}
	//Locating specific book. 
		public String getSpecificBook(String title) {
			String returnString = "";
			int match = 0;
			for(Book b : catalog) {
				if (b.title.contains(title)) {
					returnString += b.Details() + "\n";
					checkTheCheckOut(b);
					match++;
				}
			}
			if (match <= 0) {
				System.out.println("This book does not exist in our library.");
			}
			return returnString;
		}
		
	//Checkout for book from person (Possible to simplify?)
	public HashMap<SchoolDic, ArrayList<Book>> checkOutBook(String lastName, String firstName, String bookTitle){
		int match = 0;
		ArrayList<Book> foundBooks = new ArrayList<>();
		//Look up person
		for(int i = 0; i < population.size(); i++) {
			SchoolDic d = population.get(i);
			if (d.firstName.equals(firstName) && d.lastName.equals(lastName)) {
				match++;
				//Checking if a book needs to be added to a current checkout list.
				if (checkOut.containsKey(d)) {
					foundBooks = checkOut.get(d);
				}
				for(int j = 0; j < catalog.size(); j++) {
					Book b = catalog.get(j);
					if(b.title.contains(bookTitle) && b.status == true) {
						b.status = false;
						foundBooks.add(b);
						checkOut.put(d, foundBooks);
						System.out.println(b.title + " has been checked out to " + d.firstName + " " + d.lastName);
					}
					//To state that this is book has already been checked out.
					else if (b.status == false && !checkOut.containsKey(d)) {
						System.out.println("Sorry " + d.firstName + " " + d.lastName + ", but \"" + b.title + "\" is currently checked out right now.\n" + 
											"If you're willing to wait, we can notify you when the book is available again.");
					}
				}
			}
		}
		if (match <= 0) {
			System.out.println("That person doesn't go to this school");
		}
		return checkOut;
	}
	//Return books checked out. 
	public HashMap<SchoolDic, ArrayList<Book>> returnBooks(String lastName, String firstName, String bookTitle){
		ArrayList<Book> foundBooks = new ArrayList<>();
		//Check person's current list
		for(int i = 0; i < population.size(); i++) {
			SchoolDic d = population.get(i);
			if (d.firstName.equals(firstName) && d.lastName.equals(lastName)) {
				if(checkOut.containsKey(d)) {
					foundBooks = checkOut.get(d);
				}
				//remove specified book
				for(int j = 0; j < catalog.size(); j++) {
					Book b = catalog.get(j);
					if(b.title.contains(bookTitle)) {
						b.status = true;
						foundBooks.remove(b);
						System.out.println("Book: "+ bookTitle + " has been returned.");
					}
				}//End of checking books
			}//End of name check	
		}
		return checkOut;
	}
	
	//Checking the status of a book
	public boolean checkTheCheckOut(Book b){
		if(b.status == true) {
			System.out.println(b.title + " can be checked out right now.");
		}
		else if (b.status == false) {
			System.out.println("Sorry, but \"" + b.title + "\" is currently checked out right now.\n" + 
					"If you're willing to wait, we can notify you when the book is available again.");
		}
		return b.status;
	}
	
	//Stretch Goal Objective: Implement While and Switch loop methods to access all the methods established for easy access.
	//(Incomplete)
	public void userCommands(Scanner console) {
		this.console = console;
		String decision = console.nextLine();
		boolean active = true;
		String name;
		String lastName;
		String firstName;
		String bookTitle;
		while (active == true) {
			//add methods and switch cases here.
			switch (decision.trim().toLowerCase()) {
			case "find":
				decision = console.nextLine();
				switch (decision.trim().toLowerCase()) {
					case "any":
						System.out.println("Who do you want to look up?");
						name = console.nextLine();
						getSpecific(name);
						break;
					case "school":
						System.out.println("Which school do you want to look up?");
						name = console.nextLine();
						getSchoolName();
						break;
					case "student":
						break;
					case "teacher":
						break;
					case "principle":
						break;
					case "book":
						break;
					case "number":
						break;
				}
				case "checkout":
					System.out.println("Enter last name: ");
					lastName = console.nextLine();
					System.out.println("Enter first name: ");
					firstName = console.nextLine();
					System.out.println("Enter the book title: ");
					bookTitle = console.nextLine();
					checkOutBook(lastName, firstName, bookTitle);
					break;
				case "return book":
					System.out.println("Enter last name: ");
					lastName = console.nextLine();
					System.out.println("Enter first name: ");
					firstName = console.nextLine();
					System.out.println("Enter the book title: ");
					bookTitle = console.nextLine();
					returnBooks(lastName, firstName, bookTitle);
					break;
				case "help":
					displayCommands();
					break;
				case "quit": case "exit":
					active = false;
					break;	
			}
			
		}
	}
	
	public String displayCommands() {
		String show = "ADD\t-Student: add a student to the school's directory.\n"
					+ "\t-Teacher: add a teacher to the school's directory.\n"
					+ "\t-Principle: add a principle to the school's directory.\n"
					+ "\t-Book: add new book to either the school's catalog or main library.\n"
					+ "FIND\t-Any: find anyone in school's directory.\n"
					+ "\t-School.\n"
					+ "\t-Student.\n"
					+ "\t-Teacher.\n"
					+ "\t-Principle.\n"
					+ "\t-Number: based on category: this will return the number of content available.\n"
					+ "\t-Book: from either school catalog or main library.\n"
					+ "HELP\t-Show user commands.\n"
					+ "REMOVE\t-Student: remove a student from the school's directory.\n"
					+ "\t-Teacher: remove a teacher from the school's directory.\n"
					+ "\t-Principle: remove a principle from the school's directory.\n"
					+ "\t-Book: remove a book from either the school's catalog or main library.\n"
					+ "CHECKOUT\t-check out any book's from the school's catalog or request a book from main library."
					+ "RETURN BOOK\t-return books back to School catalog."
					+ "QUIT\t-exit program.";		
		return show;
	}
		
	
	
}

