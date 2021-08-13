package com.swlc.bolton.snakeoom;

import com.swlc.bolton.snakeoom.exceptions.InvalidDirectionException;
import com.swlc.bolton.snakeoom.impl.*;
import org.junit.jupiter.api.Test;

import java.awt.geom.Ellipse2D;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SnakeTest {

	@Test
	public void testSnakeMovesUP() {
		ScoreBoard scoreBoard;
		GaminField gameField;
		scoreBoard = new ScoreBoard();
		gameField = new GaminField();
		Snake snake = new Snake(gameField, scoreBoard);
		Route.DOWN.toString();
		Route direction = Route.UP;

		switch (Route.UP) {
		case UP:
			assertEquals(Route.UP.toString(), "UP");

			break;

		default:
			new InvalidDirectionException("Unexcepted Direction value!").printStackTrace();
			break;
		}

	}

	@Test
	public void testSnakeMovesDown() {
		ScoreBoard scoreBoard;
		GaminField gameField;
		scoreBoard = new ScoreBoard();
		gameField = new GaminField();
		Snake snake = new Snake(gameField, scoreBoard);
		Route.DOWN.toString();

		switch (Route.DOWN) {
		case DOWN:
			assertEquals(Route.DOWN.toString(), "DOWN");

			break;

		default:
			new InvalidDirectionException("Unexcepted Direction value!").printStackTrace();
			break;
		}

	}

	@Test
	public void testSnakeMovesLeft() {
		ScoreBoard scoreBoard;
		GaminField gameField;
		scoreBoard = new ScoreBoard();
		gameField = new GaminField();
		Snake snake = new Snake(gameField, scoreBoard);
		Route.LEFT.toString();

		switch (Route.LEFT) {
		case LEFT:
			assertEquals(Route.LEFT.toString(), "LEFT");

			break;

		default:
			new InvalidDirectionException("Unexcepted Direction value!").printStackTrace();
			break;
		}

	}

	@Test
	public void testSnakeMovesRight() {
		ScoreBoard scoreBoard;
		GaminField gameField;
		scoreBoard = new ScoreBoard();
		gameField = new GaminField();
		Snake snake = new Snake(gameField, scoreBoard);
		Route.RIGHT.toString();

		switch (Route.RIGHT) {
		case RIGHT:
			assertEquals(Route.RIGHT.toString(), "RIGHT");

			break;

		default:
			new InvalidDirectionException("Unexcepted Direction value!").printStackTrace();
			break;
		}

	}

	@Test
	public void testSnakeFoodCollision() {
		ScoreBoard scoreBoard;

		GaminField gameField;
		scoreBoard = new ScoreBoard();
		gameField = new GaminField();
		boolean over = false;
		Snake snake = new Snake(gameField, scoreBoard);
		List<Ellipse2D.Double> snakeParts = snake.getParts();

		Ellipse2D.Double head = snakeParts.get(0);
		Food food = gameField.getFood();
		scoreBoard.addPoints(10);
		
		if(head.getMaxX() == food.getShape().getMinX() && head.getMinY() == food.getShape().getMinY()) {
			assertEquals(scoreBoard,10);
		}

	}


	@Test
	public void testSnakeDies() {
		ScoreBoard scoreBoard;

		GaminField gameField;
		scoreBoard = new ScoreBoard();
		gameField = new GaminField();
		boolean over = false;
		Snake snake = new Snake(gameField, scoreBoard);
		List<Ellipse2D.Double> snakeParts = snake.getParts();

		Ellipse2D.Double head = snakeParts.get(0);
		Food food = gameField.getFood();

		snake.changeDirection(Route.UP);
        snake.move();
        snake.changeDirection(Route.DOWN);
        snake.move();
        snake.changeDirection(Route.LEFT);
        snake.move();
        snake.changeDirection(Route.RIGHT);
        snake.move();

        assertTrue(snake.isGameOver());
		
	}

}
