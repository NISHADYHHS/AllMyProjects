
public  class Tile {

	
	private int x;
	private int y;
	private String display;
	private boolean covered;
	private boolean bomb;
	private boolean flag;
	private boolean start;
	private int index;
	
	public Tile(int x, int y, String display, boolean covered, boolean bomb, int index, boolean flag, boolean start) {
		
		this.flag = flag;
		this.covered = covered;
		this.x = x;
		this.y = y;
		this.display = display;
		this.bomb = bomb;
		this.index = index;
	}
	
	
	
	public  boolean getCovered() {
		
		return covered;
	}
	
	public boolean getFlag() {
		
		return flag;
	}
	
	public boolean getStart() {
		
		return start;
	}
	
	public int getX() {
		
		return x;
	}
	public int getIndex() {
		
		return index;
	}
	
	public int getY() {
	
	return y;
	}
	
	public boolean getBomb() {
		
		return bomb;
	}
	
	public String getDisplay() {
	
	return display;
	}
	
	
	public void setCovered(boolean covered) {
		
		this.covered = covered;
	}
	
	public void setFlag(boolean flag) {
		
		this.flag = flag;
	}
	public void setStart(boolean flag) {
		
		this.start = flag;
	}
	
	public void setBomb(boolean covered) {
		
		this.bomb = covered;
	}
	
	public void setDisplay(String covered) {
		
		this.display = covered;
	}
	public void setX(int x) {
		
		this.x = x;
	}
	
	public void setY(int y) {
	
		this.y =  y;
	}

	
	}
