package com.swlc.bolton.snakeoom;

import com.swlc.bolton.snakeoom.impl.Food;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JPanel;

public class GaminField extends JPanel {

	public static final int PANEL_WIDTH = 700;
	public static final int PANEL_HEIGHT = 400;

	private List<Ellipse2D.Double> snakeParts;
	private FoodInterface foods = new Food(100, 100);;

	public GaminField() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
		setBackground(Color.GRAY);
		initDefaults();
	}

	public void initDefaults() {
		snakeParts = Collections.synchronizedList(new ArrayList<Ellipse2D.Double>());
		snakeParts.add(new Ellipse2D.Double(260, 260, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 280, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 300, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 320, 20, 20));
	}

	public void setSnakeParts(List<Ellipse2D.Double> snakeParts) {
		this.snakeParts = snakeParts;
	}

	public void setApple(Food food) {
		this.foods = food;
	}

	public Food getFood() {
		return (Food)foods;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw the foods
		g2.setPaint(Color.ORANGE);
		g2.fillRect((int) foods.getShape().getMinX() + 5, (int) foods.getShape().getMinY() + 5, 15, 15);

		// Draw the snake parts
		g2.setPaint(new Color(255, 255, 255)); // white
		for (Ellipse2D e : snakeParts) {
			g2.fill(e);
		}

		// Draw the head of the snake
		g2.setPaint(new Color(0, 255, 0)); // green
		g2.fill(snakeParts.get(0));
	}
}
