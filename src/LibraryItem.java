import java.util.Date;
import java.util.List;

public abstract class LibraryItem{
	protected String title;
	protected List<String> authors, genre;
	protected String publisher, language;
	protected int publication_year;
	protected ItemAvailabilityStatus availabilityStatus;

	public enum ItemAvailabilityStatus{
		AVAILABLE, CHECKED_OUT, RESERVED
	}
	public enum LibraryItemType{
		BOOK,
		MEDIA,
		PERIODICAL,
		DIGITAL_RESOURCE
	}

	public String getTitle(){
		return title;
	}

	public List<String> getAuthors(){
		return authors;
	}

	public List<String> getGenre(){
		return genre;
	}

	public String getPublisher(){
		return publisher;
	}

	public String getLanguage(){
		return language;
	}

	public int getPublication_year(){
		return publication_year;
	}

	public ItemAvailabilityStatus getAvailabilityStatus(){
		return availabilityStatus;
	}
}





