package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Golem extends Pokemon {

	public Golem() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.
		super(new ArrayList<Attack>(Arrays.asList(new Scream(), new Fart(),new Smash(), new LightningBolt())), 290, 82, 84, 95, 
				new Muscular(), "Golem", 290, "Golem.png", 0, 0, null, 1000000);
		// TODO Auto-generated constructor stub
	}

}
