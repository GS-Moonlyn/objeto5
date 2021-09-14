package objeto5;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import javax.swing.JComponent;
import javax.swing.JFrame;

public class Board extends JFrame{
	
	public static int boardWidth = 1000;
	public static int boardHeight = 800;
	
	public static void main(String[] args) {
		
		new Board();
		
	}
	
	public Board() {
		
		this.setSize(boardWidth, boardHeight);
		this.setTitle("Java Quadtree");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		GameDrawingPanel gamePanel = new GameDrawingPanel();
		
		this.add(gamePanel, BorderLayout.CENTER);
		
		ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(5);
		
		executor.scheduleAtFixedRate(new RepaintTheBoard(this), 0L, 20L, TimeUnit.MILLISECONDS);
		
		this.setVisible(true);
	}
	
	
}

class RepaintTheBoard implements Runnable {
	
	Board theBoard;
	
	public RepaintTheBoard(Board theBoard) {
		this.theBoard = theBoard;
	}

	@Override
	public void run() {
		
		theBoard.repaint();
	}
	
}

class GameDrawingPanel extends JComponent{
	
	public ArrayList<Ball> balls = new ArrayList<Ball>();
	
	int[] polyXArray = Ball.sPolyXArray;
	int[] polyYArray = Ball.sPolyYArray;
	
	int width = Board.boardWidth;
	int height = Board.boardHeight;
	
	public GameDrawingPanel() {
		
		for(int i = 0; i < 50; i++) {
			
			int randomStartXPos = (int) (Math.random() * (Board.boardWidth - 40) + 1);
			int randomStartYPos = (int) (Math.random() * (Board.boardHeight - 40) + 1);
			
			balls.add(new Ball(Ball.getpolyXArray(randomStartXPos), Ball.getpolyYArray(randomStartYPos), 13, randomStartXPos, randomStartYPos));
			Ball.balls = balls;
			
		}
	}
	
	public void paint(Graphics g) {
		
		Graphics2D graphicSettings = (Graphics2D)g;
		
		graphicSettings.setColor(Color.BLACK);
		graphicSettings.fillRect(0, 0, getWidth(), getHeight());
		
		graphicSettings.setRenderingHint( RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		
		graphicSettings.setPaint(Color.WHITE);
		
		for(Ball ball : balls) {
			
			ball.move();
			
			graphicSettings.draw(ball);
		}
	}
}
