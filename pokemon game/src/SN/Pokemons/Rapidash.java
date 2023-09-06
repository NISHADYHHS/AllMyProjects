package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Rapidash extends Pokemon {

	public Rapidash() {
		//75,84,90
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Smash(), new Scream(), new WaterBlast())), 289, 75, 84, 90, 
				new Fire(), "Rapidash", 289, "Rapidash.png", 0, 0, null, 100000);
		// TODO Auto-generated constructor stub
	}

}
