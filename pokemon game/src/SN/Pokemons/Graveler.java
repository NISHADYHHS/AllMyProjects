package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Graveler extends Pokemon{

	public Graveler() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new Scream(), new Smash(), new WaterBlast(), new LightningBolt())), 245, 61, 66, 70, 
				new Muscular(), "Graveler", 245, "Graveler.png", 0, 0, new Golem(), 4);
		// TODO Auto-generated constructor stub
	}

}
