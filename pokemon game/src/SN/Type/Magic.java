package SN.Type;

import java.util.ArrayList;
import java.util.Arrays;

public class Magic extends Type {

	public Magic() {
		super(new ArrayList<Type>(Arrays.asList(new Water(), new Fire())),
		new ArrayList<Type>(Arrays.asList(new Electricity())),
		new ArrayList<Type>(Arrays.asList(new Sound(), new Plant())), "Magic", 199,21,133);
		// TODO Auto-generated constructor stub
	}

}
