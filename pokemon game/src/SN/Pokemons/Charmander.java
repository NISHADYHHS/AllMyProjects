package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Charmander extends Pokemon {
	
	public Charmander() {
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Scream(), new WaterBlast(), new Smash())), 90, 45, 50, 77, new Fire(), "Charmander",90, "Charmander.gif",0,0, new Charmelion(), 2);
		
		System.out.println(getSpeed());
		System.out.println(getAttack());
		System.out.println(getDefense());
	}

}
