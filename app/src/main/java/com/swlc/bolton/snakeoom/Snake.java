package com.swlc.bolton.snakeoom;

import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * @author vidurajith.SAS9OCD
 *
 */
public class Snake {

	public static final int XSIZE = 20;
	public static final int YSIZE = 20;

	private GaminField gameField;
	private ScoreBoard scoreBoard;
	private List<Ellipse2D.Double> snakeParts;
	private Route route;

	private Ellipse2D.Double temp;
	private Ellipse2D.Double ass;

	private boolean over = false;

	public Snake(GaminField gameField, ScoreBoard scoreBoard) {
		this.gameField = gameField;
		this.scoreBoard = scoreBoard;
		initDefaults();
	}


	public void changeDirection(Route route) {
		this.route = route;
	}

	public void move() {
		switch (route) {
		case UP:
			moveBody();
			// head
			snakeParts.set(0,
					new Ellipse2D.Double(snakeParts.get(0).getMinX(), snakeParts.get(0).getMinY() - 20, XSIZE, YSIZE));
			if (snakeParts.get(0).getMinY() < 0) {
				over = true;
			}
			break;
			
		case DOWN:
			moveBody();
			// head
			snakeParts.set(0,
					new Ellipse2D.Double(snakeParts.get(0).getMinX(), snakeParts.get(0).getMinY() + 20, XSIZE, YSIZE));
			if (snakeParts.get(0).getMaxY() > gameField.getBounds().getMaxY()) {
				over = true;
			}
			break;

		case LEFT:
			moveBody();
			// head
			snakeParts.set(0,
					new Ellipse2D.Double(snakeParts.get(0).getMinX() - 20, snakeParts.get(0).getMinY(), XSIZE, YSIZE));
			if (snakeParts.get(0).getMinX() < 0) {
				over = true;
			}
			break;

		case RIGHT:
			moveBody();
			// head
			snakeParts.set(0,
					new Ellipse2D.Double(snakeParts.get(0).getMinX() + 20, snakeParts.get(0).getMinY(), XSIZE, YSIZE));
			if (snakeParts.get(0).getMaxX() > gameField.getBounds().getMaxX()) {
				over = true;
			}
			break;

		default:
			new Exception("Unexcepted Direction value!").printStackTrace();
			break;
		}
	}

	public List<Ellipse2D.Double> getParts() {
		return snakeParts;
	}

	public void check() {
		Ellipse2D.Double head = snakeParts.get(0);
		Food food = gameField.getFood();

		// Ate itself
		for (int i = 1; i < snakeParts.size(); i++) {
			if (head.getMinX() == snakeParts.get(i).getMinX() && head.getMinY() == snakeParts.get(i).getMinY()) {
				over = true;
				return;
			}
		}
		// Ate food
		if (head.getMinX() == food.getShape().getMinX() && head.getMinY() == food.getShape().getMinY()) {
			scoreBoard.addPoints(10);
			food.next(this);
			snakeParts.add(ass);
		}
	}

	public boolean isGameOver() {
		return over;
	}

	private void moveBody() {
		for (int i = snakeParts.size() - 1; i > 0; i--) {
			if (i == snakeParts.size() - 1) {
				ass = (Ellipse2D.Double) snakeParts.get(i).clone();
			}
			temp = (Ellipse2D.Double) snakeParts.get(i - 1).clone();
			snakeParts.set(i, temp);
		}
	}

	private void initDefaults() {
		snakeParts = Collections.synchronizedList(new ArrayList<Ellipse2D.Double>());
		snakeParts.add(new Ellipse2D.Double(260, 260, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 280, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 300, 20, 20));
		snakeParts.add(new Ellipse2D.Double(260, 320, 20, 20));
	}

}
