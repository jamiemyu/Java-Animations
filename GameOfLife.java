package intermediateJava;

import apcs.Window;

public class GameOfLife {
	static int cw = 50;
	static int ch = 50;
	public static void main(String[] args) {
		Window.size(600, 600);
		int side = Window.width()/cw;
		
		boolean[][] cells = new boolean [cw][ch];

/**
 * COMMENT THIS OUT for a blank board (to allow manual drawing of cells at t=0.
 */
//		for(int y = 0; y < ch; y++){
//			for (int x=0; x < cw; x++){
//				cells[y][x] = Window.flipCoin();
//			}
//		}

		while(true) {
			Window.frame();
			Window.out.background("white");
			Window.out.color("red");
			for(int y = 0; y < ch; y++) {
				for (int x=0; x < cw; x++) {
					if(cells[y][x] == true) Window.out.square(x*side + side/2, y*side + side/2, side - 1);
				}
			}
			
			int xClick = 0;
			int yClick = 0;
			if (Window.mouse.clicked()) {
				// (x,y) coordinate 
				xClick = Window.mouse.getX() / side;
			    yClick = Window.mouse.getY() / side;
			    cells[yClick][xClick] = true;
			}
			
			if (Window.key.pressed(' ')) cells = life(cells);
		 }	
	}
		
	private static boolean[][] life(boolean[][] cells) {
		
		boolean[][] cells_copy = new boolean[ch][cw];
		for(int y = 0; y < ch; y++){
			for (int x=0; x < cw; x++){
				int neighbors=0;
				
				// top left
				if (x > 0 && y > 0 && cells[y-1][x-1]) neighbors++;

				// bottom right
				if(x < cw-1 && y < ch-1 && cells[y+1][x+1]) neighbors++;
				
				
				// top right
				if(x < cw-1 && y > 0 &&  cells[y-1][x+1]) neighbors++;
				
				// bottom left
				if(x > 0 && y < ch-1 && cells [y+1][x-1]) neighbors++;
				
				
				// bottom middle
				if(y < ch-1 && cells[y+1][x]) neighbors++;
				
				// top middle
				if (y > 0 && cells[y-1][x]) neighbors++;
				
				
				// middle right
				if(x < cw-1 && cells[y][x+1]) neighbors++;	

				// middle left
				if(x > 0 && cells[y][x-1]) neighbors++;
			
				
				if(cells[y][x] == true) {
					//if alive
					if(neighbors == 0 || neighbors == 1) cells_copy[y][x] = false;
					else if(neighbors == 2 || neighbors == 3) cells_copy[y][x] = true;
					else if(neighbors >= 4) cells_copy[y][x] = false;
				} else {
					if (neighbors==3) cells_copy[y][x] = true;
				}
			}
		}	
		return cells_copy;
	}
}

