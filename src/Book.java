
public class Book{
	String title;
	int pages;
	String genre;
	String author;
	boolean status = true;
	
	
	/*
	 * Constructor for the book
	 */
	public Book(String title, int pages, String genre, String author, boolean status) {
		this.title = title;
		this.pages = pages;
		this.genre = genre;
		this.author = author;
		this.status = status;
	}
	
	public String toString() {
		return title;
	}
	
	public String Details() {
		return "Title: " + title + ", #pages: " + pages + ", Author: " + author + ", Genre: " + genre;
	}
}
