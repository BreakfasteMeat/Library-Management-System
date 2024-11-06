import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LibraryManagementAppHandler{
	List<LibraryItem> libraryItems = new LinkedList<>();
	List<List<String>> database = new ArrayList<>();
	BookInputWindow inputWindow;
	LibraryManagementApp app;

	public BookInputWindow getInputWindow(){
		return inputWindow;
	}

	public void setApp(LibraryManagementApp app){
		this.app = app;
	}

	public LibraryManagementAppHandler(){
		this.inputWindow = new BookInputWindow();
		inputWindow.setLibraryManagementAppHandler(this);
		readFileDatabase();
		updateFileDatabase();
	}

	public void addItem(LibraryItem.LibraryItemType libraryItemType){
		LibraryItem item = null;
		switch(libraryItemType){
			case BOOK -> {
				item = LibraryItemFactory.createLibraryItem(LibraryItem.LibraryItemType.BOOK,
						inputWindow.getTitleFieldText(),
						inputWindow.getAuthorField().getText(),
						Integer.parseInt(inputWindow.getYearOfPublicationField().getText()), LibraryItem.ItemAvailabilityStatus.RESERVED);
				libraryItems.add(item);
			}
			case MEDIA -> {
				
			}
			default -> throw new IllegalStateException("Unexpected value: " + libraryItemType);
		}

		List<String> itemEntry = convertToDatabaseEntry(item);
		addEntryToDatabase(itemEntry);
		updateFileDatabase();
		app.updateTable();
		app.revalidate();
	}
	private void addEntryToDatabase(List<String> entry){
		database.add(entry);
	}
	private List<String> convertToDatabaseEntry(LibraryItem item){
		List<String> result = new ArrayList<>();
		result.add(item.getTitle());
		result.add(item.getAuthors().getFirst());
		result.add(String.valueOf(item.getPublication_year()));
		result.add("Available");
		return result;
	}
	public void readFileDatabase(){
		database.clear();
		try(BufferedReader reader = new BufferedReader(new FileReader("src/database/library_database.csv")))
		{
			String line;
			while((line = reader.readLine()) != null){
				String[] values = line.split(",");
				System.out.println(Arrays.toString(values));
				List<String> new_row = new ArrayList<>(Arrays.asList(values));
				database.add(new_row);
			}
		} catch (IOException e){
			System.out.println("File Error");
			e.printStackTrace();
		}
	}
	public void updateFileDatabase(){

		try(BufferedWriter writer = new BufferedWriter(new FileWriter("src/database/library_database.csv")))
		{
			for(List<String> innerlist : database){
				writer.write(String.join(",",innerlist));
				writer.append("\n");
			}
			writer.flush();
		} catch(IOException e){
			System.out.println("File Error");
			e.printStackTrace();
		}
	}
	private void addBook(Book book){
		libraryItems.add(book);
	}

	public List<LibraryItem> getLibraryItems(){
		return libraryItems;
	}

	public List<List<String>> getDatabase(){
		return database;
	}
}
