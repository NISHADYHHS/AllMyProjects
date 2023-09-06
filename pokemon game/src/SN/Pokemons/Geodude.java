package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Geodude extends Pokemon {

	public Geodude() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Scream(), new WaterBlast(), new Smash())), 200, 40, 45, 55, 
				new Water(), "Geodude", 200, "Geodude.png", 0, 0, new Graveler(), 2);
		// TODO Auto-generated constructor stub
	}

}
