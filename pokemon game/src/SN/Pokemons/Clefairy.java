package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Clefairy extends Pokemon {

	public Clefairy() {
		super(new ArrayList<Attack>(Arrays.asList(new WaterBlast(), new Scream(), new Smash(), new LightningBolt())), 255, 55, 75, 54, 
				new Magic(), "Clefairy", 255, "Clefairy.png", 0, 0, new Clefable(), 4);
		// TODO Auto-generated constructor stub
	}
 
}
