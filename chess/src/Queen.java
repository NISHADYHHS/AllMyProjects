import java.util.ArrayList;

public class Queen extends Piece {
	public Queen(Loc location, boolean isWhite) {
		super(location);
		
		this.isWhite = isWhite;
		this.name = "Queen";
		this.filename = "ChessPieces//queen.jpg";
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
		
		int rightX = x;int upY = y;int leftX = x;int downY = y;
		int urX = x;int urY = y;int ulX = x;int ulY = y;int lrX = x;int lrY = y;int llX = x;int llY = y;
		
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
