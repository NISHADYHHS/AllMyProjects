package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Meganium extends Pokemon {

	public Meganium() {
		super(new ArrayList<Attack>(Arrays.asList(new Smash(), new Scream(), new WaterBlast(), new Fart())), 310, 80, 93, 90, 
				new Plant(), "Meganium", 310, "Meganium.png", 0, 0, null, 10000);
		// TODO Auto-generated constructor stub
	}

}
