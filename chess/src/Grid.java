import java.util.ArrayList; 

import processing.core.PApplet;
import processing.core.PImage;


public class Grid {

	private Slots slots[][];
	
	private PImage pawn;
	private PImage queen;
	private PImage king;
	private PImage knight;
	private PImage bishop;
	private PImage rook;
	
	private PImage wpawn;
	private PImage wqueen;
	private PImage wking;
	private PImage wknight;
	private PImage wbishop;
	private PImage wrook;

	private Loc recordingLoc;
	
	
	public Grid(PImage pawn, PImage queen, PImage king, PImage knight, PImage bishop, PImage rook,
			PImage wpawn, PImage wqueen, PImage wking, PImage wknight, PImage wbishop, PImage wrook) {
		
		this.pawn = pawn;
		this.queen = queen;
		this.king = king;
		this.knight = knight;
		this.bishop = bishop;
		this.rook = rook;
		this.wpawn = wpawn;
		this.wqueen = wqueen;
		this.wking = wking;
		this.wknight = wknight;
		this.wbishop = wbishop;
		this.wrook = wrook;
		slots = new Slots[8][8];
		
		
		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
				
						if(j == 1 ) {
							slots[i][j] = new Slots(new Pawn( new Loc(i,j), false),true, new Loc(i,j));slots[i][j].setClicked(false);
						}
						else if(j == 6) {
							slots[i][j] = new Slots(new Pawn( new Loc(i,j), true),true, new Loc(i,j));slots[i][j].setClicked(false);			
						}
						else if((j == 0) && (i == 1 || i == 6) ) {
							slots[i][j] = new Slots(new Knight( new Loc(i,j), false),true, new Loc(i,j));slots[i][j].setClicked(false);						
						}
						else if((j == 7) && (i == 1 || i == 6)) {
							slots[i][j] = new Slots(new Knight( new Loc(i,j), true),true, new Loc(i,j));slots[i][j].setClicked(false);
						}
						else if((j == 0) && (i == 0 || i == 7)) {
							slots[i][j] = new Slots(new Rook( new Loc(i,j), false),true, new Loc(i,j));slots[i][j].setClicked(false);
						}
						else if((j == 7) && (i == 0 || i == 7)) {
							slots[i][j] = new Slots(new Rook( new Loc(i,j), true),true, new Loc(i,j));slots[i][j].setClicked(false);
						}
						else if((j == 0) && (i == 2 || i == 5)) {
							slots[i][j] = new Slots(new Bishop( new Loc(i,j), false),true, new Loc(i,j));slots[i][j].setClicked(false);	
						}
						else if((j == 7) && (i == 2 || i == 5)) {	
							slots[i][j] = new Slots(new Bishop( new Loc(i,j), true),true, new Loc(i,j));slots[i][j].setClicked(false);	
						}
						else if((j == 0) && (i == 3)) {	
							slots[i][j] = new Slots(new Queen( new Loc(i,j),false),true , new Loc(i,j)); slots[i][j].setClicked(false);
						}
						else if((j == 7) && (i == 3)) {
							slots[i][j] = new Slots(new Queen( new Loc(i,j),true), true, new Loc(i,j));slots[i][j].setClicked(false);
						}
						else if((j == 0) && (i == 4)) {
							slots[i][j] = new Slots(new King( new Loc(i,j),false),true, new Loc(i,j));slots[i][j].setClicked(false);	
						}
						else if((j == 7) && (i == 4)) {	
							slots[i][j] = new Slots(new King( new Loc(i,j),true),true,  new Loc(i,j));slots[i][j].setClicked(false);		
						}
						else {
							slots[i][j] = new Slots(new Nothing(new Loc(i,j)), false, new Loc(i,j));slots[i][j].setClicked(false);
						}
		
			}
		
	}
	}
	
	
	public Slots getSlotAtLoc(Loc location) {
		
		int lx = location.getX();
		int ly = location.getY();
		
		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
					
				if(lx == j && ly == i) {
					return slots[j][i];
				}
				
				}		
			}
		return slots[lx][ly];
	}
	
	public void recordLoc(Loc locationSent) {
		
		
		recordingLoc = new Loc(locationSent.getX(), locationSent.getY());
	}
	
	
	
	public void makeSlotRed(Loc location) {
		
		int i = location.getX();
		int j = location.getY();
		
		if(slots[i][j].getClicked() == false ) {
			
			slots[i][j].setClicked(true);
		}
		else {
			
			
			slots[i][j].setClicked(false);
		}
	}
	
	public boolean checkIfRed(Loc location) {
		
		int i = location.getX();
		int j = location.getY();
		if(slots[i][j].getClicked() == false) {
			
			return false;
		}
		else {
			
			return true;
		}
	}
	
	public void clearBoard() {
		
		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
					
					slots[i][j].setClicked(false);
				
				}		
			}
	}
	
	public boolean getRecordedWhite() {
		
		return slots[recordingLoc.getX()][recordingLoc.getY()].getPiece().getisWhite();
	}
	
	
	public void move( Slots slot2) {
		
		int x1 = recordingLoc.getX();
		int y1 = recordingLoc.getY();
		
		int x2 = slot2.getLocation().getX();
		int y2 = slot2.getLocation().getY();
		
		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
					System.out.print(slots[i][j].getPiece().getName().charAt(0) + " | ");
				}
				System.out.println();
			}
		System.out.println();
		System.out.println();
		
		
		
			slots[x2][y2].setPiece(slots[x1][y1].getPiece());
			slots[x1][y1].removePiece();
		
		
		
		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
					System.out.print(slots[i][j].getPiece().getName().charAt(0) + " | ");
				}
				System.out.println();
			}
	}
	
	
	
	public void checkWherePieceCanMove(Loc location) {
		
		int i = location.getX();
		int j = location.getY();
		ArrayList<ArrayList<Loc>> possibleLocs = new ArrayList<ArrayList<Loc>>();
		ArrayList<Loc> actualLocs = new ArrayList<Loc>();
		ArrayList<Loc> kLoc = new ArrayList<Loc>();
		
		if(slots[i][j].getPiece().getName().equals("Nothing"))
			System.out.println();
		else if(slots[i][j].getPiece().getName().equals("Knight")) {
			kLoc = slots[i][j].getPiece().getKMoves(location);
		}else 
			possibleLocs = slots[i][j].getPiece().getMoves(location);
		
		
		
		
		if(slots[i][j].getPiece().getName().equals("Pawn")){// IF THE PIECE IS A PAWN
			int c = 0;
			for(ArrayList<Loc> e: possibleLocs) {
				
				for(Loc f: e) {
					
					if(c != 0) {
						if(!slots[f.getX()][f.getY()].getPiece().getName().equals("Nothing") &&slots[f.getX()][f.getY()].getPiece().getisWhite()!= slots[i][j].getPiece().getisWhite())
							actualLocs.add(new Loc(f.getX(),f.getY()));//^ CHECKS IF THE PAWN CAN MOVE DIAGONALLY BY CHECKING IF PIECES ARE PRESENT
					}
					else {
						if(slots[f.getX()][f.getY()].getPiece().getName().equals("Nothing"))// CHECKS IF THE SQUARE AHEAD OF IT IS OPEN
							actualLocs.add(new Loc(f.getX(),f.getY()));
					}
					c++;
				}
			}
		}
		else if(slots[i][j].getPiece().getName().equals("Knight")) {
			
			for(Loc e: kLoc) {
				
				if(!slots[e.getX()][e.getY()].getPiece().getName().equals("Nothing") &&slots[e.getX()][e.getY()].getPiece().getisWhite()!= slots[i][j].getPiece().getisWhite())
					actualLocs.add(new Loc(e.getX(), e.getY()));
				if(slots[e.getX()][e.getY()].getPiece().getName().equals("Nothing"))// CHECKS IF THE SQUARE AHEAD OF IT IS OPEN
					actualLocs.add(new Loc(e.getX(),e.getY()));
			}
			
		}
		else if(slots[i][j].getPiece().getName().equals("King")) {
			
			for(ArrayList<Loc> e: possibleLocs) {
				
				for(Loc f: e) {
						
					if(!slots[f.getX()][f.getY()].getPiece().getName().equals("Nothing") &&slots[f.getX()][f.getY()].getPiece().getisWhite()!= slots[i][j].getPiece().getisWhite())
						actualLocs.add(new Loc(f.getX(), f.getY()));
						
					if(slots[f.getX()][f.getY()].getPiece().getName().equals("Nothing"))// CHECKS IF THE SQUARE AHEAD OF IT IS OPEN
						actualLocs.add(new Loc(f.getX(),f.getY()));
					
					}
					
					}
				}
		else {
			for(ArrayList<Loc> e: possibleLocs) {// IF THE PIECE IS ROOK/BISHOP/KING/QUEEN
				
				
				
				
				for(int loccount = 1; loccount < e.size(); loccount++){
					System.out.println(loccount + ": " + e.get(loccount).getX() + " "+e.get(loccount).getY());
					if(!slots[e.get(loccount).getX()][e.get(loccount).getY()].getPiece().getName().equals("Nothing")) {
						
						if(slots[e.get(loccount).getX()][e.get(loccount).getY()].getPiece().getisWhite() != slots[i][j].getPiece().getisWhite())
							actualLocs.add(new Loc(e.get(loccount).getX(), e.get(loccount).getY()));
						
						loccount  = e.size();
					}
					else {
						actualLocs.add(new Loc(e.get(loccount).getX(), e.get(loccount).getY()));
					}
					
					
			
				}
				
			}
		}
		
		for(Loc e: actualLocs) {
			
			
				makeSlotRed(e);
		}
		
		
	}
	
	
	public void draw(PApplet marker) {
		
		 
		for(int j = 0; j < slots.length; j++) {
			
			for(int i = 0; i < slots[0].length; i++) {
				
				if(slots[i][j].getPiece().getName().equals("Nothing") == true && slots[i][j].getClicked() == false) {
					
					marker.fill(255);
					marker.rect(slots[i][j].getLocation().getX() * 100, slots[i][j].getLocation().getY() * 100, 100, 100 );
				}
				if( slots[i][j].getClicked() == true && slots[i][j].getPiece().getName().equals("Nothing") == true ) {
					
					marker.fill(255,0,0);
					marker.rect(slots[i][j].getLocation().getX() * 100, slots[i][j].getLocation().getY() * 100, 100, 100 );
				}
				else if(!slots[i][j].getPiece().getName().equals("Nothing")) {
					
					if(slots[i][j].getClicked() == false)
						marker.fill(255);
					if(slots[i][j].getClicked() == true)
						marker.fill(255,0,0);
					
					marker.rect(slots[i][j].getLocation().getX() * 100, slots[i][j].getLocation().getY() * 100, 100, 100 );
					String thePiece = slots[i][j].getPiece().getName();
					if(thePiece.equals("Pawn")) {
						
						if(slots[i][j].getPiece().getisWhite()) {
							marker.image(wpawn, slots[i][j].getLocation().getX() * 100 + 4, slots[i][j].getLocation().getY() * 100 + 4);
						}
						else {
							marker.image(pawn, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
					}
					else if(thePiece.equals("Queen")) {
						
						if(slots[i][j].getPiece().getisWhite()) {
							 marker.image(wqueen, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
						else {
							 marker.image(queen, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
					}
					else if(thePiece.equals("Bishop")) {
						
						if(slots[i][j].getPiece().getisWhite()) {
							marker.image(wbishop, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
						else {
							marker.image(bishop, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
					}
					else if(thePiece.equals("King")) {
						
						if(slots[i][j].getPiece().getisWhite()) {
							marker.image(wking, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
						else {
							marker.image(king, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
					}
					else if(thePiece.equals("Knight")) {
						
						if(slots[i][j].getPiece().getisWhite()) {
							marker.image(wknight, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
						else {
							marker.image(knight, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
					}
					else if(thePiece.equals("Rook")) {
						
						if(slots[i][j].getPiece().getisWhite()) {
							marker.image(wrook, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
						else {
							marker.image(rook, slots[i][j].getLocation().getX() * 100+ 4, slots[i][j].getLocation().getY() * 100+ 4);
						}
					}
				}
				
				
				}
			}
		
		
	}


	
	
	
}
