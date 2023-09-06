package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Squirtle extends Pokemon {

	public Squirtle() {
		//Attacks, health, speed, defense, attack, TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.
//200,250,300 //40, 62, 84    33, 60, 93  43, 70, 94
		super(new ArrayList<Attack>(Arrays.asList(new Scream(), new Smash(), new LightningBolt(), new WaterBlast())), 200, 40, 33, 47, 
				new Water(), "Squirtle", 200, "Squirtle.png", 0, 0, new Wartortle(), 2);
		// TODO Auto-generated constructor stub
	}
	
}
