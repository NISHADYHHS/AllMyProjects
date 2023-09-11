import processing.core.PApplet;
import processing.core.PImage;

import java.awt.event.KeyEvent;
public class DrawingSurface extends PApplet {
	
	Grid grid;
	PImage pawn;
	PImage queen;
	PImage king;
	PImage rook;
	PImage knight;
	PImage bishop;
	PImage wpawn;
	PImage wqueen;
	PImage wking;
	PImage wrook;
	PImage wknight;
	PImage wbishop;
	boolean whiteMove = true;
	public DrawingSurface() {
		
		
		
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		
		 pawn = loadImage("ChessPieces//pawn.jpg");
		 queen = loadImage("ChessPieces//queen.jpg");
		 king = loadImage("ChessPieces//king.jpg");
		 rook = loadImage("ChessPieces//rook.jpg");
		 knight = loadImage("ChessPieces//knight.jpg");
		 bishop = loadImage("ChessPieces//bishop.jpg");
		 
		 wpawn = loadImage("ChessPieces//wpawn.jpg");
		 wqueen = loadImage("ChessPieces//wqueen.jpg");
		 wking = loadImage("ChessPieces//wking.jpg");
		 wrook = loadImage("ChessPieces//wrook.jpg");
		 wknight = loadImage("ChessPieces//wknight.jpg");
		 wbishop = loadImage("ChessPieces//wbishop.jpg");


		 grid = new Grid(pawn, queen, king, knight, bishop, rook, wpawn,  wqueen,  wking,  wknight,  wbishop,  wrook );
		
	}
	
	public void draw() {
		
		
	
		grid.draw(this);
		
		
		
		}
		
	public void keyPressed() {
		
		
		 
	}

	
	public void mousePressed() {
		if(mouseButton == LEFT) {
			
			
			
		
			
			
			if(whiteMove ) {
				Loc locationSent = new Loc(mouseX/100, mouseY/100);
				//if(grid.getSlotAtLoc(locationSent).getPiece().getisWhite()) {
					
					if(!grid.getSlotAtLoc(locationSent).getPiece().getName().equals("Nothing") &&!grid.checkIfRed(locationSent)&& grid.getSlotAtLoc(locationSent).getPiece().getisWhite()) {
						
						grid.recordLoc(locationSent);
						grid.makeSlotRed(locationSent);
						grid.checkWherePieceCanMove(locationSent);
					}
					else if(!grid.getSlotAtLoc(locationSent).getPiece().getName().equals("Nothing") && grid.checkIfRed(locationSent) 
							&& grid.getRecordedWhite() == grid.getSlotAtLoc(locationSent).getPiece().getisWhite()) {
						System.out.println("fsdfsdaff");
						grid.clearBoard();
					}
					else if(grid.checkIfRed(locationSent)) { // place clicked is red and isnt filled
						//System.out.println(grid.returnLoc().getPiece().getName());
						if(grid.getRecordedWhite()) {
							grid.move(grid.getSlotAtLoc(locationSent)); // move saved 
							whiteMove = false;
							
							grid.clearBoard();
						}
					
				}
			}
			else {
				Loc locationSent = new Loc(mouseX/100, mouseY/100);
				
					
					if(!grid.getSlotAtLoc(locationSent).getPiece().getName().equals("Nothing") &&!grid.checkIfRed(locationSent) && !grid.getSlotAtLoc(locationSent).getPiece().getisWhite() ) {
						
						grid.recordLoc(locationSent);
						grid.makeSlotRed(locationSent);
						grid.checkWherePieceCanMove(locationSent);
					}
					else if(!grid.getSlotAtLoc(locationSent).getPiece().getName().equals("Nothing") && grid.checkIfRed(locationSent) 
							&& grid.getRecordedWhite() == grid.getSlotAtLoc(locationSent).getPiece().getisWhite()) {
						System.out.println("fsdfsdaff");
						grid.clearBoard();
					}
					else if(grid.checkIfRed(locationSent)) { // place clicked is red and isnt filled
						//System.out.println(grid.returnLoc().getPiece().getName());
						if(!grid.getRecordedWhite()) {
							grid.move(grid.getSlotAtLoc(locationSent)); // move saved 
							whiteMove = true;
							grid.clearBoard();
						}
					
				}
				
			}
			
			
				
			
			
		}
		
	}
	}
	


