import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class ComplexDriver {
	public static void main(String[] args) {
		ButtonPanel bp;
		ComplexControlPanel cp = new ComplexControlPanel();

		// Create radio panel
		Light livingroomlight = new Light("Living Room");
		Light kitchenlight = new Light("Kitchen");
		Light stereo = new Light("Stereo");
		Light dummy1 = new Light("Dummy");
		Light dummy2 = new Light("Dummy");

		livingroomlight.add();
		kitchenlight.add();
		stereo.add();
		dummy1.add();
		dummy2.add();
		JFrame lights = new JFrame("Lights");
		JPanel lp = new JPanel(new GridLayout(1, 5));
		lights.setLayout(new GridLayout(1, 5));
		lp.add(livingroomlight);
		lp.add(kitchenlight);
		lp.add(dummy1);
		lp.add(stereo);
		lp.add(dummy2);
		lights.add(lp);
		lights.setSize(400, 100);
		lights.setVisible(true);

		// Create on - off commands
		LightOnCommand livingroomlighton = new LightOnCommand(livingroomlight);
		LightOffCommand livingroomlightoff = new LightOffCommand(
				livingroomlight);
		LightOnCommand kitchenlighton = new LightOnCommand(kitchenlight);
		LightOffCommand kitchenlightoff = new LightOffCommand(kitchenlight);
		LightOnCommand stereoon = new LightOnCommand(stereo);
		LightOffCommand stereooff = new LightOffCommand(stereo);

		// initialize complex control panel with on-off commands
		cp.setCommand(0, livingroomlighton, livingroomlightoff);
		cp.setCommand(1, kitchenlighton, kitchenlightoff);
		cp.setCommand(3, stereoon, stereooff);
		// System.out.println(p); // how does this work??

		// create button panel that uses complex control panel
		bp = new ButtonPanel(cp);

	}
}
