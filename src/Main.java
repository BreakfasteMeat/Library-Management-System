import javax.swing.*;

public class Main{
	public static void main(String[] args){
		LibraryManagementApp app = new LibraryManagementApp();
		app.setContentPane(app.getMainPanel());
		app.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		app.setSize(500,500);
		app.setVisible(true);
	}
}
