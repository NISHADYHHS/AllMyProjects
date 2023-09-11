import java.util.ArrayList;

public class Bishop extends Piece {
	public Bishop(Loc location, boolean isWhite) {
		super(location);
		
		this.isWhite = isWhite;
		this.name = "Bishop";
		this.filename = "ChessPieces//bishop.jpg";
	}
	
	 @Override public ArrayList<ArrayList<Loc>> getMoves(Loc location){
		
		ArrayList<Loc> upperRight = new  ArrayList<Loc>();//x++, y--
		ArrayList<Loc> upperLeft = new  ArrayList<Loc>();//x-- y--
		ArrayList<Loc> lowerRight = new  ArrayList<Loc>();//x++ y++
		ArrayList<Loc> lowerLeft = new  ArrayList<Loc>();//x-- y++
		ArrayList<ArrayList<Loc>> locations = new  ArrayList<ArrayList<Loc>>();
		int x = location.getX();
		int y = location.getY();
		
		int urX = x;int urY = y;int ulX = x;int ulY = y;int lrX = x;int lrY = y;int llX = x;int llY = y;
		
		while(urX < 8 && urY >= 0) {//upper right
			upperRight.add(new Loc(urX,urY));
			urX++;
			urY--;
		}
		while(ulX >= 0 && ulY >= 0) {//upper left
			upperLeft.add(new Loc(ulX,ulY));
			ulX--;
			ulY--;
		}
		while(lrX < 8 && lrY < 8) {// lower right
			lowerRight.add(new Loc(lrX,lrY));
			lrX++;
			lrY++;
		}
		while(llX >= 0 && llY < 8) {//lower left
			lowerLeft.add(new Loc(llX,llY));
			llX--;
			llY++;
		}
		

		locations.add(upperRight);
		locations.add(upperLeft);
		locations.add(lowerRight);
		locations.add(lowerLeft);
		return locations;
		
	}
}
