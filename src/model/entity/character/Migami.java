package model.entity.character;

import model.Pair;

public class Migami extends Character{
	public Migami() {
		super();
		this.name = "Migami";
		this.HP = 999;
		this.rangeDamage = new Pair<Double, Double>(67.0, 90.0);
		this.speedAttack = 1;
		this.lifeSteal = 0.0;
	}
}
