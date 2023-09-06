package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Pidgey extends Pokemon {

	public Pidgey() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Smash(), new WaterBlast(), new Scream())), 210, 45, 47, 50, 
				new Sound(), "Pidgey", 210, "Pidgey.png", 0, 0, new Pidgeotto(), 2);
		// TODO Auto-generated constructor stub
	}
	
}
