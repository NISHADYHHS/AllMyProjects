package SN.Type;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Fire extends Type{
	//private static Water w = new Water();
	//private static Plant s = new Plant();
	//private static Lightning n = new Lightning();
	private static ArrayList<Type> a = new ArrayList<Type>(Arrays.asList(new Plant()));
	private static ArrayList<Type> b = new ArrayList<Type>(Arrays.asList(new Water()));
	private static ArrayList<Type>c = new ArrayList<Type>(Arrays.asList( new Electricity()));
	
	public Fire() {
		super(a, b, c, "Fire",255,140,0);
	}
	
	public ArrayList<Type> getStrength() {
		return a;
	}
	
	public ArrayList<Type> getWeakness() {
		return b;
	}
	
	public ArrayList<Type> getNeutral() {
		return c;
	}

	
}

