package com.JayPi4c;

import javax.swing.JOptionPane;

public class Countdown extends Thread {

	public static int COUNTDOWN = 15;
	public static int counter;

	private static Object[] options = { "OK" };

	private static double cps;

	@Override
	public void run() {
		counter = COUNTDOWN;
		boolean running = true;
		while (running) {
			if (counter > 0) {
				counter--;
				Main.Duration.getParent().invalidate();
				Main.Duration.setText("Noch: " + counter + " Sekunden");
				Main.Duration.getParent().validate();

			}
			if (counter <= 0) {
				running = false;
				cps = Main.score / COUNTDOWN;

				JOptionPane.showOptionDialog(null,
						"Du hast: " + Main.score + " Klicks geschafft." + "\n" + "Das entspricht ca.: " + cps, " ",
						JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

				if (Main.score > Main.highscore) {
					Main.highscore = Main.score;
					JOptionPane.showOptionDialog(null,
							"Du hast einen neuen Highscore von: " + String.valueOf(Main.highscore)
									+ " Klicks erreicht!!",
							"Ergebnis", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options,
							options[0]);
				}
				counter = COUNTDOWN;
				Main.score = 0;

				Main.Text.getParent().invalidate();
				Main.Text.setText("Mit dem 1. Klick startet das Spiel erneut");
				Main.Text.getParent().validate();

			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException exception) {
			}
		}
	}

}
