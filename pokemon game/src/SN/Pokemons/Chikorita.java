package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Chikorita extends Pokemon{

	public Chikorita() {
		//Attacks, health, speed, defense, attack, TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new Smash(), new Scream(), new LightningBolt(), new WaterBlast())), 203, 36, 40, 
		50, new Plant(), "Chikorita", 203, "Chikorita.png", 0, 0, new Bayleef(), 2);
		// TODO Auto-generated constructor stub
	}

}
