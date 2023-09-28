package swing;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class JFramePack {

	public void run() {
		// TODO Auto-generated method stub
		JFrame.setDefaultLookAndFeelDecorated(true);
		JFrame frame = new JFrame();
		frame.setTitle("Welcome to Nhuong's Swing Application.");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label = new JLabel("Hello");
		frame.add(label);
		frame.pack();
		frame.setVisible(true);
	}

}
