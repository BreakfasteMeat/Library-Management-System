import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LibraryItemFactory{
	public static LibraryItem createLibraryItem(LibraryItem.LibraryItemType libraryItemType, String title, String author, int year, LibraryItem.ItemAvailabilityStatus availabilityStatus){
		switch(libraryItemType){
			case BOOK -> {
				List<String> authors = new ArrayList<>();
				authors.add(author);
				return new Book.BookBuilder()
						.setTitle(title)
						.setAuthors(authors)
						.setPublicationYear(year)
						.build();
			}
		}
		return null;
	}
}
