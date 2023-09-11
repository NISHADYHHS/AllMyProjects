import java.util.ArrayList;

public class Rook extends Piece {
	public Rook(Loc location, boolean isWhite) {
		super(location);
		
		this.isWhite = isWhite;
		this.name = "Rook";
		this.filename = "ChessPieces//rook.jpg";
	}
	
@Override public ArrayList<ArrayList<Loc>> getMoves(Loc location){
		
		ArrayList<Loc> up = new  ArrayList<Loc>();//y--
		ArrayList<Loc> down = new  ArrayList<Loc>();//y++
		ArrayList<Loc> left = new  ArrayList<Loc>();//x--
		ArrayList<Loc> right = new  ArrayList<Loc>();//x++
		
		ArrayList<ArrayList<Loc>> locations = new  ArrayList<ArrayList<Loc>>();
		
		int x = location.getX();
		int y = location.getY();
		
		int rightX = x;int upY = y;int leftX = x;int downY = y;
		
		while(upY >= 0) {//up
			up.add(new Loc(x,upY));
			upY--;
		}
		while(downY < 8) {//down
			down.add(new Loc(x,downY));
			downY++;
		}
		while(leftX >= 0) {//left
			left.add(new Loc(leftX,y));
			leftX--;
		}
		while(rightX < 8) {//right
			right.add(new Loc(rightX,y));
			rightX++;
		}
		
		
		

		locations.add(up);
		locations.add(down);
		locations.add(left);
		locations.add(right);
		return locations;
		
	}

}
