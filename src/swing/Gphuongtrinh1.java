
package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public  class Gphuongtrinh1 implements ActionListener{
	private JComponent createButtonPane() {
		JButton button = new JButton("New window");
		button.setActionCommand("a");
		button.addActionListener(this);;
		JPanel pane = new JPanel(); // use default FlowLayout
		pane.setBorder(BorderFactory.createEmptyBorder(10, 10, 9, 8));
		pane.add(button);
		return pane;
	}
	public void run() {
		JFrame frame = new JFrame("Swing Frame");
		JLabel label = new JLabel("This is a Swing frame", 
		JLabel.CENTER);
		frame.add(label);
		frame.addWindowListener(new WindowEventHandler());
		frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		Gphuongtrinh1 a = new Gphuongtrinh1();
		frame.add(a.createButtonPane());
		frame.setSize(350, 200); // width=350, height=200
		frame.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		if ("a".equals(command)) {
			System.out.println("Click");
		}
	}
}
