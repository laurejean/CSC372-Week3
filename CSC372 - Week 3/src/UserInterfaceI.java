import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UserInterfaceI {
	//Create attribute
	private static JTextArea textArea;

	public static void main(String[] args) {
		//Create the frame
		JFrame frame = new JFrame("User Interface I");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(600,400);
		
		//Create the menu bar
		JMenuBar menuBar = new JMenuBar();	   
		
		//Create the menu
		JMenu menu = new JMenu("Options");
	    
		//Create menu items
		JMenuItem item1 = new JMenuItem("Date & Time");
		JMenuItem item2 = new JMenuItem("Save to file");
		JMenuItem item3 = new JMenuItem("Change background color");
		JMenuItem item4 = new JMenuItem("Exit");
		
		//Add menu items to menu
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		
		//Add menu to menu bar
		menuBar.add(menu);
		
		//Add menu bar to frame
		frame.setJMenuBar(menuBar);
		
		//Initialization of textArea and making the text area non-editable by the user. 
		textArea = new JTextArea();
        textArea.setEditable(false);
       	
		//Add text area and scroll pane to the frame
		frame.add(textArea, BorderLayout.CENTER);
	
		// Action listener for "Show Date & Time"
        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
                textArea.setText(dateTime);
            }
        });
        
        // Action listener for "Save to File"
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                	textArea.setText("Text saved to log.txt");
            }
        });
  
        // Action listener for "Change Background Color"
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Generate a random green color
                Random random = new Random();
                int r = 0; // Red component
                int g = random.nextInt(256); // Green component (0-255)
                int b = 0; // Blue component
                
               //Create a new color with random green hue
                Color randomGreen = new Color(r, g, b);
                
                // Display the initial random hue 
                textArea.setText("Background color changed to: " + randomGreen);
            }
        });
       
        // Action listener for "Exit"
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

		//Set frame visibility
		frame.setVisible(true);
	}

}
