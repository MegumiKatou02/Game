package model.entity.character;

import model.Pair;

public class Mars extends Character {
	public Mars() {
		super();
		this.name = "Mars";
		this.HP = 820;
		this.rangeDamage = new Pair<Double, Double>(45.0, 79.0);
		this.speedAttack = 1;
		this.lifeSteal = 0.01909;
	}
}
