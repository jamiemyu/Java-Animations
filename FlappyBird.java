package JavaDay4;

import apcs.Window;

public class FlappyBird {
	static int width = 600;
	static int height = 750;
	static int radius = 30;
	static int gravity = 10;
	static int x = 50;
	static int y = height / 2;
	static int spaceBetweenPoles = 200;
	static int poleWidth = 50;
	static int speedPoles = 10;
	static int polePosition = width;
	static int score = 0;
	
	public static void main(String[] args) {
		Window.size(width, height);
		drawBackground();
		drawBird(x, y);
		
		int topPoleHeight = Window.random(0, height / 2);
		int bottomPoleHeight = height - topPoleHeight - spaceBetweenPoles;
		
		while (true) {
			Window.frame();
			
			// -----------------------------------------------------------------------------------------------
			// CHECK FOR VALID BIRD POSITION
			if (x + radius >= polePosition && x + radius <= polePosition + poleWidth) {
				if (y < topPoleHeight || y > (topPoleHeight + spaceBetweenPoles)) {
					break;
				} else {
					score = score + 1;
				}
			}
			
			// -----------------------------------------------------------------------------------------------
			// UPDATE BIRD POSITION
			// Holding down on the mouse = fly up; no hold = fall down
			if (Window.mouse.clicked() != true) {
				y = y + gravity;
			} else {
				y = y - gravity;
			}
			
			// -----------------------------------------------------------------------------------------------
			// UPDATE POLE POSITION
			if (polePosition > 0) {
				polePosition = polePosition - speedPoles;
			} else if (polePosition <= width / 2) {
				topPoleHeight = Window.random(0, height / 2);
				bottomPoleHeight = height - topPoleHeight - spaceBetweenPoles;
				polePosition = width;
			}
			
			// -----------------------------------------------------------------------------------------------
			// DRAW
			drawBackground();
			drawBird(x, y);
			drawPoles(polePosition, topPoleHeight, bottomPoleHeight);
			drawScore(score);
		}
		endGame();
	}
	
	public static void drawBackground() {
		Window.out.background("sky blue");
		
		// Tree
		Window.out.color("dark green");
		Window.out.circle(width / 6, height - 100, 150);
		drawTrunk(width / 6);
		
		// Tree
		Window.out.color("light green");
		Window.out.circle(width / 2, height - 150, 150);
		drawTrunk(width / 2);
		
		// Tree
		Window.out.color("dark green");
		Window.out.circle(width / 2 + (2 * (width / 6)), height - 120, 150);
		drawTrunk(width / 2 + (2 * (width / 6)));
	}
	
	public static void drawLeaves(int centerWidth) {
		
	}
	
	public static void drawTrunk(int centerWidth) {
		// Draw trunk
		Window.out.color(107,72,27);
		Window.out.rectangle(centerWidth, height, 50, height/4);
		
		// Draw shadow lines
		Window.out.color(128,100,63);
		Window.out.rectangle(centerWidth - 7, height, 2, height/4);
		Window.out.color(128,100,63);
		Window.out.rectangle(centerWidth + 5, height, 2, height/4);
		Window.out.color(128,100,63);
		Window.out.rectangle(centerWidth, height, 2, height/4);
		Window.out.color(128,100,63);
		Window.out.rectangle(centerWidth + 18, height, 2, height/4);
		Window.out.color(128,100,63);
		Window.out.rectangle(centerWidth - 18, height, 2, height/4);
	}
	
	public static void drawBird(int x, int y) {
		//Window.out.color("yellow");
		//Window.out.circle(x, y, radius);
		Window.out.image("./Desktop/flappybird.png", x, y);
	}
	
	public static void drawPoles(int polePosition, int topPoleHeight, int bottomPoleHeight) {
		// Top pole
		Window.out.color(113,155,97);
		Window.out.rectangle(polePosition, topPoleHeight / 2, poleWidth, topPoleHeight);
		Window.out.color(54,80,45);
		Window.out.rectangle(polePosition, topPoleHeight, poleWidth + 10, 10);
		
		// Bottom pole
		Window.out.color(113,155,97);
		Window.out.rectangle(polePosition, height - bottomPoleHeight / 2, poleWidth, bottomPoleHeight);
		Window.out.color(54,80,45);
		Window.out.rectangle(polePosition, height - bottomPoleHeight, poleWidth + 10, 10);
	}
	
	public static void drawScore(int score) {
		// We have to divide our score because the score counter increments
		// over multiple frames
		score = score / (speedPoles / 2);
		Window.out.color("white");
		Window.out.fontSize(30);
		Window.out.print(score, 50, 50);
	}
	
	public static void endGame() {
		Window.out.background("Black");
		Window.out.fontSize(30);
		Window.out.color("White");
		Window.out.print("GAME OVER", 175, height / 2);
		Window.frame();
	}
}
