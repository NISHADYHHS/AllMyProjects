package SN.Type;

import java.util.ArrayList;
import java.util.Arrays;

public class Muscular extends Type {

	public Muscular() {
		super(new ArrayList<Type>(Arrays.asList(new Plant(), new Sound(), new Smelly())), 
		new ArrayList<Type>(Arrays.asList(new Fire(), new Water(), new Electricity())), null, "Muscular", 255,182,193);
		// TODO Auto-generated constructor stub
	}

}
