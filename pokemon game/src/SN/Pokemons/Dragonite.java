package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Dragonite extends Pokemon {

	public Dragonite() {
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Scream(), new WaterBlast(), new Smash())), 343, 86, 92, 89, 
				new Fire(), "Dragonite", 343, "Dragonite.png", 0, 0, null, 1000000);
		// TODO Auto-generated constructor stub
	}

}
