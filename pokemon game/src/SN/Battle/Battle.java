package SN.Battle;

import SN.Pokemons.Pokemon;
import SN.Type.Type;
import SN.Attack.Attack;
import SN.Player.*;
import SN.main.NButton;
import processing.core.PApplet;

public class Battle {
	private Pokemon p1, p2;
	private boolean battleTime = false;
	private boolean turn1;
	private boolean turn2;

	private NButton capturingButton;

	public Battle(Pokemon p1, Pokemon p2) {
		this.p1 = p1;
		this.p2 = p2;
		capturingButton = new NButton(800, 800);

	}

	public boolean getBattle() {

		return battleTime;
	}

	// public
	public void startBattle() {
		if (p1.getSpeed() > p2.getSpeed()) {
			// System.out.println("YOU GO FIRST");
			turn1 = true;
			// turn2 = false;
		} else {
			// System.out.println("YOU GO SECOND");
			turn2 = true;

		}
	}

	public NButton getCapturingButton() {
		return capturingButton;
	}

	public Pokemon getPokemon1() {

		return p1;
	}

	public Pokemon getPokemon2() {

		return p2;
	}

	public void setPokemon1(Pokemon p) {
		p1 = p;
	}

	public void setPokemon2(Pokemon p) {
		p2 = p;
	}

	public boolean getTurn1() {

		return turn1;
	}

	public boolean getTurn2() {

		return turn2;
	}

	public void setTurn1(boolean turn1) {
		this.turn1 = turn1;
	}

	public void setTurn2(boolean turn2) {

		this.turn2 = turn2;
	}

	public void odrawAttack(PApplet marker, Attack attack) {

	}

	public void drawBattleScreen(PApplet marker, Pokemon pokemon1, Pokemon pokemon2) { // the screen when you encounter
																						// a pokemon, only when
																						// encounter is true

		marker.textSize(40);
		marker.text("You found a wild : " + pokemon2.getName(), 500, 200);
		marker.textSize(20);
		pokemon2.draw(marker, 500, 250);
		marker.text("Attack : " + pokemon2.getAttack(), 875, 250);
		marker.text("Defense : " + pokemon2.getDefense(), 875, 300);
		marker.text("Speed : " + pokemon2.getSpeed(), 875, 350);
		marker.text("Health : " + pokemon2.getHealth(), 875, 400);
		marker.text("Type : " + pokemon2.getType().getName(), 875, 450);
		marker.text("Weaknesses : ", 875, 500);
		int count = 0;
		for (Type e : pokemon2.getType().getWeakness()) {

			marker.text(e.getName(), 1010 + count, 500);

			count += 50;
		}

		// marker.text(pokemon1.getName(), 500, 100);
		// marker.text(pokemon1.getHealth(), 600, 100);
		// marker.text(pokemon2.getHealth(), 300, 100);
		marker.stroke(0);
		marker.fill(0, 255, 30);
		marker.rect(500, 700, 100, 50);
	}

	public void drawAttackScreen(PApplet marker, Pokemon pokemon) { // the screen when you encounter a pokemon, only
																	// when encounter is true

		if (pokemon != null) {
			marker.fill(pokemon.getMoves().get(0).getType().getColor1(),
					pokemon.getMoves().get(0).getType().getColor2(), pokemon.getMoves().get(0).getType().getColor3());
			marker.rect(400, 500, 400, 130);
			marker.fill(pokemon.getMoves().get(1).getType().getColor1(),
					pokemon.getMoves().get(1).getType().getColor2(), pokemon.getMoves().get(1).getType().getColor3());
			marker.rect(1100, 500, 400, 130);
			marker.fill(pokemon.getMoves().get(2).getType().getColor1(),
					pokemon.getMoves().get(2).getType().getColor2(), pokemon.getMoves().get(2).getType().getColor3());
			marker.rect(400, 700, 400, 130);
			marker.fill(pokemon.getMoves().get(3).getType().getColor1(),
					pokemon.getMoves().get(3).getType().getColor2(), pokemon.getMoves().get(3).getType().getColor3());
			marker.rect(1100, 700, 400, 130);
			marker.textSize(10);
			marker.fill(0);
			marker.textSize(40);
			marker.text("Opponent HP", 1100, 50);
			marker.text("Your Pokemon HP", 400, 50);
			p1.healthBar(marker, 400, 75);
			p1.xpBar(marker, 400, 75);
			p1.draw(marker, 400, 150);
			p2.healthBar(marker, 1100, 75);
			p2.draw(marker, 1100, 150);

			capturingButton.drawButton(marker, 100, 100, "Press me when you need for capturing");

			marker.textSize(23);
			marker.text(pokemon.getMoves().get(0).getName(), 510, 525);
			marker.text(pokemon.getMoves().get(1).getName(), 1210, 525);
			marker.text(pokemon.getMoves().get(2).getName(), 510, 725);
			marker.text(pokemon.getMoves().get(3).getName(), 1210, 725);
			marker.fill(0);
		}
	}

	public void drawOrderChooser(PApplet marker) {
		marker.noFill();
		marker.rect(30, 110, 150, 50);
		marker.stroke(0, 0, 0);
		marker.textSize(10);
		marker.text("Switch", 30, 140);
	}

	public void drawStatPage(PApplet marker, Pokemon pokemon) {

		marker.textSize(20);
		pokemon.draw(marker, 500, 250);
		marker.text("Attack : " + pokemon.getAttack(), 875, 250);
		marker.text("Defense : " + pokemon.getDefense(), 875, 300);
		marker.text("Speed : " + pokemon.getSpeed(), 875, 350);
		marker.text("Health : " + pokemon.getHealth(), 875, 400);
		marker.text("Type : " + pokemon.getType().getName(), 875, 450);
	}

	public void drawSwitchScreen(PApplet marker, Player player) {

		player.getP1().setAttack(player.getP1().getTrueAttack());
		player.getP1().setSpeed(player.getP1().getTrueSpeed());
		player.getP1().setDefense(player.getP1().getTrueDefense());

		player.getP1().setAttackT(false);
		player.getP1().setDefenseT(false);
		player.getP1().setSpeedT(false);

		if (player.getP1() != null) {

			marker.fill(player.getP1().getType().getColor1(), player.getP1().getType().getColor2(),
					player.getP1().getType().getColor3());
			marker.rect(200, 100, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP1().getName(), 300, 163);
		}
		if (player.getP2() != null) {

			marker.fill(player.getP2().getType().getColor1(), player.getP2().getType().getColor2(),
					player.getP2().getType().getColor3());
			marker.rect(200, 400, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP2().getName(), 300, 463);
		}

		if (player.getP3() != null) {

			marker.fill(player.getP3().getType().getColor1(), player.getP3().getType().getColor2(),
					player.getP3().getType().getColor3());
			marker.rect(200, 700, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP3().getName(), 300, 763);
		}

		if (player.getP4() != null) {

			marker.fill(player.getP4().getType().getColor1(), player.getP4().getType().getColor2(),
					player.getP4().getType().getColor3());
			marker.rect(1100, 100, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP4().getName(), 1200, 163);
		}

		if (player.getP5() != null) {

			marker.fill(player.getP5().getType().getColor1(), player.getP5().getType().getColor2(),
					player.getP5().getType().getColor3());
			marker.rect(1100, 400, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP5().getName(), 1200, 463);
		}

		if (player.getP6() != null) {

			marker.fill(player.getP6().getType().getColor1(), player.getP6().getType().getColor2(),
					player.getP6().getType().getColor3());
			marker.rect(1100, 700, 500, 100);

			marker.fill(0);

			marker.textSize(40);
			marker.text(player.getP6().getName(), 1200, 763);
		}

	}
}