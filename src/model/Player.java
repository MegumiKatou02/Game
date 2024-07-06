package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.entity.character.Character;
import model.entity.character.LiLy;
import model.entity.character.Mars;
import model.entity.character.Migami;

public class Player {
	private String name;
	private ArrayList<Character> listCharacter;
	private int sizeList;
	private double level;
	
	public Player(){
		this.name = "";
		this.level = 1;
		this.sizeList = 0;
		this.listCharacter = new ArrayList<Character>();
		getData();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		WriteBaseData();
	}
	
	public int getSizeCharacter() {
		return this.listCharacter.size();
	}

	public ArrayList<Character> getListCharacter() {
		return listCharacter;
	}

	public void setListCharacter(ArrayList<Character> listCharacter) {
		this.listCharacter = listCharacter;
	}

	public double getLevel() {
		return level;
	}

	public void setLevel(double level) {
		this.level = level;
		WriteBaseData();
	}

	public void AddCharacter(Character character) {
		this.listCharacter.add(character);
		this.sizeList = this.listCharacter.size();
		WriteAppendCharacter(character);
	}
	
	// dùng trong trường hợp lấy thông tin cơ bản của người chơi
	public void getBaseData() {
		final String filePath = "src/file/player.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			this.name = br.readLine().trim();
			this.level = Double.parseDouble(br.readLine().trim());
			this.sizeList = Integer.parseInt(br.readLine().trim());
		}catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	// dùng trong trường hợp lấy hết thông tin của người chơi (dùng để khởi đầu trò chơi)
	public void getData() {
		final String filePath = "src/file/player.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			this.name = br.readLine().trim();
			this.level = Double.parseDouble(br.readLine().trim());
			this.sizeList = Integer.parseInt(br.readLine().trim());

			for(int i = 0; i < this.sizeList; i++) {
				String name = br.readLine().trim();
				Character character = getObject(name);
				character.setName(name);
				character.setHP(Double.parseDouble(br.readLine().trim()));
				String[] damage = br.readLine().trim().split("\\s+");
				character.setRangeDamage
					(new Pair<>(Double.parseDouble(damage[0]), Double.parseDouble(damage[1])));
				character.setSpeedAttack(Integer.parseInt(br.readLine().trim()));
				character.setLifeSteal(Double.parseDouble(br.readLine().trim()));
				character.setLevel(Double.parseDouble(br.readLine().trim()));
				
				this.listCharacter.add(character);
			}
			
		}catch (IOException | NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	// dùng trong trường hợp ghi thông tin cơ bản của người chơi
	public void WriteBaseData() {
		final String fileNamePlayer = "src/file/player.txt";
		
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileNamePlayer))) {
			String infor = this.name + "\n" + this.level + "\n" + this.sizeList + "\n";
			writer.write(infor);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	// dùng trong trường hợp thay đổi thuộc tính nhân vật (ghi hết)
	public void WriteData() {
		final String fileNamePlayer = "src/file/player.txt";
		final String fileNameCharacter = "src/file/character.txt";
		
		try (
				BufferedWriter writer = new BufferedWriter(new FileWriter(fileNamePlayer));
				BufferedWriter writerCh = new BufferedWriter(new FileWriter(fileNameCharacter))
			) {
			String infor = this.name + "\n" + this.level + "\n" + this.sizeList + "\n";
			writer.write(infor);
			writerCh.write(this.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	// dùng trong trường hợp thêm nhân vật
	public void WriteAppendCharacter(Character character) {
		final String fileNameCharacter = "src/file/character.txt";
		
		try (
			BufferedWriter writerC = new BufferedWriter(new FileWriter(fileNameCharacter, true))
			) {
			writerC.write(character.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	@Override
	public String toString() {
		String write = "";
		for(Character character : this.listCharacter) {
			write += character.getName() + "\n" + 
					character.getHP() + "\n" +
					character.getRangeDamage().first + " " + character.getRangeDamage().second +
					character.getSpeedAttack() + "\n" +
					character.getLifeSteal() + "\n" +
					character.getLevel() + "\n";
		}
		return write;
	}
	
	public Character getObject(String string) {
		if(string.equals("LiLy")) {
			return new LiLy();
		}
		if(string.equals("Mars")) {
			return new Mars();
		}
		if(string.equals("Migami")) {
			return new Migami();
		}
		return null;
	}
}