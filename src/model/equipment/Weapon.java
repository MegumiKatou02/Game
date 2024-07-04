package model.equipment;

import model.Pair;

public class Weapon extends Equipment {
	protected Pair<Double, Double> rangeDamage;
	protected int weight;
	protected double critRate;
	protected double lifeSteal;
	
	public Pair<Double, Double> getRangeDamage() {
		return rangeDamage;
	}
	public void setRangeDamage(Pair<Double, Double> rangeDamage) {
		this.rangeDamage = rangeDamage;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public double getCritRate() {
		return critRate;
	}
	public void setCritRate(double critRate) {
		this.critRate = critRate;
	}
	public double getLifeSteal() {
		return lifeSteal;
	}
	public void setLifeSteal(double lifeSteal) {
		this.lifeSteal = lifeSteal;
	}
}
