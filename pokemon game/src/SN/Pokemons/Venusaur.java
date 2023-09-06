package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Venusaur extends Pokemon {
	public Venusaur() {
		//Attacks, health(300), speed(83), defense(83), attack(90), TYpe, name, startingHealth, imagename, xp, level, evolution, evolvingLevel.

		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Smash(), new WaterBlast(), new Scream())), 260, 105, 60,
			100, new Smelly(), "Venusaur", 210, "Venusaur.png", 0, 0, null, 1000);
	}
}
