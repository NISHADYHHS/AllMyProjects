package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;

import SN.Type.*;

public class Ivysaur extends Pokemon {
	public Ivysaur() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new Fart(), new Smash(), new WaterBlast(), new Scream())), 230, 80, 40,
			80, new Smelly(), "Ivysaur", 230, "Ivysaur.png", 0, 0, new Venusaur(), 4);
	}

}
