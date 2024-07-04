package model.entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import model.Pair;
import model.equipment.Armor;
import model.equipment.Weapon;

public class Player extends Entity {
	protected Pet pet;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
	
	@Override
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
            Pet pet = null;
            int flag = Integer.parseInt(br.readLine().trim());
            if(flag != 0) {
            	pet = new Pet();
            	pet.setName(br.readLine().trim());
            }
            
            this.name = name;
            this.HP = HP;
            this.rangeDamage = rangeDamage;
            this.speedAttack = speedAttack;
            this.lifeSteal = lifeSteal;
            this.weapon = weapon;
            this.armor = armor;
            this.pet = pet;
            
		} catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	@Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", HP=" + HP +
                ", rangeDamage=" + rangeDamage.first + " - " + rangeDamage.second +
                ", speedAttack=" + speedAttack +
                ", lifeSteal=" + lifeSteal +
                ", weapon=" + weapon.getID() +
                ", armor=" + armor.getID() +
                ", Pet=" + pet.getName() +
                '}';
    }
}