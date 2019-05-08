package com.JayPi4c;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Main extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	public static JFrame MainFrame;
	public static JButton Settings;
	public static JButton Credits;
	public static JButton Highscore;
	public static JButton Close;
	public static JButton PressMe;
	public static JLabel Duration;
	public static JLabel Score;
	public static JLabel Text;

	public static int score;
	public static int highscore;

	static Thread countdown = new Countdown();

	private static Object[] options = { "OK" };

	public static void main(String[] args) {

		Main frame = new Main("Schaffst du mehr?");
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setSize(600, 600);
		frame.setLocationRelativeTo(null);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	public Main(String title) {
		super(title);
		PressMe = new JButton("Drück Mich!!");
		PressMe.setBounds(30, 50, 530, 400);
		PressMe.addActionListener(this);
		PressMe.setBorderPainted(true);
		PressMe.setBackground(Color.BLACK);
		PressMe.setForeground(Color.GREEN);
		add(PressMe);
		PressMe.setVisible(true);

		Settings = new JButton("Settings");
		Settings.setBounds(20, 500, 120, 40);
		Settings.addActionListener(this);
		add(Settings);
		Settings.setVisible(true);

		Credits = new JButton("Credits");
		Credits.setBounds(150, 500, 120, 40);
		Credits.addActionListener(this);
		add(Credits);
		Credits.setVisible(true);

		Highscore = new JButton("Highscore");
		Highscore.setBounds(290, 500, 120, 40);
		Highscore.addActionListener(this);
		add(Highscore);
		Highscore.setVisible(true);

		Close = new JButton("Beenden");
		Close.setBounds(430, 500, 120, 40);
		Close.addActionListener(this);
		add(Close);
		Close.setVisible(true);

		Duration = new JLabel("Noch: " + Countdown.counter + " Sekunden");
		Duration.setBounds(230, 20, 200, 20);
		add(Duration);
		Duration.setVisible(true);

		Score = new JLabel("Klick: " + score);
		Score.setBounds(250, 450, 200, 20);
		add(Score);
		Score.setVisible(true);

		Text = new JLabel("Mit dem 1. Klick startet das Spiel.");
		Text.setBounds(200, 0, 300, 20);
		add(Text);
		Text.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == PressMe && score == 0) {
			countdown = new Countdown();
			countdown.start();
			score++;
			Text.getParent().invalidate();
			Text.setText("Du bist im Spiel, klicke so oft du kannst.");
			Text.getParent().validate();

		}
		if (e.getSource() == PressMe && score != 0) {
			score++;
			Score.getParent().invalidate();
			Score.setText("Klick: " + score);
			Score.getParent().validate();

		}
		if (e.getSource() == Close) {
			System.exit(0);

		}
		if (e.getSource() == Credits) {
			JOptionPane.showOptionDialog(null,
					"Made by PohlProductions4c" + "\n" + "developed by JayPi4c" + "\n" + "Version: Beta 0.2.5" + "\n"
							+ "tested by: Issa das Biest" + "\n" + "           ZockfischLP" + "\n"
							+ "           SuchtTea Pfefferminz" + "\n" + "           Kirinto" + "\n"
							+ "           DerHenne" + "\n" + "           Lahme",
					"Credits", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

		}
		if (e.getSource() == Settings) {

			Countdown.COUNTDOWN = Integer
					.parseInt(JOptionPane.showInputDialog(null, "Wie lange willst du spielen?", "15"));

		}
		if (e.getSource() == Highscore) {
			JOptionPane.showOptionDialog(null, "Dein bisheriger Highscore beträgt: " + highscore, "Highscore",
					JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		}
	}

}