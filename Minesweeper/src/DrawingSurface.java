import processing.core.PApplet;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import processing.core.PImage;


public class DrawingSurface extends PApplet {

	private Grid grid;
	private int count1 = 0;
	private boolean bombstart = false;
	private int magicalNumber = 0;
	public DrawingSurface() {
		
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
		
		grid = new Grid("Grid//Grid", false);
		
		grid.drawRandomizedGrid();
		grid.makeArray();
		
		
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		background(192,192,192);   // Clear the screen with a white background
		
		
		
		
			if(grid.getStatus() == false) {
			
			
				
				
				grid.makeList();
				//grid.makeDisplay();
				grid.drawGrid(this);
			
			
			
			
		}
		else {
			textSize(100);
			text("GAME OVER",50,50);
			grid.drawGrid(this);
			grid.makeList();
			grid.makeDisplay();
			
		}
		
		
			
	}
	
	public void mousePressed() {
		
		if(mouseButton == LEFT) {
			
			
			
			
			//System.out.println(bombstart);
			
				for(Tile e: grid.getGrid()) {
				
				
					if((e.getX() <= mouseX && e.getX() + 39 >= mouseX) && (e.getY() <= mouseY && e.getY() + 39 >= mouseY) ) {
						
							
								
								
						if(e.getBomb() == true && count1 > 0 && bombstart == false) {
							 System.out.println("END");
							grid.gameOver();
							//grid.drawRandomizedGrid();
							break;
						}
							 
							  if(count1 == 0 && e.getBomb() == false ) {
								  
								  	
								  	grid.drawPart(e.getIndex());
								  	grid.makeDisplay();
								  	grid.makeArray();
								  	
								  	grid.drawGrid(this);
								
								  	 bombstart = false;
								 	//grid.print();
								 	 count1++;
								 	break;
									
							 }
							  else if(count1 == 0 && e.getBomb() == true ) {
								  	System.out.println("fdhfdsuhifdsadyashduifgsoigufdgifousydagydfosiuagiyusdaf");
								  	grid.drawPart(e.getIndex());
								  	grid.makeDisplay();
								  	grid.makeArray();
								  	
								  	grid.drawGrid(this);
								
								 	
								 	//grid.print();
								  	bombstart = true;
								 	 count1++;
								 	break;
							  }
							  else if(e.getBomb() == false && count1> 0) {
								  
								//  grid.makeDisplay();
								  bombstart = false;
								  grid.check(e.getIndex());
								  break;
								  
								  
							  }
							   
						
							 
						
						
						
					}
				
				
				
				}
				
				
				
			}
		if(mouseButton == RIGHT) {
			int count  = 0;
		//	grid.makeArrayFromList();
			grid.makeDisplay();
			
			for(Tile e: grid.getGrid()) {
				
				
				if((e.getX() <= mouseX && e.getX() + 39 >= mouseX) && (e.getY() <= mouseY && e.getY() + 39 >= mouseY) ) {
					
					
						if(e.getFlag() == false && count == 0) {
							e.setFlag(true);
							count++;
						}
						
						if(e.getFlag() == true && count == 0) {
							e.setFlag(false);
							count++;
						}
						
				//	grid.gameOver();
					
					
				}
			
			
			
			}
			
		}
				
				
			}
		}
	
	
	

