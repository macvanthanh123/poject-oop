package model;

import java.util.ArrayList;
public class Library {
	private ArrayList<Book> Books = new ArrayList<Book>();
	private ArrayList<EBook> Ebooks = new ArrayList<EBook>();
	public Library(ArrayList<Book> books, ArrayList<EBook> ebooks) {
		this.Books = books;
		this.Ebooks = ebooks;
	}
	
	public ArrayList<Book> getBooks() {
		return Books;
	}
	public void setBooks(ArrayList<Book> books) {
		this.Books = books;
	}
	public ArrayList<EBook> getEbooks() {
		return Ebooks;
	}
	public void setEbooks(ArrayList<EBook> ebooks) {
		this.Ebooks = ebooks;
	}
	
	public void Add_book(Book book) {
		Books.add(book);
	}
	public void Remove_book(int i) {
		Books.remove(i);
	}
	public void Add_ebook(EBook ebook) {
		Ebooks.add(ebook);
	}
	public void Remove_ebook(int i) {
		Ebooks.remove(i);
	}
}

