package JavaDay2;

import apcs.Window;

public class Bouncy {
	public static void main(String[] args) {
		// Set up initial Window view.
		int width = 600;
		int height = 600;
		
		Window.size(width, height);
		
		int x = Window.random(200, 400);
		int y = Window.random(200, 400);
		int radius = 30;
		Window.out.color("pink");
		Window.out.circle(x, y, radius);

		int speedX = 7; 
		int speedY = -6;
		while (true) {
			// 1) Erase old ball
			//Window.frame();
			
			
			
			//  2) Create a new ball
			
				// Check if the ball hits a boundary
				//	Do something if the ball hits a boundary
				if (x >= (width - radius) || x <= radius) {
					// Change x direction
					speedX = -speedX;
				}
				
				if (y >= (height - radius) || y <= radius) {
					speedY = -speedY;
				}
			
			
				// Change our x value on every turn
				x = x + speedX;
				
				// change our y value on every turn
				y = y + speedY;
				
				Window.out.randomColor();
				Window.out.circle(x, y, radius);
		
				
			
			
			
			
		}
		
		
	}
}
