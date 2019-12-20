package com.demo.program.copy;

public class ShalowCopy {

	public static void main(String[] args) {

		SuperHero ironMan = new SuperHero("Tony Stark", "Iron Man", 48,
				new Profession("Business Man", "Weapon Manufacturer", true)
		);

		
		try {
			SuperHero ironMansCopy = (SuperHero) ironMan.clone();

			System.out.println("Before copy :: " + ironMan.profession.name);

			ironMansCopy.profession.name = "Iron man's Suit designer";

			System.out
					.println("After copy Obj-1 :: " + ironMan.profession.name);

			System.out.println("After copy Obj-2:: " + ironMansCopy.profession.name);

		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
	}
}


class Profession {
	public String category;
	public String name;
	public boolean isGoodJob;
	
	public Profession(String category, String name, boolean isGoodJob) {
		super();
		this.category = category;
		this.name = name;
		this.isGoodJob = isGoodJob;
	}	
}

class SuperHero implements Cloneable {
	
	public String name;
	public String superName;
	public int age;
	
	public Profession profession;
	
	public SuperHero(String name, String superName, int age, Profession profession) {
		super();
		this.name = name;
		this.superName = superName;
		this.age = age;
		this.profession = profession;
	}
	
	//Default clone() method creates shallow copy of an object.
	protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
