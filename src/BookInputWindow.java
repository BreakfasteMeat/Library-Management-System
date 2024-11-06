import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BookInputWindow extends JFrame{
	JFrame frame = this;
	private JPanel panel1;
	private JTextField TitleField;
	private JButton addBookButton;
	private JTextField YearOfPublicationField;
	private JTextField AuthorField;
	private LibraryManagementAppHandler libraryManagementAppHandler;

	public BookInputWindow() throws HeadlessException{
		super("Add Book");
		TitleField = this.TitleField;
		addBookButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if(TitleField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Must input a title");
					return;
				}
				if(YearOfPublicationField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Must input a publication year");
					return;
				}
				if(AuthorField.getText().isEmpty()){
					JOptionPane.showMessageDialog(null, "Must input an author");
					return;
				}
				libraryManagementAppHandler.addItem(LibraryItem.LibraryItemType.BOOK);
				TitleField.setText("");
				YearOfPublicationField.setText("");
				AuthorField.setText("");
				frame.dispose();
			}
		});


	}

	public BookInputWindow setLibraryManagementAppHandler(LibraryManagementAppHandler libraryManagementAppHandler){
		this.libraryManagementAppHandler = libraryManagementAppHandler;
		return this;
	}

	public void initiateWindow(){
		this.add(panel1);

		// Set default close operation, size, and visibility
		this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		this.setSize(300, 200);  // Or whatever size you prefer
		this.setVisible(true);
	}

	public JTextField getTitleField(){
		return TitleField;
	}
	public String getTitleFieldText(){
		return TitleField.getText();
	}


	public JTextField getYearOfPublicationField(){
		return YearOfPublicationField;
	}

	public JTextField getAuthorField(){
		return AuthorField;
	}
}
