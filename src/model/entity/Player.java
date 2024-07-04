package model.entity;

public class Player extends Entity {
	protected Pet pet;

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}
}