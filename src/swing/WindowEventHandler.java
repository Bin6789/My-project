package swing;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class WindowEventHandler extends WindowAdapter{
	public WindowEventHandler() {
		
	}
	public void windowClosing(WindowEvent evt) {
		System.out.println("Exit");
	}
	
}


