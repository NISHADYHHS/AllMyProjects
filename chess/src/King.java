import java.util.ArrayList;

public class King extends Piece {
	public King(Loc location, boolean isWhite) {
		super(location);
		
		this.isWhite = isWhite;
		this.name = "King";
		this.filename = "ChessPieces//king.jpg";
	}
	
@Override public ArrayList<ArrayList<Loc>> getMoves(Loc location){
		
		ArrayList<Loc> up = new  ArrayList<Loc>();//y--
		ArrayList<Loc> down = new  ArrayList<Loc>();//y++
		ArrayList<Loc> left = new  ArrayList<Loc>();//x--
		ArrayList<Loc> right = new  ArrayList<Loc>();//x++
		
		ArrayList<Loc> upperRight = new  ArrayList<Loc>();//x++, y--
		ArrayList<Loc> upperLeft = new  ArrayList<Loc>();//x-- y--
		ArrayList<Loc> lowerRight = new  ArrayList<Loc>();//x++ y++
		ArrayList<Loc> lowerLeft = new  ArrayList<Loc>();//x-- y++
		
		ArrayList<ArrayList<Loc>> locations = new  ArrayList<ArrayList<Loc>>();
	
		int x = location.getX();
		int y = location.getY();
		
		if(y > 0) {
			up.add(new Loc(x, y -1));//y--
			if(x > 0)
				upperLeft.add(new Loc(x-1, y -1));//x-- y--
			if(x < 7)
				upperRight.add(new Loc(x+1, y -1));//x++, y--
		}
		if(y <= 7) {
			down.add(new Loc(x, y +1));//y++
			if(x < 7)
				lowerRight.add(new Loc(x+1, y +1));//x++ y++
			if(x > 0)
				lowerLeft.add(new Loc(x-1, y +1));//x-- y++
		}
		
		if(x > 0)
			left.add(new Loc(x-1, y ));//x--
		if(x < 7)
			right.add(new Loc(x+1, y ));//x++
	
		
		
		
		
		
		locations.add(up);
		locations.add(down);
		locations.add(left);
		locations.add(right);
		locations.add(upperRight);
		locations.add(upperLeft);
		locations.add(lowerRight);
		locations.add(lowerLeft);
		
		return locations;
		
	}
}
