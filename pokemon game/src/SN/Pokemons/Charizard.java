package SN.Pokemons;

import java.util.ArrayList;
import java.util.Arrays;

import SN.Attack.*;
import SN.Type.*;

public class Charizard extends Pokemon{
	
	
	
	public Charizard() {
		super(new ArrayList<Attack>(Arrays.asList(new LightningBolt(), new Scream(), new WaterBlast(), new Smash())), 200, 100, 111, 92, new Water(), "Charizard",200, "Charizard.png",0,0, new Blastoise(), 100000);
		// TODO Auto-generated constructor stub
	}
	
	
}
