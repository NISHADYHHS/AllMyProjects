package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Dragonaire extends Pokemon{

	public Dragonaire() {
		//Attacks, health, speed, defense, attack, TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.
							//83,  83,      90,                                                       
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new SuperPunch(), new Scream(), new WaterBlast())), 250, 55, 65, 70, 
		new Water(), "Dragonaire", 250, "Dragonair.png", 0, 0, new Dragonite(), 4);
		// TODO Auto-generated constructor stub
	}
	
}
