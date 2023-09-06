
public class Tile {
	
	private int x, y, value;
	private boolean moved = false;
	
	public Tile(int x, int y, int value, boolean moved) {
		
		this.x = x;
		this.y = y;
		this.value =value;
		this.moved = moved;
		
		
		
	}
	
	public int getX() {
		
		return x;
	}
	
	public boolean getMoved() {
		
		return moved;
	}
	
	public void setMoved(boolean moved ) {
		
		this.moved = moved;
	}
	
	public int getValue() {
		
		return value;
	}
	
	public void setValue(int value) {
		
		this.value = value;
	}
	

	public int getY() {
		
		return y;
	}
	
	
	
}
