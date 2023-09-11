import java.util.ArrayList;

public class Knight extends Piece {
	
	


	public Knight(Loc location, boolean isWhite) {
		super(location);
		
		this.isWhite = isWhite;
		this.name = "Knight";
		this.filename = "ChessPieces//knight.jpg";
	}
	
	@Override public ArrayList<Loc> getKMoves(Loc location){
		ArrayList<Loc> moves = new ArrayList<Loc>();
		int x = location.getX();
		int y = location.getY();

		
		if(x > 1) {
			if(y > 1)
				moves.add(new Loc(x - 1, y - 2));
			if(y < 6)
				moves.add(new Loc(x - 1, y + 2));
			
		}
		if(x < 7) {
			if(y > 1)
				moves.add(new Loc(x + 1, y - 2));
			if(y < 6)
				moves.add(new Loc(x + 1, y + 2));
			
		}
		
		if(x > 1) {
			if(y >= 1)
				moves.add(new Loc(x - 2, y - 1));
			if(y <= 6)
				moves.add(new Loc(x - 2, y + 1));
		}
		if(x < 6) {
			if(y >= 1)
				moves.add(new Loc(x + 2, y - 1));
			 if(y <= 6)
				moves.add(new Loc(x + 2, y + 1));
		}
		
		return moves;
	}
 

}
