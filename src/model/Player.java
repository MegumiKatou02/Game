package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.entity.character.Character;

public class Player {
	private String name;
	private String sizeCharacter;
	private ArrayList<Character> listCharacter;
	
	public Player(){
		name = "";
		listCharacter = new ArrayList<Character>();
		getData();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		WriteData();
	}
	
	public void getData() {
		final String filePath = "src/file/player.txt";
		try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
			String name = br.readLine().trim();
			this.name = name;
		}catch (IOException | NumberFormatException e) {
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
		return this.name;
	}
}