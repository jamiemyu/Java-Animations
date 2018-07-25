package JavaDay2;

import apcs.Window;

public class BouncyBall {

	public static void main(String[] args) {
		int width = 800;
		int height = 600;
		Window.size(width, height);
		
		// Select a random starting point for the ball
		int x = 200;
		int y = 300;
		int radius = 50; 
		Window.out.background("yellow");
		Window.out.color("red");
		Window.out.circle(x, y, radius);
		
		// Change the location of the ball by ∆x, ∆y
		int dx = 10;
		int dy = 10;
		
		while (true) {

			// If the x coordinate reaches out of the width, change the direction
			if (x >= (width - radius) || x <= radius) {
				dx = -dx;
			}
			x += dx;
			
			// If the y coordinate reaches out of the height, change the direction
			if (y >= (height - radius) || y <= radius) {
				dy = -dy;
			} 
			y += dy;
			
			
			// Update the ball position
			Window.out.background("yellow");
			Window.out.color("red");
			Window.out.circle(x,  y,  radius);
			Window.frame();
		}
	}

}
