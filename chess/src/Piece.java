
import java.util.ArrayList;

import processing.core.PApplet;


public abstract class Piece {
	
	protected Loc location;
	protected String name;
	protected String filename;
	protected boolean isWhite = true;
	
	public Piece(Loc location, String name, String filename, boolean isWhite) {
		
		this.location = location;
		this.name = name;
		this.filename = filename;
		this.isWhite = isWhite;
		
	}
	
	public Piece(Loc location) {
		
		this.location = location;
		this.name = "Nothing";
		
		
	}
	
	public ArrayList<ArrayList<Loc>> getMoves(Loc location){
		
		ArrayList<ArrayList<Loc>> locations = new  ArrayList<ArrayList<Loc>>();
		
			
		return locations;
		
	}
	
	public ArrayList<Loc> getKMoves(Loc location){
		
		ArrayList<Loc> locations = new  ArrayList<Loc>();
		
			
		return locations;
		
	}
	
	
	public String getfilename() {
		
		return filename;
	}
	
	public boolean getisWhite() {
		
		return isWhite;
	}
	
	public Loc getLocation() {
		
		return location;
		
	}
	
	public String getName() {
		
		return name;
	}
	
	public void setName(String name) {
		
		this.name = name;
		}
	
	public void setLocation(Loc location) {
		
		this.location = location;
	}
	
	
	
	
	
}
