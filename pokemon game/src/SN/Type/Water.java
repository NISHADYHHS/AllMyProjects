package SN.Type;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Water extends Type {

	
	//private static Lightning w = new Lightning();
	//private static Fire s = new Fire();
	//private static Sound n = new Sound();
	private static ArrayList<Type> a = new ArrayList<Type>(Arrays.asList(new Fire()));
	private static ArrayList<Type>b = new ArrayList<Type>(Arrays.asList(new Electricity(), new Plant()));
	private static ArrayList<Type>c = new ArrayList<Type>(Arrays.asList(new Sound()));
	
	public Water() {		
		super(a, b, c, "Water", 30,144,255);
	}
	
	public ArrayList <Type> getStrength() {
		return a;
	}
	
	public ArrayList<Type> getWeakness() {
		return b;
	}
	
	public ArrayList<Type> getNeutral() {
		return c;
	}

	
}