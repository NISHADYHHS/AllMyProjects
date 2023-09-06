import processing.core.PApplet;
import java.awt.event.KeyEvent;
public class DrawingSurface extends PApplet {
	
	Grid grid;
	boolean pressed = false;
	
	public DrawingSurface() {
		grid = new Grid();
		
		
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
		
		//pad.drawGrid(this);
		
		
	}
	
	public void draw() {
		
		
	
		grid.draw(this);
		
		if (key == CODED) {
		    if (keyCode == UP) {
		    	grid.reset();
		    	grid.up();
		    	pressed = true;
		    	
		    	}
		    else if(keyCode == LEFT) {
		    	grid.reset();
		    	grid.left();
		    	pressed = true;
		    	}	
		    else if(keyCode == RIGHT) {
		    	grid.reset();
		    	grid.right();
		    	pressed = true;
	    		}	
		    else if(keyCode == DOWN) {
		    	grid.reset();
		    	grid.down();
		    	pressed = true;
		    	
		    	
	    		}	
		    }
		
		
		}
		
	public void keyPressed() {
		
		if (key == CODED) {
			if(pressed == true) {
				grid.reset();
				grid.randomADD();
				pressed = false;
			
			}
		    }
		 
	}

	}
	


