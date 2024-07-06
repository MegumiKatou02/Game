package model.entity.character;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import model.Pair;
import model.entity.Entity;
import model.entity.Pet;
import model.equipment.Armor;
import model.equipment.Weapon;

public abstract class Character extends Entity {
	protected Pet pet;

	public Character() {
		super();
		pet = null;
//		GetData();
	}
	
	@Override
	public void setName(String name) {
		super.setName(name);
		WriteData();
	}
	
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
            Weapon weapon = new Weapon();
            Armor armor = new Armor();
        	weapon.setID(br.readLine().trim());
        	armor.setID(br.readLine().trim());
            Pet pet = new Pet();
        	pet.setName(br.readLine().trim());
            
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
	
	public void WriteData() {
		final String fileName = "src/file/player.txt";
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
			writer.write(this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Override
    public String toString() {
        String s = this.name + "\n" +
        		this.HP + "\n" +
        		this.rangeDamage.first + " " + this.rangeDamage.second + "\n" +
        		this.speedAttack + "\n" +
        		this.lifeSteal + "\n" +
        		this.weapon.getID() + "\n" +
        		this.armor.getID() + "\n" +
        		this.pet.getName();
        return s;
    }
}