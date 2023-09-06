package SN.Type;

import java.util.ArrayList;
import java.util.Arrays;

public class Smelly extends Type{

	public Smelly() {
		super(new ArrayList<Type>(Arrays.asList(new Sound(), new Water(), new Plant(), new Magic())), new ArrayList<Type>(Arrays.asList(new Fire(), new Electricity(), new Magic())), new ArrayList<Type>(Arrays.asList()), "Smelly", 
			85,107,47);
		// TODO Auto-generated constructor stub
	}

}
