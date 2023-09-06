package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Wartortle extends Pokemon {

	public Wartortle() {
		super(new ArrayList<Attack>(Arrays.asList(new Scream(), new WaterBlast(), new Smash(), new LightningBolt())), 250, 62, 60, 70, 
				new Water(), "Wartortle", 250, "Wartortle.png", 0, 0, new Blastoise(), 4);
		// TODO Auto-generated constructor stub
	}

}
