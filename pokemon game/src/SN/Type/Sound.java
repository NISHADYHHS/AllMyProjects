package SN.Type;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

public class Sound extends Type {

	private static Electricity l = new Electricity();
	private static Water cl = new Water();
	private static Fire d = new Fire();
	private static ArrayList<Type> a = new ArrayList<Type>(Arrays.asList(cl));
	private static ArrayList<Type> b = new ArrayList<Type>(Arrays.asList(d));
	private static ArrayList<Type> c = new ArrayList<Type>(Arrays.asList(l));
	public Sound() {
		super(a, b, c, "Sound", 230,230,250);
		
	}

	@Override
	public ArrayList<Type> getStrength() {
		//a.toString();
		return c;
	}

	@Override
	public ArrayList<Type> getWeakness() {
		//b.toString();
		return b;
	}

	@Override
	public ArrayList <Type> getNeutral() {
		//c.toString();
		return a;
	}
}