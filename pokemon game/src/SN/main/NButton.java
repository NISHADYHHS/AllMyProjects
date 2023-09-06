package SN.main;
import processing.core.PApplet;

public class NButton {

	private int x;
	private int y;
	private int length;
	private int width;
	
	public NButton(int x, int y) {
		
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		
		return x;
	}
	
	public int getY() {
		
		return y;
	}
	
	public int getW() {
		
		return width;
	}
	public int getL() {
	
	return length;
	}
	public void drawButton(PApplet marker, int length, int width, String text) {
		
		this.length = length;
		this.width = width;
		marker.fill(0, 255, 33);
		marker.rect(x, y, length, width);
		marker.fill(0);
		marker.text(text, x + length/4, y + width/2);
		
		
		
	}
	
	public void mouseAnimation(PApplet marker, int length, int width) {
		marker.fill(255, 0, 33);
		marker.strokeWeight(10);
		marker.rect(x, y, length, width);
		marker.strokeWeight(1);
		

		
	}
}
