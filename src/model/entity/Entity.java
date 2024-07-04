package model.entity;

import model.Pair;
import model.equipment.Armor;
import model.equipment.Weapon;

public abstract class Entity {
	protected String name;
	protected double HP;
	protected Pair<Double, Double> rangeDamage;
	protected int speedAttack;
	protected double lifeSteal;
	protected Weapon weapon;
	protected Armor armor;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getHP() {
		return HP;
	}
	public void setHP(double hP) {
		HP = hP;
	}
	public Pair<Double, Double> getRangeDamage() {
		return rangeDamage;
	}
	public void setRangeDamage(Pair<Double, Double> rangeDamage) {
		this.rangeDamage = rangeDamage;
	}
	public int getSpeedAttack() {
		return speedAttack;
	}
	public void setSpeedAttack(int speedAttack) {
		this.speedAttack = speedAttack;
	}
	public double getLifeSteal() {
		return lifeSteal;
	}
	public void setLifeSteal(double lifeSteal) {
		this.lifeSteal = lifeSteal;
	}
	public Weapon getWeapons() {
		return weapon;
	}
	public void setWeapons(Weapon weapon) {
		this.weapon = weapon;
	}
	public Armor getArmors() {
		return armor;
	}
	public void setArmors(Armor armor) {
		this.armor = armor;
	}
}