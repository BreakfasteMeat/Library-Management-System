import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class LibraryManagementApp extends JFrame{
	private JTable tableLibraryItems;
	private JPanel mainPanel;
	private JButton addBookButton;
	private JButton updateTableButton;
	private JList list1;
	private LibraryManagementAppHandler libraryManagementAppHandler = new LibraryManagementAppHandler();
	private BookInputWindow bookInputWindow = libraryManagementAppHandler.getInputWindow();
	private DefaultTableModel model;


	public JPanel getMainPanel(){
		return mainPanel;
	}

	public LibraryManagementApp() throws HeadlessException{

		super("Library Management App");
		libraryManagementAppHandler.setApp(this);
		updateTable();


		// Create the JTable with the model

		addBookButton.addActionListener(e -> {
			bookInputWindow.initiateWindow();
		});
		updateTableButton.addActionListener(e -> {
			updateTable();
		});
	}
	public void updateTable(){

		List<String> columnNames = libraryManagementAppHandler.getDatabase().getFirst();
		List<List<String>> data = libraryManagementAppHandler.getDatabase();

		// Convert columnNames to Object[]
		Object[] columnNamesArray = columnNames.toArray(new Object[0]);

		// Convert data to Object[][]
		Object[][] dataArray = new Object[data.size()][];
		for (int i = 0; i < data.size(); i++) {
			List<String> row = data.get(i);
			dataArray[i] = row.toArray(new Object[0]);
		}
		model = new DefaultTableModel(dataArray,columnNamesArray);
		tableLibraryItems.setModel(model);
		tableLibraryItems.repaint();
		tableLibraryItems.revalidate();

	}


}
