package SN.Type;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Plant extends Type {
	
//	private static Lightning w = new Lightning();
//	private static Water s = new Water();
	//private static Fire n = new Fire();
	private static ArrayList<Type> a = new ArrayList<Type>(Arrays.asList(new Water()));
	private static ArrayList<Type> b = new ArrayList<Type>(Arrays.asList(new Fire()));
	private static ArrayList<Type> c = new ArrayList<Type>(Arrays.asList(new Electricity()));
	
	public Plant() {	
			super(a, b, c, "Plant", 50,205,50);
	}
	
	public ArrayList<Type> getStrength() {
		//s.toString();
		return a;
	}
	
	public ArrayList<Type> getWeakness() {
		//w.toString();
		return b;
	}
	
	public ArrayList<Type> getNeutral() {
		//n.toString();
		return c;
	}

	
	
}
