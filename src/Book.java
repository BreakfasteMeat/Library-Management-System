import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class Book extends LibraryItem{
	private String edition;
	private String ISBN;
	private List<String> series;
	private HashMap<String, List<String>> additional_contributors;

	public Book(BookBuilder builder) {
		this.title = builder.title;
		this.authors = builder.authors;
		this.genre = builder.genre;
		this.publisher = builder.publisher;
		this.language = builder.language;
		this.publication_year = builder.publication_year;
		this.edition = builder.edition;
		this.ISBN = builder.ISBN;
		this.series = builder.series;
	}

	@Override
	public String toString(){
		return title + " By: " + authors.toString();
	}

	public static class BookBuilder{
		private String title;
		private List<String> authors;
		private List<String> genre;
		private String publisher;
		private String language;
		private int publication_year;
		private String edition;
		private String ISBN;
		private List<String> series;
		private HashMap<String, List<String>> additional_contributors;


		public BookBuilder(){}
		public BookBuilder setTitle(String title) {
			this.title = title;
			return this;
		}

		public BookBuilder setAuthors(List<String> authors) {
			this.authors = authors;
			return this;
		}

		public BookBuilder setGenre(List<String> genre) {
			this.genre = genre;
			return this;
		}

		public BookBuilder setPublisher(String publisher) {
			this.publisher = publisher;
			return this;
		}

		public BookBuilder setLanguage(String language) {
			this.language = language;
			return this;
		}

		public BookBuilder setPublicationYear(int publication_year) {
			this.publication_year = publication_year;
			return this;
		}

		public BookBuilder setEdition(String edition){
			this.edition = edition;
			return this;
		}

		public BookBuilder setISBN(String ISBN){
			this.ISBN = ISBN;
			return this;
		}

		public BookBuilder setSeries(List<String> series){
			this.series = series;
			return this;
		}
		
		public Book build(){
			return new Book(this);
		}
//TODO IMPLEMENT HASHMAP READER

//		public BookBuilder setAdditional_contributors(HashMap<String, List<String>> additional_contributors){
//			this.additional_contributors = additional_contributors;
//			return this;
//		}
	}
}
