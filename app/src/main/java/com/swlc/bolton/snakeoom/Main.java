package com.swlc.bolton.snakeoom;

import com.swlc.bolton.snakeoom.impl.*;

import java.awt.EventQueue;
import java.awt.GridBagLayout;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main extends JFrame {

	private ScoreBoard scoreBoard;
	private GaminField gameField;
	private Thread thread;
	private Snake snake;

	// Current Routing of the snake
	private Route direction = Route.UP;

	private boolean started = false;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {
				GameInitPool.getMain().startGame();
			}
		});
	}

	public void startGame () {
		initComponents();
		initGame();
		initFrame();

		snake.changeDirection(direction);
		newGame();
	}

	private void initComponents() {
		setLayout(new GridBagLayout());
		addKeyListener(new KeyboardHandler());

		scoreBoard = new ScoreBoard();
		add(scoreBoard, new Grid(0, 8, 8, 1));

		gameField = new GaminField();
		add(gameField, new Grid(0, 0, 8, 8));

	}

	private void initGame() {
		snake = new Snake(gameField, scoreBoard);
		Runnable r = new GamePanel(gameField, snake, this);
		thread = new Thread(r);
	}

	private void initFrame() {
		pack();
		setTitle("Snake Game OOM");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setVisible(true);
	}

	public void newGame() {
		started = true;
		thread.start();
	}

	public boolean getStarted() {
		return started;
	}

	public void pauseGame(){
		started = false;
		thread.suspend();
	}

	public void restartPausedGame() {
		started = true;
		thread.resume();
	}

	public void gameOver() {
		int returnValue = JOptionPane.showConfirmDialog(this, "Do you want to start a new game?", "GAME OVER!",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);

		switch (returnValue) {
		case JOptionPane.OK_OPTION:
			direction = Route.UP;
			started = false;
			snake = new Snake(gameField, scoreBoard);
			scoreBoard.clear();
			gameField.initDefaults();
			scoreBoard.repaint();
			gameField.repaint();
			Runnable r = new GamePanel(gameField, snake, this);
			thread = null;
			thread = new Thread(r);

			snake.changeDirection(direction);
			newGame();

			break;

		case JOptionPane.CANCEL_OPTION:
			System.exit(0);
			break;
		default:
			JOptionPane.showMessageDialog(getParent(), "Something went wrong :( /n Please relaunch app");
			break;
		}
	}

	private class KeyboardHandler extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				if (direction == Route.DOWN)
					return;
				if (!started)
					newGame();
				if (snake != null) {
					snake.changeDirection(Route.UP);
					direction = Route.UP;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				if (direction == Route.UP)
					return;
				if (!started)
					newGame();
				if (snake != null) {
					snake.changeDirection(Route.DOWN);
					direction = Route.DOWN;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				if (direction == Route.RIGHT)
					return;
				if (!started)
					newGame();
				if (snake != null) {
					snake.changeDirection(Route.LEFT);
					direction = Route.LEFT;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				if (direction == Route.LEFT)
					return;
				if (!started)
					newGame();
				if (snake != null) {
					snake.changeDirection(Route.RIGHT);
					direction = Route.RIGHT;
				}
			}

			if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				if (started) {
					pauseGame();
				} else {
					restartPausedGame();
				}
			}
		}
	}
}
