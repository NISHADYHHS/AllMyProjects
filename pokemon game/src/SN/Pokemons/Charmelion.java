package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Charmelion extends Pokemon {
	
	public Charmelion() {
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Scream(), new WaterBlast(), new Smash())), 100, 50, 55, 92, new Fire(), "Charmelion",100, "Charmelion.gif",0,0, new Charizard(), 4);
		// TODO Auto-generated constructor stub
	}
	

}
