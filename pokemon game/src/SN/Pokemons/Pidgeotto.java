package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;


public class Pidgeotto extends Pokemon{

	public Pidgeotto() {//85, 87, 90
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Smash(), new WaterBlast(), new Scream())), 250, 65, 67, 70, 
				new Sound(), "Pidgeotto", 250, "Pidgeotto.png", 0, 0, new Pidgeot(), 4);		// TODO Auto-generated constructor stub
	}
	
}
