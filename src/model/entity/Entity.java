package model.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
	
	@Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                ", HP=" + HP +
                ", rangeDamage=" + rangeDamage.first + " - " + rangeDamage.second +
                ", speedAttack=" + speedAttack +
                ", lifeSteal=" + lifeSteal +
                ", weapon=" + weapon.getID() +
                ", armor=" + armor.getID() +
                '}';
    }
	public void GetData() {
		String filePath = "src/file/player.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String name = br.readLine().trim();
			double HP = Double.parseDouble(br.readLine().trim());
			String[] damageTokens = br.readLine().trim().split("\\s+");
            Pair<Double, Double> rangeDamage = new Pair<>
            	(Double.parseDouble(damageTokens[0]), Double.parseDouble(damageTokens[1]));
            int speedAttack = Integer.parseInt(br.readLine().trim());
            double lifeSteal = Double.parseDouble(br.readLine().trim());
            int num = Integer.parseInt(br.readLine().trim());
            Weapon weapon = null;
            Armor armor = null;
            if(num >= 1) {
            	weapon = new Weapon();
            	weapon.setID(br.readLine().trim());
            }
            if(num == 2) {
            	armor = new Armor();
            	armor.setID(br.readLine().trim());
            }
            
            this.name = name;
            this.HP = HP;
            this.rangeDamage = rangeDamage;
            this.speedAttack = speedAttack;
            this.lifeSteal = lifeSteal;
            this.weapon = weapon;
            this.armor = armor;
            
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
}