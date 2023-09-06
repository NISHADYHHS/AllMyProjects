package SN.Type;

import java.awt.Color;
import java.util.ArrayList;

public abstract class Type {
	private ArrayList<Type> strength;
	private ArrayList<Type> weakness;
	private ArrayList<Type> neutral;
	private String name;
	private int color1;
	private int color2;
	private int color3;
	//Types : Sound, Lightning, Desert, Forest, cloud, Normal
	public Type(ArrayList<Type> s, ArrayList<Type> w, ArrayList<Type> n, String name,  int color1, int color2, int color3) {
		strength = s;
		weakness = w;
		neutral = n;
		this.name = name;
		this.color1 = color1;
		this.color2 = color2;
		this.color3 = color3;
	}
	public ArrayList <Type> getStrength() {
		
		return strength;
	}
	public ArrayList <Type> getWeakness() {
		
		return weakness;
	}
	public ArrayList<Type> getNeutral() {	
		return neutral;
	}
	public void setStrength(ArrayList<Type> s) {
		strength = s;
	}
	public void setWeakness(ArrayList<Type> w) {
		weakness = w;
	}
	public void setNeutral(ArrayList<Type> n) {
		neutral= n;
	}
	public String getName() {
		return name;
	}
	
	public int getColor1() {
		
		return color1;
	}
	public int getColor2() {
		
		return color2;
	}
	public int getColor3() {
	
		return color3;
	}
	
}