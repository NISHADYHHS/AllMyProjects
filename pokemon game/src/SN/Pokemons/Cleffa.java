package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Cleffa extends Pokemon {

	public Cleffa() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new Smash(), new Scream(), new WaterBlast(), new LightningBolt())), 190, 30, 55, 32, 
				new Magic(), "Cleffa", 190, "Cleffa.png", 0, 0, new Clefairy(), 2);
		// TODO Auto-generated constructor stub
	}
	
}
