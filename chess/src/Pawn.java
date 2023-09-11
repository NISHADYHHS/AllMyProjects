import java.util.ArrayList;

public class Pawn extends Piece {

	public Pawn(Loc location, boolean isWhite) {
		super(location);
		
		this.isWhite = isWhite;
		this.name = "Pawn";
		this.filename = "ChessPieces//pawn.jpg";
	}
	
	 @Override public ArrayList<ArrayList<Loc>> getMoves(Loc location){
		 ArrayList<ArrayList<Loc>> locations = new  ArrayList<ArrayList<Loc>>();

		 
		if(isWhite == true) {
			ArrayList<Loc> forward = new  ArrayList<Loc>();//y--
			ArrayList<Loc> upperLeft = new  ArrayList<Loc>();//x-- y--
			ArrayList<Loc> upperRight = new  ArrayList<Loc>();//x++, y--
			
			if(location.getY() > 0)//forward
				forward.add(new Loc(location.getX(), location.getY() -1));
			else
				forward.add(new Loc(location.getX(), location.getY()));
			
			if(location.getY() > 0 && location.getX() > 0)//upper left
				upperLeft.add(new Loc(location.getX() -1, location.getY() -1));
			else
				upperLeft.add(new Loc(location.getX(), location.getY()));
			
			if(location.getX() < 7 && location.getY() > 0)// upper right
				upperRight.add(new Loc(location.getX()+1, location.getY() -1));
			else
				upperRight.add(new Loc(location.getX(), location.getY()));
			
			locations.add(forward);
			locations.add(upperLeft);
			locations.add(upperRight);
			return locations;
		}
		else {
			
			ArrayList<Loc> forward = new  ArrayList<Loc>();//y++
			ArrayList<Loc> lowerLeft = new  ArrayList<Loc>();//x-- y++
			ArrayList<Loc> lowerRight = new  ArrayList<Loc>();//x++, y++
			
			if(location.getY() < 7)//forward
				forward.add(new Loc(location.getX(), location.getY() +1));
			else
				forward.add(new Loc(location.getX(), location.getY()));
			
			if(location.getX() > 0 && location.getY() < 7)//upper left
				lowerLeft.add(new Loc(location.getX() -1, location.getY() +1));
			else
				lowerLeft.add(new Loc(location.getX(), location.getY()));
			
			if(location.getX() < 7 && location.getY() < 7)// upper right
				lowerRight.add(new Loc(location.getX()+1, location.getY() +1));
			else
				lowerRight.add(new Loc(location.getX(), location.getY()));
			
			
			
			locations.add(forward);
			locations.add(lowerLeft);
			locations.add(lowerRight);
			return locations;

		}
	 }

}
