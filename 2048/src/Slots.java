
public class Slots {

	
	private boolean filled;
	private Tile tile;
	private int x,y;
	private boolean canmove;
	
	public Slots(int x, int y, boolean filled, Tile tile) {
		
		
		this.filled = filled;
		this.tile = tile;
		this.x = x;
		this.y = y;
		this.canmove = canmove;
		
	}
	
	public Tile getTile() {
		
		
		return tile;
	}
	public int getX() {
		
		
		return x;
	}
	public boolean getCanmove() {
		
		return canmove;
	}
	
	
	public int getY() {
	
	
		return y;
	}
	
	public boolean getFilled() {
	
	
		return filled;
	}

	public void setTile(Tile tile) {
		
		
		this.tile = tile;
	}
	public void setX(int x) {
		
		
		this.x = x;
	
	}

	public void setY(int y) {
	
	
		this.y = y;
	}
	
	public void setFilled(boolean filled) {
	
	
		this.filled = filled;
	}
	public void setCanmove(boolean canmove) {
		
		
		this.canmove = canmove;
	}
}
