package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Pidgeot extends Pokemon {

	public Pidgeot() {
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Smash(), new WaterBlast(), new Scream())), 290, 85, 87, 90, 
				new Sound(), "Pidgeot", 210, "Pidgeot.png", 0, 0, null, 1000000);		// TODO Auto-generated constructor stub
	}

}
