package model.entity.character;

import model.Pair;

public class LiLy extends Character {
	public LiLy() {
		super();
		this.name = "LiLy";
		this.HP = 1080;
		this.rangeDamage = new Pair<Double, Double>(30.0, 60.0);
		this.speedAttack = 1;
		this.lifeSteal = 0.0;
	}
}
