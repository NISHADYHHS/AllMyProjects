package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Clefable extends Pokemon {

	public Clefable() {
		super(new ArrayList<Attack>(Arrays.asList(new WaterBlast(),new Fart(), new LightningBolt(), new Scream())), 320, 70, 100, 71, 
				new Magic(), "Clefable", 320, "Clefable.png", 0, 0, null, 10000);
		// TODO Auto-generated constructor stub
	}
	
}
