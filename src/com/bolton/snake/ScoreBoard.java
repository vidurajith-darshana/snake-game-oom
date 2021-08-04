package com.bolton.snake;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class ScoreBoard extends JPanel {

	private static final long serialVersionUID = 1L;
	public static final int PANEL_WIDTH = 400;
	public static final int PANEL_HEIGHT = 50;

	private final Font FONT;
	private final String SCORE_LABEL = "RESULT:";
	private String score;

	public ScoreBoard() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(Color.yellow);

		score = "0";
		FONT = new Font("cursive", Font.BOLD, 20);
	}

	public void addPoints(int points) {
		int oldValue = Integer.parseInt(score);
		oldValue += points;
		score = new String(oldValue + "");
		repaint();
	}

	public void clear() {
		score = "0";
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setFont(FONT);
		g2.setPaint(new Color(0, 0, 0)); // white
		g2.drawString(SCORE_LABEL, 15, 32);
		g2.setPaint(new Color(0, 0, 0)); // orange
		g2.drawString(score, 140, 32);
	}

}
