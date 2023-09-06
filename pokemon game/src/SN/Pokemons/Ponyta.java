package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Ponyta extends Pokemon {

	public Ponyta() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.
//75,84,90
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new WaterBlast(), new Scream(), new Smash())), 220, 60, 70, 74, 
				new Fire(), "Ponyta", 220, "Ponyta.png", 0, 0, new Rapidash(), 2);
		// TODO Auto-generated constructor stub
	}

}
