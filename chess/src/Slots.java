
public class Slots {

	
	private Piece piece;
	private boolean isFilled;
	private Loc location;
	private boolean clicked = false;;
	
	public Slots(Piece piece, boolean isFilled, Loc location) {
		
		
		this.piece = piece;
		this.isFilled = isFilled;
		this.location = location;
		
	}
	
	
	
	public Slots( boolean isFilled, Loc loc) {
		
		
		
		this.isFilled = isFilled;
		this.location = loc;
		
		
	}
	
	public Piece getPiece() {
		return piece;
		
	}
	
	public void removePiece() {
		this.piece = new Nothing(this.location);
		this.piece.setName("Nothing");
		this.isFilled = false;
	}
	
	public void setPiece(Piece p) {
		
		if(p.getName() == "Bishop") {
			
			this.piece = new Bishop(location, p.getisWhite());
			this.isFilled = true;
		}
		if(p.getName() == "Knight") {
					
			this.piece = new Knight(location, p.getisWhite());
			this.isFilled = true;
		}
		if(p.getName() == "Rook") {
			
			this.piece = new Rook(location, p.getisWhite());
			this.isFilled = true;
		}
		if(p.getName() == "Pawn") {
			
			this.piece = new Pawn(location, p.getisWhite());
			this.isFilled = true;
		}
		if(p.getName() == "King") {
			
			this.piece = new King(location, p.getisWhite());
			this.isFilled = true;
		}
		if(p.getName() == "Queen") {
			
			this.piece = new Queen(location, p.getisWhite());
			this.isFilled = true;
		}
	}
	
	
	public boolean getisFilled() {
		
		return isFilled;
	}
	public Loc getLocation() {
		
		return location;
	}
	
	public boolean getClicked() {
		
		return clicked;
	}
	
	public void setClicked(boolean clicked) {
		
		this.clicked = clicked;
	}
	
	public void setFilled(boolean isFilled) {
		
		this.isFilled = isFilled;
	}
	
	
	
}
