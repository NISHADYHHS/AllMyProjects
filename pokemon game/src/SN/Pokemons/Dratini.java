package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Dratini extends Pokemon{

	public Dratini() {
		//Attacks, health, speed, defense, attack, TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new WaterBlast(), new Smash(), new Scream())), 200, 35, 44, 50,
		new Fire(), "Dratini", 230, "Dratini.png", 0, 0, new Dragonaire(), 2);
		// TODO Auto-generated constructor stub
	}
	
}
