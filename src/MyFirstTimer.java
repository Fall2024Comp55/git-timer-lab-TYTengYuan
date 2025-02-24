import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import acm.graphics.GLabel;
import acm.program.GraphicsProgram;

public class MyFirstTimer extends GraphicsProgram implements ActionListener{
	public static final int PROGRAM_HEIGHT = 600;
	public static final int PROGRAM_WIDTH = 800;
	public static final int MAX_STEPS = 20;
	private GLabel myLabel;
	private Timer timer;
	private int numTimes;

	public void init() {
		setSize(PROGRAM_WIDTH, PROGRAM_HEIGHT);
		requestFocus();
	}
	
	public void run() {
		myLabel = new GLabel("# of times called?", 0, 100);
		add(myLabel);
		
		numTimes = 0;
		
		timer = new Timer(1000, this);
		timer.setInitialDelay(3000);
		timer.start();
	}
	
	public void actionPerformed(ActionEvent e) {
		numTimes++;
		myLabel.setLabel("times called? " + numTimes);
		myLabel.move(5, 0);
		
		if (numTimes >= 10) {
			timer.stop();
		}
	}
	
	public static void main(String[] args) {
		new MyFirstTimer().start();
	}
}