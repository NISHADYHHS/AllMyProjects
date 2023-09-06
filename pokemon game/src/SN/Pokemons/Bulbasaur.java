package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Bulbasaur extends Pokemon {
	public Bulbasaur() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

				super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Smash(), new WaterBlast(), new Scream())), 200, 65, 20,
					60, new Smelly(), "Bulbasaur", 210, "Bulbasaur.png", 0, 0, new Ivysaur(), 2);
	}
}
