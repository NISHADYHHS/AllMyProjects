package SN.Type;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Electricity extends Type{

	//private static Sound n = new Sound();
	//private static Forest s = new Forest();
	//private static Fire w= new Fire();
	private static ArrayList<Type> a = new ArrayList<Type>(Arrays.asList(new Water()));
	private static ArrayList<Type> b = new ArrayList<Type>(Arrays.asList(new Sound()));
	private static ArrayList<Type> c = new ArrayList<Type>(Arrays.asList(new Plant(), new Fire()));
	
	public Electricity() {
		super(a, b, c, "Lightning", 255,255,0);
	}
	
	public ArrayList<Type> getStrength() {
		a.toString();
		return a;
	}
	
	public ArrayList<Type> getWeakness() {
		b.toString();
		return b;
	}
	
	public ArrayList<Type> getNeutral() {
		c.toString();
		return c;
	}

	
	
	
}