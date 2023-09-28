package swing;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class ResizingPositioningJFrame {
	public ResizingPositioningJFrame(){
		
	}
	public void run() {
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("JFrame Test");
		frame.setLayout(new GridLayout(10,8));
		frame.add(new JLabel("What your's name?"));
		frame.add(new JLabel("Fisrt name:"));
		frame.add(new JTextField());
		frame.add(new JLabel("Last name:"));
		frame.add(new JTextField());
		frame.add(new JButton("Check"));
		int frameWidth = 100;
		int frameHeight = 80;
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((int) screenSize.getWidth()- frameWidth,0, frameWidth,frameHeight);
		frame.setVisible(true);
	}
}
	
