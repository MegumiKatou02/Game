package model.equipment;

public class Armor extends Equipment{
	protected double counterDamage;
	protected double stamina;
	protected int liftingAbility;
	
	public double getCounterDamage() {
		return counterDamage;
	}
	public void setCounterDamage(double counterDamage) {
		this.counterDamage = counterDamage;
	}
	public double getStamina() {
		return stamina;
	}
	public void setStamina(double stamina) {
		this.stamina = stamina;
	}
	public int getLiftingAbility() {
		return liftingAbility;
	}
	public void setLiftingAbility(int liftingAbility) {
		this.liftingAbility = liftingAbility;
	}
}
