package model.entity;

import model.element.Element;

public class Pet {
	protected String name;
	protected Element element;
	protected double level;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Element getElement() {
		return element;
	}
	public void setElement(Element element) {
		this.element = element;
	}
	public double getLevel() {
		return level;
	}
	public void setLevel(double level) {
		this.level = level;
	}
}
